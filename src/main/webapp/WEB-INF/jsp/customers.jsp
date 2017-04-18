<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Customer List</h2>
		
		<c:if test="${success != null}">
			<p><c:out value="${success}"></c:out></p>
		</c:if>
		
		<div class="col-md-12">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>Customer ID</th>
						<th>Customer Name</th>
						<th>Address</th>
						<th>Create Order</th>
						<th>View Orders</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.internalCustomerId}</td>
							<td>${customer.customerName}</td>
							<td>${customer.address}</td>

							<c:url var="placeOrderUrl" value="/controller/order/create">
								<c:param name="customerId" value="${customer.id}"></c:param>
							</c:url>

							<td><a href="${placeOrderUrl}">Create New Orders</a></td>
							
							<c:url var="viewOrderUrl" value="/controller/order/${customer.internalCustomerId}">
							</c:url>
							
							<td><a href="${viewOrderUrl}">View All Orders</a></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<a href="/controller/customer/add">Add New Customer</a>
		
	</div>
</body>
</html>