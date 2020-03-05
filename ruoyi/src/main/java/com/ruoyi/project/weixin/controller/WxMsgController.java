/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.ruoyi.project.weixin.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.weixin.config.CommonConstants;
import com.ruoyi.project.weixin.service.WxMsgService;
import com.ruoyi.project.weixin.service.WxUserService;
import com.ruoyi.project.weixin.constant.ConfigConstant;
import com.ruoyi.project.weixin.entity.WxMsg;
import com.ruoyi.project.weixin.entity.WxMsgVO;
import com.ruoyi.project.weixin.entity.WxUser;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpKefuService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 微信消息
 *
 * @author JL
 * @date 2019-05-28 16:12:10
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/wxmsg")
@Api(value = "wxmsg", tags = "wxmsg管理")
public class WxMsgController extends BaseController {

    private final WxMsgService wxMsgService;
	private final WxUserService wxUserService;
	private final WxMpService wxService;

    /**
    * 分页查询
    * @param page 分页对象
    * @param wxMsgVO 微信消息
    * @return
    */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermi('wxmp:wxmsg:index')")
    public AjaxResult getWxMsgPage(Page page, WxMsgVO wxMsgVO) {
    	if(StringUtils.isNotBlank(wxMsgVO.getNotInRepType())){
			return  AjaxResult.success(wxMsgService.listWxMsgMapGroup(page,wxMsgVO));
		}
    	if(StringUtils.isNotBlank(wxMsgVO.getWxUserId())){//标记为已读
			WxMsg wxMsg = new WxMsg();
			wxMsg.setReadFlag(CommonConstants.YES);
			Wrapper queryWrapper = Wrappers.<WxMsg>lambdaQuery()
					.eq(WxMsg::getWxUserId,wxMsgVO.getWxUserId())
					.eq(WxMsg::getReadFlag,CommonConstants.NO);
			wxMsgService.update(wxMsg,queryWrapper);
		}
    	return AjaxResult.success(wxMsgService.page(page,Wrappers.query(wxMsgVO)));
    }

    /**
    * 通过id查询微信消息
    * @param id id
    * @return R
    */
    @GetMapping("/{id}")
    @PreAuthorize("@ss.hasPermi('wxmp:wxmsg:get')")
    public AjaxResult getById(@PathVariable("id") String id){
    	return AjaxResult.success(wxMsgService.getById(id));
    }

