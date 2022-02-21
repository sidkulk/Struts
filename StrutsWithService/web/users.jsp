<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>User list</title>
</head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<body>


	<table>
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<s:iterator value="userList">
			<tr>
				<td><s:property value="username" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="password" /></td>
			</tr>
		</s:iterator>
	</table>


</body>
</html>