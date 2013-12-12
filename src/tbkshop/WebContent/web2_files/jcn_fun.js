//********常量区**begin********
var GUANZHU_QZONE_IFRAME_MODEL = "<iframe class=\"iframe_guanzhu_#XKS# #CLASS#\" onload=\"javascript:#ONLOADFUN#;\" data-from=\"#DATAFROM#\" src=\"http://open.qzone.qq.com/like?url=http%3A%2F%2Fuser.qzone.qq.com%2F#QQNUMBER#&amp;type=button&amp;width=400&amp;height=30&amp;style=3\" allowtransparency=\"true\" scrolling=\"no\" border=\"0\" frameborder=\"0\" width=\"#WIDTH#\" height=\"21\"></iframe>";
var HTML_LOGIN_DIALOG_SWITCHXKS = "登录后才能获得个性化着装推荐<div class='text_'><span class='cont_'><i></i>已有 <strong class='peo_num_1'>1196033</strong> 人选她为选款师<i></i></span></div>";
var HTML_LOGIN_DIALOG_YICHU = "登录后开启你的衣橱<div class='text_'><span class='cont_'><i></i>已有 <strong class='peo_num_1'>1196033</strong> 人开启了衣橱<i></i></span></div>";
//********常量区**end********

//获取当前url并返回对应参数值
function getUrlParam(name){
 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
 var r = window.location.search.substr(1).match(reg);  //匹配目标参数
 if (r!=null) return unescape(r[2]); return null; //返回参数值
}

//全页遮罩
function mask(){
	var mw = $(window).width();
	var mh = $(document).height();
	$("#mask").css({"width":mw,"height":mh,"display":"block"});
}

//设置cookies
function setCookie(c_name, value, expiredays) {
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

//-------------------选款师弹窗 --begin--
//选她作我的选款师，登录页窗口
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
//选她作我的选款师-已登录
$(".guide_btn_show_d2").click(function() {
	delCookie('tempxks');
	var thisObj=this;
	jQuery.get('/logger/chooseXKS', function(data) {
		location.href = "/jingpin?xks="+$(thisObj).attr("id");
    });
});

//只关注 不弹窗
var fguanzhu_only_flag = ",";
var guanzhu_only_from="";
function iframe_guanzhu_only_onload(xksid){
	iframe_guanzhu_only_onload_d(xksid,'')
}
function iframe_guanzhu_only_onload_d(xksid,flag){
   var xks_flag=xksid+"_"+flag;
   if(fguanzhu_only_flag.indexOf(","+xks_flag+",")!=-1){
		var url = "/logger/fans1_qqfanscount?from="+guanzhu_only_from+"&xks_id="+xksid;
		$.getJSON(url,function(data){});
		$(".iframe_guanzhu_"+xksid).parent().remove();
   }else{
		fguanzhu_only_flag=fguanzhu1_flag+xks_flag+",";
		guanzhu_only_from=$(".iframe_guanzhu_"+xksid).attr("data-from");
   }
}
//加关注按钮
function addQZoneGuanZhuBTN(){
	$(".js-guanzhu-qz-p").each(function( index ) {
		var thisObj=this;
		var dataCheckFans=$(thisObj).attr("data-check-fans");
		if("1" == dataCheckFans){
			$.get('/platform/qq/opensns/check_page_fans?sid='+$(thisObj).attr("data-xksid"),function(data){
				if(data.is_fans != 1){
					addQZoneGuanZhuBTNDetail(thisObj);
				}
			});
		}else{
			addQZoneGuanZhuBTNDetail(thisObj);
		}
	});
}
function addQZoneGuanZhuBTNDetail(thisObj){
	var ifr_cnt=GUANZHU_QZONE_IFRAME_MODEL;
	ifr_cnt=ifr_cnt.replace("#XKS#",$(thisObj).attr("data-xksid"));
	ifr_cnt=ifr_cnt.replace("#ONLOADFUN#",$(thisObj).attr("data-onloadfun"));
	ifr_cnt=ifr_cnt.replace("#DATAFROM#",$(thisObj).attr("data-from"));
	ifr_cnt=ifr_cnt.replace("#QQNUMBER#",$(thisObj).attr("data-qqid"));
	ifr_cnt=ifr_cnt.replace("#CLASS#",$(thisObj).attr("data-class"));
	var iwidth=75;
	if($(thisObj).attr("data-width") > 0){
		iwidth=$(thisObj).attr("data-width");
	}
	ifr_cnt=ifr_cnt.replace("#WIDTH#",iwidth);
	var dataHtmlLocation=$(thisObj).attr("data-html-l");
	if("prepend" == dataHtmlLocation){
		$(thisObj).prepend(ifr_cnt);
	}else{
		$(thisObj).append(ifr_cnt);
	}
}

//关注and弹窗
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
				 if(window.location.href.indexOf("/recommend/pick2_result") == -1){
					 window.location.reload();
				 }
			 }
			 $(".popupWrap").css("top","-999em");
			 $(".landing").css("top","-999em");
			 guanzhu_refuse_close();
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

