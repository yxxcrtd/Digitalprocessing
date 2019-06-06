<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#FtpFolderForm").validationEngine();
			});
		</script>
	</head>
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>FTP文件夹信息<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;新建</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="FtpFolderForm" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="serverNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>服务器名称：</label>
									<div class="controls">
										<select id="ftpid" data-validation-engine="validate[required]" name="ftpid" class="span6" value="">
									        <option value="">--选择--</option>
									        <#if ftpConfigList ??>
										        <#list ftpConfigList as ftpConfig>
										        	<option value="${ftpConfig.id}">${ftpConfig.ftpName}</option>
										        </#list>
									        </#if>
									     </select>
										<span id="activeSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="folderNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>文件夹名称：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="folderName" name="obj.folderName"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="urlDiv">
									<label class="control-label"><span class="red">*&nbsp</span>配置路径：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="url" name="obj.url"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="depictDiv">
									<label class="control-label"><span class="red">*&nbsp</span>文件夹描述：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="depict" name="obj.depict" />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
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
		<script type="text/javascript" src="${request.contextPath}/pages/ftpfolder/ftpFolderList.js"></script>
	</body>
</html>
