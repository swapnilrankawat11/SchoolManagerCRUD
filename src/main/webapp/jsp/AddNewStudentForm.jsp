<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="StudentForm.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Add New Student</title>
</head>
<body>
	<header>
		<h1>SETMAX: YOUR SCHOOL MANAGER</h1>
		<a href="ViewServlet" style="float: right;">View All Records</a>
	</header>

	<form class="form-horizontal" action="saveServlet" method="post">
		<div class="form-group">
			<label for="fname">Full Name: </label> <input type="text" id="fname"
				name="fullName" style="margin-left: 40px;" required>
		</div>
		<div class="form-group">
			<label for="momName">Mother Name: </label> <input type="text"
				id="momName" name="motherName" style="margin-left: 7px;" required>
		</div>
		<div class="form-group">
			<label for="dadName">Father Name: </label> <input type="text"
				id="dadName" name="fatherName" style="margin-left: 16px;" required>
		</div>
		<div class="form-group">
			<label for="class">Standard: </label> <input type="number" id="class"
				name="standard" min="1" max="12" style="margin-left: 46px;" required>
		</div>
		<div class="form-group">
			<label for="fees">Fees: </label> <input type="text" id="fees"
				name="fees" style="margin-left: 85px;" required>
		</div>
		<div class="form-group">
			<label for="phoneNumber">Contact Number: </label> <input type="tel"
				id="phoneNumber" name="contactNumber"
				pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="XXX-XXX-XXXX"
				style="margin-left: 7px;" required>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
		<button type="reset" class="btn btn-danger">Reset</button>
	</form>
</body>
</html>