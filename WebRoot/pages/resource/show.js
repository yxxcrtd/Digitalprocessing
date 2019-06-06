
disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};
showResponse = function(response, statusText) {
	disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('PUP.Base.News.oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		enableAllButton();
	}
};

//Add保存
	$(function() {
		var options = {
			success : showResponse,
			url : $('#ctx').val() + "/pages/xmlnode/form/editSubmit",
			type : 'post',
			clearForm : false,
			timeout : 3000
		};
		$('#form').ajaxForm(options);
	});


PUP.Base.News.Show = function() {
	this.zTree = null;
	this.rMenu = null;
	this.shadow = null;
};
/**
 * 修改功能按钮
 */
PUP.Base.News.modObj = function(id) {
	var url = $('#ctx').val() + "/pages/xmlnode/form/edit?id=" + id;
	var commonModalCss = {
		"width" : "550px",
		"height" : "600px"
	};
	var commonModalBodyCss = {
		"max-height" : "600px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};

xmlnodecolinit = function(id) {
	var url = $('#ctx').val() + "/pages/xmlnode/form/xmlnodecolinit?id=" + id;
	var commonModalCss = {
		"width" : "550px",
		"height" : "600px"
	};
	var commonModalBodyCss = {
		"max-height" : "600px"
	};
	openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};


xmlnodecolsubmit = function(){
	var options = {
			success : showResponse,
			url : $('#ctx').val() + "/pages/xmlnode/form/xmlnodecolsubmit",
			type : 'post',
			clearForm : false,
			timeout : 3000
		};
	$('form').ajaxForm(options);
	$('form').submit();
};


/**
 * 撤回功能键
 */
PUP.Base.News.unrelease = function(id){
	openConfirmModalInFrame("您确定撤回吗？", function() {
		var url = $('#ctx').val() + "/pages/news/form/unrelease?id=" + id;
		$.ajax({
			"dataType" : 'json',
			"type" : "POST",
			"url" : url,
			"cache" : false,
			"success" : function(response) {
				if (response.isSuccess == "true") {
					openSuccessAlertModalInFrame(response.msg);
					refreshFrameDataTableInFrame('PUP.Base.News.oTable1');
				} else {
					openErrorAlertModalInFrame(response.msg);
				}
			},
			"error" : function(response) {
				alert("error");
			}
		});
	}, null, null);
};

PUP.Base.News.newspicture = function (id) {
	var url=$('#ctx').val() + "/pages/newspicture/form/index?nid=" + id;
	window.location.href = url;
};

PUP.Base.News.newsVideo=function (id) {
	var url=$('#ctx').val() + "/pages/newsVideo/form/index?nid=" + id;
	window.location.href = url;
};

PUP.Base.News.products = function(id) {
	var url=$('#ctx').val() + "/pages/news/form/productsIndex?nid=" + id;
	window.location.href = url;
};


PUP.Base.News.hideTree = function() {
	$('#treeDemo').toggleClass("hide");
};

PUP.Base.News.retrieveData = function(sSource, aoData, fnCallback) {
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
		}
	});
};

