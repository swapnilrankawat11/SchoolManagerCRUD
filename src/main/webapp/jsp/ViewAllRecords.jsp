<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.setmax.dto.StudentDetails,java.util.List,com.setmax.dto.LoginUserDTO,com.setmax.util.Constant"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" />
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<title>View All Students Details</title>

</head>
<style>
table {
	font-family: arial;
	border-collapse: collapse;
	width: 80%;
	margin-top: 50px;
	margin-left: 150px;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 8px;
}

th {
	border: 1px solid black;
	text-align: center;
	padding: 8px;
	background-color: #c0c0c0;
}

tr:hover {
	background-color: yellow;
}

a:link {
	color: blue;
}

a:visited {
	color: blue;
}

#addNewStudentLink {
	color: yellow;
}

#editLink {
	color: white;
}

#deleteLink {
	color: white;
}

header {
	background-color: orange;
}

h1 {
	font-family: Calibri;
	padding: 10px;
	font-size: 50px;
	margin: 0px 0px;
}

h4 {
	text-decoration: underline;
	margin: 0px 0px;
	padding: 10px;
	font-family: Comic Sans MS;
}
</style>
<body>
	<%
	LoginUserDTO loggedInUser = (LoginUserDTO) session.getAttribute("loggedInUser");
	%>
	<header>
		<h1>SETMAX: YOUR SCHOOL MANAGER</h1>
		<h4>
			Welcome
			<%=loggedInUser.getFirst_name()%>!
		</h4>
	</header>

	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-home"></span> Home</a></li>
				<li><a href="#">Teacher</a></li>
				<li><a href="#">Student</a></li>
				<li><a href="#">Guardian</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>

	<table>
		<thead>
			<tr>
				<th>Serial No</th>
				<th>Full Name</th>
				<th>Father Name</th>
				<th>Mother Name</th>
				<th>Standard</th>
				<th>Fees</th>
				<th>Contact Number</th>
				<%
				if (loggedInUser.getUserTypeID() == Constant.USR_TYP_ADMIN
								|| loggedInUser.getUserTypeID() == Constant.USR_TYP_TEACHER) {
				%>
				<th colspan="2">Action</th>
				<%
				}
				%>
			</tr>
		<thead>
			<%
			List<StudentDetails> list = (List<StudentDetails>) session.getAttribute("savedStudentData");
				int serialNo = 1;
				for (StudentDetails student : list) {
			%>
		
		<tbody>
			<tr>
				<td><%=serialNo++%></td>
				<td><%=student.getFullName()%></td>
				<td><%=student.getFatherName()%></td>
				<td><%=student.getMotherName()%></td>
				<td><%=student.getStandard()%></td>
				<td><%=student.getFees()%></td>
				<td><%=student.getContactNumber()%></td>
				<%
				if (loggedInUser.getUserTypeID() == Constant.USR_TYP_ADMIN
								|| loggedInUser.getUserTypeID() == Constant.USR_TYP_TEACHER) {
				%>
				<td><a id="editLink" class="btn btn-primary btn-sm"
					href="editServlet?serialNo=<%=student.getSerialNo()%>">Edit</a></td>
				<td><a id="deleteLink" class="btn btn-danger btn-sm"
					href="deleteServlet?serialNo=<%=student.getSerialNo()%>">Delete</a></td>
			</tr>
		</tbody>
		<%
		}
		%>
		<%
		}
		%>

	</table>
</body>

</html>