    /**
    * 新增微信消息
    * @param wxMsg 微信消息
    * @return R
    */
    @PostMapping
    @PreAuthorize("@ss.hasPermi('wxmp:wxmsg:add')")
    public AjaxResult save(@RequestBody WxMsg wxMsg){
		try {
			WxUser wxUser = wxUserService.getById(wxMsg.getWxUserId());
			//入库
			wxMsg.setNickName(wxUser.getNickName());
			wxMsg.setHeadimgUrl(wxUser.getHeadimgUrl());
			wxMsg.setCreateTime(LocalDateTime.now());
			wxMsg.setType(ConfigConstant.WX_MSG_TYPE_2);
			WxMpKefuMessage wxMpKefuMessage = null;
			if(WxConsts.KefuMsgType.TEXT.equals(wxMsg.getRepType())){
				wxMsg.setRepContent(wxMsg.getRepContent());
				wxMpKefuMessage = WxMpKefuMessage.TEXT().build();
				wxMpKefuMessage.setContent(wxMsg.getRepContent());
			}
			if(WxConsts.KefuMsgType.IMAGE.equals(wxMsg.getRepType())){//图片
				wxMsg.setRepName(wxMsg.getRepName());
				wxMsg.setRepUrl(wxMsg.getRepUrl());
				wxMsg.setRepMediaId(wxMsg.getRepMediaId());
				wxMpKefuMessage = WxMpKefuMessage.IMAGE().build();
				wxMpKefuMessage.setMediaId(wxMsg.getRepMediaId());
			}
			if(WxConsts.KefuMsgType.VOICE.equals(wxMsg.getRepType())){
				wxMsg.setRepName(wxMsg.getRepName());
				wxMsg.setRepUrl(wxMsg.getRepUrl());
				wxMsg.setRepMediaId(wxMsg.getRepMediaId());
				wxMpKefuMessage = WxMpKefuMessage.VOICE().build();
				wxMpKefuMessage.setMediaId(wxMsg.getRepMediaId());
			}
			if(WxConsts.KefuMsgType.VIDEO.equals(wxMsg.getRepType())){
				wxMsg.setRepName(wxMsg.getRepName());
				wxMsg.setRepDesc(wxMsg.getRepDesc());
				wxMsg.setRepUrl(wxMsg.getRepUrl());
				wxMsg.setRepMediaId(wxMsg.getRepMediaId());
				wxMpKefuMessage = WxMpKefuMessage.VIDEO().build();
				wxMpKefuMessage.setMediaId(wxMsg.getRepMediaId());
				wxMpKefuMessage.setTitle(wxMsg.getRepName());
				wxMpKefuMessage.setDescription(wxMsg.getRepDesc());
			}
			if(WxConsts.KefuMsgType.MUSIC.equals(wxMsg.getRepType())){
				wxMsg.setRepName(wxMsg.getRepName());
				wxMsg.setRepDesc(wxMsg.getRepDesc());
				wxMsg.setRepUrl(wxMsg.getRepUrl());
				wxMsg.setRepHqUrl(wxMsg.getRepHqUrl());
				wxMpKefuMessage = WxMpKefuMessage.MUSIC().build();
				wxMpKefuMessage.setTitle(wxMsg.getRepName());
				wxMpKefuMessage.setDescription(wxMsg.getRepDesc());
				wxMpKefuMessage.setMusicUrl(wxMsg.getRepUrl());
				wxMpKefuMessage.setHqMusicUrl(wxMsg.getRepHqUrl());
				wxMpKefuMessage.setThumbMediaId(wxMsg.getRepThumbMediaId());
			}
			if(WxConsts.KefuMsgType.NEWS.equals(wxMsg.getRepType())){
				List<WxMpKefuMessage.WxArticle> list = new ArrayList<>();
				JSONArray jSONArray = wxMsg.getContent().getJSONArray("articles");
				WxMpKefuMessage.WxArticle t;
				for(Object object : jSONArray){
					JSONObject jSONObject = JSONUtil.parseObj(JSONUtil.toJsonStr(object));
					t = new WxMpKefuMessage.WxArticle();
					t.setTitle(jSONObject.getStr("title"));
					t.setDescription(jSONObject.getStr("digest"));
					t.setPicUrl(jSONObject.getStr("thumbUrl"));
					t.setUrl(jSONObject.getStr("url"));
					list.add(t);
				}
				wxMsg.setRepName(wxMsg.getRepName());
				wxMsg.setRepDesc(wxMsg.getRepDesc());
				wxMsg.setRepUrl(wxMsg.getRepUrl());
				wxMsg.setRepMediaId(wxMsg.getRepMediaId());
				wxMsg.setContent(wxMsg.getContent());
				wxMpKefuMessage = WxMpKefuMessage.NEWS().build();
				wxMpKefuMessage.setArticles(list);
			}
			if(wxMpKefuMessage != null){
				WxMpKefuService wxMpKefuService = wxService.getKefuService();
				wxMpKefuMessage.setToUser(wxUser.getOpenId());
				wxMpKefuService.sendKefuMessage(wxMpKefuMessage);
				wxMsgService.save(wxMsg);
				return AjaxResult.success(wxMsg);
			}else{
				return AjaxResult.error("非法消息类型");
			}
		} catch (WxErrorException e) {
			e.printStackTrace();
			log.error("新增微信消息失败"+e.getMessage());
			return AjaxResult.error(e.getMessage());
		}
    }

    /**
    * 修改微信消息
    * @param wxMsg 微信消息
    * @return R
    */
    @PutMapping
    @PreAuthorize("@ss.hasPermi('wxmp:wxmsg:edit')")
    public AjaxResult updateById(@RequestBody WxMsg wxMsg){
    	return AjaxResult.success(wxMsgService.updateById(wxMsg));
    }

    /**
    * 通过id删除微信消息
    * @param id id
    * @return R
    */
    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermi('wxmp:wxmsg:del')")
    public AjaxResult removeById(@PathVariable String id){
    	return AjaxResult.success(wxMsgService.removeById(id));
    }

}
