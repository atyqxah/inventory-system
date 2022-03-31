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
<title>Update Staff</title>
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
		rs = stmt.executeQuery("select * from branch");
		%>

<br/><a href="StaffController?action=listStaff" class="button2">Back</a><br/><br><br>
	<form name="form1" method="post" id="ff" action="StaffController">
	<div class ="container">
	
		<h1><legend><center><b>Update Staff</b></center></legend><h1></h1>
		<center>
		Staff ID: <br>
		<input type="number" name="staffId" id="id" value="<c:out value="${staff.staffId}" />" readonly/><br>
		Staff IC:<br>
		 <input type="number" name="staffIc" id="sic" value="<c:out value="${staff.staffIc}" />" /><br>
		Staff Name: <br>
		<input type="text" name="staffName" id="name" value="<c:out value="${staff.staffName}" />"/><br>		
		Phone Number:<br> 
		<input type="text" name="staffPhone" id="phone" value="<c:out value="${staff.staffPhone}" />"/><br>
		Address:<br> 
		<input type="text" name="staffAddress" id="address" value="<c:out value="${staff.staffAddress}" />"/><br>
		Manager ID : <br>
		<input type="number" name="managerId" id="manager" value="<c:out value="${staff.managerId}" />"/><br>
		Role : <br>
		<!--  <input type="text" name="roles" id="roles" value="<c:out value="${staff.roles}" />"readonly/><br>-->
		<select name="roles" id="roles">
		<option selected hidden value="<c:out value="${staff.roles}"/>"> <c:out value="${staff.roles}"/></option>
  		<option value="Manager">Manager</option>
  		<option value="Staff">Staff</option>
  		</select><br>		
		
		Branch ID:<br>
		<!--  <input type="text" name="branchId" id="branchId" value="<c:out value="${staff.branchId}" />"readonly/><br>-->
  		 <select name="branchId" id="branchId">
  		  <option selected hidden value ="<c:out value="${staff.branchId}"/>"><c:out value="${staff.branchName}"/></option>
  		  <% 
  		  	while(rs.next()){ %>
  		  		
  		  	<option value ="<%=rs.getString("branchId") %>"> <%=rs.getString("branchName")%></option>
  		  <% } %>
  		
  		  </select>	<br>
		Nickname :<br>
		<input type="text" name="username" id="username" value="<c:out value="${staff.username}" />"/><br>
		Password :<br>
		<input type="text" name="password" id="password" value="<c:out value="${staff.password}"  />"/><br>
		
		
		<input class="sendButton" type="submit" name="submitcontact" value="Update">
	
	
	</form>
	</center>
</div>
</body>
</html>
