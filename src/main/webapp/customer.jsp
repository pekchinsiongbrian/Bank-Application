<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" href="/bankservicesystem/global.css">
<style>
	.container {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Welcome to the bank service system, ${cusername}!</h2>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/changePin.jsp">Change PIN</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/CheckBalance">Check Balance</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/sendMoney.jsp">Send Money</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/applyLoan.html">Apply Loan</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/CheckLoanStatus">Check Loan Status</a>
		</div>
		<br>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg == "error") {
			alert("An error occurred");
		}
	</script>
</body>
</html>