<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
		
		<br/><a href="ProductController?action=listProduct">Back</a><br/><br><br>
		
		<form name="form1" method="post" id="ff" action="ProductController">
	
		Product id:<br>
		<input type="number" name="productId" id="pid" value="<c:out value="${product.productId}"/>" readonly/><br>
		Product Name:<br>
		<input type="text" name="productName" id="name" value="<c:out value="${product.productName}"/>"/><br>
		Size:<br>
		<input type="text" name="productSize" id="size" value="<c:out value="${product.productSize}"/>"/><br>
		Price:<br>
		<input type="number" name="productPrice" id="price" value="<c:out value="${product.productPrice}"/>" /><br>
		Stock:<br>
		<input type="number" name="currentStock" id="stock" value="<c:out value="${product.currentStock}"/>"/><br>
		
		<br><input class="sendButton" type="submit" name="submitcontact" value="Update">
		</form>
</body>
</html>
