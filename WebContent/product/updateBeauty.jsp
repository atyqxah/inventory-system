<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, java.sql.*, java.net.*,
oracle.jdbc.*, oracle.sql.*" %>
<%@ page import="healin.connection.ConnectionManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Beauty</title>
<style>
body {
	color: #4e4e4e;
	background: #cfedfc;
	font-family: Calibri, Helvetica, sans-serif;
}

table.center{
	border-collapse: collapse;
	width: 70%;
	margin-left: 30%;
	margin-right: 30%;
	style="text-align:center;"
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

input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=number], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

 .content {
  max-width: 500px;
  max-height: 500px;
  margin: auto;
  background: white;
  padding: 70px;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.container {
  border-radius: 2px;
  background-color: #f2f2f2;
  padding: 10px;
  max-width: 500px;
  margin: auto;
}

.button2 {
  background-color: #000000;
  font-family: Calibri, Helvetica, sans-serif;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
  margin-left: auto;
  margin-right: auto;
  position: absolute;
  left: 0px;
}
</style>
</head>
<body>

		<%
		Connection currentCon = ConnectionManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		stmt = currentCon.createStatement();
		rs = stmt.executeQuery("select * from beauty");
		%>
		
		<br/><a href="ProductController?action=listProduct" class="button2">Back</a><br/><br><br>
		
		<form name="form1" method="post" id="ff" action="ProductController">
		<div class ="container">
		<h1><legend><center><b>Update Product</b></center></legend><h1></h1>
		<center>
		Product id:<br>
		<input type="number" name="productId" id="pid" value="<c:out value="${beauty.productId}"/>" readonly/><br>
		Product Name:<br>
		<input type="text" name="productName" id="name" value="<c:out value="${beauty.productName}"/>"readonly/><br>
		Size:<br>
		<input type="text" name="productSize" id="size" value="<c:out value="${beauty.productSize}"/>"readonly/><br>
		Price:<br>
		<input type="text" name="productPrice" id="price" value="<c:out value="${beauty.productPrice}"/>" /><br>
		Stock:<br>
		<input type="number" name="currentStock" id="stock" value="<c:out value="${beauty.currentStock}"/>"/><br>
		Product Type :<br>
		<input type="text" name="productType" value="<c:out value="${beauty.productType}"/>" readonly/><br>
	
		<br>
		Makeup Type : <br>
		<input type="text" name="makeupType" value="<c:out value="${beauty.makeupType}"/>" readonly><br>
		<!--  <select name="makeupType">
		<option value=""> <c:out value="${beauty.makeupType}"/></option>
		<option value="Cleansing">Cleansing</option>
		<option value="Blemish">Blemish</option>
		<option value="Moisturizer">Moisturizer</option>
		<option value="Sunscreen">Sunscreen</option>
		<option value="Lipstick">Lipstick</option>
		</select>-->
		<br>
        Direction : <br>
        <input type="text"  name="direction" cols="30" rows="5"  id="direction" value="<c:out value="${beauty.direction}"/>"></textarea><br>
        
		<br><input class="sendButton" type="submit" name="submitcontact" value="Update">
		</form>
		</center>
</body>
</html>