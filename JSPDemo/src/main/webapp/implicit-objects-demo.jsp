<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>implicit-objects-demo.jsp</title>
</head>
<body>

<%
	String responseCheck = request.getParameter("office");

	if (responseCheck != null) {

		response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "response-redirect.jsp?office=" + responseCheck);

	}

	String errorCheck = request.getParameter("error");

	//simulate throw error

	if (errorCheck != null) {

		int x = 0;

		if (x == 0)

			throw new RuntimeException("Exception has been raised");

	}
%>


</body>
</html>