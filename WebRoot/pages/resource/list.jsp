<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">if(/*@cc_on @_jscript_version+@*/0==10){document.write("<meta http-equiv='X-UA-Compatible' content='IE=edge'/>");}</script>
<title><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.title" /></title>
<link rel="stylesheet"
	href="${ctx }/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<link rel="stylesheet" type="text/css"
	href="${ctx }/css/ui-lightness/jquery-ui-1.9.0.custom.css"></link>
<script type="text/javascript" src="${ctx }/js/jquery-1.8.2.js"></script>
<script type="text/javascript"
	src="${ctx }/ztree/js/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript"
	src="${ctx }/ztree/js/jquery.ztree.excheck-3.4.js"></script>
<script type="text/javascript"
	src="${ctx }/ztree/js/jquery.ztree.exedit-3.4.js"></script>
<script type="text/javascript"
	src="${ctx }/js/jquery-ui-1.9.0.custom.js"></script>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}

#dialog1-overlay {
	background: blue;
	opacity: 0.8;
	filter: alpha(opacity = 80);
}
</style>
<script type="text/javascript">	
<!--	
	//var zTree;
	var setting = {
			async: {
				enable: true,
				url:"${ctx}/pages/111/form/subList",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter,
				type:"post"
			},
			view: {expandSpeed:"",
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false,
				
			},
			edit: {
				enable: true,
				showRemoveBtn: setRemoveBtn,
                removeTitle: "删除",
                renameTitle: "修改"
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeRemove: beforeRemove,
				beforeDrag: beforeDrag,
//				beforeDrop: beforeDrop,
				beforeEditName:zTreeBeforeEditName
			}
		};

		function zTreeBeforeEditName(treeId,treeNode){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			//通过Ajax去后台取数据
			$.ajax({
					type : "POST",
					async : false,    
	            	url: "<%=request.getContextPath()%>/pages/xmlnode/form/editChild",
	            	data: {id:treeNode.id},
	            	success : function(data) {
	            		console.log(data);  
						$("#name1").val(data.obj.nodeName);
            		},  
            		error : function(data) { 
              			alert("获取节点信息失败");
            		}  
            	});
			
			
			$("#detail").dialog("open");
			$("#detail").dialog("option","buttons",{"OK":function(){
				var name1 = $("#name1");
				if(name1.val() ==""){
					alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.name'/>");//"分类名称不能为空");
					document.getElementById("name1").focus();
					return;
				}
				$.ajax({
					type : "POST", 
					async : false,   
	            	url: "<%=request.getContextPath()%>/pages/xmlnode/form/editSubmit",
	            	data: {id:treeNode.id,pId:treeNode.pId,name:name1.val(),isp:"false"},
	            	success : function(data) {
	            		alert(data.msg);
	            		if(data.msg=="success"){
	             			alert("修改成功");  
							zTree.cancelEditName(name1.val());
							$("#name1").val("");
							$("#detail").dialog("close");
						}else{
							alert("修改失败");
						}
            		},  
            		error : function(data) {  
            			alert("修改失败");
            		}  
            	});
            	
			}});
			return true;
		}
		//设置顶级节点不能删除
		function setRemoveBtn(treeId, treeNode) {
		    if(treeNode.pId!=null&&treeNode!="")
	           return true;
            else
               return false;
        }
		
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeRemove(treeId, treeNode) {
			var r = false;
			if(treeNode!=null&&treeNode.children!=null&&treeNode.children.length!=null&&treeNode.children.length>0){
				alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.children'/>");//"该分类下有子分类，请先删除子分类");
				r = false;
			}else{
				if(confirm("确认删除 节点 -- [" + treeNode.name + "] ？"))
				{
					$.ajax({
						type : "POST",
						async : false,  
					    url: "<%=request.getContextPath()%>/pages/xmlnode/form/deleteNode",
					    data: {id:treeNode.id,pId:treeNode.pId},
					    success : function(data) {  
					    	
				            if(data.msg=="success"){
				             	r = true;
				            }else{
				            	r = false;
				            }
					    },  
					    error : function(data) {  
					         alert("rerr");
					         r = false;
					    }  
					});
				}else{
					r = false;
				}
			}
			return r;
		}	
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.id
				+ "' title='添加' onfocus='this.blur();'></span>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			 if (btn) btn.bind("click", function(){
				$("#detail").dialog("open");
				$("#detail").dialog("option","buttons",{"OK":function(){
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					var name1 = $("#name1").val();
					if(name1 ==""){
						alert("节点名称不能为空");
						document.getElementById("name1").focus();
						return;
					}
					var res = "success";
					$.ajax({
						type : "POST",  
				           url: "<%=request.getContextPath()%>/pages/xmlnode/form/addSubmit",
				           data: {pId:treeNode.id,name:name1,isp:"false"},
				           success : function(data) { 
				           		var s = data.split(":");
				           		if(s[0]=="success"){
				           			alert("添加成功");
				                    var result = new Array(); 
					           		result = data.split(";");
					           		if(result.length>=1){
										var nodes = zTree.getSelectedNodes();
										if (nodes.length>0) {
											nodes[0].isParent=true;
											zTree.reAsyncChildNodes(nodes[0], "refresh");
										}
					            		$("#detail").dialog("close");
					           		}else{
					    	    		alert("添加失败");
					    	    		res = "error";
					           		}
					       		}else{
					       			alert(s[1]);
					       			res = "error";
					       		}
			            },  
			            error : function(data) {  
			              alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Subject.info.add.error'/>");
			              res = "error";
			            }  
			         });
			         //清空
			         if(res=="success"){
			         	$("#code1").val("");
						$("#name1").val("");
						$("#desc1").val("");
				     }
				}});
			});
		//	} 
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove(); 
		};
		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			var datas = {id:targetNode.id,order:targetNode.order,pId:targetNode.pId,changeId:treeNodes[0].id,moveType:moveType,changePid:treeNodes[0].pId}
			if(targetNode.drop !== false){
				return drops(datas);
			}else{
				return false;
			}
			//return targetNode ? targetNode.drop !== false : true;
		}
		function drops(datas){
			var r = false;
			//如果可以移动，保存移动结果
				$.ajax({
					type : "POST",  
		            url: "<%=request.getContextPath()%>/pages/111/form/subjectPosChange",
		            data: datas,
		            success : function(data) {  
			            //alert(data);
			            if(data=="success"){
			            	r = true;
			            }else{
			            	r = false;
			            }
		            },  
		            error : function(data) {  
		            	r = false;
		            }  
		        });
		}
		function checkCode(code){
			var oldCode = $("#oldCode").val();
			if(code!=oldCode){
				$.ajax({
					type : "POST",  
		            url: "<%=request.getContextPath()%>/pages/subject/form/checkCode",
		            data: {code:code,isp:"false",treeCode:$("#treeCode1").val()},
		            success : function(data) {  
			            //alert(data);
			           $("#check").html(data);
		            },  
		            error : function(data) {  
		            }  
		        });
		    }else{
		    	$("#check").html('');
		    }
		}
		//页面加载树显示
		$(document).ready(function(){
			setting.async.url="${ctx}/pages/xmlnode/form/subList?subId=<%=request.getParameter("id")%>";
			$.fn.zTree.init($("#treeDemo"), setting);
			$("#detail").dialog({
			autoOpen: false,
			height: 400,
			width: 450,
			modal: true,
			buttons: {},
			close: function() {}
			});
		});
		//-->
	</script>
</head>
<body>
	<input type="hidden" name="treeCode" id="treeCode1" value="<%=request.getParameter("treeCode")%>"/>
	<div class="bodyDiv bodyNew" style="position:relative;">
		<div class="pos">
			<div class="bodyBg">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
	</div>

	<div style="display:none;" id="detail">
		<div id="simTestContent" class="simScrollCont">
			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="1" class="tab02">
				<tr>
					<th width="25%">节点名称：</th>
					<td width="75%" align="left"><input type="text" id="name1" 
						name="name" style="width:98%"/></td>
				</tr>
			</table>
			<div class="mtp10"></div>
		</div>
	</div>
</body>
</html>

