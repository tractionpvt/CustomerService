<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Order List</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Order List for Customer ${customerId}</h2>
		<p>Rest Url used :${restUrl}</p>
		<br>
		<div class="col-md-12">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Order Date</th>
						<th>Item</th>
						<th>Quantity</th>
						<th>Order Status</th>
						<th>Comment</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${order.orders}">
						<tr>
							<td>${order.orderId}</td>
							<td> 
								<fmt:formatDate value="${order.orderDate}" pattern="dd-MM-yyyy:HH:mm:ss a"/>							
							</td>
							<td>${order.item}</td>
							<td>${order.quantity}</td>
							<td>${order.orderStatus}</td>
							<td>${order.comments}</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>
			
		<a href="/controller/customer/list">Back to Customer List</a>
			
	</div>
</body>
</html>