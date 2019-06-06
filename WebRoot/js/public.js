// Copyright 2014
// Author: YangXinXin


$(function() {
	
//	$('#container').isotope({
//		  itemSelector : '.item',
//		  layoutMode : 'fitRows'
//	});
    
	initMenu();
	
	// 加入购物车
	$(".buyit").on("click", function() {
		// var curid = $(this).siblings(".id").val();
		var This = $(this);
		var curid = This.attr("value");
		var total =  parseInt($("#shoppingcart").text());
		$.get("buy", { "resourceId" : curid }, function(data) {
			if ("true" == data) {
				This.siblings(".status").html("添加成功！").show().fadeOut(1500);
				$("#shoppingcart").html(total + 1);
			} else {
				This.siblings(".status").html("添加失败！").show().fadeOut(5000);
			}
		});
	});
	
	// 终端判断
	var isMobile = {
    	Windows: function() { return navigator.userAgent.match(/IEMobile/i) ? true : false; },
    	Android: function() { return navigator.userAgent.match(/Android/i) ? true : false; },
    	iOS: function() { return navigator.userAgent.match(/iPhone|iPad|iPod/i) ? true : false; }
    };
	if (isMobile.Android()) {
		//alert("是   Android 系统！");
	} else if (isMobile.iOS()) {
		//alert("是   iOS 系统！");
	} else if (!isMobile.Windows()) {
		//alert("普通浏览器！");
	} else {
		alert("未知的 手持系统！" + $(window).width() + " - " + $(window).height());
	}
	
});

// 菜单初始化
function initMenu() {
	$('#menu ul').hide();
//	$('#menu ul:first').show();
	var curNode = $('#menu li ul');
	$('#menu li a').click(function() {
		var curid = $(this).attr("value");
		curNode.html("");
		$.getJSON("getCategoryById", { "id" : curid }, function(data) {
			if ("" != data) {
				$("#targetTemplateId").append("<option value=''>' /></option>");
				$.each(data, function(i, field) {
					curNode.append("<li><a href='?c=" + field.id + "'>&nbsp;&nbsp;&nbsp;&nbsp;" + field.name + "</a></li>");
				});
			} else {
				curNode.append("<ul></ul>");
			}
		});
		
		var checkElement = $(this).next();
		if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
			$('#menu ul:visible').slideUp('normal');
			checkElement.slideDown('normal');
			return false;
		} else {
			$(checkElement).slideToggle('normal');
		}
	});
}
