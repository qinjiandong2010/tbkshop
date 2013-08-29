//回到顶部
function newGoToTop() {
	$("html, body").animate({
		scrollTop: 0
	}, 120);
}


//判断浏览器宽度是否添加样式
function newmyWardrobe_add_remo(){
	var winw = $(window).width();					//window的初始化宽度
	if(winw <= 1024){
		$(".newmyWardrobe").addClass("newmyWardrobe1024");
		$(".newGoToTop").addClass("newGoToTop1024")
	}else{
		$(".newmyWardrobe").removeClass("newmyWardrobe1024");
		$(".newGoToTop").removeClass("newGoToTop1024");
	}
}
function floatGoToTop() {
	var ie6 = window.XMLHttpRequest;				//用来判断在非ie6
	var hnw=$(".nav3_wrap").hasClass("nav3_fix");	//判断样式是否存在
	function handle_id6(){
		
	}
	function handle(){
		var st = $(document).scrollTop();	//获取滚动条高度
		//判断浏览器宽度是否添加样式
		newmyWardrobe_add_remo()
		//判断返回顶部是否显示
		newGoToTop_s_h(st);
		//导航浮动
		nav_float_two(st);
		
	}
	//导航浮动
	function nav_float_two(_top){
		if($.browser.msie){

		}else{
			if(_top > 180){
				if(!hnw){
					$(".nav3_wrap").addClass("nav3_fix");
				}
				if(!ie6){
					$(".newmyWardrobe").css("top",54 + _top);
				}
				if(ie6){$(".newmyWardrobe").css("top",54)}
			}else{
				$(".nav3_wrap").removeClass("nav3_fix");
				if(!ie6){
					$(".newmyWardrobe").css("top",239)
				}
				if(ie6){$(".newmyWardrobe").css("top",239-_top)}
			}
		}
	}
	
	//判断返回顶部是否显示
	function newGoToTop_s_h(_top){
		if(_top > 150){
			$(".newGoToTop").show();
		}else{
			$(".newGoToTop").hide()
		};
	}
	$(window).bind("scroll", handle);
	$(window).bind("resize", newmyWardrobe_add_remo);
	$(window).bind("onresize", newmyWardrobe_add_remo);
	$(window).bind("load", handle);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
}



//鼠标hover效果


function mouseHover() {
	var pro = $(".pro_list .layout,.fosi24");
	pro.each(function() {
		var add = $(this).find(".pro_add");
		var tag = $(this).find(".f_proTag");
		var imgBor = $(this).find(".imgwrap");
		var wbGuideReg = $(this).find(".wb_guide_reg");
		$(this).hover(function() {
			tag.css("display", "block");
			add.css("top", "15px");
			imgBor.addClass("imgwrap_h");
			wbGuideReg.css("top", "14px");
			if ($(this).parent().parent().hasClass("test_list")) {
				add.css("top", "10px");
			}
		}, function() {
			tag.css("display", "none");
			add.css("top", "-999em");
			wbGuideReg.css("top", "-999em");
			imgBor.removeClass("imgwrap_h");
		})
	})
}

//评论选项卡


function commentTabs(a, b) {
    $(a).click(function () {
        i = $(a).index(this);
        $(this).addClass("cur").siblings().removeClass("cur");
        for (var j = 0; j < $(a).length; j++) {
            $(b).eq(j).addClass("hide");
        }
        $(b).eq(i).removeClass("hide");
    });
}
//加入衣橱（新）

function newPutWardrobe() {
    $(".addto_btn,.addto,.add_btn").click(function () {
		var aoffsetL = $(this).offset().left;
		var aoffsetT = $(this).offset().top;
		var ooffsetL = $(".newmyWardrobe").offset().left;
		var ooffsetT = $(".newmyWardrobe").offset().top-20;
		$(".newmyWardrobeIco").css({"left":aoffsetL,"top":aoffsetT}).show().stop(true).animate({top:[ooffsetT,'easeOutCubic'],left:ooffsetL,opacity:0}, 500,'linear',function(){
				$(this).css({"display":"none","opacity":1,"left":ooffsetL+4,"top":ooffsetT+20});
				$(".newmyWardrobe a").addClass("newmyWardrobeBg");
			});		
			setTimeout(function () {
			$(".newsAdd_animate").fadeIn("fast").stop(true).animate({
				top:"-75px",
				opacity:1
			}, 600, function () {
				setTimeout(function () {$(".newsAdd_animate").css({
						"opacity":10,
						"display":"none",
						"top":"-50px"
			 		});
					$(".newmyWardrobe a").stop(true).animate({'opacity':0.6},100).animate({'opacity':0.8},200).animate({'opacity':0.6},100).animate({'opacity':1},200).animate({'opacity':0.8},100).animate({'opacity':1},200,function(){
					$(this).removeClass("newmyWardrobeBg");
					});
			},800);
		 });			 
		 },700);
		//$(this).replaceWith("<em class='hasaddto_btn f14'>已收入衣橱</em>");
		//favHanlder($('#productid').val(), $('#productprice').val());
    })
}
//随机


