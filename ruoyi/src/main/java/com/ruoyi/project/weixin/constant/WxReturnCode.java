/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.ruoyi.project.weixin.constant;

import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 微信接口全局返回码
 * @author jl
 *
 */
public enum WxReturnCode {
	
	SUC_0("0", "请求成功"){},
	ERR_1("-1", "系统繁忙，此时请开发者稍候再试"){},
	ERR_10001("10001", "涉嫌广告 "){},
	ERR_20001("20001", "涉嫌政治 "){},
	ERR_20002("20002", "涉嫌色情 "){},
	ERR_20004("20004", "涉嫌社会 "){},
	ERR_20006("20006", "涉嫌违法犯罪 "){},
	ERR_20008("20008", "涉嫌欺诈 "){},
	ERR_20013("20013", "涉嫌版权 "){},
	ERR_21000("21000", "涉嫌其他 "){},
	ERR_22000("22000", "涉嫌互推(互相宣传) "){},
	ERR_30001("30001", "原创校验出现系统错误且用户选择了被判为转载就不群发 "){},
	ERR_30002("30002", "原创校验被判定为不能群发 "){},
	ERR_30003("30003", "原创校验被判定为转载文且用户选择了被判为转载就不群发 "){},
	ERR_40001("40001", "获取access_token时AppSecret错误，或者access_token无效。请开发者认真比对AppSecret的正确性，或查看是否正在为恰当的公众号调用接口"){},
	ERR_40002("40002", "不合法的凭证类型"){},
	ERR_40003("40003", "不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID"){},
	ERR_40004("40004", "不合法的媒体文件类型"){},
	ERR_40005("40005", "不合法的文件类型"){},
	ERR_40006("40006", "不合法的文件大小"){},
	ERR_40007("40007", "不合法的媒体文件id"){},
	ERR_40008("40008", "不合法的消息类型"){},
	ERR_40009("40009", "不合法的图片文件大小"){},
	ERR_40010("40010", "不合法的语音文件大小"){},
	ERR_40011("40011", "不合法的视频文件大小"){},
	ERR_40012("40012", "不合法的缩略图文件大小"){},
	ERR_40013("40013", "不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写"){},
	ERR_40014("40014", "不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口"){},
	ERR_40015("40015", "不合法的菜单类型"){},
	ERR_40016("40016", "不合法的按钮个数"){},
	ERR_40017("40017", "不合法的按钮个数"){},
	ERR_40018("40018", "不合法的按钮名字长度"){},
	ERR_40019("40019", "不合法的按钮KEY长度"){},
	ERR_40020("40020", "不合法的按钮URL长度"){},
	ERR_40021("40021", "不合法的菜单版本号"){},
	ERR_40022("40022", "不合法的子菜单级数"){},
	ERR_40023("40023", "不合法的子菜单按钮个数"){},
	ERR_40024("40024", "不合法的子菜单按钮类型"){},
	ERR_40025("40025", "不合法的子菜单按钮名字长度"){},
	ERR_40026("40026", "不合法的子菜单按钮KEY长度"){},
	ERR_40027("40027", "不合法的子菜单按钮URL长度"){},
	ERR_40028("40028", "不合法的自定义菜单使用用户"){},
	ERR_40029("40029", "不合法的oauth_code"){},
	ERR_40030("40030", "不合法的refresh_token"){},
	ERR_40031("40031", "不合法的openid列表"){},
	ERR_40032("40032", "不合法的openid列表个数"){},
	ERR_40033("40033", "不合法的请求字符，不能包含xxxx格式的字符"){},
	ERR_40035("40035", "不合法的参数"){},
	ERR_40055("40055", "不完整的url，前面要加http://"){},
	ERR_40037("40037", "template_id不正确"){},
	ERR_40038("40038", "不合法的请求格式"){},
	ERR_40039("40039", "不合法的URL长度"){},
	ERR_40050("40050", "不合法的分组id"){},
	ERR_40051("40051", "分组名字不合法"){},
	ERR_40062("40062", "标题长度不合法"){},
	ERR_40097("40097", "参数不合法"){},
	ERR_40113("40113", "文件名称不合法，需包含正确后缀"){},
	ERR_40117("40117", "分组名字不合法"){},
	ERR_40118("40118", "media_id大小不合法"){},
	ERR_40119("40119", "button类型错误"){},
	ERR_40120("40120", "button类型错误"){},
	ERR_40121("40121", "不合法的media_id类型"){},
	ERR_40125("40125", "不合法的AppSecret，请开发者检查AppSecret的正确性，避免异常字符，注意大小写"){},
	ERR_40130("40130", "至少需要同时发送两个用户"){},
	ERR_40132("40132", "微信号不合法"){},
	ERR_40137("40137", "不支持的图片格式"){},
	ERR_40164("40164", "调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置"){},
	ERR_41001("41001", "缺少access_token参数"){},
	ERR_41002("41002", "缺少appid参数"){},
	ERR_41003("41003", "缺少refresh_token参数"){},
	ERR_41004("41004", "缺少secret参数"){},
	ERR_41005("41005", "缺少多媒体文件数据"){},
	ERR_41006("41006", "缺少media_id参数"){},
	ERR_41007("41007", "缺少子菜单数据"){},
	ERR_41008("41008", "缺少oauth code"){},
	ERR_41009("41009", "缺少openid"){},
	ERR_41028("41028", "form_id不正确，或者过期"){},
	ERR_41029("41029", "form_id已被使用"){},
	ERR_41030("41030", "page不正确"){},
	ERR_42001("42001", "access_token超时，请检查access_token的有效期，请参考基础支持-获取access_token中，对access_token的详细机制说明"){},
	ERR_42002("42002", "refresh_token超时"){},
	ERR_42003("42003", "oauth_code超时"){},
	ERR_43001("43001", "需要GET请求"){},
	ERR_43002("43002", "需要POST请求"){},
	ERR_43003("43003", "需要HTTPS请求"){},
	ERR_43004("43004", "需要接收者关注"){},
	ERR_43005("43005", "需要好友关系"){},
	ERR_44001("44001", "多媒体文件为空"){},
	ERR_44002("44002", "POST的数据包为空"){},
	ERR_44003("44003", "图文消息内容为空"){},
	ERR_44004("44004", "文本消息内容为空"){},
	ERR_45001("45001", "多媒体文件大小超过限制"){},
	ERR_45002("45002", "消息内容超过限制"){},
	ERR_45003("45003", "标题字段超过限制"){},
	ERR_45004("45004", "描述字段超过限制"){},
	ERR_45005("45005", "链接字段超过限制"){},
	ERR_45006("45006", "图片链接字段超过限制"){},
	ERR_45007("45007", "语音播放时间超过限制"){},
	ERR_45008("45008", "图文消息超过限制"){},
	ERR_45009("45009", "接口调用超过限制"){},
	ERR_45010("45010", "创建菜单个数超过限制"){},
	ERR_45015("45015", "回复时间超过限制"){},
	ERR_45016("45016", "系统分组，不允许修改"){},
	ERR_45017("45017", "分组名字过长"){},
	ERR_45018("45018", "分组数量超过上限"){},
	ERR_45028("45028", "没有群发的配额，配额已经用完"){},
	ERR_45047("45047", "客服下行消息超过上限"){},
	ERR_45157("45157", "标签名非法，请注意不能和其他标签重名"){},
	ERR_45158("45158", "标签名长度超过30个字节"){},
	ERR_45056("45056", "创建的标签数过多，请注意不能超过100个"){},
	ERR_45058("45058", "不能修改0/1/2这三个系统默认保留的标签"){},
	ERR_45057("45057", "该标签下粉丝数超过10w，不允许直接删除"){},
	ERR_45059("45059", "有粉丝身上的标签数已经超过限制"){},
	ERR_45159("45159", "非法的tag_id"){},
	ERR_46001("46001", "不存在媒体数据"){},
	ERR_46002("46002", "不存在的菜单版本"){},
	ERR_46003("46003", "不存在的菜单数据"){},
	ERR_46004("46004", "不存在的用户"){},
	ERR_47001("47001", "解析JSON/XML内容错误"){},
	ERR_48001("48001", "api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限"){},
	ERR_48002("48002", "粉丝拒收消息（粉丝在公众号选项中，关闭了 “ 接收消息 ” ）"){},
	ERR_48004("48004", "api 接口被封禁，请登录 admin.weixin.qq.com 查看详情"){},
	ERR_48005("48005", "api 禁止删除被自动回复和自定义菜单引用的素材"){},
	ERR_48006("48006", "api 禁止清零调用次数，因为清零次数达到上限"){},
	ERR_48008("48008", "没有该类型消息的发送权限"){},
	ERR_49003("49003", "传入的openid不属于此AppID"){},
	ERR_50001("50001", "用户未授权该api"){},
	ERR_50002("50002", "用户受限，可能是违规后接口被封禁"){},
	ERR_50005("50005", "用户未关注公众号"){},
	ERR_61003("61003", "请确认是否取消授权（第三方平台授权）"){},
	ERR_61004("61004", "当前ip未在白名单中，直接获取本地ip添加"){},
	ERR_61005("61005", " 组件 ticket已失效，重新接受授权url反馈的ticket"){},
	ERR_61006("61006", "获取componentTicket为null"){},
	ERR_61007("61007", "当前公众号或者小程序已在公众平台解绑"){},
	ERR_61009("61009", "授权码失效，重新授权"){},
	ERR_61451("61451", "参数错误(invalid parameter)"){},
	ERR_61452("61452", "无效客服账号(invalid kf_account)"){},
	ERR_61453("61453", "客服帐号已存在(kf_account exsited)"){},
	ERR_61454("61454", "客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid kf_acount length)"){},
	ERR_61455("61455", "客服帐号名包含非法字符(仅允许英文+数字)(illegal character in kf_account)"){},
	ERR_61456("61456", "客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)"){},
	ERR_61457("61457", "无效头像文件类型(invalid file type)"){},
	ERR_61450("61450", "系统错误(system error)"){},
	ERR_61500("61500", "日期格式错误"){},
	ERR_61501("61501", "日期范围错误"){},
	ERR_65400("65400", "API不可用，即没有开通/升级到新版客服功能"){},
	ERR_65401("65401", "无效客服帐号"){},
	ERR_65403("65403", "客服昵称不合法"){},
	ERR_65404("65404", "客服帐号不合法"){},
	ERR_65405("65405", "帐号数目已达到上限，不能继续添加"){},
	ERR_65406("65406", "已经存在的客服帐号"){},
	ERR_65407("65407", "邀请对象已经是该公众号客服"){},
	ERR_65408("65408", "本公众号已经有一个邀请给该微信"){},
	ERR_65409("65409", "无效的微信号"){},
	ERR_65410("65410", "邀请对象绑定公众号客服数达到上限（目前每个微信号可以绑定5个公众号客服帐号）"){},
	ERR_65411("65411", "该帐号已经有一个等待确认的邀请，不能重复邀请"){},
	ERR_65412("65412", "该帐号已经绑定微信号，不能进行邀请"){},
	ERR_99999("99999", "无法获取到文件名"){},
	ERR_9001001("9001001", "POST数据参数不合法"){},
	ERR_9001002("9001002", "远端服务不可用"){},
	ERR_9001003("9001003", "Ticket不合法"){},
	ERR_9001004("9001004", "获取摇周边用户信息失败"){},
	ERR_9001005("9001005", "获取商户信息失败"){},
	ERR_9001006("9001006", "获取OpenID失败"){},
	ERR_9001007("9001007", "上传文件缺失"){},
	ERR_9001008("9001008", "上传素材的文件类型不合法"){},
	ERR_9001009("9001009", "上传素材的文件尺寸不合法"){},
	ERR_9001010("9001010", "上传失败"){},
	ERR_9001020("9001020", "帐号不合法"){},
	ERR_9001021("9001021", "已有设备激活率低于50%，不能新增设备"){},
	ERR_9001022("9001022", "设备申请数不合法，必须为大于0的数字"){},
	ERR_9001023("9001023", "已存在审核中的设备ID申请"){},
	ERR_9001024("9001024", "一次查询设备ID数量不能超过50"){},
	ERR_9001025("9001025", "设备ID不合法"){},
	ERR_9001026("9001026", "页面ID不合法"){},
	ERR_9001027("9001027", "页面参数不合法"){},
	ERR_9001028("9001028", "一次删除页面ID数量不能超过10"){},
	ERR_9001029("9001029", "页面已应用在设备中，请先解除应用关系再删除"){},
	ERR_9001030("9001030", "一次查询页面ID数量不能超过50"){},
	ERR_9001031("9001031", "时间区间不合法"){},
	ERR_9001032("9001032", "保存设备与页面的绑定关系参数错误"){},
	ERR_9001033("9001033", "门店ID不合法"){},
	ERR_9001034("9001034", "设备备注信息过长"){},
	ERR_9001035("9001035", "设备申请参数不合法"){},
	ERR_9001036("9001036", "查询起始值begin不合法"){}
	;

	WxReturnCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
    private String code;
    private String msg;

    /**
     * 通过code获取msg
     * @param code
     * @return
     */
    public static String getMsg(String code) {
		try {
			return WxReturnCode.valueOf(code).getMsg();
		}catch (IllegalArgumentException e){
			return "未定义的返回码："+code;
		}
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "WxReturnCode{" + "code='" + code + '\'' + "msg='" + msg + '\'' + '}';
	}
	
}
