<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>二维码页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>请使用微信扫一扫(请先扫描该测试公众号并关注)</h1>
  	<h3>测试公众号</h3>
  	<img alt="测试公众号" src="./resources/image/test.jpg">
  	<h3>顾客登录二维码</h3>
    <div id="qrcode1"></div><br>
    由于域名备案正在审核中导致无法访问，可直接网址访问<a href="/o2o/frontend/index">39.105.209.218/o2o/frontend/index</a>
    <h3>店家登录二维码</h3>
    <div id="qrcode2"></div><br>
    由于域名备案正在审核中导致无法访问，可直接网址访问<a href="/o2o/shopadmin/shoplist">39.105.209.218/o2o/shopadmin/shoplist</a>(测试店家账号：dd 密码：301520)
    <script type="text/javascript" src="./resources/js/common/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="./resources/js/common/jquery.qrcode.min.js"></script>
    <script type="text/javascript" src="./resources/js/wechatlogin/login.js"></script>
  </body>
</html>
