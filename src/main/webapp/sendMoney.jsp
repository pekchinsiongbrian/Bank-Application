<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Money</title>
<link rel="stylesheet" href="/bankservicesystem/global.css">
<style>
	.container {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	form {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Send Money</h2>
		<form action="/bankservicesystem/CustomerSendMoney">
			<div class="input-fields">
				<input type="text" name="to" placeholder="recipient's username" pattern="[A-Za-z]*" required>
				<input type="text" name="amount" placeholder="amount" pattern="[0-9]+" required>
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Submit">
		</form>
		<br><br>
		<a href="/bankservicesystem/customer.jsp">Go back</a>
	</div>
	<script>
		console.log("hhee");
		var errorMsg = "<%= session.getAttribute("errorMsg") %>";
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg !== "") {
			alert(errorMsg);
		}
	</script>
</body>
</html>