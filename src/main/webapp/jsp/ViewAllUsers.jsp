<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.setmax.dto.LoginUserDTO,com.setmax.util.Constant"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/jquery.ui.css" />
<link rel="stylesheet" href="../css/jquery.dataTables.min.css" />
<title>View All Users Details</title>
<link rel="icon" type="image/x-icon" href="../img/appFavicon.ico">
</head>
<style>
table {
	font-family: arial;
	border-collapse: collapse;
	margin-top: 50px;
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

.tableNav {
	width: 100%;
	background-color: yellow;
	padding: 5px;
	border: 1px solid black;
	margin-top: 0px;
}

.table {
	padding: 50px;
	padding-top: 0px;
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
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Student <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="studentsAcademicSession.jsp">Academic Session</a></li>
						<li><a href="studentAttendence.jsp">Attendence</a></li>
					</ul></li>
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

	<div class="tableNav">
		<strong style="margin-left: 10px;">User Types Lists >>
			<button id="addNewUserButtonId" type="button"
				class="btn btn-primary btn-sm">
				<b>Add New User</b>
			</button>
		</strong>
	</div>
	<div style="display: none;" id="deleteSuccessMessageContainer">
		<div class="alert alert-success alert-dismissible">
			<a href="javascript:void(0)" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> <strong id="deleteUserSuccessMessage"></strong>
		</div>
	</div>
	<div style="display: none;" id="deleteErrorMessageContainer">
		<div class="alert alert-danger alert-dismissible">
			<a href="javascript:void(0)" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> <strong id="deleteUserErrorMessage"></strong>
		</div>
	</div>
	<br>
	<br>
	<div class="table">
		<table id="usersTable" style="width: 100%;">
			<thead>
				<tr>
					<th>Serial No</th>
					<th>User Type</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Date of Birth</th>
					<%
					if (loggedInUser.getUserTypeID() == Constant.USR_TYP_ADMIN
							|| loggedInUser.getUserTypeID() == Constant.USR_TYP_TEACHER) {
					%>
					<th>Action</th>
					<%
					}
					%>
				</tr>
			</thead>
		</table>
	</div>
</body>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/jquery.ui.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<%@include file="addEditUser.jsp"%>
<%@include file="viewUser.jsp"%>

<script>
	function loadEditUserModal(userId) {
		addEditUserRefreshModal();
		loadEditUserDialog(userId);
	}

	function loadViewUserModal(userId) {
		viewUserRefreshModal();
		loadViewUserDialog(userId);
	}

	function getUsersDetail() {
		$.ajax({
			url : 'http://localhost:8090/SchoolManagerCRUD/viewUsers',
			success : function(response) {
				intializeUserDataTable(response.userDetailList);
			}
		});
	}

	function updateUsersTable() {
		$("#usersTable").DataTable().destroy();
		getUsersDetail();
	}

	function intializeUserDataTable(list) {
		$('table').DataTable({
			data : list,
			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "userType"
			}, {
				"data" : "username"
			}, {
				"data" : "firstName"
			}, {
				"data" : "lastName"
			}, {
				"data" : "email"
			}, {
				"data" : "dob"
			},{
				"data" : "actions",
				"defaultContent": "",
				render: function(data, type, row) {
					var id = row.id;
                    if (type === 'display') {
                        return '<button id="editUserModalButtonId_'+id+'" onclick="loadEditUserModal('+id+')" type="button" class="btn btn-primary btn-sm" style="color:white;">Edit</button>'+' '+
                        '<button id="viewUserModalButtonId_'+id+'" onclick="loadViewUserModal('+id+')" type="button" class="btn btn-info btn-sm" style="color:white;">View</button>'+' '+
                        '<button id="deleteUserModalButtonId_'+id+'" onclick="deleteUserByUserId('+id+')" type="button" class="btn btn-danger btn-sm" style="color:white;">Delete</button>';
                    }
                }
			}]
		});
	}
	$(document).ready(function() {
		getUsersDetail();
		$("#addNewUserButtonId").click(function() {
			addEditUserRefreshModal();
			loadAddUserDialog();
		});
	});
</script>
</html>