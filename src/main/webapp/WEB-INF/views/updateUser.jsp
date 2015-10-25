<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>

	<h1>Edit user properties</h1>

	<div align="center">

		<form:form action="${pageContext.request.contextPath}/user/update"
			method="post" commandName="original">

			<table border="0">
				<tr>
					<td colspan="2" align="center">
						<h2>Edit current user</h2>
					</td>
				</tr>
				
				<form:hidden path="startDate"/>
				<form:hidden path="id"/>
				
				<tr>
					<td>User Name:</td>
					<td><form:input path="userId" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>

				<tr>
					<td>End Date:</td>
					<td><form:input path="endDate" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Edit"></td>
				</tr>
			</table>
		</form:form>
	</div>
	<p>
		<a href='<c:out value="/"></c:out>'> Home Page</a>
	</p>
</body>
</html>