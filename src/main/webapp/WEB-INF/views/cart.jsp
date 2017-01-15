<%@include file="/WEB-INF/views/template/header.jsp" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Shopping Cart</h1>
					<p>All the selected products in your shopping cart.</p>
				</div>
			</div>
		</section>
		
		<section class="container" data-ng-app="cartApp">  <!-- access to cartApp module and functions in controller.js -->
			<!-- We have access to cartId in the module -->
			<!-- initCartId will add a new cart -->
			<div data-ng-controller = "cartCtrl" data-ng-init="initCartId('${cartID}')">
			<div>
				<a class="btn btn-danger pull-left" data-ng-click="clearCart()">
				<span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
			</div>
			<table class="table table-hover">
				<tr>  <!-- header row of table -->
					<th>Product</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr data-ng-repeat = "item in cart.cartItems">  <!-- display dynamic data for each cartItem -->
					<td>{{item.product.productName}}</td>
					<td>{{item.product.productPrice}}</td>
					<td>{{item.quantity}}</td>
					<td>{{item.totalPrice}}</td>
					<td><a href="#" class="label label-danger" data-ng-click="removeFromCart(item.product.productID)">
					<span class="glyphicon glyphicon-remove"></span>remove</a></td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>{{cart.grandTotal}}</th>
					<th></th>
				</tr>
			</table>
			<a href="<spring:url value="/productList"/> " class="btn btn-default">Continue Shopping</a>
			</div>
		</section>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>