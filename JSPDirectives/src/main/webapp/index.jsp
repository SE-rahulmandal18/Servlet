<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date"
    pageEncoding="UTF-8"%>
    
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Directives</title>
</head>
<body>
 <br> Content from index.jsp
 <h4>Import directive demo</h4>
 Hello, today is  <%= new Date() %>
 
 <h4>Include file directive demo</h4>
 <%@ include file="file1.jsp" %>
 
 <br>
 Content from index.jsp  
 
 <h4>Taglib directive demo (core taglib)</h4><br>

<c:set var="counter" value="10"></c:set>
COUNTER =<c:out value="${counter}"></c:out>

<h4>2. Taglib directive demo (fmt taglib)</h4>
<br>

Currency =
<fmt:formatNumber value="145" type="currency" />

<p>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	Current date and time is
	<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
</p>
 
 
 
 
 
 
</body>
</html>