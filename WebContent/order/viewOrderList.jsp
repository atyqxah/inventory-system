<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory Management System</title>
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
	width: 70%;
	margin-left: 30%;
	margin-right: 30%;
	style="text-align:center;"
} 
table.a {
  table-layout: auto;
  width: 1000px;  
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
	<br/><br/><br/><br><br>
	 <c:choose>
   	<c:when test="${roles == 'staff' }">
   		<a href="order/addOrder.jsp" class="button2">Add Order</a>
   	</c:when>
   </c:choose>
	
	
	<br/>



	<center>
	<table>
	
    	<tr>
        	<th>Order Id</th>
            <th>Order Type</th>
            <th>Status Order</th>
            <th>Staff Id</th>
           	<th>Action</th>
        </tr>
        
        <c:forEach items="${ordersa}" var="orders1">
        	<tr>
            	<td><c:out value="${orders1.orderId}" /></td>                                   
                <td><c:out value="${orders1.ordertype}" /></td>
                <td><c:out value="${orders1.orderstatus}" /></td>
                <td><c:out value="${orders1.staffId}" /></td>
                    
                <td>
                             
               <c:choose>
			   	<c:when test="${roles == 'staff' }">
			   		<c:if test="${orders1.orderstatus == 'pending'}">
			   		<a href="InventoryController?action=addInventory&id=<c:out value="${orders1.orderId}" />&type=<c:out value="${orders1.ordertype}" />">Add Inventory</a>
			   		</c:if>
			   		<a href="OrderController?action=viewOrder&id=<c:out value="${orders1.orderId}" />">view</a>             
	                <a href="OrderController?action=deleteOrder&id=<c:out value="${orders1.orderId}" />">delete</a>
	                <c:if test="${orders1.orderstatus == 'pending'}">
	                <a href="OrderController?action=updateOrder&id=<c:out value="${orders1.orderId}" />">update</a>
	                </c:if>
			   	</c:when>
			   	<c:otherwise>
			   		<a href="OrderController?action=viewOrder&id=<c:out value="${orders1.orderId}" />">view</a>
			   	</c:otherwise>
			   </c:choose>          
			   
                </td>
        	</tr>
        </c:forEach>
        
    </table>
</body>
</html>