function getReloadXKSUrl(xks){
	reloadUrl=location.href;
    if(reloadUrl.indexOf("xks=")==-1){
    	if(reloadUrl.indexOf("?")==-1){
    		reloadUrl=reloadUrl+"?xks="+xks;
    	}else{
    		reloadUrl=reloadUrl+"&xks="+xks;
    	}
    }
    return reloadUrl;
}
//登录弹框隐藏登录button，显示关注
function showGuanzhu(xks,xks_name,xks_qq,is_fans){
    //删除cookie
    delCookie("tempxks");
    setCount();
    reloadUrl=getReloadXKSUrl(xks);
	if(is_fans == "1"){//已关注
		$(".popupWrap").css("top","-999em");
		$(".landing").css("top","-999em");
		$("#mask").hide();
		location.href = reloadUrl;
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
			location.href = reloadUrl;
	    }
	}
}
//着陆页登录窗口关闭
$(".landing .land_close").click(function(){
	 $(".landing").css("top","-999em");
	 $("#mask").hide();
	}
);
//关闭("残忍拒绝")
$("#guanzhu_refuse_close_pick").bind("click",function() {
	guanzhu_refuse_close();
});
$("#guanzhu_refuse_close").bind("click",function() {
	guanzhu_refuse_close();
	var showDialogTimeM=$("#showDialogTimeM").val();
    if(showDialogTimeM == 10){
    }else{
  	  xks=$("#xks_id_val").val();
      reloadUrl=getReloadXKSUrl(xks);
	  location.href = reloadUrl;
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
	  if(window.location.href.indexOf("/recommend/pick2_result") == -1){
		  xks=$("#xks_id_val").val();
		  reloadUrl=getReloadXKSUrl(xks);
		  location.href = reloadUrl;
	  }
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
	peoDo("guideQz_people");
}
function peoDo(clzName){
    var g_people = $("."+clzName);
    var g_peoples = parseInt(g_people.html());
    setInterval(function () {
        g_peoples+=parseInt(Math.random()+1.5);
        g_people.html(g_peoples);
    },2000);
}
//-------------------选款师弹窗 --end--

//-------------------日志记录 --begin--
function clickLog(url) {
	jQuery.get('/clickLog?detailurl='+url, function(data) {
    });
}
//-------------------日志记录 --end--

//-------------------顶部xks --begin--
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
//删除选款师
$(".dislike").click(function() {
	mask();
	$(".top_guides_pop").addClass("top_guides_hover");
});
 $(".top_guides_pop_close,.cancel").click(function(){
	 $(".top_guides_pop").removeClass("top_guides_hover");
	 $("#mask").hide();
});
//弹出多选款师
 $(".top_guides_pop_scroll").jscroll({W:"19px",Btn:{btn:false},BgUrl:"url(http://image.guang.j.cn/images/imgs/nav_guides_scroll_bg.png)",Bg:"right 0 repeat-y",Bar:{btn:true,Bd:{Out:"none",Hover:"none"},Bg:{Out:"left 0 repeat-y",Hover:"left 0 repeat-y",Focus:"left 0 repeat-y"}}
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
//-------------------顶部xks --end--
//-------------------我的衣橱搬家提示 --begin--
 function guideYiChu1309(){
	 var today=new Date();
	 if(today.getTime() < 1378915200000){//仅在2013-09-12 00:00:00之前提示
		 if(document.getElementById("js-base-addAnimate-myyichu")){
			 var guideYiChu="guide_yichu";
			 var cval = getCookie(guideYiChu);
			 if (cval != "1") {
				 setCookie(guideYiChu, "1", 60);//避免因调整提示时间导致提示两次，这里将时间设置得长一点
				 //添加遮罩背景
				 J.tip.ward_show();
			 }
		 }
	 }
 } 
//-------------------我的衣橱搬家提示 --end--

//登录弹框
function dialogLogin(clzName,model){
	$.get('/logger/fans2_login_popups?location=switchXks');
	$("#js-base-nav_login-1").removeClass("float-nva_login-1");
	$("#js-base-nav_login-1").removeClass("float-nva_login-2");
	$("#js-base-nav_login-1").addClass(clzName);
	$("#js-base-nav_login-1 > .title_").html(model);
	peoDo("peo_num_1");
	J.nav_login($("#js-base-nav_login-1"));
}
//选择选款师
function switchXks(obj){
	var xksId=$(obj).attr("id");
	var cur_url_encode=document.getElementById("js-cur-url-encode");
    if(cur_url_encode){
    	cur_url_encode=document.getElementById("js-cur-url-encode").value;
    	if($(obj).attr("data-items") != "true"){//不含商品列表的，跳转到精品页
    		cur_url_encode="%2Fjingpin";
    	}
    	if(cur_url_encode.indexOf("%3F") <0){
    		cur_url_encode += "%3Fsx%3D1";
    	}else if(cur_url_encode.indexOf("sx%3D1")<0){
    		cur_url_encode += "%26sx%3D1";
    	}
    	if(cur_url_encode.indexOf("xks%3D")!=-1){
    		cur_url_encode = cur_url_encode.replace(/xks%3D[0-9]*/, "xks%3D"+xksId);
		}else{
			cur_url_encode = cur_url_encode+"%26xks%3D"+xksId;
		}
    	var top_px=0;
    	var recordBackUrl="/helper/recordBackUrl?url="+cur_url_encode+"&top_px="+top_px+"&location=switchXks";
    	$.get(recordBackUrl);
    	dialogLogin("float-nva_login-2",HTML_LOGIN_DIALOG_SWITCHXKS);
	}
}

//衣橱需要登录
function loginYichu(){
	var yichu_url_encode="%2Fmyyichu%2Fproduct%3Flocation%3Dyichu_r";
	var recordBackUrl="/helper/recordBackUrl?url="+yichu_url_encode+"&top_px=0&location=yichu_login";
	$.get(recordBackUrl);
	$.get('/logger/fans2_login_popups?location=yichu_login');
	dialogLogin("float-nva_login-2",HTML_LOGIN_DIALOG_YICHU);
}

//搭配收入衣橱
function addDaPei(daPeiId,strLocation) {
	fromFlag = "";
	if(getUrlParam("src") != null){
		fromFlag = getUrlParam("src");
	}else if(getUrlParam("location") != null){
		fromFlag = getUrlParam("location");
	}else{
		fromFlag = "";
	} 

	if(daPeiId>0){
		if(fromFlag!=""){
			$.get('/favourite/dapei/add/'+daPeiId+'?from_flag='+fromFlag+'&location='+strLocation);
		}else{
			$.get('/favourite/dapei/add/'+daPeiId+'?location='+strLocation);
		}
	}
}
//重置backUrl
function recordBackUrl(curUrl,location){
	var recordBackUrl="/helper/recordBackUrl?url="+curUrl+"&top_px=0&location="+location;
	$.get(recordBackUrl);
}

//第一次访问用户记录日志
function firstVisitorLogger(){
	var firstVisitor=J.cookie.get("firstVisitor");
    if (firstVisitor=="1"){
    	$.get('/logger/firstVisitor?location=firstVisitorLogger');
    	J.cookie.set("firstVisitor", "2");
    }
}
//加载弹窗
function popups(){
	var stopFlag=false;
	$(".js-popups-info-list").each(function(index) {
		if(!stopFlag){
			//请求弹窗代码
			var url = "/popups/" + $(this).attr("data-channel") + "?" + $(this).val();
			jQuery.get(url, {}, function(data) {
				$("#js-show-popups").html(data);
				stopFlag=data.length > 0;
			});
		}
	});
}
//*************启动加载部分**begin*************
$(function(){
	//我的衣橱搬家提示
	//guideYiChu1309();
	//页面按需加载QQ空间关注按钮
	addQZoneGuanZhuBTN();
	guideYiChu1309();
	firstVisitorLogger();
	popups();
});
//*************启动加载部分**end*************
