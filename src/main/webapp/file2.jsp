<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Java Bean</title>
</head>
<body>

<h3>Display Bean properties of productBean121 (the bean was created in file1.jsp)</h3>

<jsp:useBean id="productBean121" class="com.simpli.ProductBean"
	scope="session"></jsp:useBean>

Product Id:<jsp:getProperty name="productBean121" property="productId" />
<br>
Product Name:<jsp:getProperty name="productBean121" property="productName" />
<br>
Product Price:<jsp:getProperty name="productBean121" property="price" />
<br>


<h3>Display Bean properties of productBean122 (the bean was created in file1.jsp and its
properties was set from an HTML form)</h3>
<jsp:useBean id="productBean122" class="com.simpli.ProductBean"
	scope="session"></jsp:useBean>
Product Id:<jsp:getProperty name="productBean122" property="productId" />
<br>
Product Name:<jsp:getProperty name="productBean122" property="productName" />
<br>
Product Price:<jsp:getProperty name="productBean122" property="price" />
<br>
  
</body>
</html>