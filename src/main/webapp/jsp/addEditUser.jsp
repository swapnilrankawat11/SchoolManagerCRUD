<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="../css/ModalDesign.css" />
<link rel="stylesheet" href="../css/loader.css" />
<script type="text/javascript" src="../js/constant.js"></script>
</head>
<body>
	<div id="addEditUserModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div id="modal-header">
					<ul id="addEditUserTabUlId" class="nav nav-tabs">
						<li class="tabs active" id="userTab"><a data-toggle="tab"
							href="#userInfo">User Info</a></li>
						<li class="tabs" style="display: none;" id="teacherTab"><a
							data-toggle="tab" href="#teacherInfo">Teacher Info</a></li>
						<li class="tabs" style="display: none;" id="studentTab"><a
							data-toggle="tab" href="#studentInfo">Student Info</a></li>
					</ul>
				</div>
				<div class="modal-body">
					<div style="display: none;" class="col-sm-6" id="addEditUserModalLoaderContainer">
						<div id="addEditUserModalLoader" class="loader"></div>
					</div>
					<div class="tab-content">
						<div id="userInfo" class="tab-pane fade in active">
							<div id="userInfoSuccessMessageContainer"
								class="alert alert-success" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="successMessage"></strong>
							</div>
							<div id="userInfoErrorMessageContainer"
								class="alert alert-danger" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="errorMessage"></strong>
							</div>
							<form id="userInfoTabForm" class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-sm-3" for="userTypes">User
										Type</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="userType" id="userTypes"
											required>
											<option value="" selected>Select User Type</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="username">Username
									</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" id="username"
											name="userName" required>
									</div>
								</div>
								<input id="userIdField" type="hidden" name="userId" value="">
								<div class="form-group">
									<label class="control-label col-sm-3" for="fname">First
										Name </label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" id="fname"
											name="firstName" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="middleNameTextId">Middle
										Name </label>
									<div class="col-sm-7">
										<input class="form-control" type="text" id="middleNameTextId"
											name="middleName">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="lname">Last
										Name </label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" id="lname"
											name="lastName" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="dob">Date of
										Birth </label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" id="dateOfBirthPicker"
											name="dateOfBirth" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="mail">Email
									</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="email" id="mail"
											name="email" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="gender">Gender
									</label>
									<div class="col-sm-7">
										<div class="radio">
											<label for="gender"><input type="radio" name="gender"
												id="genderMale" value="Male" checked>Male</label>
										</div>
										<div class="radio">
											<label for="gender"><input type="radio" name="gender"
												id="genderFemale" value="Female">Female </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="mobileNumber">Mobile
										Number </label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="tel" id="mobileNumber"
											name="mobileNumber" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="address">Address
									</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<textarea class="form-control" id="address" name="address"
											rows="4" cols="20" maxlength="256" style="resize: none;"
											required></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="recordStatus">Status
									</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="recordStatus"
											id="recordStatus" required>
											<option value="" selected>Select
												Record Status</option>
										</select>
									</div>
								</div>
							</form>
						</div>
						<div id="teacherInfo" class="tab-pane fade">
							<div id="teacherInfoSuccessMessageContainer"
								class="alert alert-success" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="teacherInfoSuccessMessage"></strong>
							</div>
							<div id="teacherInfoErrorMessageContainer"
								class="alert alert-danger" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="teacherInfoErrorMessage"></strong>
							</div>
							<form id="teacherInfoTabForm" class="form-horizontal">
								<input id="teacherUserIdField" type="hidden" name="teacherUserId" value="">
								<input id="teacherIdField" type="hidden" name="teacherId" value="">
								<div class="form-group">
									<label class="control-label col-sm-3" for="primarySub">
										Primary Subject</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="primarySubject"
											id="primarySub" required>
											<option value="" selected>Select Primary Subject</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="secondarySub">
										Secondary Subject</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="secondarySubject"
											id="secondarySub" required>
											<option value="" selected>Select Secondary Subject</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="experience">
										Experience</label>
									<div class="col-sm-3 messageDropdownContainerSpecific">
										<select class="form-control" name="experienceInYears"
											id="experienceInYear" required>
											<option value="">Select Year</option>
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">15</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
											<option value="32">32</option>
											<option value="33">33</option>
											<option value="34">34</option>
											<option value="35">35</option>
											<option value="36">36</option>
											<option value="37">37</option>
											<option value="38">38</option>
											<option value="39">39</option>
											<option value="40">40</option>
										</select>
									</div>

									<div class="col-sm-3 messageDropdownContainerSpecific">
										<select class="form-control" name="experienceInMonths"
											id="experienceInMonth" required>
											<option value="">Select Month</option>
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>

										</select>
									</div>
								</div>

							</form>
						</div>
						<div id="studentInfo" class="tab-pane fade">
							<div id="studentInfoSuccessMessageContainer"
								class="alert alert-success" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="studentInfoSuccessMessage"></strong>
							</div>
							<div id="studentInfoErrorMessageContainer"
								class="alert alert-danger" style="display: none;">
								<a href="#" class="close" aria-label="close">&times;</a> <strong
									id="studentInfoErrorMessage"></strong>
							</div>
							<form id="studentInfoTabForm" class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-sm-3" for="class">Class</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="standard" id="class"
											required>
											<option value="" selected>Select Class</option>
										</select>
									</div>
								</div>
								<input id="studentUserIdField" type="hidden" name="studentUserId" value="">
								<input id="studentIdField" type="hidden" name="studentId" value="">
								<div class="form-group">
									<label class="control-label col-sm-3" for="favSport">Favorite
										Sport</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="favoriteSport"
											id="favSport" required>
											<option value="" selected>Select Favorite Sport</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="thirdLang">Third
										Language</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="thirdLanguage"
											id="thirdLang" required>
											<option value="" selected>Select Third Language</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="guardianType">Guardian
										Type</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="guardianType"
											id="guardianType" required>
											<option value="" selected>Select Guardian Type</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="guardianUser">Guardian
										User</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<select class="form-control" name="guardianUser"
											id="guardianUser" required>
											<option value="" selected>Select Guardian User</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="fatherNameTextId">Father
										Name</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" name="fatherName"
											id="fatherNameTextId" required>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="motherNameTextId">Mother
										Name</label>
									<div class="col-sm-7 messageParentContainerSpecific">
										<input class="form-control" type="text" name="motherName"
											id="motherNameTextId" required>
									</div>
								</div>

							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="userModalSaveBtnId" type="submit"
						class="btn btn-primary">Save</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		function loadAddUserDialog() {
			$("#addEditUserModal").modal('show');
		}
		
		function loadEditUserDialog(userId){
			$("#addEditUserModal").modal('show');
			$("#userModalSaveBtnId").prop("disabled",true);
			$("#userInfoTabForm").fadeTo(0,0.0);
			$('#addEditUserModalLoaderContainer').show();
			getUserDetailsForEdit(userId);
		}
		
		function getUserDetailsForEdit(userId){
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/UserServlet',
				data: {
					userId : userId,
				},
				type: 'GET',
				success: function(response){	
					if(response.status){
						$('#addEditUserModalLoaderContainer').hide();
						renderMetadataInModal(response.userInfo,response.studentInfo,response.teacherInfo);
					}
					else{
						$("#userInfoSuccessMessageContainer").hide();
						$("#errorMessage").append("Unable to process your request. Kindly contact system admin");
						$("#userInfoErrorMessageContainer").show();	
					}
	        }});
		}
		
		function renderMetadataInModal(userInfo,studentInfo,teacherInfo){
			imposeUserInfoData(userInfo);
			if(studentInfo != null){
				imposeStudentInfoData(studentInfo);
			}
			if(teacherInfo != null){
				imposeTeacherInfoData(teacherInfo);	
			}
		}
		
		function imposeUserInfoData(userInfo){
			$("#userModalSaveBtnId").prop("disabled",false);
			$("#userTypes").val(userInfo.userTypeId);
			enableDisableUserInfo(true);
			$("#username").val(userInfo.userName);
			$("#userIdField").val(userInfo.id);
			$("#fname").val(userInfo.firstName);
			
			if(userInfo.middleName == ""){
				$("#middleNameTextId").val("-");
			}else{
				$("#middleNameTextId").val(userInfo.middleName);	
			}
			
			$("#lname").val(userInfo.lastName);
			$("#dateOfBirthPicker").val(userInfo.dateOfBirth);
			$("#mail").val(userInfo.email);
			if(userInfo.gender == "Male"){
				$('#genderMale').prop('checked', true);
			}
			else{
				$('#genderFemale').prop('checked', true);
			} 
			$("#mobileNumber").val(userInfo.mobileNumber);
			$("#address").val(userInfo.address);
			$('#recordStatus').val(userInfo.recordStatusId);
			
			$("#userInfoTabForm").fadeTo(0,1);
		}
		
		function imposeStudentInfoData(studentInfo){
			$("#class").val(studentInfo.standardId);
			$("#studentUserIdField").val(studentInfo.studentUserId);
			$("#studentIdField").val(studentInfo.id);
			$("#favSport").val(studentInfo.favoriteSportId);
			$("#thirdLang").val(studentInfo.thirdLanguageId);
			$("#guardianType").val(studentInfo.guardianTypeId);
			$('#guardianUser').append(
						'<option value="'+studentInfo.guardianUserId+'">'+studentInfo.guardianUserValue+'</option>');	
			$("#guardianUser").val(studentInfo.guardianUserId);
			$("#fatherNameTextId").val(studentInfo.fatherName);
			$("#motherNameTextId").val(studentInfo.motherName);
			enableDisableStudentInfo(true);
			$("#studentTab").show();
		}
		
		function imposeTeacherInfoData(teacherInfo){
			$("#primarySub").val(teacherInfo.primarySubjectId);
			$("#teacherUserIdField").val(teacherInfo.teacherUserId);
			$("#teacherIdField").val(teacherInfo.id);
			$("#secondarySub").val(teacherInfo.secondarySubjectId);
			$("#teacherIdField").val(teacherInfo.teacherUserId);
			$("#experienceInYear").val(teacherInfo.experienceInYear);
			$("#experienceInMonth").val(teacherInfo.experienceInMonth);
			enableDisableTeacherInfo(true);
			$("#teacherTab").show();
		}
		
		function getMetadata(){
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/UserMetadataServlet',
				type: 'GET',
				success: function(response){	
					renderUserTypes(response.userTypes);
					renderGuardianType(response.userTypes);
					renderRecordStatus(response.recordStatus);
					renderSubjects(response.subjects);
					renderSports(response.sports);
					renderClasses(response.classes);
	        }});
		}
		
		function getGuardianUsers(){
			$("#guardianType").change(function(){
				$.ajax({
					url: 'http://localhost:8090/SchoolManagerCRUD/UserFilteredViaUserTypeServlet',
					data: {
						guardianType : $("#guardianType").val(),
					},
					type: 'POST',
					success: function(response){	
						var guardianUsers = response.users;
						renderGuardianUser(guardianUsers);
				}});
			});
		}
		
		function renderUserTypes(list) {
			var len = list.length;
			for(var i=0; i<len; i++){
				 var id = list[i].id;
		         var name = list[i].name;
		         $('#userTypes').append('<option value="'+id+'">'+name+'</option>');
			}
		}
		
		function renderGuardianType(list) {
			var len = list.length;
			for(var i=0; i<len; i++){
				if(list[i].name != "ADMIN"){
					var id = list[i].id;
			        var name = list[i].name;
			        $('#guardianType').append('<option value="'+id+'">'+name+'</option>');	
				}
			}
		}
		
		function renderClasses(list) {
			var len = list.length;
			for(var i=0; i<len; i++){
				var id = list[i].id;
		        var className = list[i].className;
		        $('#class').append('<option value="'+id+'">'+className+'</option>');	
			}
		}
		
		function renderGuardianUser(list){
			$("#guardianUser").empty();
			$('#guardianUser').append('<option value="">Select Guardian User</option>');
			var len = list.length;
			for(var i=0; i<len; i++){
					var id = list[i].id;
			        var fullName = list[i].fullName;
			        $('#guardianUser').append('<option value="'+id+'">'+fullName+'</option>');	
			}
		}
		
		function renderRecordStatus(list){
			var len = list.length;
			for(i=0;i<len;i++){
				var id = list[i].id;
				var name = list[i].name;
				$('#recordStatus').append('<option value="'+id+'">'+name+'</option');
			}
		}
		
		function renderSubjects(list){
			var len = list.length;
			for(i=0;i<len;i++){
				var id = list[i].id;
				var name = list[i].name;
				var isLanguage = list[i].isLanguage;
				$('#primarySub').append('<option value="'+id+'">'+name+'</option');
				$('#secondarySub').append('<option value="'+id+'">'+name+'</option');
				if(isLanguage === true){
					$('#thirdLang').append('<option value="'+id+'">'+name+'</option');	
				}
			}
		}
		
		function renderSports(list){
			var len = list.length;
			for(i=0;i<len;i++){
				var id = list[i].id;
				var name = list[i].name;
				$('#favSport').append('<option value="'+id+'">'+name+'</option');
			}
		}
		
		function deleteUserByUserId(userId) {
			$("#deleteErrorMessageContainer").hide();
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/UserServlet?userId='+userId+'',
				type: 'DELETE',
				success: function(response){	
					if(response.status){
						updateUsersTable();
						$("#deleteUserSuccessMessage").text("Record Deleted Succesfully!");
						$("#deleteSuccessMessageContainer").show();
					}
					else{
						$("#deleteSuccessMessageContainer").hide();
						for(var i = 0 ; i<response.errors.length ; i++){
							$("#deleteUserErrorMessage").append(response.errors[i]);
							$("#deleteUserErrorMessage").append('<br>');
						}
						$("#deleteErrorMessageContainer").show();
					}
	        }});
		}
		
		function validateUserInfoForm() {
			$("#userInfoTabForm").validate( {
				rules: {
					userName: {
						required: true,
						minlength: 8,
						maxlength: 256
					}, 
					firstName: {
						required: true,
						maxlength: 256
					},
					lastName: {
						required: true,
						maxlength: 256
					},
					dateOfBirth: {
						required: true,
					},
					email: {
						required: true,
						email: true,
						maxlength: 256
					},
					mobileNumber: {
						required: true,
						number: true,
						minlength: 10,
						maxlength: 10
					},
					address: {
						required: true,
						maxlength: 256
					}
				},
				messages: {
					userName: {
						required: "Please enter a username",
						minlength: "Your username must consist at least 8 characters",
						maxlength: "Your username can't exceed 256 characters"
					},
					firstName: {
						required: "Please enter first name",
						maxlength: "Your first name can't exceed 256 characters"
					},
					lastName: {
						required: "Please enter last name",
						maxlength: "Your last name can't exceed 256 characters"
					},
					dateOfBirth: {
						required: "Please enter date of birth",
					},
					email: {
						required: "Please enter email address",
						email: "Please enter a valid email address",
						maxlength: "Your email address can't exceed 256 characters"
					},
					mobileNumber: {
						required: "Please enter mobile number",
						maxlength: "Your mobile number can't exceed 10 digits"
					},
					address: {
						required: "Please enter address",
						maxlength: "Your address can't exceed 256 characters"
					}
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		}
		
				
		function validateTeacherInfoForm() {
			$("#teacherInfoTabForm").validate( {
				rules: {
					//TO-DO
				},
				messages: {
					//TO-DO
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-error" ).removeClass( "has-success" );
					$( element ).parents( ".messageDropdownContainerSpecific" )
																.addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-success" ).removeClass( "has-error" );
					$( element ).parents( ".messageDropdownContainerSpecific" )
																.addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		}
		
		function validateStudentInfoForm() {
			$("#studentInfoTabForm").validate( {
				rules: {
					fatherName: {
						required: true,
						maxlength: 256
					},
					motherName: {
						required: true,
						maxlength: 256
					}
				},
				messages: {
					fatherName: {
						required: "Please enter father name",
						maxlength: "Father Name can't exceed 256 characters"
					},
					motherName: {
						required: "Please enter mother name",
						maxlength: "Mother Name can't exceed 256 characters"
					}
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					error.addClass( "help-block" );
					error.insertAfter( element );	
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".messageParentContainerSpecific" )
																.addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		}

		function showTabs() {
				var x = document.getElementById("userTypes").value;
				if (x == USR_TYP_TEACHER) {
					$("#studentTab").hide();
					$("#teacherTab").show();
				} else if (x == USR_TYP_STUDENT) {
					$("#teacherTab").hide();
					$("#studentTab").show();
				} else {
					$("#teacherTab").hide();
					$("#studentTab").hide();
				}	
		}
		
		function bindUserModalSaveBtnClick() {
			$( "#userModalSaveBtnId" ).click(function() {
				$("#errorMessage").empty();
				$("#successMessage").empty();
				var id = $("#addEditUserTabUlId li.active").attr('id');
				if(id == "userTab"){
					processUserInfo();
				}
				else if(id == "studentTab"){
					processStudentInfo();
				}
				else{
					processTeacherInfo();
				}		
			});
		}
		
		function postProcessingForAddUser(response) {
			if(response.status){
				showTabs();
				var userType = document.getElementById("userTypes").value;
				enableDisableUserInfo(true);
				$("#userInfoErrorMessageContainer").hide();	
				$("#userIdField").val(response.id);
				if (userType == USR_TYP_TEACHER) {
					$("#teacherUserIdField").val(response.id);
				} else if (userType == USR_TYP_STUDENT) {
					$("#studentUserIdField").val(response.id);
				}
				$("#successMessage").text("User Information saved successfully!");
				$("#userInfoSuccessMessageContainer").show();
			}
			else{
				$("#userInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#errorMessage").append(response.errors[i]);
					$("#errorMessage").append('<br>');
				}
				$("#userInfoErrorMessageContainer").show();	
			}
		}
		
		function postProcessingForUpdateUser(response) {
			if(response.status){
				$("#userInfoErrorMessageContainer").hide();	
				$("#successMessage").text("User Information updated successfully!");
				$("#userInfoSuccessMessageContainer").show();
			}
			else{
				$("#userInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#errorMessage").append(response.errors[i]);
					$("#errorMessage").append('<br>');
				}
				$("#userInfoErrorMessageContainer").show();	
			}
		}
		
		function processUserInfo(){
			if($("#userInfoTabForm").valid()){
				$.ajax({
					url: 'http://localhost:8090/SchoolManagerCRUD/UserServlet',
					method: 'POST' ,
					data:$("#userInfoTabForm").serialize(),  
					success: function(response){
						if($("#userIdField").val() == "") {
							postProcessingForAddUser(response);
						}else{
							postProcessingForUpdateUser(response);
						}
		        }});
			}	
		}
		
		function postProcessingForAddStudent(response){
			if(response.status){
				$("#studentIdField").val(response.id);
				enableDisableStudentInfo(true);
				$("#studentInfoErrorMessageContainer").hide();	
				$("#studentInfoSuccessMessage").text("Student Information saved successfully!");
				$("#studentInfoSuccessMessageContainer").show();
				updateUsersTable();
			}
			else{
				$("#studentInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#studentInfoErrorMessage").append(response.errors[i]);
					$("#studentInfoErrorMessage").append('<br>');
				}
				$("#studentInfoErrorMessageContainer").show();	
			}
		}
		
		function postProcessingForUpdateStudent(response){
			if(response.status){
				$("#studentInfoErrorMessageContainer").hide();	
				$("#studentInfoSuccessMessage").text("Student Information updated successfully!");
				$("#studentInfoSuccessMessageContainer").show();
			}
			else{
				$("#studentInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#studentInfoErrorMessage").append(response.errors[i]);
					$("#studentInfoErrorMessage").append('<br>');
				}
				$("#studentInfoErrorMessageContainer").show();	
			}
		}
		
		function processStudentInfo(){
			if($("#studentInfoTabForm").valid()){
				$.ajax({
					url: 'http://localhost:8090/SchoolManagerCRUD/StudentInfoServlet',
					method: 'POST' ,
					data:$("#studentInfoTabForm").serialize(),  
					success: function(response){	
						if($("#studentIdField").val() == "") {
							postProcessingForAddStudent(response);
						}else{
							postProcessingForUpdateStudent(response);
						}
		        }});
			}
		}
		
		function postProcessingForAddTeacher(response) {
			if(response.status){
				$("#teacherIdField").val(response.id);
				enableDisableTeacherInfo(true);
				$("#teacherInfoErrorMessageContainer").hide();	
				$("#teacherInfoSuccessMessage").text("Teacher Information saved successfully!");
				$("#teacherInfoSuccessMessageContainer").show();
				updateUsersTable();
			}
			else{
				$("#teacherInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#teacherInfoErrorMessage").append(errors[i]);
					$("#teacherInfoErrorMessage").append('<br>');
				}
				$("#teacherInfoErrorMessageContainer").show();	
			}
		}
		
		function postProcessingForUpdateTeacher(response) {
			if(response.status){
				$("#teacherInfoErrorMessageContainer").hide();	
				$("#teacherInfoSuccessMessage").text("Teacher Information updated successfully!");
				$("#teacherInfoSuccessMessageContainer").show();
			}
			else{
				$("#teacherInfoSuccessMessageContainer").hide();
				for( var i = 0; i < response.errors.length; i++ ){
					$("#teacherInfoErrorMessage").append(response.errors[i]);
					$("#teacherInfoErrorMessage").append('<br>');
				}
				$("#teacherInfoErrorMessageContainer").show();	
			}
		}
		
		function processTeacherInfo(){
			if($("#teacherInfoTabForm").valid()){
				$.ajax({
					url: 'http://localhost:8090/SchoolManagerCRUD/TeacherInfoServlet',
					method: 'POST' ,
					data:$("#teacherInfoTabForm").serialize(),  
					success: function(response){	
					if($("#teacherIdField").val() == "") {
						postProcessingForAddTeacher(response);
					}else{
						postProcessingForUpdateTeacher(response);
					}
		        }});
			}
		}
		
		function dismissFormStatusMessage(){
			$(".close").click(function(){
				$("#userInfoSuccessMessageContainer").hide();
				$("#userInfoErrorMessageContainer").hide();
				$("#studentInfoSuccessMessageContainer").hide();
				$("#studentInfoErrorMessageContainer").hide();
				$("#teacherInfoSuccessMessageContainer").hide();
				$("#teacherInfoErrorMessageContainer").hide();
			});
		}
		
		function initializeDatePicker(){
			$("#dateOfBirthPicker").datepicker({
				dateFormat: DATE_FORMAT,
				maxDate: 0,
			});
		}
		
		function enableDisableUserInfo(disableField){
			$("#userTypes").prop( "disabled", disableField );
			$("#username").prop( "disabled", disableField );
			$("#mail").prop( "disabled", disableField);
			$("#fname").prop( "disabled", disableField);
			$("#middleNameTextId").prop( "disabled", disableField);
			$("#lname").prop( "disabled", disableField);
			$("#genderMale").prop( "disabled", disableField);
			$("#genderFemale").prop( "disabled", disableField);
			$("#dateOfBirthPicker").prop( "disabled", disableField);
		}
		
		function enableDisableStudentInfo(disableField){
			$("#class").prop( "disabled", disableField );
			$("#thirdLang").prop( "disabled", disableField );
			$("#fatherNameTextId").prop( "disabled", disableField );
			$("#motherNameTextId").prop( "disabled", disableField );
		}
		
		function enableDisableTeacherInfo(disableField){
			$("#primarySub").prop( "disabled", disableField );
		}
		
		function refreshUserInfoForm(){
			$('#userInfoTabForm input[type="text"]').val('');
			$('#userIdField').val('');
			$('#userInfoTabForm input[type="email"]').val('');
			$('#userInfoTabForm input[type="tel"]').val('');
			$('#userInfoTabForm select').val('');
			$('#userInfoTabForm textarea').val('');
			$('#genderMale').prop('checked', true);
			enableDisableUserInfo(false);
			$("#userInfoSuccessMessageContainer").hide();
			$("#userInfoErrorMessageContainer").hide();
			$( ".messageParentContainerSpecific" ).removeClass( "has-success" );
			$( ".messageParentContainerSpecific" ).removeClass( "has-error" );
			$( ".error" ).empty();	
		}
		
		function refreshStudentInfoForm(){
			$('#studentInfoTabForm input[type="text"]').val('');
			$('#studentUserIdField').val('');
			$('#studentIdField').val('');
			$('#studentInfoTabForm select').val('');
			enableDisableStudentInfo(false);
			$("#studentInfoSuccessMessageContainer").hide();
			$("#studentInfoErrorMessageContainer").hide();	
		}
		
		function refreshTeacherInfoForm(){
			$("#teacherInfoTabForm select").val('');
			$('#teacherUserIdField').val('');
			$('#teacherIdField').val('');
			enableDisableTeacherInfo(false);
			$("#teacherInfoSuccessMessageContainer").hide();
			$("#teacherInfoErrorMessageContainer").hide();
			$(".messageDropdownContainerSpecific").removeClass("has-success");
			$(".messageDropdownContainerSpecific").removeClass("has-error");
		}
		
		function addEditUserRefreshModal(){
			$("#studentInfo").removeClass('active');
			$("#teacherInfo").removeClass('active');
			$("#studentTab").removeClass('active');
			$("#teacherTab").removeClass('active');
			$("#userTab").addClass('active');
			$("#userInfo").addClass('active in');
			refreshUserInfoForm();
			refreshStudentInfoForm();
			refreshTeacherInfoForm();
			$("#studentTab").hide();
			$("#teacherTab").hide();
		}
		
		$("document").ready(function() {	
			getMetadata();
			initializeDatePicker();
			getGuardianUsers();
			bindUserModalSaveBtnClick();
			validateUserInfoForm();
			validateTeacherInfoForm();
			validateStudentInfoForm();
			dismissFormStatusMessage();
		});
	</script>

</body>
</html>