<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
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
	.input-fields {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	input, select {
		width: 300px;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Customer Registration</h2>
		<form action="/bankservicesystem/CustomerRegister">
			<div class="input-fields">
				<label>Name</label>
				<input type="text" name="name" placeholder="name" pattern="[A-Za-z]*" required>
				<br>
				<label>Username</label>
				<input type="text" name="username" placeholder="username" pattern="[A-Za-z]*" required>
				<br>
				<label>6 digit PIN Number</label>
				<input type="text" name="pin" placeholder="pin" pattern="[0-9]{6,6}" required>
				<br>
				<label>Initial Deposit (min. $1000)</label>
				<input type="text" name="initial deposit" placeholder="initial deposit" value="1000" pattern="^[1-9][0-9]{3,}" required>
				<br>
				<label>Security Question</label>
				<select name="security question" required>
					<option value="What was your childhood nickname?">What was your childhood nickname?</option>
					<option value="What is the name of your elementary school?">What is the name of your elementary school?</option>
					<option value="In what city were you born?">In what city were you born?</option>
				</select>
				<br>
				<label>Security Answer</label>
				<input type="text" name="security answer" placeholder="security answer" required>
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Register">
		</form>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg === "username") {
			alert(errorMsg + " already exists!");
		} else if (errorMsg === "error") {
			alert("An error occurred");
		}
	</script>
</body>
</html>