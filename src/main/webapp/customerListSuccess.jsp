<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, com.dxc.model.CustomerModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List Success</title>
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Here is the list of customers:</h1>
	<table>
		<tr>
			<th>S/N</th>
			<th>Name</th>
			<th>Username</th>
			<th>Balance</th>
		</tr>
		<%
			ArrayList<CustomerModel> cmList = (ArrayList<CustomerModel>) session.getAttribute("cmList");
			for (int i = 0; i < cmList.size(); i++) {
		%>
		<tr>
			<td>
				<%= i+1 %>
			</td>
			<td>
				<%= cmList.get(i).getName() %>
			</td>
			<td>
   				<%= cmList.get(i).getUsername() %>
			</td>
			<td>
  				<%= cmList.get(i).getBalance() %>
			</td>
		</tr>
		<% } %>
	</table>
	<h4>Click <a href="/bankservicesystem/admin.jsp">here</a> to return to home page</h4>
</body>
</html>