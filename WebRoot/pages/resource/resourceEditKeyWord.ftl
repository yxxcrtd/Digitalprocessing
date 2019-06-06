<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#kewordform").validationEngine();
			});
		</script>
	</head>
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>源数据管理<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;配置关键字</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="kewordform" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="serverNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>关键字：</label>
								    <input class="span6" id="name" data-validation-engine="validate[required]" name="obj.keyWord"  value="${form.obj.keyWord!}"  />
								</div>
								<!--区分修改和添加-->
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
		<script type="text/javascript" src="${request.contextPath}/pages/resource/resource.js"></script>
	</body>
</html>