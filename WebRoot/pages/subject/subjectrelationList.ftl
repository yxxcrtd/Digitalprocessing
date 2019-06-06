<#include "Common.ftl" />
<#include "Context.ftl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/x html">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>图书分类信息映射列表</title>
	</head>
	
	<body>
		<div class="clearfix">
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="row-fluid">
					    <div class="ace-thumbnails">
							<span class="fr"></span>
							<button class="btn btn-small btn-primary" onclick="addObj();">
								<i class="icon-plus-sign bigger-125"></i>新建图书分类
							</button>
						</div>
						<div class="table-header on">
							<i class="icon-caret-down"></i>&nbsp;&nbsp;查询条件
						</div>
						<div class="on-down">
							<form id="form" commandName="form" class="form-horizontal">
								<div class="row-fluid">
									<div class="control-group span3">
										<label class="control-label" for="form-field-2">编码：</label>
										<div class="controls">
										 	<input id="query_code name="code" class="span10" onkeydown="if (13 == event.keyCode) { $('.btn-success').focus(); }"/>
										</div>
									</div>
									
										<div class="control-group span3">
											<label class="control-label" for="form-field-2">名称：</label>
											<div class="controls">
											 	<input id="query_name" name="name" class="span10" onkeydown="if (13 == event.keyCode) { $('.btn-success').focus(); }"/>
											</div>
										</div>
									
									<div class="control-group span3">
										<label class="control-label" for="form-field-2">分类：</label>
										<div class="controls">
										 	<select id="baseCode" name="baseCode" class="span6">
										        <option value="">--选择--</option>
										        <#if form.elseList??>
											        <#list form.elseList as c>
											        	<option value="${c.treeCode}">${c.name}</option>
											        </#list>
										        </#if>
										     </select>
										</div>
									</div>
									
								</div>
								<div style="text-align: center;">
									<button class="btn btn-small btn-success" type="button" onclick="query();">
										<i class="icon-zoom-in bigger-110"></i> 查询
									</button>
									&nbsp;&nbsp;
									<button type="reset" class="btn btn-small btn-inverse">
										<i class="icon-repeat bigger-110"></i>重置
									</button>
								</div>
							</form>
						</div>
						<div class="table-header">
							<i class="icon-flag"></i>&nbsp;&nbsp;图书分类信息列表
						</div>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
								</tr>
							</thead>
							<tbody align="center" style="line-height: 18px; border: 1px solid #97bbdc;"></tbody>
							<tfoot>
								<tr>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
									<th width="10%" align="center"></th>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${request.contextPath}/js/common.js"></script>
		<script type="text/javascript" src="${request.contextPath}/pages/subject/subjectrelationList.js"></script>
		<script type="text/javascript" src="${request.contextPath}/pages/subject/subjectrelationListinit.js"></script>
	</body>
</html>
