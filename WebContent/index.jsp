<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="healin.model.Staff"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory Management System</title>
<link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/a076d05399.js">
</script>
</head>
<body>
<%
            Staff currentUser = (Staff) session.getAttribute("currentSessionUser");
        %>
<input type="checkbox" id="check">
<label for="check">
	<i class="fas fa-bars" id="btn"></i>
	<i class="fas fa-times" id="cancel"></i>
</label>
	<jsp:include page="sidebar.jsp"></jsp:include>
	
	<section><br>
			<br><center><img src="logo.png" alt="Paris" width="800" height="450" margin="auto"></center></br>
			</br>
		</section>
<!-- 
<br/><a href="staff/manageStaff.jsp">Staff</a><br/>
<br/><a href="product/manageProduct.jsp">Product</a><br/>
<br/><a href="branch/manageBranch.jsp">Branch</a><br/>
<br/><a href="order/manageOrder.jsp">Order</a><br/> -->
</body>
</html>