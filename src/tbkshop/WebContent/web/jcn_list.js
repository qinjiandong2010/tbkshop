function menuClassDl(){
	var oMenuClassDl = $(".menuClass dl");
	var oMenuClassDlH = Math.max(oMenuClassDl.height());
	$.each(oMenuClassDl,function() {
		$(this).height(oMenuClassDlH)
	})
}
function listSortTex(){
	var listSortTexTimer = null;
	$('.listSort_tex').focus(function(){
			clearInterval(listSortTexTimer)
			$(".listSort_bg").css("display","block");
	}).blur(function(){
			listSortTexTimer = setTimeout(function (){$(".listSort_bg").css("display","none")},200)
	});
	$('.listSort_btn').click(function(){
		$(this).parent().css("display","none");
	});	
}
$(function () {
	//menuClassDl();
	listSortTex();
	/*
	$(".menuClass dl dd a").each(function () {
        $(this).click(function () {
            $(this).siblings().removeClass("cur");
            $(this).addClass("cur");
        });
        $(this).find("i").click(function (event) {
            event.stopPropagation();
            $(this).parent().parent().removeClass("cur")
        });
    });*/
	$(".menuClass dl").hover(function(){
		$(this).addClass("hBg");
	},function(){
		$(this).removeClass("hBg");
	});
	
	/*$(".listSort_colour_bg a").click(function(){
		$(this).parent().siblings().children().removeClass("listSortCur");
		$(this).addClass("listSortCur");
	});*/
	/*$(".listSort_price li").click(function(){
		$(this).siblings().removeClass("listSort_priceCur");
		$(this).addClass("listSort_priceCur");
	});*/
})