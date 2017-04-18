<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/app.css">
</head>
<body>
	<div class="container">

		<h3>Enter Customer Details</h3>

		<form:form action="/controller/customer/add" method="POST" modelAttribute="customer">

			<form:errors path="*" cssClass="errorMsg"></form:errors>
			
			<hr>
			
			<div class="form-group">
				<label for="customerName">Customer Name</label>
				<form:input path="customerName" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="houseNo">House No</label>
				<form:input path="houseNo" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="streetName">Street name</label>
				<form:input path="streetName" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="zipCode">Zip Code</label>
				<form:input path="zipCode" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="city">City</label>
				<form:input path="city" cssClass="form-control"/>
			</div>

			<div class="form-group">
				<label for="country">Country</label>
				<form:input path="country" cssClass="form-control"/>
			</div>

			<input type="submit" value="Create Customer" class="btn btn-default"/>

		</form:form>
		
		<br>
		
		<a href="/controller/customer/list">Customer List</a>
		
	</div>
	
</body>