function randomCloud() {
    $(".btmcloud a").each(function () {
        var rand = parseInt(Math.random() * 10);
        var fsize = parseInt(Math.random() * (30 - 14 + 1) + 14);
        var marignl = parseInt(Math.random() * (40 - 20 + 1) + 20);
        var top = parseInt(Math.random() * (80 - 10 + 1) + 10);
        $(this).css({
            "font-size":fsize,
            "margin-left":marignl
        });
        $(this).addClass("tags" + rand);

    });
}

function randomNum() {

    var x = 0; /*上限 */
    var y = 18; /*下限*/
    var rand = parseInt(Math.random() * (y - x + 1) + x);
    return rand;
}
//家当扔出衣橱


function delWardrobe() {
    var allItem = $(".jd_con").find(".layout");
    allItem.each(function () {
        var del = $(this).find(".del");
        // 删除效果
        del.click(function () {
            var anchor = $(this);
            var para = anchor.attr("ref");
            delItem(para, anchor);
        });
    });
}
function delWardrobeByID(idx) {
	var allItem = $("#layout_"+idx);
	allItem.each(function () {
        var del = $(this).find(".del");
        var anchor = $(del);
        var para = anchor.attr("ref");
        delItem(para, anchor);
    });
}

function delALlWardrobe() {
	$(".ward_wrap input:checkbox").each(function(i){
		if($(this).attr("checked")){
			delWardrobeByID(i);
		}
	});
}
$(".all_del").click(function () {
	delALlWardrobe();
});
// 我的家当左侧导航


function jdSideNav() {
    var items = $(".jd_left").find("a");
    items.each(function () {
        $(this).click(function () {
            items.removeClass("on");
            $(this).addClass("on");
        })
    })
}
function closeBox(id) {
    if ($("#" + id)) {
        $("#" + id).fadeOut("slow").removeClass("fast");
    }
}


/********************新增*************************/

//设置cookies
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(-1);
    document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString() + ';path=/';

}

function setCookie2(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString() + ";path=/");
}


//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) return unescape(arr[2]);
    else return null;

}


//删除cookies
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString()+ ";path=/";

}

/*遮罩层*/
function mask(){
	var mw = $(window).width();
	var mh = $(document).height();
	$("#mask").css({"width":mw,"height":mh,"display":"block"});

}

/*换肤功能*/
function changeSkin() {
    var linkcss = $("#change_skin");
    var all = $(".skin_list a");
    /*加载皮肤*/
    if (!getCookie("jcnSkin")) {
        linkcss.attr("href", " ");
        $("#skin_default").addClass("cur");
    } else {
        linkcss.attr("href", "/css/" + getCookie("jcnSkin") + ".css");
        $("#" + getCookie("jcnSkin")).addClass("cur");
        if (getCookie("jcnSkin") == "skin_default") {
            linkcss.attr("href", " ");
        }

    }
    /*选择皮肤*/
    all.each(function () {
        $(this).click(function () {
            $(".skin_list a").removeClass("cur");
            $(this).addClass("cur");
        })
    });
    /*确认皮肤*/
    $("#setSkin").click(function () {
        all.each(function () {
            if ($(this).hasClass("cur")) {
                setCookie("jcnSkin", $(this).attr("id"));
            }
        })
        if (getCookie("jcnSkin") == "skin_default") {
            linkcss.attr("href", " ");
        } else {
            linkcss.attr("href", "/css/" + getCookie("jcnSkin") + ".css");
        }
        /*关闭弹出层*/
        closeBox('changeSkinBox');
        $('#mask').hide();
    });


}

