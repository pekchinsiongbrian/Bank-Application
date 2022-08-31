<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
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
		<h2>Customer Login</h2>
		<form action="/bankservicesystem/CustomerLogin">
			<div class="input-fields">
				<input type="text" name="username" placeholder="username" pattern="[A-Za-z]*" required>
				<input type="text" name="pin" placeholder="pin" pattern="[0-9]{6,6}" required>
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Login">
		</form>
		<br><br>
		<a href="/bankservicesystem/forgotPin.jsp">Forgot PIN?</a>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg === "username" || errorMsg === "pin") {
			var err = errorMsg + " is incorrect";
			alert(err);
		} else if (errorMsg === "error") {
			alert("An error occurred");
		}
	</script>
</body>
</html>