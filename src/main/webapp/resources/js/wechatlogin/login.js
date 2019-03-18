//生成二维码
$(function() {
	//生成二维码
	var text = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxeca617ee89ebfbcd&redirect_uri=http://xiaolaodi.store/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect"
	$("#qrcode1").qrcode({
		width : 200,
		height : 200,
		text : text
	})
	
	var text = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxeca617ee89ebfbcd&redirect_uri=http://xiaolaodi.store/o2o/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=2#wechat_redirect"
	$("#qrcode2").qrcode({
		width : 200,
		height : 200,
		text : text
	})
})