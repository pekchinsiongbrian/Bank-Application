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
	input {
		width: 300px;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>Recover PIN</h2>
		<form id="phase1" action="/bankservicesystem/RecoverPinPhaseTwo">
			<h3>${cusername}, ${securityQn}</h3>
			<div class="input-fields">
				<input type="text" name="security answer" placeholder="security answer">
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
		
		var pin = '<%= session.getAttribute("pin") %>';
		<% session.setAttribute("pin", ""); %>
		console.log(pin);
		if (pin !== null && pin.length == 6) {
			alert("Your pin is: " + pin);
		}
	</script>
</body>
</html>