function skin() {
    var all = $(".skin_list a");
    all.each(function () {
        $(this).click(function () {
            $(".skin_list a").removeClass("cur");
            $(this).addClass("cur");
        })
    });
    /*确认皮肤*/
    $("#setSkin").click(function () {
        all.each(function () {
            var skinId = $(this).attr("id");
            if ($(this).hasClass("cur")) {
                $.post("/user/changeskin/" + skinId, {}, function () {
                    var linkcss = $("#change_skin");
                    linkcss.attr("href", "/css/" + skinId + ".css");
                });
//				setCookie("jcnSkin", $(this).attr("id"));
            }
        });
        /*关闭弹出层*/
        closeBox('changeSkinBox');
        $('#mask').hide();
    });
}


//提示登录120801
function promptLog() {
	if ($.browser.msie && $.browser.version < 7) {
		var handle = function(){
			var prompt_top = $(window).height() - 143;
			var topPas = $(document).scrollTop() + prompt_top;
			$(".prompt_log,.rec").css("top", topPas)
		};
		
		$(window).bind("scroll", handle);
		$(window).bind("resize", handle);
		$(window).bind("onresize", handle);
	}
	$(".prompt_close").click(function () {
     	$(".prompt_log,.rec").css({left:-9999});
    });
};

//导3航hover
function nav3(){
	var nav3_change = $(".nav3_change");
	var nav3Menu = $(".nav3Menu");
	var nav3Timer = null;
	nav3_change.hover(function(){
		$(this).addClass("nav3_change_hover");
		nav3Menu.css("top",44);	
	},function(){
		nav3Timer = setTimeout(function (){
			nav3_change.removeClass("nav3_change_hover");
			nav3Menu.css("top","-999em");},600)
	});
	nav3Menu.hover(function(){
		clearInterval(nav3Timer)
	},function(){
		nav3_change.removeClass("nav3_change_hover");
		nav3Menu.css("top","-999em")
	});
	// 新增关闭功能20130712
	$(".btn_close").click(function(){
		$(".nav3Menu").css({
			top:-999
		});
	});
}
/*****************************************/
$(function () {
	skin();
    mouseHover();
    if(window.XMLHttpRequest){
    	floatGoToTop();
    }
	//else{
//    	$(window).bind("resize", newmyWardrobe_add_remo);
//    }
    newPutWardrobe();
    randomCloud();
    promptLog();
	nav3();
    //顶部分类选择
    $(".topCate a").each(function () {
        $(this).click(function () {
            $(this).siblings().removeClass("cur");
            $(this).addClass("cur");
        });
        $(this).find("i").click(function (event) {
            event.stopPropagation();
            $(this).parent().parent().removeClass("cur")
        });
    });
	
    $(".add_btn").click(function () {
        $(this).parent().html("已收入衣橱");
    });
	
    commentTabs(".itemlist li", ".comment_con");
    delWardrobe();
    jdSideNav();
    //弹出换肤层
    $(".skin").click(function () {
        mask();
//		$(".skin_list a").removeClass("cur");
//		if (!getCookie("jcnSkin")) {
//			$("#skin_default").addClass("cur");
//		} else {
//			$("#" + getCookie("jcnSkin")).addClass("cur");
//		} 
        $("#changeSkinBox").show();
    });

    if (getCookie("msg") == "yes") {
        $(".renewal").css("top", -9999);
    } else {
        $(".renewal").css("top", -22).animate({
            'opacity':1
        }, 1000);
    }
    $(".renewal_c").click(function () {
        $(".renewal").css("top", -9999);
        setCookie("msg", "yes");
    });
    $(".count_r_bor b,.count_r_bor em").hover(function () {
        $(".renewal").css("top", -22).animate({
            'opacity':1
        }, 1000);
    });

	//搜索
	$('.sea_in').focus(function(){
			if($(this).val() == '搜宝贝'){
			$(this).val('').css("color","#666");
		}
		}).blur(function(){
			if($(this).val() == '')
			$(this).val('搜宝贝').css("color","#d7d7d7");
	});

//橱窗-推荐选款师
	
	var page = 1;
    var i = 4; //每版放4个图片
	var recGuideL = $(".rec_guide_con_list ul li").length;
	if( recGuideL <= 4){
		$(".rec_guide_r").hide();
		};	
    //向后 按钮
    $(".rec_guide_r").click(function(){
	     var $parent = $(this).parents(".rec_guide_con");
		 var $v_show = $parent.find(".rec_guide_con_list"); 
		 var $v_content = $parent.find(".rec_guide_show");
		 var v_width = $v_content.width();
		 var len = $v_show.find("li").length;
		 var page_count = Math.ceil(len / i); 	 
		 if( !$v_show.is(":animated") ){
			  if(page == page_count - 1){ 
				$(this).animate({opacity:0},200).hide();
				}
			 $v_show.animate({ left : '-='+v_width }, "slow");
				page++;
			$(".rec_guide_l").animate({opacity:1},200).show();
		 }		 
   });
    //往前 按钮
    $(".rec_guide_l").click(function(){
	     var $parent = $(this).parents(".rec_guide_con");
		 var $v_show = $parent.find(".rec_guide_con_list");
		 var $v_content = $parent.find(".rec_guide_show");
		 var v_width = $v_content.width() ;
		 var len = $v_show.find("li").length;
		 var page_count = Math.ceil(len / i) ;   
		 if( !$v_show.is(":animated") ){
		 	 if(page == 2 ){ 
			 	$(this).animate({opacity:0},200).hide();
			}
				$v_show.animate({ left : '+='+v_width }, "slow");
				page--;
			$(".rec_guide_r").animate({opacity:1},200).show();
		}
    });
	
	 //2选1左侧
    if (getCookie("cookie_l") == "yes") {
            $(".tcookie").addClass("test_l_h");
        }
    $(".tcookie").hover(function() {
            $(this).addClass("test_l_h");
            setCookie2("cookie_l","yes",10);
            $(".test_r").removeClass("test_l_h");
            delCookie("cookie_r");
        }, function() {
            $(this).removeClass("test_l_h");
            delCookie("cookie_l");
     });
	 //右侧
	 if (getCookie("cookie_r") == "yes") {
            $(".test_r").addClass("test_l_h");
        }
    $(".test_r").hover(function() {
            $(this).addClass("test_l_h");
            setCookie2("cookie_r","yes",10);
            $(".tcookie").removeClass("test_l_h");
            delCookie("cookie_l");
        }, function() {
            $(this).removeClass("test_l_h");
            delCookie("cookie_r");
     });
	 
	 //删除选款师
	$(".dislike").click(function() {
		mask();
		$(".top_guides_pop").addClass("top_guides_hover");
	});
	 $(".top_guides_pop_close,.cancel").click(function(){
		 $(".top_guides_pop").removeClass("top_guides_hover");
		 $("#mask").hide();
	});
	
	//陆页登录窗口
	$(".guide_btn_show_d,.qqtest").click(function() {
		if((!$.isEmptyObject($(this).attr("id")) || (""+$(this).attr("id")).length>0) && $(this).attr("id")>0){
			$("#xks_id_val").val($(this).attr("id"));
		}
		mask();
		$(".landing").css("top","50%");
		jQuery.get('http://www.j.cn/logger/chooseXKS', function(data) {
	        //alert(data);
	    });

		delCookie('tempxks');
		if($(this).attr("class").indexOf("qqtest")>-1){
			$(".indexLogin_flag1").hide();
			$(".indexLogin_flag2").show();
		}else{
			$(".indexLogin_flag2").hide();
			$(".indexLogin_flag1").show();
		}
	});
	
	//2选1关注
	 $(".popupWrap .land_close").click(function(){
		 $(".popupWrap,.guide_qz_pop").css("top","-999em");
		 $("#mask").hide();
		 
		}
	 );

	//着陆页登录窗口关闭
	 $(".landing .land_close").click(function(){
		 $(".landing").css("top","-999em");
		 $("#mask").hide();
		 location.href = "/";
		 //window.location.reload();
		}
	 );
	 //选款师名称
	 $(".top_guides_list a").hover(function(){
		 $(this).addClass("curtit");
		}, function() {
			$(this).removeClass("curtit");
	});

    $(".guide_ani").click(function(){
        $("html, body").animate({
            scrollTop: 0
        }, 120);
        $(".fun_guide,.top_guides_list li a.cur").stop(true).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100);

    });
	 //选中选款师刷新
		 function funGuide(){
		 $(".fun_guide").stop(true).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100).animate({'opacity':0.4},100).animate({'opacity':1},100);}
	funGuide();

	 
     
	
});


