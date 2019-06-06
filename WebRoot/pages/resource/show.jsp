<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/pages/common/common.jsp" %>
<%@ include file="/pages/common/alert.jsp" %>
<%@ include file="/pages/common/context.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>资讯信息</title>

    <link rel="stylesheet"
          href="${ctx }/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
    <script type="text/javascript"
            src="${ctx }/ztree/js/jquery.ztree.core-3.4.js"></script>
    <script src="${ctx}/js/common.js"></script>
    <script src="${ctx}/pages/resource/show.js"></script>
    <script src="${ctx}/pages/resource/showinit.js"></script>
    <style type="text/css">
        div#rMenu {
            visibility: hidden;
            position: absolute;
            top: 0;
            text-align: left;
            padding: 2px;
            backgroundColor: #FFFFFF;
        }

        div#rMenu ul {
            listStyle: none;
            margin: 0px;
            background-color: #FFFFFF;
            border: 1px solid #999;
            width: 140px;
            padding: 1px;
        }

        div#rMenu ul li {
            margin: 0px;
            color: #000;
            display: block;
            cursor: default;
            padding: 1px;
            border: 1px solid #fff;
            background-color: transparent;
            font: normal 12px arial, tahoma, helvetica, sans-serif;
        }

        div#rMenu ul li img {
            vertical-align: middle;
        }

        div#shadow {
            background-color: #b6bdd2;
            position: absolute;
            opacity: 0.2;
            zIndex: 499;
        }
    </style>

</head>

<body>
<input type="hidden" id="xmlId" value="${xmlId}"/>

<div id="sidebar">
    <div id="sidebar-collapse" onclick="PUP.Base.News.hideTree();">
        <i class="icon-double-angle-left"></i>
    </div>
    <div id="sidebar-shortcuts">
        <div class="zTreeDemoBackground left">
            <ul id="treeDemo" class="ztree"></ul>
        </div>
    </div>
</div>

<div id="main-content" class="clearfix" style="margin-left: 250px;">
    <div id="classifyContent">
        <div class="clearfix">
            <div id="page-content" class="clearfix">
                <div class="row-fluid">
                        <form:form id="form" commandName="form" action=""
                                   class="form-horizontal">
                            <div class="row-fluid">
                            </div>
                            <input type="hidden" name="xmlId" id="xmlId" value="${xmlId}"/>
                            <input type="hidden"  name="nodeCode" id="nodeCode"/>
                        </form:form>
                        <!-- ------------------查询结束----------------------------- -->
                        <!-- ------------------功能页面部分结束----------------------------- -->
                        <!-- ------------------列表页面部分开始----------------------------- -->

                        <div class="table-header">
                            <i class="icon-flag"></i>&nbsp;&nbsp;节点列表
                        </div>
                        <table id="table_classify"
                               class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th width='10%' align='center'></th>
                                <th width='20%' align='center'></th>
                                <th width='15%' align='center'></th>
                                <th width='15%' align='center'></th>
                                <th width='15%' align='center'></th>
                            </tr>
                            </thead>
                            <tbody align='center'
                                   style="line-height: 18px; border: 1px solid #97bbdc;">

                            </tbody>
                            <tfoot>
                            <tr>
                                <th width='10%' align='center'></th>
                                <th width='20%' align='center'></th>
                                <th width='15%' align='center'></th>
                                <th width='15%' align='center'></th>
                                <th width='15%' align='center'></th>
                            </tr>
                            </tfoot>
                        </table>
                        <!-- ------------------列表页面部分结束----------------------------- -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>