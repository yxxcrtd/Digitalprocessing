<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#include "Common.ftl" />
<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<#assign ingentatag=JspTaglibs["/WEB-INF/taglib/ingenta-taglib.tld"] />
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="${request.contextPath}/ueditor/ueditor.all.js"></script>
		<script type="text/javascript" src="${request.contextPath}/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/jquery.flexselect.custom.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/liquidmetal.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#OcrFileFormEdit").validationEngine();
			});
		</script>
	</head>
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>Ocr文件信息<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;修改</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="OcrFileFormEdit" method="POST" commandName="form" class="form-horizontal" action="editSubmit">
							<div class="on-down">
								<div class="control-group" id="fileNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>文件名：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="fileName" name="obj.fileName" value="${form.obj.fileName!}"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="receiveFilePathDiv">
									<label class="control-label"><span class="red">*&nbsp</span>接收文件路径：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="receiveFilePath" name="obj.receiveFilePath" value="${form.obj.receiveFilePath!}"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="originalFilePathDiv">
									<label class="control-label"><span class="red">*&nbsp</span>原始文件路径：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required] id="receiveFilePath" name="obj.originalFilePath" value="${form.obj.originalFilePath!}"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="contentDiv">
									<label class="control-label">文件内容：</label>
									<div class="controls">
										<script class="span6" name="obj.content"  id="content" type="text/plain" style="width:85%;height:300px">${form.obj.content!}</script>
										<script type="text/javascript" > 
											ue = UE.getEditor("content",{wordCount:false,elementPathEnabled:false});
										</script>
									</div>
								</div>
								
								<input type="hidden" id="contentNoStyle" name="obj.contentNoStyle"/>
								<input type="hidden" name="obj.id" value="${form.obj.id!}" />
							</div>
							<div class="form-actions" style="text-align: center; padding-left:0px;">
								<button class="btn btn-success" type="button" onclick="saveContent();" id="save"><i class="icon-save bigger-110"></i> 保存</button>&nbsp; &nbsp; &nbsp;
								<button class="btn btn-inverse" type="reset"><i class="icon-undo bigger-110"></i> 清空</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${request.contextPath}/pages/OcrFileManage/OcrFileList.js"></script>
	</body>
</html>