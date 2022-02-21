<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	Business Service executed!
	<br>
	<br>
	<h2>
		<b> USER LOGGED IN SUCCESSFULLY </b>
	</h2>
	<center>
		<p><a href="<s:url action='showUsers'/>">Show all users</a></p>
	</center>
</body>
</html>