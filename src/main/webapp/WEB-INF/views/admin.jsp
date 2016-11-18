<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	
	<!-- LEAD TO HEADER FILE template/header.jsp -->
<%@include file="/WEB-INF/views/template/header.jsp" %>


    <div class="container-wrapper">
    	<div class="container">
			<div class="page-header">
				<h1>Administrator Page</h1>
				<p class="lead">This is the administrator page</p>
			</div>

			<h3> 
				<!-- Leads to product list but on administrative perspective -->
				<a href="<c:url value="/admin/productInventory" />" >Product Inventory </a>
			</h3>
			
			<p>Here you can view, check and modify the product inventory! </p>
			

      <!-- LEAD TO FOOTER FILE template/footer.jsp-->
<%@include file="/WEB-INF/views/template/footer.jsp" %>
