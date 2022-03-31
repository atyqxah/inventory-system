<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Inventory</title>
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
  width: 700px;  
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
<center>
	<br/><a href="InventoryController?action=listOrder" class="button2">Back</a><br/><br><br>
		
	<br><b>Order ID:</b> <c:out value="${orders1.orderId}" />         
	<br>                         
	<br><b>Order Type:</b> <c:out value="${orders1.ordertype}" />
	<br>
	<br><b>Status:</b> <c:out value="${orders1.ordertype}" />
	<br>
	<br><b>Staff ID:</b> <c:out value="${orders1.staffId}" />
<center>
	<br><br><br>
	<form>
	<center>
	<table class="a">	
	<thead>
    	<tr><th>Order Id</th>
        	<th>Product Id</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Date</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody class="a">
        	<tr>
        		<td>1</td>
        		<td>2</td>                                    
                <td>Zaniplus</td>
                <td>2</td>      
                <td>12/7/2020</td> 
                 
               <td><a href="InventoryController?action=deleteInventory&orderId=<c:out value="${orders.orderId}" />&orderId=<c:out value="${inventory.productId}" />&productId=<c:out value="${inventory.quantity}" />">Delete</a>        
         		<a href="InventoryController?action=updateInventory&orderId=<c:out value="${orders.orderId}" />&orderId=<c:out value="${inventory.productId}" />&productId=<c:out value="${inventory.quantity}" />">Update</a></td>         
         
        	</tr>
        	<tr>
        		<td>1</td>
        		<td>4</td>                                    
                <td>Facial Cleansing Gel</td>
                <td>12</td>      
                <td>12/7/2020</td> 
                 
                <td><a href="InventoryController?action=deleteInventory&orderId=<c:out value="${orders.orderId}" />&orderId=<c:out value="${inventory.productId}" />&productId=<c:out value="${inventory.quantity}" />">Delete</a>        
         		<a href="InventoryController?action=updateInventory&orderId=<c:out value="${orders.orderId}" />&orderId=<c:out value="${inventory.productId}" />&productId=<c:out value="${inventory.quantity}" />">Update</a></td>              
         
        	</tr>
        	</tbody>
    </table>
    <br><br>
    <div class="pull-right">
<a href="" onclick="window.print()" class="btn btn-info"><i class="icon-print icon-large"></i> Print</a>
</div>
    </form>
</body>
</html>