//切换选款师	chengzhu.liang@langtaojin.com
function switchXks(obj) {
	 jQuery.post("/xks/switchxks", {'xksid':obj.id}, function (data) {
	        if (data != "") {
	            if (data == "1") {    
	            	url =  location.href;
	            	if(location.href.indexOf("?") <0){
	            		url += "?sx=1";
	            	}else{
	            		if(url.indexOf("sx=1")<0){
	            			url += "&sx=1";
	            		}
	            	}   
	            	
            		if(url.indexOf("&xks=")!=-1){
            			location.href = url.replace(/&xks=[0-9]*/, "&xks="+obj.id);
            		}else{
    	                location.href = url+"&xks="+obj.id;
            		}
	                return true;
	            }
	            if (data == "0") {
	            	setCookie2("tempxks",obj.id,10);
	                location.href = "/login";
	                return false;
	            }
	        } else {
	            return false;
	        }
	    });

}

//选款师页面tab菜单
jQuery(function (jq) {
    function changeTab(lis, divs) {
        lis.each(function (i) {
            var els = jq(this);
            els.click(function () {
                lis.removeClass();
                divs.hide();
                jq(this).addClass("cur");
                divs.eq(i).show();
            });
        });
    }
    var Tab = jq(".guide_other");
    changeTab(Tab.find(".guide_other_nav ul li"), Tab.find(".conNone"));  //需要更多tab菜单效果请复制多个

});

