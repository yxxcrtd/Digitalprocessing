<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<#assign ingentatag=JspTaglibs["/WEB-INF/taglib/ingenta-taglib.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#SubjectForm").validationEngine();
			});
		</script>
	</head>
	
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>图书分类信息<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;修改</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="SubjectForm" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="identDiv">
									<label class="control-label"><span class="red">*&nbsp</span>分类名称：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required]" id="name" name="obj.name" value="${form.obj.name!}"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="ftpNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>分类编码：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required]" id="code" name="obj.code" value="${form.obj.code!}" />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="ipDiv">
									<label class="control-label"><span class="red">*&nbsp</span>英文名称：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required,custom[onlyLetterSp]]" id="nameEn" name="obj.nameEn" value="${form.obj.nameEn!}"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<input type="hidden" name="obj.id" value="${form.obj.id!}" />
							</div>
							<div class="form-actions" style="text-align: center; padding-left:0px;">
								<button class="btn btn-success" type="submit" id="save"><i class="icon-save bigger-110"></i> 保存</button>&nbsp; &nbsp; &nbsp;
								<button class="btn btn-inverse" type="reset"><i class="icon-undo bigger-110"></i> 清空</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${request.contextPath}/pages/subject/subjectList.js"></script>
	</body>
</html>