<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
<html>
<%@ include file="/common/taglibs.jsp"%>
<head>
<daxtech-tag:CssTag/>
<daxtech-tag:JsTag/>
<base target="_self"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javaScript" src="<%=request.getContextPath()%>/script/EmailUtil.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-1.8.2.js"></script>
<title><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.edit.title"/></title>
<script type="text/javascript">
	function apply(){
		if(document.getElementById("name").value==""){
			alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.name'/>");
			document.getElementById("name").focus();
			return;
		}
		if(document.getElementById("standard").value==""){
			alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.standard'/>");
			document.getElementById("standard").focus();
			return;
		}
		if(document.getElementById("type").value==""){
			alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.type'/>");
			document.getElementById("type").focus();
			return;
		}
		if(document.getElementById("code").value==""){
			alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.code'/>");
			document.getElementById("code").focus();
			return;
		}
		if(document.getElementById("nameEn").value==""){
			alert("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.subject.Prompt.nameEn'/>");
			document.getElementById("nameEn").focus();
			return;
		}
		document.getElementById("form").submit();
	}
	function checkCode(code){
		var oldCode = $("#oldCode").val();
		if(code!=oldCode){
			$.ajax({
				type : "POST",  
		        url: "<%=request.getContextPath()%>/pages/subject/form/checkCode",
		        data: {code:code,isp:"true"},
		        success : function(data) {  
 	            $("#check").html(data);
		        },  
		        error : function(data) {  
		        }  
		     });
		 }else{
		 	$("#check").html('');
		 }
	}
</script>
<link href="../css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/ui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/pub.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form:form id="form" commandName="form" action="editSubmit">
<div class="bodyDiv" >
    <div class="bodyBg">
    <c:if test="${form.id==null||form.id=='0'||form.id==''}">
    	<h3><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.edit.new"/></h3>
    </c:if>
    <c:if test="${form.id!=null&&form.id!='0'&&form.id!=''}">
    	<h3><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.edit.edit"/></h3>
    </c:if>
    <div>
    <p style="margin-left:0px;"><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Must"/></p>
     <div class="book-module">
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" class="tab02">
      <tr>
        <th><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.name"/>：</th>
        <td align="left">
        	<form:input path="obj.name" id="name" cssStyle="width:100%"/>
        </td>
      </tr>
      <tr>
        <th width="15%"><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.code"/>：</th>
        <td width="85%" align="left">
        	<form:hidden path="oldCode" id="oldCode" value="${form.obj.code}"/>
        	<form:input path="obj.code" id="code" cssStyle="width:100%" onblur="checkCode(this.value)"/><span id="check" style="color: red"></span>
        </td>
      </tr>
      <tr>
        <th><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.nameEn"/>：</th>
        <td align="left">
        	<form:input path="obj.nameEn" id="nameEn" cssStyle="width:100%"/>
        </td>
      </tr>
      <tr>
        <th width="20%"><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.matchMode"/>：</th>
        <td width="80%" align="left">
        	<form:select path="obj.matchMode" id="matchMode" cssStyle="width:100%">
        		<form:options items="${form.loadMatchMode }"/>
        	</form:select>
        </td>
      </tr>
      <tr>
        <th width="20%"><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.standard"/>：</th>
        <td width="80%" align="left">
        	<form:select path="obj.standard" id="standard" cssStyle="width:100%">
        		<form:options items="${form.loadStandard }"/>
        	</form:select>
        </td>
      </tr>
      <tr>
        <th width="15%"><span class="red">*</span><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.table.type"/>：</th>
        <td width="85%" align="left">
        	<c:if test="${form.obj.type==1}">
        		<form:hidden path="obj.type" id="type"/>
        		<ingenta-tag:LanguageTag sessionKey="lang" key="Pages.subject.type.Main"/>
        	</c:if>
        	<c:if test="${form.obj.type!=1}">
	        	<form:select path="obj.type" id="type" cssStyle="width:100%">
	        		<form:options items="${form.loadType }"/>
	        	</form:select>
        	</c:if>
        </td>
      </tr>
    </table>
    </div>
    <div align="center" class="mtp10">
    	<input type="button" name="save" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Button.Save"/>" class="devil_button" onclick="apply()"/>
    	<input type="button" name="close" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Button.Close"/>" class="devil_button" onclick="window.close();"/>
	</div>
    <div class="mtp10"></div>
    </div>
  </div>    
</div>
	<form:hidden path="id"/>
</form:form>
</body>
</html>
