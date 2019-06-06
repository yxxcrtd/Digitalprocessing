$(function() {
	oTable1 = $('#table_report').dataTable( {
        "bFilter": false, // 开关，是否启用客户端过滤器
        "bProcessing": true, // 当datatable获取数据时候是否显示正在处理提示信息。
        "bAutoWidth": false, // 自适应宽度
        "sPaginationType": "full_numbers", //分页样式
        "bServerSide": true, // 从服务器端取数据
       	"sAjaxSource": $('#ctx').val() + "/pages/resource/form/stautsIs3Manager?now=" + new Date().getTime(), //mvc后台ajax调用接口。
       	"fnServerParams": function(aoData) { // 以下是For查询
       		aoData.push({"name" : "resourceName", "value" : $("#query_resourceName").val()});
       		aoData.push({"name" : "keyWord", "value" : $("#query_keyword").val()});
       	},
        "fnServerData": retrieveData,
        "fnDrawCallback": function(oSettings) {
			for ( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )	{
				$('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr ).html( i+oSettings._iDisplayStart+1 );
			}
        },
        "aoColumns": [ { 
    			"sTitle": "序号",
        		"mDataProp": "id"
            },{
    			"sTitle": "名称",
                "mDataProp": "resourceName",
			},{
    			"sTitle": "创建时间",
                "mDataProp": "creatDateStr",
			},{
    			"sTitle": "关键字",
                "mDataProp": "keyWord",
			},{
    			"sTitle": "源文件",
                "mDataProp": "bookName",
			},{
    			"sTitle": "状态",
    			"mData": null,
    	        "aTargets": [ -1 ],	
                "fnRender": function (oObj) {
                	var statusval ="";
                	var status = oObj.aData.status;
                	if(status == 1){
                		statusval = "待处理";
                			}
                	else if(status  == 2){
                		statusval = "无源文件";
                			}
                	else if(status == 3){
                		statusval = "完成处理";
                			}
                    return statusval;
            	}
			},{
    			"sTitle": "操作",
    			"mData": null,
    	        "aTargets": [ -1 ],
              	// 自定义列的样式
                "fnRender": function (oObj) {
                    var start = '<div class="hidden-phone visible-desktop btn-group">';
                    var editkeyword = '<button class="btn btn-mini btn-warning" title="设置关键字" onclick="editkeyword(\'' + oObj.aData.id + '\')"><i class="icon-font bigger-120"></i></button>';
                    var deleteval = '<button class="btn btn-mini btn-danger" title="删除" onclick="delObj(\'' + oObj.aData.id + '\')"><i class="icon-trash bigger-120"></i></button>';
                    var configval = '<button class="btn btn-mini btn-info" title="配置" onclick="generate(\''+ oObj.aData.id+'\',\''+oObj.aData.treeCode +'\')"><i class=" icon-wrench bigger-120"></i></button>';
                    var transform = '<button class="btn btn-mini btn-warning" title="导出" onclick="transformObj(\'' + oObj.aData.id + '\')"><i class="icon-circle-arrow-down bigger-120"></i></button>';
                    var preview ='<button class="btn btn-mini btn-inverse" title="预览" onclick="previewObj(\'' + oObj.aData.id + '\')"><i class="icon-eye-open bigger-120"></i></button>';
                    var bookName = oObj.aData.bookName;
                    var editResource = '';
                    if(bookName!=null){
                    	bookName = bookName.toLowerCase();
                    	if(bookName.indexOf(".pdf") > -1 || bookName.indexOf(".txt") > -1 || bookName.indexOf(".doc") > -1 || bookName.indexOf(".docx") > -1){
                    		
                             
                    		editResource = '<button class="btn btn-mini btn-primary" title="编辑" onclick="modObj(\'' + oObj.aData.id + '\')"><i class="icon-edit bigger-120"></i></button>';
                    	}else{
                    		editResource = '';
                    		
                             
                    	}
                    }
                    var end = '</div>';
                    return start +editkeyword + deleteval + configval + transform + preview + editResource + end;
            	}
			}
        ],
        
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

    } );

	$('[data-rel=tooltip]').tooltip();
});
