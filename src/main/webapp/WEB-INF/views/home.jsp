<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Index</title>
</head>
<body>
	<h1>Entity Management</h1>
	<p>
		Link 1: <a href='<c:out value="/user/list"></c:out>'>User Management</a>
	</p>

</body>
</html>
