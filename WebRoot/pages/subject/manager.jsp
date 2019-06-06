<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${ctx }/js/jquery-1.8.2.js"></script>
<title><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.title" /></title>
<script type="text/javascript">
		window.onload=  function(){
		}
		
		function openWindow(url,top,left,width,height){
			var r="";

			if(url.indexOf("?")!=-1){
				url = url+ "&r_=" + Math.random();
			}else {
				url = url+ "?r_" + Math.random();
			}

			window.showModalDialog(url,window,"dialogTop:"+top+";dialogLeft:"+left+";dialogWidth="+width+";dialogHeight="+height);
				if(document.getElementById("txtPage")){
					document.getElementById("page").value = (document.getElementById("txtPage").value - 1);
				}else{
					document.getElementById("page").value = 0;
				}
				
				document.getElementById("form").submit();
			
		}
		function addObj(){
			var url="<%=request.getContextPath()%>/pages/subject/form/edit";
			var top=document.body.offsetHeigth/2;
			var left=document.body.offsetWIdth/2;
			var width="600px";
			var height="300px";
			openWindow(url,top,left,width,height);
		}
		function modObj(id){
			var url="<%=request.getContextPath()%>/pages/subject/form/edit?eid="+id;
			var top=document.body.offsetHeigth/2;
			var left=document.body.offsetWIdth/2;
			var width="600px";
			var height="300px";
			openWindow(url,top,left,width,height);
		}
		
		function delObj(id){
			if(window.confirm("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.delete'/>")){//"你确认要删除分类信息？")){
				document.getElementById("form").action="delete";
				document.getElementById("id").value=id
				document.getElementById("page").value=document.getElementById("txtPage").value-1;
				document.getElementById("form").submit();
			}
		}
		function generate(id,treeCode){
			var url="<%=request.getContextPath()%>/pages/subject/list.jsp?id="+id+"&treeCode="+treeCode;
			var top=document.body.offsetHeigth;
			var left=document.body.offsetWIdth;
			var width="600px";
			var height="600px";
			openWindow(url,top,left,width,height);
		}
		
		function query(){
			document.getElementById("page").value="0";
			document.getElementById("form").submit();
		}
		function generateXML(){
			$.ajax({
				type : "POST",  
				url: "<%=request.getContextPath()%>/pages/subject/form/generateXML",
				success : function(data) { 
				  	alert(data);
			    },  
			    error : function(data) {  
			        alert(data);
			    }  
			  });
		}
</script>
<script>
</script> 
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/ui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/pub.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form:form action="manager" method="post" commandName="form" id="form">
<c:if test="${form.msg!=null&&form.msg != ''}">
<script language="javascript">
		alert('${form.msg}');
	</script>
</c:if>
<div class="bodyDiv bodyNew" style="position:relative;">
	<div class="pos">
<div class="module">
  <div style="margin:5px 0px;">
   <input type="button" name="add" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Button.New"/>" class="devil_button" onclick="addObj()"/>
   <input type="button" name="add" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Label.Upload.FTP.Data"/>" class="devil_button" onclick="generateXML()"/>
  </div>
     	<table width="95%" border="0" cellpadding="0" cellspacing="1" class="devil_table">
     		<thead>
     		<tr>
		        <th width="8%" align="center">
		        	<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Label.SerialNumber"/>
		        </th>
		        <th width="10%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.name"/></th>
		        <th width="10%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.code"/></th>
		        <th width="18%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.standard"/></th>
		         <th width="8%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.type"/></th>
		        <th width="35%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Operating"/></th>
		    </tr>
		    </thead>
		    <tbody>
		   	<c:forEach items="${list}" var="p" varStatus="index">
		   	   <tr  class="<c:if test="${index.index%2 == 1}">odd</c:if><c:if test="${index.index%2 == 0}">eve</c:if>">
		   	   	<td align="center">${index.index + 1}</td>
		   	   	<td align="center">${p.name}</td>
		        <td align="center">${p.code}</td>
		        <td align="center"><c:if test="${p.standard==1 }">Y</c:if><c:if test="${p.standard==2 }">N</c:if></td>
		        <td align="center"><c:if test="${p.type==1 }"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.type.main"/></c:if><c:if test="${p.type==2 }"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.type.else"/></c:if></td>
		        <td align="center">
		        	<input type="button" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Modify"/>" class="devil_button" onclick="modObj('${p.id}')"/>
		        	<input type="button" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Delete"/>" class="devil_button" onclick="delObj('${p.id}')"/>
		        	<input type="button" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.button.manager"/>" class="devil_button" onclick="generate('${p.id}','${p.treeCode }')"/>
		        </td>
		        </tr>
		   	</c:forEach>
		    </tbody>
      	</table>
		<table width="95%" border="0" cellpadding="0" cellspacing="0">
      		<tr height="40">
		   		<td height="25">
		   			<ingenta-tag-v4:SplitTag page="${form.curpage}" pageCount="${form.pageCount}" count="${form.count}" formName="form" showNum="10" i18n="${sessionScope.lang}"/>
		   		</td>
		   	</tr>
      	</table>
</div>
</div>
</div>
<form:hidden path="id"/>
</form:form>
</body>
</html>

