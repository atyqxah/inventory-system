<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product</title>
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
 <script type="text/javascript">
	function showHide() {
		if(document.getElementById('productType').value == "Health") {
			document.getElementById('Health').style.display = 'block';	
		} else {
			document.getElementById('Health').style.display = 'none';
		}
		
		if(document.getElementById('productType').value == "Beauty") {
			document.getElementById('Beauty').style.display = 'block';	
		} else {
			document.getElementById('Beauty').style.display = 'none';
		}
	}
</script>
</head>
<body>
		<br/><a href="/healin/ProductController?action=listProduct" class="button2">Back</a><br/><br><br>
		<form name="form1" method="post" id="ff" action="../ProductController">
		<div class ="container">
		<h1><legend><center><b>Add Product</b></center></legend><h1></h1>
		<center>
		Product ID:<br>
		<input type="number" name="productId" id="productId" placeholder="Enter product id" required="required"/>
		<br>
		Product Name:<br>
		<input type="text" name="productName" id="productName" placeholder="Enter product name" required="required"/>
		<br>
		Size:<br>
		<input type="text" name="productSize" id="productSize" placeholder="Enter size" required="required"/>
		<br>
		Price:<br>
		<input type="text" name="productPrice" id="productPrice" placeholder="Enter price" required="required"/>
		<br>
		Stock:<br>
		<input type="number" name="currentStock" id="currentStock" placeholder="Enter stock" required="required"/>
		<br>

		Product type:<br>
		<select name="productType" id="productType" onchange="showHide();" class='form-control'>
		<option value="-1">Select</option>
		<option value="Health">Health</option>
		<option value="Beauty">Beauty</option>
		</select>
		
			<div id="Health" style="display: none;" >
			
			<div class="form-group">
		
			<label for="Health">Supplement:</label>
			<select name="supplementType" class='form-control'>
			<option value="-1">Choose</option>
			<option value="Category A">Category A</option>
			<option value="Category B">Category B</option>
			<option value="Category C">Category C</option>
			</select>
			
			</div>
			<div class="form-group">
			Suggestion :
			<textarea class="form-control" cols="30" rows="5" name="suggestion" id="suggestion" placeholder=" " /></textarea>
			
			</div>
			</div>
			
			<div id="Beauty" style="display: none;">
			
			Beauty:
			<select name="makeupType" class="form-control" >
			<option value="-1">Choose</option>
			<option value="Cleansing">Cleansing</option>
			<option value="Blemish">Blemish</option>
			<option value="Moisturizer">Moisturizer</option>
			<option value="Sunscreen">Sunscreen</option>
			<option value="Lipstick">Lipstick</option>
			</select>
			<br>
			Direction:
			<textarea class="form-control"  cols="30" rows="5" name="direction" id="direction" placeholder=" " /></textarea>
			<br>
			</div>
			<br><br>
		<center><input type="submit" value="Submit"><center>
		</div>
	</form>
	</center>
		



</body>
</div>
</html>
