showResponse = function(response, statusText) {
	disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		enableAllButton();
	}
};
disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

query = function() {
	initPagingParamsInFrame('oTable1');
	// 重新刷新页面Table
	refreshFrameDataTableInFrame('oTable1');
};

editsubmit = function(obj,templateNodeid,resourceid,templateid){
	var url = $('#ctx').val() + "/pages/templatemapping/form/editsubmit";
	var xmlNodeidnew = obj.value;
	var xmlNodeidold = $("#"+templateNodeid).val();
	$.ajax({
		"dataType" : 'json',
		"type" : "POST",
		"url" : url,
		"cache" : false,
		"data" : {xmlNodeidnew:xmlNodeidnew,xmlNodeidold:xmlNodeidold,templateNodeid:templateNodeid,resourceid:resourceid,templateid:templateid},
		"success" : function(response) {
			$("#"+templateNodeid).val(xmlNodeidnew);
		},
		"error" : function(response) {
			alert("error");
		}
	});
};

retrieveData = function(sSource, aoData, fnCallback) {
	$.ajax({
		"dataType" : 'json',
		"type" : "POST",
		"url" : sSource,
		"cache" : false,
		"data" : aoData,
		"success" : function(response) {
			fnCallback(response);
		},
		"error" : function(response) {
			alert("error");
		}
	});
};