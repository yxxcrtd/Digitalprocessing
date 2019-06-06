<#include "Context.ftl" />
<#assign ingentatag=JspTaglibs["/WEB-INF/taglib/ingenta-taglib.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script src="${request.contextPath}/js/jquery.namespace.js"></script>
	</head>
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>节点信息<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;修改</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="form" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="identDiv">
									<label class="control-label">节点路径：</label>
									<div class="controls">
										${form.obj.nodePath!}
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="ftpNameDiv">
									<label class="control-label">节点值：</label>
									<div class="controls">
										<textarea id="nodeValue" name="nodeValue" rows="" cols="">${form.obj.nodeValue!}</textarea>
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<input type="hidden" name="id" value="${form.id!}" />
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
		<script type="text/javascript" src="${request.contextPath}/pages/resource/show.js"></script>
	</body>
</html>