<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>蓉华教育（学员）后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="/styles/base.css" />
    <link rel="stylesheet" type="text/css" href="/styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css" />
    <script type="text/javascript" src="/scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/scripts/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="/scripts/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/styles/login.css" />
</head>
<body>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>

	<form action="/login" method="post">
	    <div class="row-fluid">
	        <h1>蓉华教育（学员）后台管理系统</h1>
	        <p>
	            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" name="username" /></label>
	        </p>
	        <p>
	            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /></label>
	        </p>
	        <p class="pcode">
	            <label>效验码：<input type="text" id="code" name="code" maxlength="5" class="code" value="e5g88" /><img src="img/code.gif" alt="" class="imgcode" /><a href="#">下一张</a></label>
	        </p>
	        <p class="tip">&nbsp;</p>
	        <hr />
	        <input type="submit" value=" 登 录 " class="btn btn-primary btn-large login" />
	        &nbsp;&nbsp;&nbsp;<input type="reset" value=" 取 消 " class="btn btn-large" />
	    </div>
    </form>
</body>
</html>
