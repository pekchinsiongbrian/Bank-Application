<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recover PIN</title>
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
		<h2>Recover PIN</h2>
		<form id="phase1" action="/bankservicesystem/RecoverPinPhaseOne">
			<div class="input-fields">
				<input type="text" name="username" placeholder="username" pattern="[A-Za-z]*">
			</div>
			<br>
			<input class="submit-btn" type="submit" value="Submit">
		</form>
		<br><br>
		<a href="/bankservicesystem/customerLogin.jsp">Back to login page</a>
	</div>
	<script>
		var errorMsg = '<%= session.getAttribute("errorMsg") %>';
		<% session.setAttribute("errorMsg", ""); %>
		if (errorMsg !== "") {
			alert(errorMsg);
		}
	</script>
</body>
</html>