showResponse = function(response, statusText) {
	disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('oTable1');
		autoCloseCommonModal(3);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		enableAllButton();
	}
};
disableAllButton = function() {
	$("#save").attr('disabled', "true");
};

enableAllButton = function() {
	$("#save").attr('disabled', "false");
};

saveContent = function(){
	var contentNoStyle = ue.getContentTxt();
	$("#contentNoStyle").val(contentNoStyle);
	$("#OcrFileFormEdit").submit();
};


//删除信息
delObj = function(id) {
	openConfirmModalInFrame("您确定删除该信息吗？",function(){
		var url = $('#ctx').val()+"/pages/OcrFileManage/form/delete?id="+id;
		$.ajax( {
			"dataType": 'json',
			"type": "POST",
			"url": url,
			"cache": false,
			"success": function(response) {
				if (response.isSuccess == "true") {
					window.parent.alertMsg('successModal', 'successMsg', response.msg);
					refreshFrameDataTableInFrame('oTable1');
					autoCloseCommonModal(50);
				} else {
					window.parent.alertMsg('errorModal', 'errorMsg', response.msg);
				}
			},
			"error": function(response) {
				alert("error");
			}
		} );
	},null,null);
};
//显示修改
modObj = function(id) {
	var url = $('#ctx').val() + "/pages/OcrFileManage/form/edit?id="+id;
	window.location=url;
};


//转换格式选择层
transformObj = function(id) {
	var url = $('#ctx').val() + "/pages/OcrFileManage/form/transform?id=" + id;
	var top=document.body.offsetHeigth/2;
	var left=document.body.offsetWIdth/2;
	var width = "800px";
	var height = "300px";
	window.showModalDialog(url,window,"minimize:yes;maximize:yes;dialogTop:"+top+";dialogLeft:"+left+";dialogWidth="+width+";dialogHeight="+height);
	
};

//在线查看
previewObj = function(id){
	var url = $('#ctx').val() + "/pages/OcrFileManage/form/preview?id="+id;
	var top=document.body.offsetHeigth/2;
	var left=document.body.offsetWIdth/2;
	var width = "800px";
	var height = "1000px";
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