<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Save Customer</title>
		<link type="text/css" rel="stylesheet"
					href="${pageContext.request.contextPath}/resources/css/style.css">
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		
	</head>
	<body>
		<div id="wrapper">
			<div id="header">CRM - Customer Relationship Manager</div>
		</div> 
		<div id="container">
			<h3>Add new Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				<form:hidden path="id"/>
				<table>
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Submit" class="save"/></td>
						</tr>
				</table>
			</form:form>
		</div>
	</body>
</html>