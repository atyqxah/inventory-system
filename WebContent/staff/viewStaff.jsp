<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Staff</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #4e4e4e;
	background: #cfedfc;
	font-family: Calibri, Helvetica, sans-serif;
}
.form-control {
	min-height: 200px;
	background: #fff;
	box-shadow: none !important;
	border-color: #e3e3e3;
}
.form-control:focus {
	border-color: #70c5c0;
}

.view-form {
	height: 1px;
	width: 500px;
	margin: 0 auto;
	padding: 40px 0 30px;		
}
.view-form form {
	color: #000000;
	border-radius: 2px;
	margin-bottom: 15px;
	font-size: 16px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;	
	position: relative;	
}
.view-form h2 {
	font-size: 22px;
	margin: 50px 0 50px;
}
.view-form a {
	color: #000000;
	text-decoration: underline;
}
.view-form a:hover {
	text-decoration: none;
}
.view-form form a {
	color: #000000;
	text-decoration: none;
}
.view-form form a:hover {
	text-decoration: underline;
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
}
</style>
</head>
<body>
  <div class="form-group">
           <br/><a href="StaffController?action=listStaff" class="button2">Back</a></div>

<div class="view-form">
    <form>    
      <legend><center><b>View Staff</b></center></legend>
    
    <div >
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Staff ID</td>
                        <td>:</td>
                        <td><c:out value="${staff.staffId}" /></td>
                      </tr>
                       <tr>
                        <td>Staff IC</td>
                         <td>:</td>
                        <td><c:out value="${staff.staffIc}" /></td>
                      </tr>
                      <tr>
                        <td>Staff Name</td>
                        <td>:</td>
                        <td><c:out value="${staff.staffName}" /></td>
                      </tr>
                       <tr>
                        <td>Phone Number</td>
                         <td>:</td>
                        <td><c:out value="${staff.staffPhone}" /></td>
                      </tr>
                      <tr>
                        <td>Address</td>
                        <td>:</td>
                        <td><c:out value="${staff.staffAddress}" /></td>
                      </tr>
                      <tr>
                        <td>Manager ID</td>
                        <td>:</td>
                        <td><c:out value="${staff.managerId}" /></td>
                      </tr>
                      <tr>
                        <td>Role</td>
                        <td>:</td>
                        <td><c:out value="${staff.roles}" /></td>
                      </tr>
                      <tr>
                        <td>Branch</td>
                        <td>:</td>
                        <td><c:out value="${staff.branchId}" /></td>
                      </tr>
                      <tr>
                        <td>Nickname</td>
                        <td>:</td>
                        <td><c:out value="${staff.username}" /></td>
                      </tr>
                      <tr>
                        <td>Password</td>
                        <td>:</td>
                        <td><c:out value="${staff.password}" /></td>
                      </tr>
                    </tbody>
                  </table>
            </div>
             
       
    </form>
  
</div>
</body>
</html>