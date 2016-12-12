<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	
	<!-- LEAD TO HEADER FILE template/header.jsp -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   <!-- import spring tag to use the header and footer we just created in "template" folder -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


    <div class="container-wrapper">
    	<div class="container">
			<div class="page-header">
				<h1>All Products</h1>
				<p class="lead">Check out all the awesome products available now!</p>
			</div>
			<!-- http://getbootstrap.com/css/#tables -->
			<table class="table" table-striped table-hover">
				<thead>
					<tr class="bg-success">
						<th>Photo Thumb</th>
						<th>Product Name</th>
						<th>Category</th>
						<th>Condition</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${products}" var="product">   <!-- JSTL tag- "product" represents each instance of products -->
				<tr>
					<td><img src="<c:url value="/resources/images/${product.productID}.png" /> " alt="image" style="width:100%"/></td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}</td>
					<td><a href="<spring:url value="/productList/viewProduct/${product.productID}" />" >   <!-- Spring tag is used to visit the url path and passing the dynamic variable productID -->
					<span class="glyphicon glyphicon-info-sign"></span> </a></td> <!-- When icon is clicked, it grabs product ID and transfers it to controller (business logic- backend fetches product from database), returns product object to controller and controller forwards to view page -->
				</tr>
				</c:forEach>
			</table>

      <!-- LEAD TO FOOTER FILE template/footer.jsp-->
<%@include file="/WEB-INF/views/template/footer.jsp" %>
