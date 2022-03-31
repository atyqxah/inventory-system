<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Inventory</title>
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
		<br/><a href="/healin/InventoryController?action=listInventory" class="button2">Back</a><br/><br><br>
		<form name="form1" method="post" id="ff" action="InventoryController">
		<div class ="container">
		<h1><legend><center><b>Update Inventory</b></center></legend><h1></h1>
			<center>
			Inventory id:<br>	
			<input type="text" name="inventoryId" id="inventoryId" value="<c:out value="${inventory.inventoryId}" />"readonly/></br>
        	<br>
  			Order id:<br>
  			<input type="text" name="orderId" id="orderId" value="<c:out value="${inventory.orderId}" />"readonly"/>
  			<br>
  			Product id:<br>
  			<input type="text" name="productId" id="productId" value=" <c:out value="${inventory.productId}" />" readonly/>		
  			<br/>
  			Quantity :<br>
  			<input type="text" name="quantity" id="quantity" value="<c:out value="${inventory.quantity}" />" />
  			<br>
  			Date : <br>
  			<input type="text" name="invdate" id="invdate" value="<c:out value="${inventory.invdate}" />" />
  			<br>
  			Description : <br>
  			<input type="text" name="description" id="description" value="<c:out value="${inventory.description}" />" />
			
			<br><input class="sendButton" type="submit" name="submitcontact" value="Submit">
	
	</center>
	</form>
</body>
</html>