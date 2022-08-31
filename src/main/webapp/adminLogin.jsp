<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
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
		<h2>Admin Login</h2>
		<form action="/bankservicesystem/AdminLogin">
			<div class="input-fields">
				<input type="text" name="username" placeholder="username">
				<input type="text" name="password" placeholder="password">
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Login">
		</form>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		console.log(errorMsg);
		if (errorMsg === "username" || errorMsg === "password") {
			var err = errorMsg + " is incorrect";
			alert(err);
		} else if (errorMsg === "error") {
			alert("An error occurred");
		}
	</script>
</body>
</html>