//删除多个选款师
function delmultixks(){
     xksids="";
     $("input[type=checkbox]").each(function(){ 
         if($(this).attr('checked')){
        	 xksids=xksids+$(this).val()+',';
        	}
          });
     if(xksids==""){
    	 return false;
     }else{
    	 //删除cookie
    	 delCookie("tempxks");
    	 xksids = xksids.substring(0,xksids.lastIndexOf(','));
    	 location.href = "/multixks/delxks?xksid="+xksids;
     }
}


//var fguanzhu1_flag=0;
var fguanzhu1_flag = ",";
var xks_id_val=0;
var guanzhu_from="";
var guanzhu_need_reload="";
function iframe_guanzhu_1_onload(){
	iframe_guanzhu_1_onload(0);
}
function iframe_guanzhu_1_onload(xksid){
	//if(fguanzhu1_flag==1){
	if(fguanzhu1_flag.indexOf(","+xksid+",")!=-1){
		 $(".popupWrap").css("top","-999em");
		 $(".landing").css("top","-999em");
		 $("#mask").hide();
		    var url = "/share/guanzhuXKS?from="+guanzhu_from+"&xks_id="+xks_id_val;
		    $.getJSON(url,function(data){
		    	});
		    
		 if(guanzhu_need_reload == '1'){
			 var showDialogTimeM=$("#showDialogTimeM").val();
			 if(showDialogTimeM == 10){
			 }else{
				  location.href = "/";
			 }
			 $(".popupWrap").css("top","-999em");
			 $(".landing").css("top","-999em");
			 $("#mask").hide();
		 }
   }else{
	   fguanzhu1_flag=fguanzhu1_flag+xksid+",";
       xks_id_val=$('#xks_id_val').val();
       guanzhu_from=$('#guanzhu_from').val();
       guanzhu_need_reload=$('#guanzhu_need_reload').val();
   }
}
$('#iframe_guanzhu_1').load(function(){
	iframe_guanzhu_1_onload();
});

function showGuanzhuDialogInfo(){
	$("#xks_top_login_title,#xks_top_login_button,#xks_top_login_close").hide(100);
	$(".landing").attr("class","guide_qz_pop");
	$("#xks_top_guanzhu_title_1,#xks_top_guanzhu_title_2,#xks_top_guanzhu_title_3,#xks_top_guanzhu_button").show(100);
	mask();
	$(".popupWrap,.guide_qz_pop").css("display","block");
	$("#xks_top_guanzhu_close").delay(3000).show(10);
	$("#guanzhu_refuse_close").delay(3000).show(10);
}
//登录弹框隐藏登录button，显示关注
function showGuanzhu(xks,xks_name,xks_qq,is_fans){
    //删除cookie
    delCookie("tempxks");
    setCount();
	if(is_fans == "1"){//已关注
		$(".popupWrap").css("top","-999em");
		$(".landing").css("top","-999em");
		$("#mask").hide();
		location.href = "/yichu?xks="+xks;
	}else{
	    if(!jQuery.isEmptyObject(xks_name) || xks_name.length>0){
	    	$("#xks_top_guanzhu_title > span").html(xks_name);
	    }
	    if(!jQuery.isEmptyObject(xks_qq) || xks_qq>0){
	    	$("#iframe_guanzhu_1").hide();
	    	$("#iframe_guanzhu_1").attr("id","");
	    	$(".iframe_guanzhu_"+xks).show();
	    	$(".iframe_guanzhu_"+xks).attr("id","iframe_guanzhu_1");
	    	showGuanzhuDialogInfo();
	    	jQuery.get('/xks/guanzhu/showDialogLog?sid='+xks, function(data) {
			});
	    }else{//没有QQ不关注
	    	$(".popupWrap").css("top","-999em");
	    	$(".landing").css("top","-999em");
			$("#mask").hide();
			location.href = "/yichu?xks="+xks;
	    }
	}
}

