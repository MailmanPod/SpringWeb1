<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<h1>List of all users registered</h1>
	<div align="center">

		<table border="2">
			<th>No</th>
			<th>User Name</th>
			<th>User Start Date</th>
			<th>User End Date</th>
			<th>User Password</th>
			<th>Actions</th>

			<c:forEach var="user" items="${allUsers }">
				<tr>
					<td>${user.id }</td>
					<td>${user.userId }</td>
					<td>${user.startDate }</td>
					<td>${user.endDate }</td>
					<td>${user.password }</td>
					<td><a
						href='<c:out value="${pageContext.request.contextPath}/user/editRedirect/${user.userId }"></c:out>'>
							Edit</a> |||||||| <a
						href='<c:out value="${pageContext.request.contextPath}/user/delete/${user.userId }"></c:out>'>
							Delete</a></td>
				</tr>
			</c:forEach>

		</table>
		
		<a href='<c:out value="/user/registerRedirect"></c:out>'>Register
			new User</a>
		
	</div>

	<p>
		<a href='<c:url value="/"></c:url>'> Home Page</a>
	</p>
</body>
</html>