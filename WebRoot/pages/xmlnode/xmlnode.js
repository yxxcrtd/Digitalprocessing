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



//Edit保存
$(function() {
	var options = {
		beforeSubmit:ZongJu.Watermark.validate,	
		success : showResponse,
		url : $('#ctx').val() + "/pages/watermark/form/editftl",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#WatermarkFormEdit').ajaxForm(options);
});






// Add保存
$(function() {
	var options = {
		success : showResponse,
		url : $('#ctx').val() + "/pages/ftpconfig/form/addftl",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#WatermarkForm').ajaxForm(options);
});

// 显示修改
modObj = function(id) {
	var url = $('#ctx').val() + "/pages/watermark/form/edit?id=" + id;
	var commonModalCss = {
		"width": "450px",
		"margin": "100px 0 0 -450px"
	};
	var commonModalBodyCss = {
		"max-height": "800px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};


//增加
addObj = function() {
	var url = $('#ctx').val() + "/pages/ftpconfig/form/add";
	var commonModalCss = {
		"width": "450px",
		"margin": "100px 0 0 -450px"
	};
	var commonModalBodyCss = {
		"max-height": "800px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};


//删除信息
delObj = function(id) {
	openConfirmModalInFrame("您确定删除该信息吗？",function(){
		var url = $('#ctx').val()+"/pages/xmlnode/form/delete?id="+id;
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
			console.log(response);
			
			fnCallback(response);
		},
		"error" : function(response) {
			alert("error");
		}
	});
};