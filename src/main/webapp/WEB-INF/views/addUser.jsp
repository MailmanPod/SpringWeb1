<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>
</head>
<body>
	<h1>Adding new user to the database</h1>

	<div align="center">
	
		<form:form action="${pageContext.request.contextPath}/user/register" method="post" commandName="userForm">
			<table border="0">

				<tr>
					<td colspan="2" align="center">
						<h2>Add new User!!!</h2>
					</td>
				</tr>
				<tr>
					<td>User name:</td>
					<td><form:input path="userId" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register"></td>
				</tr>

			</table>

		</form:form>

	</div>
<p> <a href='<c:out value="/user/list"></c:out>'> Back to list of users</a> </p>
</body>
</html>