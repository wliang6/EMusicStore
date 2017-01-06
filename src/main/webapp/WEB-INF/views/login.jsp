<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">
			<h2>Login</h2>
			<form name="loginForm" action="<c:url value="j_spring_security_check" />" method = "post">
				<div class="form-group">
					<label for="username">User: </label>
					<input type="text" id="username" name="username" class="form-control" /> <!-- form-control extends the field width -->
				</div>
				<div class="form-group">
					<label for="password">Password: </label>
					<input type="password" id="password" name="password" class="form-control" />
				</div>
				<input type="submit" value="Submit" class="btn btn-default">
<!-- 				CSRF - Cross Site Request Forgery token is included to make form submission valid for safety purpose- Spring Security protects app from CSRF attacks  -->
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</div>
	</div>
</div>





<%@include file="/WEB-INF/views/template/footer.jsp" %>