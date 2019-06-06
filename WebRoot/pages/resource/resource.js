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
};

enableAllButton = function() {
	$("#save").attr('disabled', "false");
};

// Add保存
$(function() {
	var options = {
		success : showResponse,
		url : $('#ctx').val() + "/pages/resource/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#resourceform').ajaxForm(options);
});

// 增加
addObj = function() {
	var url = $('#ctx').val() + "/pages/resource/form/edit";
	var commonModalCss = {
		"width" : "450px",
		"margin" : "100px 0 0 -450px"
	};
	var commonModalBodyCss = {
		"max-height" : "800px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};

// 删除信息
delObj = function(id) {
	openConfirmModalInFrame("您确定删除信息吗？", function() {
		var url = $('#ctx').val() + "/pages/resource/form/delete?id=" + id;
		$.ajax({
			"dataType" : 'json',
			"type" : "POST",
			"url" : url,
			"cache" : false,
			"success" : function(response) {
				if (response.isSuccess == "true") {
					window.parent.alertMsg('successModal', 'successMsg',
							response.msg);
					refreshFrameDataTableInFrame('oTable1');
					autoCloseCommonModal(50);
				} else {
					window.parent.alertMsg('errorModal', 'errorMsg',
							response.msg);
				}
			},
			"error" : function(response) {
				alert("error");
			}
		});
	}, null, null);
};

// 转换格式选择层
transformObj = function(id) {

	var url = $('#ctx').val() + "/pages/resource/form/transform?id=" + id;
	var top = document.body.offsetHeigth / 2;
	var left = document.body.offsetWIdth / 2;
	var width = "800px";
	var height = "300px";
	window.showModalDialog(url, window, "minimize:yes;maximize:yes;dialogTop:"
			+ top + ";dialogLeft:" + left + ";dialogWidth=" + width
			+ ";dialogHeight=" + height);

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
//配置xml节点
function generate(id,treeCode){
	var url=$('#ctx').val()+ "/pages/resource/form/indexList?xmlId="+id;
	window.location = url;
}
// 修改关键字
function editkeyword(id) {
	var url = $('#ctx').val() + "/pages/resource/form/editkeyword?id=" + id;
	var commonModalCss = {
		"width" : "450px",
		"margin" : "100px 0 0 -450px"
	};
	var commonModalBodyCss = {
		"max-height" : "800px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
}

// 修改关键字
$(function() {
	var options = {
		success : showResponse,
		url : $('#ctx').val() + "/pages/resource/form/editkeywordSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#kewordform').ajaxForm(options);
});

// 在线查看
previewObj = function(id) {
	var url = $('#ctx').val() + "/pages/resource/form/preview?id=" + id;
	var top = document.body.offsetHeigth / 2;
	var left = document.body.offsetWIdth / 2;
	var width = "800px";
	var height = "1000px";
	window.open(url, window, "fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=1,minimize:yes;maximize:yes;dialogTop:"
			+ top + ";dialogLeft:" + left + ";dialogWidth=" + width
			+ ";dialogHeight=" + height,' alwaysRaised=yes');
};

// 显示修改
modObj = function(id) {
	var url = $('#ctx').val() + "/pages/resource/form/editResourceContent?id=" + id;
	window.location = url;

};

saveContent = function(){
	
	$("#editResourceContentForm").submit();
};
