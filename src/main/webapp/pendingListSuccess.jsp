<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, com.dxc.model.LoanModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending List Success</title>
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Here is the list of loans pending approval:</h1>
	<table>
		<tr>
			<th>S/N</th>
			<th>Username</th>
			<th>Loan Amount</th>
			<th>Loan Type</th>
		</tr>
		<%
			ArrayList<LoanModel> pendingLoanList = (ArrayList<LoanModel>) session.getAttribute("pendingLoansList");
			for (int i = 0; i < pendingLoanList.size(); i++) {
		%>
		<tr>
			<td>
		      <%= pendingLoanList.get(i).getSn() %>
		   </td>
		   <td>
		      <%= pendingLoanList.get(i).getUsername() %>
		   </td>
		   <td>
		      <%= pendingLoanList.get(i).getLoanAmount() %>
		   </td>
		   <td>
		      <%= pendingLoanList.get(i).getLoanType() %>
		   </td>
		</tr>
		<% } %>
	</table>
	<h4>Click <a href="/bankservicesystem/admin.jsp">here</a> to return to home page</h4>
</body>
</html>