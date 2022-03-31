<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory List</title>
<link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/a076d05399.js">
</script>
<style>
body{
	color: #4e4e4e;
	background: #cfedfc;
}
table.center{
	border-collapse: collapse;
	width: 100%;
	margin-left: 30%;
	margin-right: 30%;
	style="text-align:center;"
} 
table.a {
  table-layout: auto;
  width: 500px;  
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
		<br/><br/><br/><br/><a href="/healin/InventoryController?action=addInventory" class="button2">Add Order</a><br>
	
	<br><br>
	
	
	
	<center>
	<table class="a">
	
    	<tr>
            <th>Order Id</th>
            <th>Order Type</th>
            <th>Status</th>
            <th>Staff Id</th>
            <th>Action</th>
        </tr>
        
        <c:forEach items="${ordersa}" var="orders1">
        	<tr>
            	<td><c:out value="${orders1.orderId}" /></td>                                   
                <td><c:out value="${orders1.ordertype}" /></td>
                <td><c:out value="${orders1.orderstatus}" /></td>
                <td><c:out value="${orders1.staffId}" /></td>
                
                <td><a href="InventoryController?action=viewInventory&id=<c:out value="${orders1.orderId}" />">View Inventory</a></td>              
        	</tr>
        </c:forEach>
        
    </table>
    </center>

</body>
</html>