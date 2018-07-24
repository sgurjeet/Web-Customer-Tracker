<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>List Customers</title>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" onClick="window.location.href='addCustomerForm'" 
						class="add-button" value="Add Customer"/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="cust" items="${customers}">
					<c:url var="updateLink" value="/customer/updateCustomer">
						<c:param name="customerId" value="${cust.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${cust.id}"/>
					</c:url>
					<tr>
						<td>${cust.firstName}</td>
						<td>${cust.lastName}</td>
						<td>${cust.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							<a onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
									href="${deleteLink}">Delete</a></td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</body>
	
</html>