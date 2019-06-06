<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs2.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${ctx }/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery.flexselect.custom.js"></script>
<script type="text/javascript" src="${ctx }/js/liquidmetal.js"></script>
<link href="${ctx}/css/flexselect.css" rel="stylesheet" type="text/css" />
<title><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.title"/></title>
<daxtech-tag:CssTag/>
<daxtech-tag:JsTag/>
<script type="text/javascript">
		   $(document).ready(function() {
		  
        $("select[class*=flexselect]").flexselect();
        
        
      });
		function batchSave(){
			if(window.confirm("<ingenta-tag:LanguageTag sessionKey='lang' key='Pages.Subject.relation.Prompt.batch'/>")){
				document.getElementById("form").action="batchSave";
				document.getElementById("page").value=document.getElementById("txtPage").value-1;
				document.getElementById("form").submit();
			}
		}
		
		function query(){
			document.getElementById("page").value="0";
			document.getElementById("form").submit();
		}
		
</script>
<script>
</script> 
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/ui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/pub.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form:form action="relationManager" method="post" commandName="form" id="form">
<c:if test="${form.msg!=null&&form.msg != ''}">
<script language="javascript">
		alert('${form.msg}');
	</script>
</c:if>
<div class="bodyDiv bodyNew" style="position:relative;">
	<div class="pos">
<div class="bodyBg">
  <div  class="book-module"  style="margin:5px 0px;">
  		<table width="95%" border="0" cellpadding="0" cellspacing="1" class="tab02">
	       <tr>
	       	 <th width="8%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.code"/>：</th>
	         <td width="15%">
	          <form:input path="code" cssStyle="width:95%" id="code"/> 
	         </td>
	         <th width="8%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.name"/>：</th>
	         <td width="15%">
        	<form:input path="name" cssStyle="width:95%" id="name"/> 
	         </td>
	         <th width="8%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.Sub"/>：</th>
	         <td width="15%">
	         	<form:select path="baseCode" cssStyle="width:97%" id="subId">
					<form:option value=""><ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Select"/></form:option>
						<c:forEach items="${form.elseList}" var="c">
							<form:option value="${c.treeCode}">${c.name}</form:option>
						</c:forEach>
				</form:select>
	         </td>
	         <td align="center" width="31%">
			 	<input type="button" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Button.Inquiry"/>" class="devil_button" onclick="query()"/>
			 	<input type="button" value="<ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.Button.batch"/>" class="devil_button" onclick="batchSave()"/>
			 </td>
	       </tr>
	    </table>
  </div>
  	<div class="module">
     	<table width="95%" border="0" cellpadding="0" cellspacing="1" class="devil_table">
     		<thead>
     		<tr>
		        <th width="10%" align="center">
		        	<ingenta-tag:LanguageTag sessionKey="lang" key="Global.Label.SerialNumber"/>
		        </th>
		        <th width="20%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.code"/></th>
		        <th width="35%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.name"/></th>
		        <th width="35%" align="center"><ingenta-tag:LanguageTag sessionKey="lang" key="Pages.Subject.relation.table.reSub"/></th>
		    </tr>
		    </thead>
		    <tbody>
		   	<c:forEach items="${list}" var="p" varStatus="index">
		   	   <tr  class="<c:if test="${index.index%2 == 1}">odd</c:if><c:if test="${index.index%2 == 0}">eve</c:if>">
		   	   	<td align="center">${index.index + 1}</td>
		   	   	<td align="center">${p.elseSub.code}</td>
		        <td align="center">${p.elseSub.name}</td>
		        <td align="center">
		        	<input type="hidden" name="coopCodes" value="${p.elseSub.code}" style="width:100%"/>
		        	<input type="hidden" name="coopIds" value="${p.elseSub.id}" style="width:100%"/>
		        	<select  name="CLCIds" style="width:97%">
		        		<option value="0" <c:if test="${p.mainSub.id==null||p.mainSub.id==''}"> selected</c:if>><ingenta-tag:LanguageTag sessionKey="lang" key="Global.Prompt.Select"/></option>
		        		<c:forEach items="${form.subList}" var="c">
		        			<option value="${c.id}" <c:if test="${p.mainSub.id==c.id}"> selected</c:if>>
		        			<c:if test="${fn:length(c.treeCode)==6 }">${c.name}</c:if>
		        			<c:if test="${fn:length(c.treeCode)>6 }">
		        			<c:forEach  begin="0" end="${fn:length(c.treeCode)-6 }"  varStatus="sta">-</c:forEach>${c.name}${c.code}
		        			</c:if>
		        			</option>
						</c:forEach>
		        	</select>
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
</div>
</form:form>
</body>
</html>

