<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory Management System</title><link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/a076d05399.js">
</script>
<style>
body{
	color: #4e4e4e;
	background: #cfedfc;
}
table.center{
	border-collapse: collapse;
	width: 70%;
	margin-left: 30%;
	margin-right: 30%;
	style="text-align:center;"
} 
table.a {
  table-layout: auto;
  width: 1100px;  
}

th,td{
	text-align: left;
	padding: 8px;
}

tr:nth-child(even){
	background-color: #f2f2f2
}

th{
	background-color: #00bfff;
	color: white;
}
.button2 {
  background-color:#0086b3;
  font-family: Calibri, Helvetica, sans-serif;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  cursor: pointer;
  margin-left: auto;
  margin-right: auto;
}
</style>
</head>
<body>
<input type="checkbox" id="check">
<label for="check">
	<i class="fas fa-bars" id="btn"></i>
	<i class="fas fa-times" id="cancel"></i>
</label>
	<jsp:include page="../sidebar.jsp"></jsp:include>
<br/><br/><br/><br/>

 <c:choose>
   	<c:when test="${roles == 'manager' }">
   		<a href="product/addProduct.jsp" class="button2">Add Product</a>
   	</c:when>
   </c:choose>
<br><br>

	<center>
	<table class="a">
	
    	<tr>
        	<th>Product Id</th>
            <th>Product Name</th>
            <th>Size</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Product Type</th>
            <th>Action</th>
        </tr>
        
        <c:forEach items="${products}" var="product">
        	<tr>
            	<td><c:out value="${product.productId}" /></td>                                   
                <td><c:out value="${product.productName}" /></td>
                <td><c:out value="${product.productSize}" /></td>
                <td><c:out value="${product.productPrice}" /></td>
                <td><c:out value="${product.currentStock}" /></td>
                <td><c:out value="${product.productType}" /></td>
                    
                <td>
                <a href="ProductController?action=viewProduct&id=<c:out value="${product.productId}" />">view</a>
                <c:choose>
                	<c:when test="${roles == 'manager' }">
                		<a href="ProductController?action=deleteProduct&id=<c:out value="${product.productId}" />">delete</a>
                		<a href="ProductController?action=updateProduct&id=<c:out value="${product.productId}" />">update</a>
                	</c:when>
                </c:choose>
                
                
                </td>
        	</tr>
        </c:forEach>
        
    </table>
    <br><br><br>
    <div class="pull-right">
<a href="" onclick="window.print()" class="btn btn-info"><i class="icon-print icon-large"></i> Print</a>
</div>
    </center>
</body>
</html>