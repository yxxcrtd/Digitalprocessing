    <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <%@ taglib prefix="ckeditor" uri="http://ckeditor.com" %>  
    <%@ include file="/common/taglibs.jsp"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>文件管理</title>  
    <link type="text/css" rel="stylesheet" href="${ctx}/js/ckfinder/skins/kama/app.css" />  
    <script type="text/javascript" src="${ctx}/js/ckfinder/ckfinder.js"></script>  
    </head>  
    <body>  
    <p style="padding-left: 1px; padding-right: 30px;" style="padding-left: 30px; padding-right: 30px;">  
            <script type="text/javascript"><!--  
                function showFileInfo( fileUrl, data )  
                {  
                    var msg = '选定的网址是: <a href="' + fileUrl + '" mce_href="' + fileUrl + '">' + fileUrl + '</a><br /><br />';  
                    if ( fileUrl != data['fileUrl'] )  
                        msg += '<b>File url:</b> ' + data['fileUrl'] + '<br />';  
                    msg += '<b>File size:</b> ' + data['fileSize'] + 'KB<br />';  
                    msg += '<b>Last modifed:</b> ' + data['fileDate'];  
      
                    this.openMsgDialog( "Selected file", msg );  
                }  
      
                var finder = new CKFinder();  
                finder.basePath = 'js/ckfinder/';  
                finder.selectActionFunction = showFileInfo;  
                finder.create();  
              
    // --></script>  
        </p>  
    </body>  
    <script type="text/javascript" src="${request.contextPath}/js/common.js"></script>
    </html>  