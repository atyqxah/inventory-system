<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff List</title>
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
  width: 100%;  
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
	
	
	<br/><br/><br/><br><br><a href="./staff/registerStaff.jsp" class="button2">Register Staff</a><br/>
	<br><br>
	<center>
	<table class="a">
	
    	<tr>
        	<th>Staff ID</th>
        	<th>Staff IC</th>
            <th>Staff Name</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Manager ID</th>
            <th>Roles</th>
            <th>Branch</th>
            <th>Nickname</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        
        <c:forEach items="${staffs}" var="staff">
        	<tr>
            	<td><c:out value="${staff.staffId}" /></td>         
            	<td><c:out value="${staff.staffIc}" /></td>                            
                <td><c:out value="${staff.staffName}" /></td>
                <td><c:out value="${staff.staffPhone}" /></td>
                <td><c:out value="${staff.staffAddress}" /></td>
                <td><c:out value="${staff.managerId}" /></td>
                <td><c:out value="${staff.roles}" /></td>
                <td><c:out value="${staff.branchId}"/></td>
                <td><c:out value="${staff.username}" /></td>
                <td><c:out value="${staff.password}" /></td>
                    
               <td><a href="StaffController?action=viewStaff&id=<c:out value="${staff.staffId}" />">view</a>
               <a href="StaffController?action=deleteStaff&id=<c:out value="${staff.staffId}" />">delete</a>
               <a href="StaffController?action=updateStaff&id=<c:out value="${staff.staffId}"/>">update</a></td>
        	</tr>
        </c:forEach>
        
    </table>

</body>
</html>