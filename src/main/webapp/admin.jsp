<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
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
		<h1>Welcome, admin ${ausername}</h1>
		<div class="submit-btn">
			<a class="anchor-in-btn" href="/bankservicesystem/AdminViewCustomers">View Customers</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" class="button" href="/bankservicesystem/AdminViewLoans">View Existing Loans</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" class="button" href="/bankservicesystem/AdminViewPending">View Pending Loans</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" class="button" href="/bankservicesystem/updateStatus.html">Update Loan Status</a>
		</div>
		<br>
		<div class="submit-btn">
			<a class="anchor-in-btn" class="button" href="/bankservicesystem/AnalyseLoans">Analyse Loans</a>
		</div>
	</div>
	
</body>
</html>