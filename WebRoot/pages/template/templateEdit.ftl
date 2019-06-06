<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#templateform").validationEngine();
			});
		</script>
	</head>
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>模板管理<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;<#if form.id==null>新建</#if><#if form.id?? >修改</#if></small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="templateform" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="serverNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>模板名称：</label>
								    <input class="span6"  data-validation-engine="validate[required]" id="name" name="obj.name"  value="${form.obj.name!}"  />
								</div>
								<!--区分修改和添加-->
								<div class="control-group" id="folderNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>模板文件：</label>
									<div class="controls">
										<#if form.id==null>
											<input type="file"  class="span6"   data-validation-engine="validate[required,custom[fileFormat]]" name="upFile" id="upFile"/>
										</#if>	
										<#if form.id?? >
											${form.obj.originalName!}
										</#if>							
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
							</div>
								<input type="hidden" name="id" value="${form.obj.id!}" />
								<input type="hidden" name="obj.id" value="${form.obj.id!}" />
							<div class="form-actions" style="text-align: center; padding-left:0px;">
								<button class="btn btn-success" type="submit" id="save"><i class="icon-save bigger-110"></i> 保存</button>&nbsp; &nbsp; &nbsp;
								<button class="btn btn-inverse" type="reset"><i class="icon-undo bigger-110"></i> 清空</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${request.contextPath}/pages/template/templateList.js"></script>
	</body>
</html>