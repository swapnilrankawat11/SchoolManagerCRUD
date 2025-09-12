<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="../css/bootstrap5.min.css" />
<link rel="stylesheet" href="../css/jquery.ui.css" />
<link rel="stylesheet" href="../css/studentAttendencePageDesign.css" />
<link rel="stylesheet" href="../css/jquery.dataTables.min.css" />
<%@include file="header.jsp"%>
<title>Student Attendence</title>
<link rel="icon" type="image/x-icon" href="../img/appFavicon.ico" />
</head>
<style>
table {
	border: 1px solid black;
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 7px;
}

th {
	border: 1px solid black;
	text-align: center;
	padding: 7px;
	background-color: #c0c0c0;
}

.dataTables_wrapper .dataTables_length {
	padding-bottom: 5px;
}

#studentsAttendenceTableContainer {
	padding: 20px 50px 50px 50px;
}
</style>
<body>
	<div class="attendenceListHeaderContainer">
		<div class="row">
			<div class="col-sm-2" id="attendenceListTitleId"
				style="width: 13%; border-color: black;">
				<h4
					style="text-align: left; padding-top: 4px; font-family: calibri;">Attendence
					List</h4>
			</div>
			<div class="col-sm-8"></div>
			<div class="col-sm-2" style="width: 20%;">
				<button type="button" id="takeAttendenceBtnId"
					class="btn btn-primary" style="float: right; width: 52%;">Take
					Attendence</button>
			</div>
		</div>
	</div>
	<hr style="opacity: 0; margin: 0.4px;">
	<div class="studentAttendenceTableSearchFieldsContainer">
		<form id="studentAttendenceRecordsSearchForm">
			<div class="row">
				<div class="col-sm-1 studentAttendenceTableSearchLabel">Year</div>
				<div class="col-sm-2">
					<select class="form-select" id="attendenceYearSelectId"
						name="attendenceYear" required>
						<option id="chooseAttendenceYearOptionTextId" value="" selected>Select
							Year</option>
					</select>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-1 studentAttendenceTableSearchLabel">Month</div>
				<div class="col-sm-2">
					<select class="form-select" id="attendenceMonthSelectId"
						name="attendenceMonth">
						<option id="chooseAttendenceMonthOptionTextId" value="" selected>Select
							Month</option>
						<option value="01">January</option>
						<option value="02">February</option>
						<option value="03">March</option>
						<option value="04">April</option>
						<option value="05">May</option>
						<option value="06">June</option>
						<option value="07">July</option>
						<option value="08">August</option>
						<option value="09">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>
					</select>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-1 studentAttendenceTableSearchLabel">Day</div>
				<div class="col-sm-2">
					<select class="form-select" id="attendenceDaySelectId"
						name="attendenceDay">
						<option id="chooseAttendenceDayOptionTextId" value="" selected>Select
							Day</option>
					</select>
				</div>
			</div>
			<hr style="opacity: 0;">
			<div class="row">
				<div class="col-sm-1 studentAttendenceTableSearchLabel">Class</div>
				<div class="col-sm-2">
					<select class="form-select" id="showAttendenceRecordsByClassSelectId"
						name="attendenceOfClass" required>
						<option id="chooseClassForAttendenceOptionTextId" value=""
							selected>Select Class</option>
					</select>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-1 studentAttendenceTableSearchLabel">Student
					Info</div>
				<input class="col-sm-2 form-control" type="text"
					id="studentInfoTextId" name="studentInfo"
					style="margin-left: 12px; width: 15%; border: 1px solid #ced4da">
				<div class="col-sm-1"></div>
				<div class="col-sm-1 studentAttendenceTableSearchLabel"
					style="margin-left: 15px;">Teacher Info</div>
				<input class="col-sm-2 form-control" type="text"
					id="teacherInfoTextId" name="teacherInfo"
					style="margin-left: 25px; width: 15%; border: 1px solid #ced4da; margin-left: 10px;">
				<div class="col-sm-1">
					<button type="button" id="searchAttendenceRecordsBtnId"
						class="btn btn-primary" style="float: right;">
						<span id="searchAttendenceRecordsLoader"></span> Search
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="studentAttendenceRecordsErrorMessageContainer"
		class="alert alert-danger alert-dismissible" style="display: none;">
		<button type="button" class="btn-close" data-hide="alert"></button>
		<strong id="errorMessageAtStudentAttendenceRecord"></strong>
	</div>
	<div id="studentsAttendenceTableContainer">
		<table id="studentsAttendenceTableId"
			style="width: 100%; margin-top: 10px; display:none;">
			<thead>
				<tr>
					<th>Index</th>
					<th>Sr.No</th>
					<th>Student Name</th>
					<th>Father Name</th>
					<th>Class</th>
					<th>Status</th>
					<th>Date</th>
					<th>Attendence By</th>
				</tr>
			</thead>
			<tbody id="studentsAttendenceTableBodyId">
			</tbody>
		</table>
	</div>
	<div id="studentAttendenceTableLoaderId"
		class="spinner-border text-primary"
		style="display: none; margin-left: 720px; margin-top: 110px; width: 3rem; height: 3rem;"></div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap5.bundle.min.js"></script>
	<script	type="text/javascript" src="../js/jquery.ui.min.js"></script>
	<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	<%@include file="takeStudentAttendence.jsp"%>
	<script>
		function renderDays(){
			for(var day=1;day<32;day++){
				$("#attendenceDaySelectId").append('<option value="'+day+'">'+day+'</option>');
			}
		}	
	
		function renderClasses(classes) {
			var len = classes.length;
			for(var i=0; i<len; i++) {
				 var id = classes[i].id;
		         var standardName = classes[i].standardName;
		         $('#showAttendenceRecordsByClassSelectId').append('<option id="'+standardName+'" value="'+id+'">'+standardName+'</option>');
		         $('#takeAttendenceByClassSelectId').append('<option id="'+standardName+'" value="'+id+'">'+standardName+'</option>');
			}
		}
		
		function renderYears(years) {
			var optionId = "sessionStartYearOptionId"; 
			for(var i=0; i<years.length; i++) {
		         $('#attendenceYearSelectId').append('<option id="sessionStartYearOptionId" value="'+years[i]+'">'+years[i]+'</option>');
		         optionId = optionId.replace('Start','End');
			}
		}
		
		function getMetadata() {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAttendenceMetadata',
				type: 'GET',
				success: function(response) {	
					renderClasses(response.classes);
					renderYears(response.years);
					classes = response.classes;
	        }});
		}
		
		function disableLabelOptionInSelects() {
			$("#attendenceYearSelectId").change(function() {
				$("#chooseAttendenceYearOptionTextId").prop("disabled",true);
			});
			$("#showAttendenceRecordsByClassSelectId").change(function() {
				$("#chooseClassForAttendenceOptionTextId").prop("disabled",true);
			});
		}
		
		function disableAllSearchFields(disable) {
			$("#attendenceYearSelectId").prop("disabled",disable);
			$("#attendenceMonthSelectId").prop("disabled",disable);
			$("#attendenceDaySelectId").prop("disabled",disable);
			$("#showAttendenceRecordsByClassSelectId").prop("disabled",disable);
			$("#teacherInfoTextId").prop("disabled",disable);
			$("#studentInfoTextId").prop("disabled",disable);
		}
		
		function intializeStudentAttendenceDataTable(studentAttendenceRecords) {
			var index = 1;
			$("#studentsAttendenceTableId").DataTable({
				"searching" : false,
				data : studentAttendenceRecords,
				"columns" : [ {
					"data" : "",
					render : function(data,type,row) {
						return index++;
					}
				}, {
					"data" : "",
					render : function(data,type,row) {
						return "SR_"+row.studentId;
					}
				}, {
					"data" : "studentName"
				}, {
					"data" : "fatherName"
				}, {
					"data" : "standardValue"
				}, {
					"data" : "attendenceStatus"
				}, {
					"data" : "attendenceDate"
				}, {
					"data" : "attendenceByUserFullName"
				}],
			});
			$("#studentAttendenceTableLoaderId").hide();
			$("#studentsAttendenceTableId").show();
			$("#studentsAttendenceTableContainer").show();
		}
		
		function getStudentAttendenceRecords(searchParams) {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAttendenceRecordSearchServlet',
				type: 'POST',
				data: searchParams,
				success: function(response) {
					$("#searchAttendenceRecordsLoader").removeClass("spinner-border spinner-border-sm");
					disableAllSearchFields(false);
					if(response.status) {
						$("#studentAttendenceRecordsErrorMessageContainer").hide();
						$("#errorMessageAtStudentAttendenceRecord").text();
						intializeStudentAttendenceDataTable(response.studentAttendenceRecords);
					}else{
						$("#studentAttendenceTableLoaderId").hide();
						if(response.studentAttendenceRecords == null) {
							$("#errorMessageAtStudentAttendenceRecord").text("No matching records found!");
						}else {
							for(var i = 0 ; i<response.errors.length ; i++) {
								$("#errorMessageAtStudentAttendenceRecord").append(response.errors[i]);
								$("#errorMessageAtStudentAttendenceRecord").append('<br>');
							}
						}
						$("#studentAttendenceRecordsErrorMessageContainer").show();
					}	
	        }});
		}
		
		function bindSearchBtnClick() {
			$("#searchAttendenceRecordsBtnId").click(function() {
				$("#searchAttendenceRecordsLoader").addClass("spinner-border spinner-border-sm");
				$("#studentAttendenceTableLoaderId").show();
				$("#studentsAttendenceTableContainer").hide();
				$("#studentsAttendenceTableId").DataTable().destroy();
				getStudentAttendenceRecords($("#studentAttendenceRecordsSearchForm").serialize());
				disableAllSearchFields(true);
			});
		}
		
		function bindTakeAttendenceBtnClick() {
			$("#takeAttendenceBtnId").click(function(){
				loadTakeStudentAttendenceDialog();
			});
		}
		
		function bindCloseAlertBtnClick() {
			$("[data-hide]").on("click", function() {
				$(this).closest("." + $(this).attr("data-hide")).hide();
			});
		}
		
		$("document").ready(function() {
			$("#studentsAttendenceTableContainer").hide();
			$("#studentsAttendenceTableId").hide();
			getMetadata();
			renderDays();
			disableLabelOptionInSelects();
			bindSearchBtnClick();
			bindTakeAttendenceBtnClick();
			bindCloseAlertBtnClick();
		});
	</script>
</body>
</html>