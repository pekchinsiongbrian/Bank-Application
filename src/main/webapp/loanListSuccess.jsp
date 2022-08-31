<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, com.dxc.model.LoanModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan List Success</title>
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Here is the list of loans:</h1>
	<table>
		<tr>
			<th>S/N</th>
			<th>Username</th>
			<th>Loan Amount</th>
			<th>Loan Type</th>
		</tr>
		<%
			ArrayList<LoanModel> loanList = (ArrayList<LoanModel>) session.getAttribute("loanList");
			for (int i = 0; i < loanList.size(); i++) {
		%>
		<tr>
			<td>
		      <%= i+1 %>
		   </td>
		   <td>
		      <%= loanList.get(i).getUsername() %>
		   </td>
		   <td>
		      <%= loanList.get(i).getLoanAmount() %>
		   </td>
		   <td>
		      <%= loanList.get(i).getLoanType() %>
		   </td>
		</tr>
		<% } %>
	</table>
	<h4>Click <a href="/bankservicesystem/admin.jsp">here</a> to return to home page</h4>
</body>
</html>