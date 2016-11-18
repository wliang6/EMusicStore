<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	
	<!-- LEAD TO HEADER FILE template/header.jsp -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   <!-- import spring tag to use the header and footer we just created in "template" folder -->
<%@include file="/WEB-INF/views/template/header.jsp" %>


    <div class="container-wrapper">
    	<div class="container">
			<div class="page-header">
				<h1>Add Product</h1>
				<p class="lead">Fill the below information to add a product:</p>
			</div>
			
			<form:form action="${pageContext.request.contextPath }/admin/productInventory/addProduct" method="post" commandName="product">
				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="productName" id="name" class="form-Control" /> <!-- when adding product, it will be binded to the productName -->
				</div>
				
				<div class="form-group">
					<label for="category">Category</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument" />Instrument</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record" />Record</label>
					<label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory" />Accessory</label>
				</div>
				
				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea path="productDescription" id="description" class="form-Control" /> <!-- when adding product, it will be binded to the productName -->
				</div>
				
				<div class="form-group">
					<label for="price">Price</label>
					<form:input path="productPrice" id="price" class="form-Control" /> <!-- when adding product, it will be binded to the productName -->
				</div>
				
				<div class="form-group">
					<label for="condition">Condition</label>
					<label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new" />New</label>
					<label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used" />Used</label>
				</div>
				
				<div class="form-group">
					<label for="status">Status</label>
					<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active" />Active</label>
					<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive" />Inactive</label>
				</div>
				
				<div class="form-group">
					<label for="unitInStock">Unit In Stock</label>
					<form:input path="unitInStock" id="unitInStock" class="form-Control" /> <!-- when adding product, it will be binded to the productName -->
				</div>
				
				<div class="form-group">
					<label for="manufacturer">Manufacturer</label>
					<form:input path="productManufacturer" id="manufacturer" class="form-Control" /> <!-- when adding product, it will be binded to the productName -->
				</div>
				
				<br><br>
				<input type="submit" value="submit" class="btn btn-default">
				<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">cancel</a>
			</form:form>
		
	
      <!-- LEAD TO FOOTER FILE template/footer.jsp-->
<%@include file="/WEB-INF/views/template/footer.jsp" %>
