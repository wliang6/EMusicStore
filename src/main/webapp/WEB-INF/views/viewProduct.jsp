<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	
	<!-- LEAD TO HEADER FILE template/header.jsp -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   <!-- import spring tag to use the header and footer we just created in "template" folder -->
<%@include file="/WEB-INF/views/template/header.jsp" %>


    <div class="container-wrapper">
    	<div class="container">
			<div class="page-header">
				<h1>Product Details</h1>
				<p class="lead">Here are the detail information of the product!</p>
			</div>
			
			<!-- http://getbootstrap.com/css/#grid -->
			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<img src="#" alt="image" style="width:100%   height:300px" />
					</div>
					
					<div class="col-md-5">
						<h3>${product.productName }</h3>
						<p>
							<strong>Description</strong> :
							${product.productDescription}</p>
						<p> 
							<strong>Manufacturer</strong> :
							${product.productManufacturer}</p>
						<p> 
							<strong>Category</strong> :
							${product.productCategory}</p>
						<p> 
							<strong>Condition</strong> :
							${product.productCondition}</p>
						
						<h4>${product.productPrice} USD</h4>
						
					</div>
				</div>
			</div>
			
	
      <!-- LEAD TO FOOTER FILE template/footer.jsp-->
<%@include file="/WEB-INF/views/template/footer.jsp" %>
