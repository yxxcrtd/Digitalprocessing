<#include "Context.ftl" />
<#include "newformValidate.ftl" />
<#assign ingentatag=JspTaglibs["/WEB-INF/taglib/ingenta-taglib.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#FtpConfigForm").validationEngine();
			});
			
		</script>
	</head>
	
	<body>
		<div class="clearfix">
			<#include "AjaxMsg.ftl" />
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="page-header position-relative">
						<h1>FTP配置信息<small> <i class="icon-double-angle-right"></i>&nbsp;&nbsp;新建</small></h1>
					</div>
					<div class="row-fluid">
						<div class="table-header on">基本信息</div>
						<form id="FtpConfigForm" commandName="form" class="form-horizontal">
							<div class="on-down">
								<div class="control-group" id="identDiv">
									<label class="control-label"><span class="red">*&nbsp</span>标识：</label>
									<div class="controls">
										<input class="span6"  data-validation-engine="validate[required,custom[onlyLetterSp]]" id="ident" name="obj.ident"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="ftpNameDiv">
									<label class="control-label"><span class="red">*&nbsp</span>名称：</label>
									<div class="controls">
										<input class="span6"  data-validation-engine="validate[required]" id="ftpName" name="obj.ftpName"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="ipDiv">
									<label class="control-label"><span class="red">*&nbsp</span>IP：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required,custom[ipv4]]" id="ip" name="obj.ip" />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="portDiv">
									<label class="control-label"><span class="red">*&nbsp</span>端口号：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required],custom[onlyNumberSp],max[65535]" id="port" name="obj.port"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="contentDiv">
									<label class="control-label"><span class="red">*&nbsp</span>用户名：</label>
									<div class="controls">
										<input class="span6" data-validation-engine="validate[required]" id="username" name="obj.username"  />
										<span id="contentSpan" class="help-inline"></span>
									</div>
								</div>
								<div class="control-group" id="fontDiv">
									<label class="control-label"><span class="red">*&nbsp</span>密码：</label>
									<div class="controls">
										<input id="font" data-validation-engine="validate[required]" class="span6" name="obj.password" />
										<span id="fontSpan" class="help-inline"></span>
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
		<script type="text/javascript" src="${request.contextPath}/pages/ftpconfig/ftpconfigList.js"></script>
	</body>
</html>
