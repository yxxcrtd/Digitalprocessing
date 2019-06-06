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

readval = function(id){
	var url = $('#ctx').val() + "/pages/convertresource/form/readonline?id="+id;
//	var url = $('#ctx').val() + "/pages/convertresource/readonline.jsp";
	var top=document.body.offsetHeigth/2;
	var left=document.body.offsetWIdth/2;
	var width = "800px";
	var height = "300px";
	window.showModalDialog(url,window,"minimize:yes;maximize:yes;dialogTop:"+top+";dialogLeft:"+left+";dialogWidth="+width+";dialogHeight="+height);
};

query = function() {
	initPagingParamsInFrame('oTable1');
	// 重新刷新页面Table
	refreshFrameDataTableInFrame('oTable1');
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