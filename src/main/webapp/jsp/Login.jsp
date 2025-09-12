<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login to SETMAX</title>
<link rel="icon" type="image/x-icon" href="img/appFavicon.ico">
<link rel="stylesheet" href="css/LoginPage.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<style>
html, body {
	height: 100%;
}

body {
	background-image: url("img/loginBack.jpg");
	background-repeat: no-repeat;
	background-position: left top;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>

</head>
<body>
	<div id="form" style="position: fixed;">
		<strong id="websiteName">SETMAX</strong> <br> <br>
		<form>
			<div id="loginContainer" class="alert alert-danger"
				style="display: none;">
				<a href="#" class="close" aria-label="close">&times;</a> <strong
					id="loginStatus"></strong>
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-user"></i></span> <input id="uName" type="text"
					class="form-control" name="username" placeholder="Username"
					required>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon"><i
					class="glyphicon glyphicon-lock"></i></span> <input id="pwd"
					type="password" class="form-control" name="password"
					placeholder="Password" required>
			</div>
			<br>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		function bindSubmitBtnClick() {
			$(":submit").click(function(){
				processLoginDetails();
			});
		}
		
		function processLoginDetails() {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/loginServlet',
				data: {
					username: $("#uName").val(),
					password: $("#pwd").val(),
				},
				type: 'POST' ,
				success: function(response) {	
					var status = response.loginStatus;
					if(status==="AUTHENTICATED"){
						window.location.href='/SchoolManagerCRUD/redirectToViewUsers';	
					} else if(status==="MISSING_INPUT") {
						$("#loginStatus").text("Both username and password is required to process a login request!");
						$("#loginContainer").show();
					} else {
						$("#loginStatus").text("Wrong Username or Password!");
						$("#loginContainer").show();
					}
	   		 }});
		}
		
		function bindCloseBtnClick(){
			$(".close").click(function(){
				$("#loginContainer").hide();
			});
		}
		
		$("document").ready(function(){
			bindSubmitBtnClick();	
		    bindCloseBtnClick();
		});
</script>
</body>
</html>