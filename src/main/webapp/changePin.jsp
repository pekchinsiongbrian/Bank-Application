<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change PIN</title>
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
		<h2>Change PIN</h2>
		<form action="/bankservicesystem/CustomerChangePin">
			<div class="input-fields">
				<input type="text" name="old pin" placeholder="old PIN" pattern="[0-9]{6,6}" required>
				<input type="text" name="new pin" placeholder="new PIN" pattern="[0-9]{6,6}" required>
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Submit">
		</form>
		<br><br>
		<a href="/bankservicesystem/customer.jsp">Go back</a>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg === "pin") {
			alert(errorMsg + " is incorrect");
		}
	</script>
</body>
</html>