<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="../css/StudentAcademicSessionDesign.css"/>
<link rel="stylesheet" href="../css/bootstrap5.min.css" />
<%@include file="header.jsp"%>
<title>Students Academic Session</title>
<link rel="icon" type="image/x-icon" href="../img/appFavicon.ico">
</head>
<style>
.myTable {
	display: none;
	width: 90%;
	margin-left: 60px;
	border-color: black;
	margin-top: 50px;
	text-align: center;
}
</style>
<body>
	<div class="searchFieldsContainerForAcademicSessionStudents">
		<div class="academicSessionAndClassContainer">
			<div class="row">
				<div class="col-2">
					<h5 style="text-align:left;padding-top:6px;font-family:arial;">Current Session</h5>
				</div>
				<div class="col-3">
					<select class="form-select" id="academicSessionsSelectId"
						name="academicSessions">
						<option id="chooseAcademicSessionOptionTextId" value="" selected>Select
							Academic Session</option>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-2">
					<h5 style="text-align:left;padding-top:6px;font-family:arial;">Choose class</h5>
				</div>
				<div class="col-3">
					<select class="form-select" id="classesSelectId" name="standard">
						<option id="chooseClassOptionTextId" value="" selected>Select class</option>
					</select>
				</div>
				<div class="col-1">
					<button id="searchButtonId" type="button" class="btn btn-primary"><span id="searchLoader"></span> Search</button>
				</div>
			</div>
		</div>
	</div>
	<div id="academicSessionSuccessMessageContainer"
		class="alert alert-success alert-dismissible" style="display: none;">
		<button type="button" class="btn-close" data-hide="alert"></button>
		<strong id="successMessageAtAcademicSession"></strong>
	</div>
	<div id="academicSessionErrorMessageContainer"
		class="alert alert-danger alert-dismissible" style="display: none;">
		<button type="button" class="btn-close" data-hide="alert"></button>
		<strong id="errorMessageAtAcademicSession"></strong>
	</div>
	<table id="academicSessionStudentsTableId" class="table table-bordered table-hover myTable">
		<thead>
			<tr>
				<th><input class="form-check-input academicSessionStudentRecordCheckbox" type="checkbox"
					id="checkAllCheckBoxId" name="allRecords"></input></th>
				<th>Index</th>
				<th>Sr.No</th>
				<th>Student Name</th>
				<th>Father Name</th>
			</tr>
		</thead>
		<tbody id="academicSessionStudentsTableBodyId">
		</tbody>
	</table>
	<div id="tableLoaderAcademicSessionId" class="spinner-border text-primary" 
										   style="display:none;margin-left:720px;width: 3rem; height: 3rem;"></div>
	<button id="saveAcademicSessionButtonId" type="button" class="btn btn-primary" style="display:none;margin-left:90%;">
																			<span id="saveLoader"></span> Save</button>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap5.bundle.min.js"></script>
	
	<script>
		function renderAcademicSession(academicSessions) {
			var len = academicSessions.length;
			for(var i=0; i<len; i++){
				$('#academicSessionsSelectId').append('<option id="'+academicSessions[i].isCurrentSession+
										'" value="'+academicSessions[i].id+'">'+academicSessions[i].sessionStart+" TO "+
															academicSessions[i].sessionEnd+'</option>');
			}
		}
		
		function renderClasses(classes) {
			var len = classes.length;
			for(var i=0; i<len; i++){
				 var id = classes[i].id;
		         var standardName = classes[i].standardName;
		         $('#classesSelectId').append('<option id="'+standardName+'" value="'+id+'">'+standardName+'</option>');
			}
		}
		
		function getMetadata() {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/AcademicSessionMetadataServlet',
				type: 'GET',
				success: function(response){	
					renderAcademicSession(response.academicSessions);
					renderClasses(response.classes);
	        }});
		}
		
		function initializeAcademicSessionTable(students) {
			$("#tableLoaderAcademicSessionId").hide();
			var index = 1;
			var rowData = null;
			$.each(students, function () {
				rowData = 
					"<tr><td><input class='form-check-input academicSessionStudentRecordCheckbox'" + 
														"type='checkbox' id='"+this.userId+"' checked></input></td>"+
					"<td>"+(index++)+"</td>"+
					"<td>SR_"+this.studentId+"</td>"+
					"<td>"+this.studentName+"</td>"+
					"<td>"+this.fatherName+"</td></tr>"
					
				if($("#academicSessionsSelectId option:selected").attr("id") == "true"){
					if(this.studentAcademicSessionId == "0"){
						rowData = rowData.replace('checked','');
					}
	                $("#academicSessionStudentsTableBodyId").append(rowData);
	                $('#checkAllCheckBoxId').prop("disabled", false);
	                $("#saveAcademicSessionButtonId").show();
	                if($("#academicSessionsSelectId option:selected").attr("id") == "false"){
						$(".academicSessionStudentRecordCheckbox").prop("disabled", true);
					}
	                var defaultCheckboxSelectedId = [];
	                $(".academicSessionStudentRecordCheckbox:checked").each(function(){
	                	defaultCheckboxSelectedId.push($(this).attr("id"));
	                });
	                bindCheckboxClick(defaultCheckboxSelectedId);
				}else{
					if(this.studentAcademicSessionId == $("#academicSessionsSelectId").val()){
						$("#academicSessionStudentsTableBodyId").append(rowData);
		                $("#saveAcademicSessionButtonId").show();
						$(".academicSessionStudentRecordCheckbox").prop("disabled", true);
					}
				}
		    });
		}
		
		function getStudentsAcademicSessionDetail(academicSessionId,standardId) {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAcademicSessionServlet',
				data: {
					standardId : standardId,
					academicSessionId : academicSessionId,
				},
				type: 'GET',
				success: function(response){
					$("#searchLoader").removeClass("spinner-border spinner-border-sm");
					if(response.status){
						$("#academicSessionSuccessMessageContainer").hide();
						$("#academicSessionErrorMessageContainer").hide();
						initializeAcademicSessionTable(response.students);
					}else{
						$("#academicSessionSuccessMessageContainer").hide();
						if(response.students == null){
							$("#tableLoaderAcademicSessionId").hide();
							$("#saveAcademicSessionButtonId").hide();
							$("#academicSessionStudentsTableId").hide();
							$("#errorMessageAtAcademicSession").text("There are no records of class "+
																$("#classesSelectId option:selected").attr("id")+"!");
						}
						else{
							for(var i = 0 ; i<response.errors.length ; i++){
								$("#errorMessageAtAcademicSession").append(response.errors[i]);
								$("#errorMessageAtAcademicSession").append('<br>');
							}	
						}
						$("#academicSessionErrorMessageContainer").show();
					}
	        }});
		}
		
		function saveStudentAcademicSession(userIdArray) {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAcademicSessionServlet',
				data: {
					userIdArray: userIdArray,
				},
				type: 'POST',
				success: function(response){
					$("#saveLoader").removeClass("spinner-border spinner-border-sm");
					$(".academicSessionStudentRecordCheckbox").prop("disabled",false);
					if(response.status){
						$("#academicSessionErrorMessageContainer").hide();
						$("#successMessageAtAcademicSession").text("Records Updated Successfully!");
						$("#academicSessionSuccessMessageContainer").show();
					}else{
						$("#academicSessionSuccessMessageContainer").hide();
						$("#errorMessageAtAcademicSession").text("");
						for(var i = 0 ; i < response.errors.length ; i++){
							$("#errorMessageAtAcademicSession").append(response.errors[i]);
							$("#errorMessageAtAcademicSession").append('<br>');
						}
						$("#academicSessionErrorMessageContainer").show();
					}
	        }});
		}
		
		function bindSearchBtnClick() {
			$("#searchButtonId").click(function() {
				$("#academicSessionErrorMessageContainer").hide();
				$("#academicSessionSuccessMessageContainer").hide();
				$("#searchLoader").addClass("spinner-border spinner-border-sm");
				$("#saveAcademicSessionButtonId").hide();
				$("#errorMessageAtAcademicSession").text("");
				$("#successMessageAtAcademicSession").text("");
				$("#academicSessionStudentsTableBodyId").empty();
				$("#checkAllCheckBoxId").prop("checked",false);
				$('#checkAllCheckBoxId').prop("disabled", true);
				$("#academicSessionStudentsTableId").show();
				$("#tableLoaderAcademicSessionId").show();
				getStudentsAcademicSessionDetail($("#academicSessionsSelectId").val(),$("#classesSelectId").val());
			});
		}
		
		function bindCheckAllBtnClick() {
			$("#checkAllCheckBoxId").click(function() {
				$('.academicSessionStudentRecordCheckbox').not(this).prop('checked', this.checked);
			});
		}

		function bindSaveBtnClick() {
			$("#saveAcademicSessionButtonId").click(function() {
				$(".academicSessionStudentRecordCheckbox").prop("disabled", true);
				$("#saveLoader").addClass("spinner-border spinner-border-sm");
				var userIdArray = [];
				$('.academicSessionStudentRecordCheckbox:checked').each(function() {
					if ($(this).attr('id') != "checkAllCheckBoxId") {
						var userId = $(this).attr('id');
						userIdArray.push(userId);
					}
				});
				saveStudentAcademicSession(userIdArray);
			});
		}

		function bindCloseAlertBtnClick() {
			$("[data-hide]").on("click", function() {
				$(this).closest("." + $(this).attr("data-hide")).hide();
			});
		}

		function bindSelectDropdownClick() {
			$("#academicSessionsSelectId").change(function(){
				$("#chooseAcademicSessionOptionTextId").prop("disabled", true);
				 $("#academicSessionStudentsTableBodyId").empty();
				$("#classesSelectId").prop("disabled",false);
				$("#classesSelectId").change(function() {
					$('#searchButtonId').removeAttr('disabled');
					$("#chooseClassOptionTextId").prop("disabled", true);
				});
			});	
		}

		function bindCheckboxClick(defaultCheckboxSelected){
			$(".academicSessionStudentRecordCheckbox").click(function(){
				if($(".academicSessionStudentRecordCheckbox:checked").length > 0){
					if($(".academicSessionStudentRecordCheckbox:checked").length == defaultCheckboxSelected.length){
						var checkedCheckboxes = [];
							$(".academicSessionStudentRecordCheckbox:checked").each(function(){
								checkedCheckboxes.push($(this).attr("id"));
			                });
						if($(checkedCheckboxes).not(defaultCheckboxSelected).length === 0 && $(defaultCheckboxSelected)
																				.not(checkedCheckboxes).length === 0){
							$('#saveAcademicSessionButtonId').prop("disabled", true);
						}else{
							$('#saveAcademicSessionButtonId').prop("disabled", false);
						}	
					}
					else{
						$('#saveAcademicSessionButtonId').prop("disabled", false);
					}
				}else{
					$('#saveAcademicSessionButtonId').prop("disabled", true);
				}
			});
		}
		
		$("document").ready(function() {
			$('#searchButtonId').prop("disabled", true);
			$('#saveAcademicSessionButtonId').prop("disabled", true);
			$('#checkAllCheckBoxId').prop("disabled", true);
			$("#classesSelectId").prop("disabled",true);
			getMetadata();
			bindSearchBtnClick();
			bindCheckAllBtnClick();
			bindSaveBtnClick();
			bindCloseAlertBtnClick();
			bindCloseAlertBtnClick();
			bindSelectDropdownClick();
		});
	</script>
</body>
</html>