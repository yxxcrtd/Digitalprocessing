showResponse = function(response, statusText) {
	if (response.isSuccess == "true") {
		alert("设置成功！");
	} else {
		alert("设置失败");
	}
};



$(function() {
	var options = {
		success : showResponse,
		url : $('#ctx').val() + "/pages/threadconfig/form/submit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#ThreadConfigForm').ajaxForm(options);
});


