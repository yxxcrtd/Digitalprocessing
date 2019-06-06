function openWindow(url,width,height){
	var top=document.body.offsetHeigth/2;
    var left=document.body.offsetWIdth/2;
    
    if(url.indexOf("?")!=-1){
		url = url+ "&r_=" + new Date().getTime();
	}else {
		url = url+ "?r_" + new Date().getTime();
	}
	return window.showModalDialog(url,window,"dialogWidth="+width+"px;dialogHeight="+height+"px");
}
