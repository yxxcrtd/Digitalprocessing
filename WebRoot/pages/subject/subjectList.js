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


// Add保存
$(function() {
	var options = {
		success : showResponse,
		url : $('#ctx').val() + "/pages/subject/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#SubjectForm').ajaxForm(options);
});

// 显示修改
modObj = function(id) {
	var url = $('#ctx').val() + "/pages/subject/form/edit?eid="+id;
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
	var url = $('#ctx').val() + "/pages/subject/form/edit?";
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
		var url = $('#ctx').val()+"/pages/subject/form/delete?id="+id;
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

function generate(id,treeCode){
	var url=$('#ctx').val()+ "/pages/subject/list.jsp?id="+id+"&treeCode="+treeCode;
	var top=document.body.offsetHeigth/2;
	var left=document.body.offsetWIdth/2;
	var width = "600px";
	var height = "600px";
	window.showModalDialog(url,window,"minimize:yes;maximize:yes;dialogTop:"+top+";dialogLeft:"+left+";dialogWidth="+width+";dialogHeight="+height);
}


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