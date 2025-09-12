<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.setmax.dto.LoginUserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/headerDesign.css" />
<title></title>
</head>
<body>
	<%
	LoginUserDTO loggedInUser = (LoginUserDTO) session.getAttribute("loggedInUser");
	%>
	<header>
		<h1 class="websiteNameOnHeader">SETMAX: YOUR SCHOOL MANAGER</h1>
		<h4 class="welcomeUserMessage">
			Welcome
			<%=loggedInUser.getFirst_name()%>!
		</h4>
	</header>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="#"><span
						class="glyphicon glyphicon-home"></span>Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:void(0)">Teacher</a></li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="javascript:void(0)" role="button" data-bs-toggle="dropdown">Student</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="studentsAcademicSession.jsp">Academic Session</a></li>
						<li><a class="dropdown-item" href="studentAttendence.jsp">Attendence</a></li>
					</ul>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:void(0)">Guardian</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:void(0)">About Us</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:void(0)">Contact Us</a></li>
			</ul>
			<ul class="navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link"
					href="javascript:void(0)">Logout</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>