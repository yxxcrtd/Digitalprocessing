
var setting = {
		async: {
			enable: true,
			url:$('#ctx').val() + "/pages/resource/form/getMenuZTree",
			autoParam:["id"],
			dataFilter: filter
		},
		edit: {
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},callback: {
			OnLeftClick: OnLeftClick,
			onClick:PUP.Base.News.createDataTable
		}
		
	};
$(document).ready(function(){
	setting.async.url=$('#ctx').val() + "/pages/resource/form/getMenuZTree?rootid=" + $('#rootid').val()+"&xmlId="+$('#xmlId').val();
	$.fn.zTree.init($("#treeDemo"), setting);
		PUP.Base.News.Show.zTree = $.fn.zTree.getZTreeObj("treeDemo");
		/*PUP.Base.News.Show.rMenu = $("#rMenu");*/
		PUP.Base.News.Show.shadow = $("#shadow");
		//zTree.expandNode(root, true, false, false);
	});