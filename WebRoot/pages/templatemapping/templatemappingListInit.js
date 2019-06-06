$(function() {
	$(".on").click(function(){
		$(".on-down").slideToggle();
	});
	oTable1 = $('#table_report').dataTable( {
        "bFilter": false, // 开关，是否启用客户端过滤器
        "bProcessing": true, // 当datatable获取数据时候是否显示正在处理提示信息。
        "bAutoWidth": false, // 自适应宽度
        "sPaginationType": "full_numbers", //分页样式
        "bServerSide": true, // 从服务器端取数据
       	"sAjaxSource": $('#ctx').val() + "/pages/templatemapping/form/manager?now=" + new Date().getTime(), //mvc后台ajax调用接口。
       	"fnServerParams": function(aoData) { // 以下是For查询
       		aoData.push({"name" : "resourceid", "value" : $("#query_resourceid").val()});
       		aoData.push({"name" : "templateid", "value" : $("#query_templateid").val()});
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
    			"sTitle": "数据模板节点路径",
                "mData": null,
    	        "aTargets": [ -1 ],
              	// 自定义列的样式
                "fnRender": function (oObj) {
                	var start = "<select name='xmlNodeid' id='xmlNodeid' onchange=editsubmit(this,'"+oObj.aData.id+"','"+oObj.aData.resourceid+"','"+oObj.aData.templateid+"') class='span6'>";
                	var optionval = "<option value=''>--选择--</option>";
                	var hiddenval = "<input type='hidden' id='"+oObj.aData.id+"' value=''/>";
                	for(var o in oObj.aData.xmlNodeList){  
                		optionval+="<option value="+oObj.aData.xmlNodeList[o].id;
                		if(oObj.aData.xmlNodeList[o].id==oObj.aData.templateMappingMap[oObj.aData.id]){
                			optionval+=" selected ";
                			hiddenval = "<input type='hidden' id='"+oObj.aData.id+"' value='"+oObj.aData.xmlNodeList[o].id+"'/>";
                		}
                		optionval+=">"+oObj.aData.xmlNodeList[o].nodePath+"</option>";
                	}  
                	var end = "</select>"+hiddenval;
                    return start + optionval + end;
            	}
			},{
    			"sTitle": "标准模板节点路径",
    			"mDataProp": "nodePath",
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
