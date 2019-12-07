<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="../includes/inc.taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet" type="text/css" href="web/css/style.css"/>
	<script type="text/javascript" src="web/js/jquery-1.6.min.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<tiles:insertAttribute name="header"/>
		</div>
		<div class="content">
			<tiles:insertAttribute name="body"/>
		</div>
		<div>
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
	
</body>
</html>