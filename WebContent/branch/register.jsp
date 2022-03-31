<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Branch</title>
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

		<br/><a href="/healin/BranchController?action=listBranch" class="button2">Back</a>
		<form name="form1" method="post" id="ff" action="../BranchController">
		<div class ="container">
		<h1><legend><center><b>Add New Branch</b></center></legend><h1></h1>
		<center>
		<!-- Branch ID:<br>
		<input type="text" name="branchId" id="branchId" placeholder="Enter branch id" required="required"/>
		<br> -->
		Address:<br>
		<textarea name="branchAddress" id="branchAddress" cols="31" rows="8" placeholder="Enter branch address" required="required"/></textarea>
		<br>
		Phone Number:<br>
		<input type="number" name="branchPhone" id="branchPhone" placeholder="Enter phone number" required="required"/>
		<br>
		Branch : <br>
		<input type="text" name="branchName" id="branchName" placeholder="Enter Branch" required="required"/>
		<br><br>
		<input type="submit" value="Submit">
		</center>
		</form>

</div>
</body>
</html>