//顶部多个选款师
$(".top_guides").hScrollPane({
	mover:".top_guides_list",
	moverW:function(){return $(".top_guides_list li").length*66;}(),
	easing:false,
	handleCssAlter:"draghandlealter",
	mousewheel:{moveLength:66}
});

$(".top_guides_list li a").click(function(){
    $(".top_guides_list li a").removeClass("cur");
    $(this).addClass("cur");
});

//弹出多选款师
$(".top_guides_pop_scroll").jscroll({W:"19px",Btn:{btn:false},BgUrl:"url(http://image.guang.j.cn/images/imgs/nav_guides_scroll_bg.png)",Bg:"right 0 repeat-y",Bar:{btn:true,Bd:{Out:"none",Hover:"none"},Bg:{Out:"left 0 repeat-y",Hover:"left 0 repeat-y",Focus:"left 0 repeat-y"}}
});
//关闭("残忍拒绝")
$("#guanzhu_refuse_close_pick").bind("click",function() {
	guanzhu_refuse_close();
});
$("#guanzhu_refuse_close").bind("click",function() {
	guanzhu_refuse_close();
	var showDialogTimeM=$("#showDialogTimeM").val();
    if(showDialogTimeM == 10){
    }else{
	  location.href = "/";
    }
});
function guanzhu_refuse_close(){
	$(".landing").css("top","-999em");
    $(".guide_qz_pop").css("top","-999em");
    $("#mask").hide();
}

//不再提示
$("#xks_top_guanzhu_close_pick").bind("click",function() {
	xks_top_guanzhu_close();
});
$("#xks_top_guanzhu_close").bind("click",function() {
  xks_top_guanzhu_close();
  var showDialogTimeM=$("#showDialogTimeM").val();
  if(showDialogTimeM == 10){
  }else{
	  location.href = "/";
  }
});
function xks_top_guanzhu_close(){
	$(".landing").css("top","-999em");
	$(".guide_qz_pop").css("top","-999em");
	$("#mask").hide();
	jQuery.get('/xks/guanzhu/stopShowDialog', function(data) {
	});
}

var needShowDialogXKS=$("#needShowDialogXKS").val();
if(!jQuery.isEmptyObject(needShowDialogXKS) || needShowDialogXKS>0){
	jQuery.get('/platform/qq/opensns/check_page_fans?sid='+needShowDialogXKS, function(data) {
		if(data.is_fans == 0){
			var waitTime=1000;
			var showDialogTimeM=$("#showDialogTimeM").val();
			if(showDialogTimeM>0){//默认的切换xks不再弹框
				waitTime=showDialogTimeM*1000;
			}
			var interval = setInterval(function(){
				showGuanzhuDialogInfo();
				clearTimeout(interval);
				jQuery.get('/xks/guanzhu/showDialogLog?sid='+needShowDialogXKS, function(data) {
				});
			}, ""+waitTime);
		}
    });
	setCount();
}

//显示随机计数相关
function setCount() {
	$(".guideQz_people").html(rnd(50000,70000));
	peo();
}
function rnd(b,e) {
	return parseInt(Math.random()*(b-e+1) + e);
}
function peo(){
    var g_people = $(".guideQz_people");
    var g_peoples = parseInt(g_people.html());
    setInterval(function () {
        g_peoples+=parseInt(Math.random()+1.5);
        g_people.html(g_peoples);
    },2000);
}
function clickLog(url) {
	jQuery.get('/clickLog?detailurl='+url, function(data) {
    });
}
