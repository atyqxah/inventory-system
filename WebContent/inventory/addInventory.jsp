<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD INVENTORY</title>
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

button2{

}

</style>
<link href="/healin/select2.min.css" rel="stylesheet" />
<script src="/healin/jquery-3.5.1.min.js"></script>
<script src="/healin/select2.min.js"></script>
<script>
	$(document).ready(function() {
	    
	    $("#add").click(function(e){
	    	$("#product").append('<div class="row2"><div id="" class="row">'+
  			'Product id:<br>'+
  			'<select name="productId" class="js-example-basic-single" required>'+
  				'<c:forEach items="${products}" var="product">'+
  					'<option value="${product.productId }">${product.productName}</option>'+
  				'</c:forEach>'+
  			'</select>'+
  			
  			'<br/>'+
  			'Quantity :<br>'+
  			'<input type="text" name="quantity" id="quantity" placeholder="" required="required" />'+
  			'</div>'+
  			'<button type="button" id="delete">Delete</button></div>');
	    	$('body').on('click', '#delete', function(e){
	    		$(this).parent('div').remove();
	    	})
	    	 $('.js-example-basic-single').select2();
	    });
	});
	</script>
</head>
<body>
			<br/><a href="/healin/OrderController?action=listOrder" class="button2">Back</a><br/><br><br>
			
			<form name="form1" method="post" id="ff" action="/healin/InventoryController">
			<div class ="container">
			<h1><legend><center><b>Inventory</b></center></legend></h1>
			<div class="row">
			<center>
			Date : <br>
  			<input type="date" name="invdate" id="txtDate" placeholder="" min="2015-10-28" required="required" />
  			<input type="hidden" name="orderid" value="${orderid }"  />
  			<input type="hidden" name="ordertype" value="${type }"  />
  			<br>

   			<div id="product"></div>
  			<button type="button" id="add" role="button">Add Inventory</button>
  			<button type="submit" name="action" value="Add">Submit</button>
	
	</form>
	<script>
	
    
	$(document).ready(function() {
		
		
	    
	    $(function(){
	        var dtToday = new Date();
	        
	        var month = dtToday.getMonth() + 1;
	        var day = dtToday.getDate();
	        var year = dtToday.getFullYear();
	        if(month < 10)
	            month = '0' + month.toString();
	        if(day < 10)
	            day = '0' + day.toString();
	        
	        var maxDate = year + '-' + month + '-' + day;
	        $('#txtDate').attr('min', maxDate);
	    });
	    
	    $('.js-example-basic-single').select2();
	    
	  
	    
	  
	});
	</script>
</body>
</html>