<#include "Common.ftl" />
<#include "Context.ftl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>线程配置列表</title>
	</head>
	<body>
		<form id="ThreadConfigForm" commandName="form" class="form-horizontal" method="post">
			<table id="table_report" class="table table-striped table-bordered table-hover">
					<thead></thead>
					<tbody align="center" style="line-height: 20px; border: 1px solid #97bbdc;"></tbody>
					<tfoot>
						<tr>
							<th width="30%" align="center">自动下载线程设置：</th>
							<th width="15%" align="center">
								<select id="sourceDataLoad" name="sourceDataLoad" class="span6"value="{form.obj.threadConfigForm！}">
									<option value="0" <#if threadConfigForm.threadA == 0> selected="selected" </#if> >关闭</option>
									<option value="1" <#if threadConfigForm.threadA == 1> selected="selected" </#if> >开启</option>
							     </select>
							</th>
							<th width="30%" align="center">解析拆分线程设置：</th>
							<th width="15%" align="center">
								<select id="analysisDataLoad" name="analysisDataLoad" class="span6" value="{form.obj.threadConfigForm！}">
									<option value="0" <#if (threadConfigForm.threadB == 0)> selected="selected" </#if>>关闭</option>
							        <option value="1" <#if (threadConfigForm.threadB == 1)> selected="selected" </#if>>开启</option>
							     </select>
							</th>
						</tr>
					</tfoot>
				</table>
				<div class="form-actions" style="text-align: center; padding-left:0px;">
					<button class="btn btn-success" type="submit" id="save" ><i class="icon-save bigger-110"></i> 设置</button>&nbsp; &nbsp; &nbsp;
				</div>
			</form>
			<script type="text/javascript" src="${request.contextPath}/pages/threadconfig/threadConfigList.js"></script>
	</body>
</html>
