<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory Management System</title>
<link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/a076d05399.js">
</script>
  <style>
    .view-form {
	height: 1px;
	width: 700px;
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
  </style>
</head>
<body>
<input type="checkbox" id="check">
<label for="check">
	<i class="fas fa-bars" id="btn"></i>
	<i class="fas fa-times" id="cancel"></i>
</label>
		<jsp:include page="sidebar.jsp"></jsp:include>
	
	<section><br>
  <div class="view-form">
    <form>    
	
      
      <legend><center><h3><b>ABOUT</b></h3></center></legend>
      <br></br>
			<p>In 1996, Professor Dato Dr Hassan Yaakob established Healwell Pharmaceuticals Sdn Bhd by sharing formulation with consumers. Through extensive research about beneficial use of gamat (StichopusHorrens Extract) in traditional healing, Professor Dato Dr Hassan Yaakob developed Gamodulin and used it to create a range of products.</p>
  <br></br>
In the meantime, House of Healin is a leading pharmaceutical company in Malaysia that markets health supplement as well as personal and skincare product under the HEALIN brands name. Besides, House of Healin strives to bring their products through innovation because it has always been the strategy of choice, research and development has borne fruit to the development of a series of healthcare products. Moreover, House of Healin is respected and well known for the introduction of new concepts of health focusing specially on sophistication, simple and effective.</p><br></br>
  <p>The CEO of House of Healin is Professor Datuk Dr Hassan Yaacob. Furthermore, the House of Healin HQ in Malaysia is more than 18 store and over 53 dealer and pharmacies. The product of House of Healin is sea cucumber-based acts as a healer of internal and external wound. There are 42 types of health supplement and 42 types of skincare product produced through research by CEO itself. The House of Healin do not use agent to sell the product. One of House of Healin HQ is located at Kompleks Perniagaan Al-Azim, 75150 Bukit Baru, Melaka. </p>

			</br>
		
  </form>
  </div>
  </section>
<!-- 
<br/><a href="staff/manageStaff.jsp">Staff</a><br/>
<br/><a href="product/manageProduct.jsp">Product</a><br/>
<br/><a href="branch/manageBranch.jsp">Branch</a><br/>
<br/><a href="order/manageOrder.jsp">Order</a><br/> -->
</body>
</html>