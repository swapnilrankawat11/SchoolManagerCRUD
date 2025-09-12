<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<script type="text/javascript" src="../js/constant.js"></script>
</head>
<style>
.takeStudentAttendenceTable {
	display: none;
	width: 90%;
	margin-left: 40px;
	border-color: black;
	margin-top: 30px;
	text-align: center;
}
.isPresentRadio {
	margin-left: -26px;
}

.isAbsentRadio {
	margin-left: 32px;
}
</style>
<body>
	<div class="modal" id="takeStudentAttendenceModal">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Student Attendence</h5>
				</div>
				<div class="modal-body">
					<form id="takeStudentAttendenceSearchForm">
						<div class="row">
							<div class="col-1 studentAttendenceTableSearchLabel">Class</div>
							<div class="col-3 messageParentContainerSpecific">
								<select class="form-control" id="takeAttendenceByClassSelectId"
									name="standardId">
									<option id="selectClassOptionToTakeAttendenceId" value="">Select
										Class</option>
								</select>
							</div>
							<div class="col-1" style="width: 7%;"></div>
							<div class="col-1 studentAttendenceTableSearchLabel">Date</div>
							<div class="col-3 messageParentContainerSpecific">
								<input class="form-control" type="text"
									id="attendenceDatePickerId" name="attendenceDate"
									placeholder="Select Date"
									style="margin-left: 12px; width: 100%;">
							</div>
							<div class="col-1"></div>
							<div class="col-sm-2">
								<button type="button" id="takeAttendenceBySearchBtnId"
									class="btn btn-primary" style="float: right;">
									<span id="takeAttendenceSearchBtnLoader"></span> Search
								</button>
							</div>
						</div>
						<hr>
					</form>
					<div id="takeStudentAttendenceModalSuccessMessageContainer"
						class="alert alert-success alert-dismissible"
						style="display: none;">
						<button type="button" class="btn-close" data-hide="alert"></button>
						<strong id="successMessageAtTakeStudentAttendenceModal"></strong>
					</div>
					<div id="takeStudentAttendenceModalErrorMessageContainer"
						class="alert alert-danger alert-dismissible"
						style="display: none;">
						<button type="button" class="btn-close" data-hide="alert"></button>
						<strong id="errorMessageAtTakeStudentAttendenceModal"></strong>
					</div>
					<table id="takeStudentAttendenceTableId"
						class="table table-bordered table-hover takeStudentAttendenceTable">
						<thead>
							<tr>
								<th style="width:28%;"><input type="radio" style="margin-left:-41px;"
									class="form-check-input takeStudentAttendenceRadio"
									id="allStudentsArePresentId" name="allRecords">
									<label style="margin-left:1px;" class="form-check-label" for="allStudentsArePresentId">All
										P</label> <input type="radio" style="margin-left:48px;"
									class="form-check-input takeStudentAttendenceRadio"
									id="allStudentsAreAbsentId" name="allRecords"> <label
									style="margin-left:2px;" class="form-check-label" for="allStudentsAreAbsentId">All
										A</label></th>
								<th>Index</th>
								<th>Sr.No</th>
								<th>Student Name</th>
								<th>Father Name</th>
							</tr>
						</thead>
						<tbody id="takeStudentAttendenceTableBodyId">
						</tbody>
					</table>
					<div id="takeStudentAttendenceTableLoaderId"
						class="spinner-border text-primary"
						style="display: none; margin-left: 550px; margin-top: 10px; width: 3rem; height: 3rem;"></div>
				</div>
				<div class="modal-footer">
					<button id="saveStudentAttendenceBtnId" type="button"
						class="btn btn-primary" style="display:none;">
					<span id="saveStudentAttendenceBtnLoader"></span> Save</button>
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function initializeDatePicker() {
			$("#attendenceDatePickerId").datepicker({
				dateFormat : DATE_FORMAT,
				maxDate : 0,
			});
		}

		function loadTakeStudentAttendenceDialog() {
			refreshTakeStudentAttendenceModal();
			$("#takeStudentAttendenceModal").modal("show");
		}
		
		function disableAllTakeAttendenceSearchFields(disable) {
			$("#takeAttendenceByClassSelectId").prop("disabled",disable);
			$("#attendenceDatePickerId").prop("disabled",disable);
		}
		
		function intializeTakeStudentAttendenceTable(studentsForAttendence){
			$("#takeStudentAttendenceTableLoaderId").hide();
			var index = 1;
			var rowData = null;
			$.each(studentsForAttendence, function () {
				var isPresentRadio = "<input type='radio' class='form-check-input takeStudentAttendenceRadio isPresentRadio'"+
					 				 "id='"+this.userId+"' name='"+this.userId+"isPresent' value='P' checked>" +
								     "<label style='margin-left:7px;' class='form-check-label' for='present'>Present</label>";
				var isAbsentRadio = "<input type='radio' class='form-check-input takeStudentAttendenceRadio isAbsentRadio'"+
								    "id='"+this.userId+"' name='"+this.userId+"isPresent' value='A' checked>"+
								     "<label style='margin-left:7px;' class='form-check-label' for='absent'>Absent</label>";
				
				if(this.attendenceStatus == null){
					isPresentRadio =  isPresentRadio.replace('checked','');
					isAbsentRadio = isAbsentRadio.replace('checked','');
				}else{
					if(this.attendenceStatus == "A"){
						isPresentRadio =  isPresentRadio.replace('checked','');
					}else{
						isAbsentRadio = isAbsentRadio.replace('checked','');
					}
				}
				
				rowData = "<tr><td>"+isPresentRadio+isAbsentRadio+"</td>"+	 
					"<td>"+(index++)+"</td>"+
					"<td>SR_"+this.studentId+"</td>"+
					"<td>"+this.studentName+"</td>"+
					"<td>"+this.fatherName+"</td></tr>"
				
				$("#takeStudentAttendenceTableBodyId").append(rowData);
		    });
			$("#takeStudentAttendenceTableId").show();
			$("#saveStudentAttendenceBtnId").show();
		}
		
		function getStudentDataToTakeAttendence(searchParams) {
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAttendenceSearchServlet',
				type: 'POST',
				data: searchParams,
				success: function(response) {
					$("#takeAttendenceSearchBtnLoader").removeClass("spinner-border spinner-border-sm");
					disableAllTakeAttendenceSearchFields(false);
					if(response.status) {
						$("#takeStudentAttendenceModalErrorMessageContainer").hide();
						$("#errorMessageAtTakeStudentAttendenceModal").text();
						intializeTakeStudentAttendenceTable(response.studentsForAttendence);
					}else {
						$("#takeStudentAttendenceTableLoaderId").hide();
						if(response.studentsForAttendence == null) {
							$("#errorMessageAtTakeStudentAttendenceModal").text("No matching records found!");
							$("#errorMessageAtTakeStudentAttendenceModal").append('<br>');
						}else {
							for(var i = 0 ; i<response.errors.length ; i++) {
								$("#errorMessageAtTakeStudentAttendenceModal").append(response.errors[i]);
								$("#errorMessageAtTakeStudentAttendenceModal").append('<br>');
							}
						}
						$("#takeStudentAttendenceModalErrorMessageContainer").show();
					}	
	        }});
		}
		
		function postProcessingForChangeInSearchFields() {
			$("#takeAttendenceByClassSelectId").change(function() {
				$("#selectClassOptionToTakeAttendenceId").prop("disabled",true);
				$("#takeStudentAttendenceTableBodyId").empty();
				$("#takeStudentAttendenceTableId").hide();
				$("#saveStudentAttendenceBtnId").hide();
			});
			$("#attendenceDatePickerId").change(function() {
				$("#selectClassOptionToTakeAttendenceId").prop("disabled",true);
				$("#takeStudentAttendenceTableBodyId").empty();
				$("#takeStudentAttendenceTableId").hide();
				$("#saveStudentAttendenceBtnId").hide();
			});	
		}
		
		function bindModalSearchBtnClick() {
			$("#takeAttendenceBySearchBtnId").click(function(){
				validateTakeAttendenceDialogSearchParams();
				if($("#takeStudentAttendenceSearchForm").valid()){
					$("#takeAttendenceSearchBtnLoader").addClass("spinner-border spinner-border-sm");
					$("#takeStudentAttendenceTableBodyId").empty();
					$("#studentAttendenceSaveBtnId").hide();
					$("#takeStudentAttendenceTableLoaderId").show();
					$("#takeStudentAttendenceModalErrorMessageContainer").hide();
					$("#takeStudentAttendenceModalSuccessMessageContainer").hide();
					$("#successMessageAtTakeStudentAttendenceModal").text();
					$("#errorMessageAtTakeStudentAttendenceModal").text();
					$("#allStudentsArePresentId").prop('checked',false);
					$("#allStudentsAreAbsentId").prop('checked',false);
					getStudentDataToTakeAttendence($("#takeStudentAttendenceSearchForm").serialize());
					disableAllTakeAttendenceSearchFields(true);
				}	
			});
		}
		
		function refreshTakeStudentAttendenceModal() {
			$("#attendenceDatePickerId").val("")
			$("#takeAttendenceByClassSelectId").val("");
			$(".messageParentContainerSpecific").removeClass("has-success has-error")
			$("#takeStudentAttendenceTableId").hide();
			$("#saveStudentAttendenceBtnId").hide();
			$("#takeStudentAttendenceModalErrorMessageContainer").hide();
			$("#takeStudentAttendenceModalSuccessMessageContainer").hide();
			$(".error").empty();
			$("#takeStudentAttendenceTableBodyId").empty();
		}
		
		function validateTakeAttendenceDialogSearchParams() {
			$("#takeStudentAttendenceSearchForm").validate( {
				rules: {
					standardId: {
						required: true
					},
					attendenceDate: {
						required: true
					}
				},
				messages: {
					standardId: {
						required: "Please choose class"
					},
					attendenceDate: {
						required: "Please enter date"
					}
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					error.addClass("help-block");
					error.insertAfter(element);	
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents(".messageParentContainerSpecific").addClass( "has-error" )
																						.removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents(".messageParentContainerSpecific").addClass( "has-success" )
																						.removeClass( "has-error" );
				}
			} );
		}
		
		function saveStudentAttendence(studentsAttendenceData){
			$.ajax({
				url: 'http://localhost:8090/SchoolManagerCRUD/StudentAttendenceServlet',
				type: 'POST',
				data: studentsAttendenceData,
				success: function(response) {
					$("#saveStudentAttendenceBtnLoader").removeClass("spinner-border spinner-border-sm");
					disableAllRadios(false);
					if(response.status) {
						$("#takeStudentAttendenceModalErrorMessageContainer").hide();
						$("#errorMessageAtTakeStudentAttendenceModal").text();
						$("#successMessageAtTakeStudentAttendenceModal")
																	.text("Students attendence saved successfully!");
						$("#takeStudentAttendenceModalSuccessMessageContainer").show();
					}else {
						$("#takeStudentAttendenceModalSuccessMessageContainer").hide();
							for(var i = 0 ; i<response.errors.length ; i++) {
								$("#errorMessageAtTakeStudentAttendenceModal").append(response.errors[i]);
								$("#errorMessageAtTakeStudentAttendenceModal").append('<br>');
							}
						$("#takeStudentAttendenceModalErrorMessageContainer").show();
					}	
	        }});
		}
		
		function disableAllRadios(disable) {
			$(".takeStudentAttendenceRadio").prop("disabled",disable);
		}
		
		function bindSaveAttendenceBtnClick(){
			$("#saveStudentAttendenceBtnId").click(function(){
				$("#saveStudentAttendenceBtnLoader").addClass("spinner-border spinner-border-sm");
				disableAllRadios(true);
				var studentsAttendenceParams = [];
				$('.takeStudentAttendenceRadio:checked').each(function() {
					if ($(this).attr('id') != "allStudentsArePresentId" && 
							$(this).attr('id') != "allStudentsAreAbsentId") {
						var studentAttendenceData = {};
						studentAttendenceData.userId = $(this).attr('id');
						if($(this).val() == isPresent){
							studentAttendenceData.attendenceStatus = isPresent;
						}else{
							studentAttendenceData.attendenceStatus = isAbsent;
						}
						studentsAttendenceParams.push(studentAttendenceData);
					}
				});
				var studentsAttendenceData = {"standardId" : $("#takeAttendenceByClassSelectId").val(),
											  "attendenceDate" : $("#attendenceDatePickerId").val(),
											  "studentAttendence" : studentsAttendenceParams
											 }; 
				saveStudentAttendence(studentsAttendenceData);
			});
		}
		
		function bindAllPresentBtnClick() {
			$("#allStudentsArePresentId").click(function() {
				$('.isPresentRadio').not(this).prop('checked', this.checked);
			});
		}
		
		function bindAllAbsentBtnClick() {
			$("#allStudentsAreAbsentId").click(function() {
				$('.isAbsentRadio').not(this).prop('checked', this.checked);
			});
		}

		$("document").ready(function() {
			$("#saveStudentAttendenceBtnId").hide();
			initializeDatePicker();
			postProcessingForChangeInSearchFields();
			bindModalSearchBtnClick();
			bindAllPresentBtnClick();
			bindAllAbsentBtnClick();
			bindSaveAttendenceBtnClick();
		});
	</script>
</body>
</html>