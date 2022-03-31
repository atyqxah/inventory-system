<%
String role = (String) session.getAttribute("roles");
%>

<div class="sidebar">
		<header>Menu</header>
		<ul>
			<li><a href="about.jsp"><i class="far fa-question-circle"></i>About</a></li>
			<li><a href="./ProductController?action=listProduct"><i class="fas fa-stream"></i>Product</a></li>
			<li><a href="./OrderController?action=listOrder"><i class="fas fa-shopping-bag"></i>Order</a></li>
			<li><a href="./StaffController?action=listStaff"><i class="fas fa-user-friends"></i>Staff</a></li>
			<% if(role.equalsIgnoreCase("manager")){ %>
			<li><a href="./BranchController?action=listBranch"><i class="fas fa-home"></i>Branch</a></li>
			<% } %>
			<!-- <li><a href="./InventoryController?action=listInventory"><i class="fas fa-file"></i>Inventory</a></li>-->
			<li><a href="/healin/loginController"><i class="fas fa-door-open"></i>Log out</a></li>
		</ul>
	</div>