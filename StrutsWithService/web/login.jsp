<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<center>
		<s:form action="login">
			<s:textfield name="username" label="Username" />
			<s:textfield name="password" label="Password" />
			<s:submit value="login" />
			<s:reset value="reset" />
		</s:form>

		<a href="register.jsp">Sign up</a>
	</center>
</body>
</html>