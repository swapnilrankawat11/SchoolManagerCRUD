<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.setmax.dto.StudentDetails"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="StudentForm.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<title>Edit Existing Student</title>
</head>
<body>
	<header>
		<h1>SETMAX: YOUR SCHOOL MANAGER</h1>
		<a href="ViewServlet" style="float: right; font-size: 23px;">Back</a>
	</header>
	<%
	StudentDetails student = (StudentDetails) session.getAttribute("existingStudentData");
	String sno = (String) session.getAttribute("serialNo");
	int serialNo = Integer.parseInt(sno);
	%>
	<form class="form-horizontal" action="SaveEditedStudentDetailsServlet"
		method="post">

		<input type="hidden" name="serialNo"
			value="<%=student.getSerialNo()%>">
		<div class="form-group">
			<label for="fname">Full Name: </label> <input type="text" id="fname"
				name="fullName" style="margin-left: 40px;"
				value="<%=student.getFullName()%>" required>
		</div>
		<div class="form-group">
			<label for="momName">Mother Name: </label> <input type="text"
				id="momName" name="motherName" style="margin-left: 7px;"
				value="<%=student.getMotherName()%>" required>
		</div>
		<div class="form-group">
			<label for="dadName">Father Name: </label> <input type="text"
				id="dadName" name="fatherName" style="margin-left: 16px;"
				value="<%=student.getFatherName()%>" required>
		</div>
		<div class="form-group">
			<label for="class">Standard: </label> <input type="number" id="class"
				name="standard" min="1" max="12" style="margin-left: 46px;"
				value="<%=student.getStandard()%>" required>
		</div>
		<div class="form-group">
			<label for="fees">Fees: </label> <input type="text" id="fees"
				name="fees" style="margin-left: 85px;"
				value="<%=student.getFees()%>" required>
		</div>
		<div class="form-group">
			<label for="phoneNumber">Contact Number: </label> <input type="tel"
				id="phoneNumber" name="contactNumber"
				pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" style="margin-left: 7px;"
				placeholder="XXX-XXX-XXXX" value="<%=student.getContactNumber()%>"
				required>
		</div>

		<button type="submit" class="btn btn-primary">Edit & Save</button>
		<button type="reset" class="btn btn-danger">Reset</button>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>