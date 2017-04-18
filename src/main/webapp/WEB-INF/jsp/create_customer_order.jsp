<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Customer Order</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/app.css">
</head>
<body>
	<div class="container">

		<h3>Enter Customer Order Details</h3>

		<form:form action="/controller/order/create" method="POST" modelAttribute="order">

			<form:errors path="*" cssClass="errorMsg"></form:errors>
			
			<hr>
			
			<div class="form-group">
				<label for="quantity">Enter quantity</label>
				<form:input path="quantity" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="itemName">Item name</label>
				<form:input path="itemName" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="description">Comments or Description</label>
				<form:textarea path="description" cssClass="form-control" rows="2"/>
			</div>

			<input type="submit" value="Place Order" class="btn btn-default"/>
			
			<input type="hidden" name="customerId" value="${param.customerId}"/>

		</form:form>
		
		<br>
		
		<a href="/controller/customer/list">Customer List</a>
		
	</div>
	
</body>