/**查询按钮  触发事件*/
PUP.Base.News.createDataTable = function() {
	var nodeCode = PUP.Base.News.Show.zTree.getSelectedNodes()[0].nodeCode;
	$("#nodeCode").val(nodeCode);
	if(PUP.Base.News.oTable1!=null){
		refreshFrameDataTableInFrame('PUP.Base.News.oTable1');
	}else{
		PUP.Base.News.oTable1 = $('#table_classify')
					.dataTable(
							{
								"bFilter" : false, // 开关，是否启用客户端过滤器
								"bProcessing" : true, // 当datatable获取数据时候是否显示正在处理提示信息。
								"bAutoWidth" : false, // 自适应宽度
								"sPaginationType" : "full_numbers", // 分页样式
								"bServerSide" : true, // 从服务器端取数据
								"sAjaxSource" : $('#ctx').val()+ "/pages/xmlnode/form/manager", // mvc后台ajax调用接口。
								"fnServerParams" : function(aoData) {
									aoData.push({"name": "nodeCode", "value": PUP.Base.News.Show.zTree.getSelectedNodes()[0].nodeCode});
									aoData.push({"name": "xmlId", "value": $("#xmlId").val()});
								},
								"fnServerData" : PUP.Base.News.retrieveData,
								"fnDrawCallback" : function(oSettings) {
									for ( var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
										$('td:eq(0)',oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i+ oSettings._iDisplayStart+ 1);
									}
								},
								"aoColumns" : [
										{
											"sTitle" : "序号",
											"mDataProp" : "id",
										},
										{
											"sTitle": "节点路径",
							                "mDataProp": "nodePath",
										},
										{
											"sTitle": "节点路径",
							                "mDataProp": "nodeValue",
										},
										{
											"sTitle": "节点标注",
							                "mDataProp": "nodeKey",
										},
										{
											"sTitle" : "操作",
											"bSortable" : false,
											"mData" : null,
											"aTargets" : [ -1 ],
											// 自定义列的样式  
											"fnRender" : function(oObj) {
												var start = '<div class="hidden-phone visible-desktop btn-group">';
												var edit = '<button class="btn btn-mini btn-warning" title="修改" onclick="PUP.Base.News.modObj(\''
														+ oObj.aData.id +'\')"><i class="icon-edit bigger-120"></i></button>';
												var xmlnodecolinit = '<button class="btn btn-mini btn-warning" title="标引" onclick="xmlnodecolinit(\''
													+ oObj.aData.id +'\')"><i class="icon-edit bigger-120"></i></button>';
												var end = '</div>';
												
												return start  + edit + xmlnodecolinit + end;
											}
										} ],
	
								// 多语言配置
								"oLanguage" : {
									"sProcessing" : "正在加载中......",
									"sLengthMenu" : "每页显示 _MENU_ 条记录",
									"sZeroRecords" : "对不起，查询不到相关数据！",
									"sEmptyTable" : "表中无数据存在！",
									"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
									"sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
									"sSearch" : "搜索",
									"oPaginate" : {
										"sFirst" : "首页",
										"sPrevious" : "上一页",
										"sNext" : "下一页",
										"sLast" : "末页"
									}
								}
							});
		$('[data-rel=tooltip]').tooltip();
	}
};

function OnRightClick(event, treeId, treeNode) {
	PUP.Base.News.Show.zTree.selectNode(treeNode);
	showRMenu(treeNode, event.clientX, document.body.scrollTop + event.clientY);
}

function OnLeftClick(event, treeId, treeNode) {
	
	
}

function filter(treeId, parentNode, childNodes) {
	if (!childNodes)
		return null;
	for ( var i = 0, l = childNodes.length; i < l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}
function showRShadow(width, height, x, y) {
	PUP.Base.News.Show.shadow.css({
		"width" : width + "px",
		"height" : height + "px",
		"left" : x + 4 + "px",
		"top" : y + 4 + "px",
		"visibility" : "visible"
	});
}
function hideRMenu() {
	if (PUP.Base.News.Show.rMenu)
		PUP.Base.News.Show.rMenu.css({
			"visibility" : "hidden"
		});
	if (PUP.Base.News.Show.shadow)
		PUP.Base.News.Show.shadow.css({
			"visibility" : "hidden"
		});
	$("body").unbind("mousedown", onBodyMouseDown);
}
function onBodyMouseDown(event) {
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
		PUP.Base.News.Show.rMenu.css({
			"visibility" : "hidden"
		});
		PUP.Base.News.Show.shadow.css({
			"visibility" : "hidden"
		});
	}
}
function showRMenu(node, x, y) {
	$("#rMenu ul").show();
	$("#shadow").show();
	if (node.isParent) {// 菜单非叶子节点
		$("#add").show();
		$("#edit").show();
		$("#delete").hide();
	} else { // 菜点叶子节点
		$("#add").show();
		$("#edit").show();
		$("#delete").show();
}

	showRShadow(PUP.Base.News.Show.rMenu.width(), PUP.Base.News.Show.rMenu.height(), x, y);
	PUP.Base.News.Show.rMenu.css({
		"top" : y + "px",
		"left" : x + "px",
		"visibility" : "visible"
	});

	$("body").bind("mousedown", onBodyMouseDown);
}