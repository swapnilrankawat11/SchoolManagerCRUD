<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="../css/ModalDesign.css" />
<link rel="stylesheet" href="../css/loader.css" />
<script type="text/javascript" src="../js/constant.js"></script>
<style>
.well {
	min-height: 40px;
}

.colAlign {
	text-align: right;
}
.displayNone{
	display : none;
}

</style>
</head>
<body>
	<div id="viewUserModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div id="modal-header">
					<ul class="nav nav-tabs">
						<li class="tabs active" id="userDetailViewTab"><a
							data-toggle="tab" href="#userDetailView">User Info</a></li>
						<li class="tabs" style="display: none;" id="teacherDetailViewTab"><a
							data-toggle="tab" href="#teacherDetailView">Teacher Info</a></li>
						<li class="tabs" style="display: none;" id="studentDetailViewTab"><a
							data-toggle="tab" href="#studentDetailView">Student Info</a></li>
					</ul>
				</div>
				<div class="modal-body">
					<div style="display: none;" class="col-sm-6"
						id="viewUserModalLoaderContainer">
						<div id="viewUserModalLoader" class="loader"></div>
					</div>
					<div class="tab-content">
						<div id="userDetailView" class="tab-pane fade in active">
							<div id="userDetailViewErrorMessageContainer"
								class="alert alert-danger" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="userDetailViewErrorMessage"></strong>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>User Type</b>
								</h5>
								<div class="col-sm-7">
									<div id="userType" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Username</b>
								</h5>
								<div class="col-sm-7">
									<div id="usernameTextId" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>First Name</b>
								</h5>
								<div class="col-sm-7">
									<div id="firstName" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Middle Name</b>
								</h5>
								<div class="col-sm-7">
									<div id="middleName" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Last Name</b>
								</h5>
								<div class="col-sm-7">
									<div id="lastName" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Date of Birth</b>
								</h5>
								<div class="col-sm-7">
									<div id="dob" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Email</b>
								</h5>
								<div class="col-sm-7">
									<div id="email" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Gender</b>
								</h5>
								<div class="col-sm-7">
									<div id="gender" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Mobile Number</b>
								</h5>
								<div class="col-sm-7">
									<div id="mobileNumberId" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Address</b>
								</h5>
								<div class="col-sm-7">
									<div id="addressId" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Record Status</b>
								</h5>
								<div class="col-sm-7">
									<div id="recordStatusTextId" class="well well-sm"></div>
								</div>
							</div>

						</div>
						<div id="studentDetailView" class="tab-pane fade">
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Class</b>
								</h5>
								<div class="col-sm-7">
									<div id="classTextId" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Favorite Sport</b>
								</h5>
								<div class="col-sm-7">
									<div id="favSportTextId" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Third Language</b>
								</h5>
								<div class="col-sm-7">
									<div id="thirdLangTextId" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Guardian Type</b>
								</h5>
								<div class="col-sm-7">
									<div id="guardianTypeTextId" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Guardian User</b>
								</h5>
								<div class="col-sm-7">
									<div id="guardianUserTextId" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Father Name</b>
								</h5>
								<div class="col-sm-7">
									<div id="fatherName" class="well well-sm"></div>
								</div>
							</div>

							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Mother Name</b>
								</h5>
								<div class="col-sm-7">
									<div id="motherName" class="well well-sm"></div>
								</div>
							</div>
						</div>
						<div id="teacherDetailView" class="tab-pane fade">
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Primary Subject</b>
								</h5>
								<div class="col-sm-7">
									<div id="primarySubTextId" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Secondary Subject</b>
								</h5>
								<div class="col-sm-7">
									<div id="secondarySubTextId" class="well well-sm"></div>
								</div>
							</div>
							<div class="row">
								<h5 class="col-sm-3 colAlign">
									<b>Experience</b>
								</h5>
								<div class="col-sm-7">
									<div id="experience" class="well well-sm"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function loadViewUserDialog(userId) {
			$("#viewUserModal").modal('show');
			$("#userDetailView").fadeTo(0, 0.0);
			$('#viewUserModalLoaderContainer').show();
			getViewUserMetadata(userId);
		}

		function getViewUserMetadata(userId) {
			$.ajax({
				url : 'http://localhost:8090/SchoolManagerCRUD/UserServlet',
				data : {
					userId : userId,
				},
				type : 'GET',
				success : function(response) {
					if (response.status) {
						$('#viewUserModalLoaderContainer').hide();
						renderMetadataInViewModal(response.userInfo,
								response.studentInfo,
								response.teacherInfo);
					} else {
						$("#userDetailViewErrorMessage").append("Unable to process your request. Kindly contact system admin");
						$("#userDetailViewErrorMessageContainer").show();
					}
				}
			});
		}

		function renderMetadataInViewModal(userInfo, studentInfo, teacherInfo) {
			if (userInfo != null) {
				showUserInfoData(userInfo);
			}
			if (studentInfo != null) {
				$("#studentDetailView").addClass("displayNone").hide();
				showStudentInfoData(studentInfo);
			}
			if (teacherInfo != null) {
				$("#teacherDetailView").addClass("displayNone").hide();
				showTeacherInfoData(teacherInfo);
			}
		}

		function showUserInfoData(userInfo) {
			$("#userType").text(userInfo.userTypeValue);
			$("#usernameTextId").text(userInfo.userName);
			$("#firstName").text(userInfo.firstName);
			$("#middleName").text(userInfo.middleName);
			$("#lastName").text(userInfo.lastName);
			$("#dob").text(userInfo.dateOfBirth);
			$("#email").text(userInfo.email);
			$('#gender').text(userInfo.gender);
			$("#mobileNumberId").text(userInfo.mobileNumber);
			$("#addressId").text(userInfo.address);
			$('#recordStatusTextId').text(userInfo.recordStatusValue);
			$("#userDetailView").fadeTo(0, 1);
		}

		function showStudentInfoData(studentInfo) {
			$("#classTextId").text(studentInfo.standardValue);
			$("#favSportTextId").text(studentInfo.favoriteSportValue);
			$("#thirdLangTextId").text(studentInfo.thirdLanguageValue);
			$("#guardianTypeTextId").text(studentInfo.guardianTypeValue);
			$("#guardianUserTextId").text(studentInfo.guardianUserValue);
			$("#fatherName").text(studentInfo.fatherName);
			$("#motherName").text(studentInfo.motherName);
			$("#studentDetailViewTab").show();
		}

		function showTeacherInfoData(teacherInfo) {
			$("#primarySubTextId").text(teacherInfo.primarySubjectValue);
			$("#secondarySubTextId").text(teacherInfo.secondarySubjectValue);
			$("#experience").text(
					teacherInfo.experienceInYear + " years and "
							+ teacherInfo.experienceInMonth + " months");
			$("#teacherDetailViewTab").show();
		}

		function refreshUserDetailViewTab() {
			$("#userType").empty();
			$("#usernameTextId").empty();
			$("#firstName").empty();
			$("#middleName").empty();
			$("#lastName").empty();
			$("#dob").empty();
			$("#email").empty();
			$('#gender').empty();
			$("#mobileNumberId").empty();
			$("#addressId").empty();
			$('#recordStatusTextId').empty();
		}

		function refreshStudentDetailViewTab() {
			$("#classTextId").empty();
			$("#favSportTextId").empty();
			$("#thirdLangTextId").empty();
			$("#guardianTypeTextId").empty();
			$("#guardianUserTextId").empty();
			$("#fatherName").empty();
			$("#motherName").empty();
		}

		function refreshTeacherDetailViewTab() {
			$("#primarySubTextId").empty();
			$("#secondarySubTextId").empty();
			$("#experience").empty();
		}

		function viewUserRefreshModal() {
			$("#studentDetailViewTab").removeClass('active');
			$("#teacherDetailViewTab").removeClass('active');
			$("#userDetailViewTab").addClass('active');	
			$("#studentDetailView").removeClass('active in');
			$("#teacherDetailView").removeClass('active in');
			$("#userDetailView").addClass('active in');	
			$("#userDetailView").removeClass("displayNone").show();
			$("#teacherDetailView").addClass("displayNone").hide();
			$("#studentDetailView").addClass("displayNone").hide();
			$("#studentDetailViewTab").hide();
			$("#teacherDetailViewTab").hide();
			refreshUserDetailViewTab();
			refreshStudentDetailViewTab();
			refreshTeacherDetailViewTab();
			
		}
		
		function displayDataInSpecificTab() {
			$("#userDetailViewTab").click(function(){
				$("#userDetailView").removeClass("displayNone").show();
				$("#studentDetailView").addClass("displayNone").hide();
				$("#teacherDetailView").addClass("displayNone").hide();
			});
			$("#studentDetailViewTab").click(function(){
				$("#studentDetailView").removeClass("displayNone").show();
				$("#userDetailView").addClass("displayNone").hide();
			});
			$("#teacherDetailViewTab").click(function(){
				$("#teacherDetailView").removeClass("displayNone").show();
				$("#userDetailView").addClass("displayNone").hide();
			});
		}
		
		$("document").ready(function() {
			displayDataInSpecificTab();
		});
	</script>
</body>
</html>