<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Inventory Management System</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
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
	font-size: 16px;
	background: #f2f2f2;
	box-shadow: none !important;
	border-color: transparent;
}
.form-control:focus {
	border-color: #d3d3d3;
}
.form-control, .btn {        
	border-radius: 2px;
}
.login-form {
	width: 380px;
	margin: 0 auto;
	font-size: 15px;
}
.login-form h2 {		
	margin: 0;
	padding: 30px 0;
	font-size: 34px;
}

.login-form form {
	color: #7a7a7a;
	border-radius: 4px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;		
}	
.login-form .btn, .login-form .btn:active {
	font-weight: bold;
	background: #063146 !important;
	border: none;
	margin-bottom: 20px;
}
.login-form .btn:hover, .login-form .btn:focus {
	background: #1275a6 !important;
}
.login-form a {
	color: #ef3b3a;
}	
.login-form form a {
	color: #1275a6;
}
.login-form a:hover, .login-form form a:hover {
	text-decoration: underline;
}
.hint-text {
	color: #999;
	text-align: center;
}
.form-footer {
	padding-bottom: 15px;
	text-align: center;
}
</style>
</head>
<body>
<div class="login-form">
	
    <form name="form1" method="post" id="ff" action="/healin/loginController">
      <h2 class="text-center"><b>Login</b></h2>
        <div class="form-group">
          <label><h5>User ID:</h5></label>
        	<input type="text" class="form-control input-lg" name="staffId" required="required">
        </div>
      <div></div>
		<div class="form-group">
          <label><h5>Password:</h5></label>
            <input type="password" class="form-control input-lg" name="password" required="required">
        </div>        
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Sign in</button>
        </div>
      
    </form>
</div>
</body>
</html>