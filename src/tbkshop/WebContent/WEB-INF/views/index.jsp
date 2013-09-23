<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/page" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<link rel="icon" href="/favicon.ico?v=20120319" type="image/x-icon">
<link rel="stylesheet" href="http://image.guang.j.cn/images/css/jcn.min.css?v=1376902440">
<link rel="stylesheet" href="http://image.guang.j.cn/images/css/jcn.nav.c.css?v=1376902440">
<link id="change_skin" rel="stylesheet" href="http://image.guang.j.cn/images/css/skin_default.css?v=1376902440">

<meta name="keywords" content="所有上衣, 所有上衣价格, 所有上衣女装, 所有上衣单品推荐, 所有上衣搭配">
<meta name="description" content="泛美丽www.j-fml.cn 所有上衣频道汇聚了当季最新款、最流行的所有上衣，淘实惠、品质、潮流所有上衣和最佳搭配、购买心得，就来简单网所有上衣频道。简单衣橱，专属你的美丽。">
<title>2013流行新款所有上衣、淘宝时尚所有上衣_品牌所有上衣搭配、网购 –泛美丽网www.j-fml.cn</title>

<iframe src="./web/m.htm" style="display: none;"></iframe></head>
<body class="">
<script type="text/javascript" async="" src="./web/ga.js"></script><script type="text/javascript" src="./web/selfAdaption.js"></script>
<div class="site_nav">
    <div class="wrap rela clearfix auto">
        <h1 class="fl"><a href="http://www.j-fml.cn/" title="简单衣橱，专属你的美丽"><span class="hide">泛美丽</span></a></h1>  
            <p class="weibo fr"><a href="javascript:void(0)" class="qqzone" title="qq空间" id="top_qqzone">关注</a> <a href="javascript:void(0)" class="sina" title="新浪微博" id="top_sina">关注</a></p>
        	<p class="weibo fr"><a href="http://www.j.cn/myyichu" class="myWD" title="我的衣橱" target="_blank">我的衣橱</a></p>
            <p class="top_user fr"><span>Hi~</span>dong<a href="http://www.j.cn/login/out">退出</a></p>
        </div>
</div>
<div class="nav3_wrap rela">
    <div class="wrap nav3 auto">
        <div class="nav3_change fl">
            <b class="tr msf iepng">全部分类</b>
        </div>
        <div class="nav3_list msf fl f14">
            <ul>
                <li><a href="http://www.j.cn/?src=nav_c_idxnew">首页</a></li>
                    <li><a href="http://www.j.cn/cate/j_shangyi?src=nav_c_shangyi">上衣</a></li>
                <li>
                    <a href="http://www.j.cn/cate/j_qunzi?src=nav_c_qunzi">裙子</a>
                    <i><a href="http://www.j.cn/cate/j_qunzi/34/?src=nav_c_hot1">连衣裙</a><a href="http://www.j.cn/cate/j_qunzi/78/?src=nav_c_hot1">雪纺裙</a></i>
                </li>
                <li><a href="http://www.j.cn/cate/j_kuzi?src=nav_c_kuzi">裤子</a></li>
                <li>
                    <a href="http://www.j.cn/cate/j_xiezi?src=nav_c_xiezi">女鞋</a>
                    <i><a href="http://www.j.cn/cate/j_xiezi/221?src=nav_c_hot3">凉鞋</a><a href="http://www.j.cn/cate/j_xiezi/232?src=nav_c_hot4">高跟鞋</a></i>
                </li>
                <li class="borRNone"><a href="http://www.j.cn/j_bao?src=nav_c_bao">包包</a></li>
                <li class="borRMar">
                    <a href="http://www.j.cn/yichu2?src=nav_c_new">每日新品</a> 
                    </li>
            </ul>
        </div>
    </div>
    <div class="nav3Menu clearfix hide" style="top: -999em;">
        <div class="nav3MenuBg iepng">
            <div class="wrap auto cate_rela"><!-- start 新增样式cate_rela -->
                <!-- start btn_close -->
                <div class="close_btn">
                    <a class="btn_close" href="http://www.j.cn/j_shangyi?src=nav_c_all###">关闭 x</a>
                </div>
                <!-- end btn_close -->
                <ul class="nav3MenuList clearfix msf">
                      <c:forEach var="category" items="${categoryList }" varStatus="status">
                      		<c:if test="${status.index % 3 == 0  }">
                      			<li>
		                        <dl>
                      		</c:if>
	                        		<dt class="iepng">
		                                <a href="/?categorys=${category.id }">${category.typeName }</a>
		                            </dt>
		                            <dd class="clearfix">
			                            <option value="${category.id }">${category.typeName }</option>
			                            <c:forEach var="category2" items="${category.listNode }">
			                                <a class="cred" href="/?categorys=${category2.id }"><span>${category2.typeName }<i></i></span></a>
			                            </c:forEach>
		                            </dd>
	                         <c:if test="${status.index % 3 == 0  }">
                      			</dl>
                      			</li>
                      		</c:if>
	                  </c:forEach>
                </ul>
            </div>
        </div>
        <span class="nav3MenuBott iepng"></span>
    </div>
</div>
<link rel="stylesheet" href="http://image.guang.j.cn/images/css/jcn_list.css?v=1376902440">
<style>
.dir { height:27px; padding:10px 0 0 5px; border-bottom:1px dashed #ccc;  background:#f8f8f8; color:#999; /* ie6,7 */ *height:24px; *padding-top:13px; }
    .dir h2 { display:none; }
    .dir a { color:#666; }
    .dir a:hover { color:#33bff0; }
    .dir .index,
    .dir i { position:relative; top:-2px; width:13px; height:11px; margin:0 3px; overflow:hidden; display:inline-block; vertical-align:middle; background:url(http://image.guang.j.cn/images/imgs/min-icons.png) no-repeat; font-size:0; /* ie6,7 */ *top:0; *display:inline; *zoom:1; }
    .dir .index:hover { background-position:-13px 0; }
    .dir i { width:7px; height:8px; background-position:0 -11px; }
    .dir i.last { background-position:-7px -11px; }
</style>
<div class="bigBg">
<div class="listTopBgX"></div>
<div class="wrap968 listSort clearfix">
    <h2 class="newList_tit msf fl">女衣</h2>
    	<form:form id="searchForm" commandName="formParam" method="GET">
        <div class="listSort_r fr">
	        <div class="fr">
	            <span class="listSort_colour_tit msf fl">颜色：</span>
	            <div class="listSort_colour_bg fl">
	                <ul>
	                    <li><a class="red" href="http://www.j.cn/j_shangyi?color=972&location=colorId:972">红色系</a></li><li><a class="rose_red" href="http://www.j.cn/j_shangyi?color=1190&location=colorId:1190">玫红色</a></li><li><a class="yellow" href="http://www.j.cn/j_shangyi?color=975&location=colorId:975">黄色系</a></li><li><a class="green" href="http://www.j.cn/j_shangyi?color=976&location=colorId:976">绿色系</a></li><li><a class="blue" href="http://www.j.cn/j_shangyi?color=977&location=colorId:977">蓝色系</a></li><li><a class="purple" href="http://www.j.cn/j_shangyi?color=978&location=colorId:978">紫色系</a></li><li><a class="black" href="http://www.j.cn/j_shangyi?color=968&location=colorId:968">黑色系</a></li><li><a class="white" href="http://www.j.cn/j_shangyi?color=970&location=colorId:970">白色系</a></li><li><a class="gray" href="http://www.j.cn/j_shangyi?color=969&location=colorId:969">灰色系</a></li></ul>
	            </div>
	        </div>
	        <div class="fr">
	            <div class="listSort_price fr">
	                <ul>
	                    <li class="listSort_priceL listSort_priceCur"><a href="/"><i class="listSort_priceLI"></i><em>全部</em></a></li>
	                    <li class=""><a href="/?pricefrom=0&priceto=80"><em>0-80</em></a></li>
	                    <li class=""><a href="/?pricefrom=80&priceto=300"><em>80-300</em></a></li>
	                    <li class="listSort_priceR "><a href="/?pricefrom=300"><em>300以上</em><i class="listSort_priceRI"></i></a></li>
	                </ul>
	                <div class="listSort_custom fl rela">                        
	                  <div class="rela listSort_texRel"><form:input path="pricefrom" type="text" class="listSort_tex" id="pricefrom" value=""/>&nbsp;一&nbsp;<form:input path="priceto" id="priceto" type="text" class="listSort_tex" value=""/></div>
	                  <div class="listSort_bg abso tc"><input type="button" id="priceButton" value="确定" onclick="submitPrice()" class="listSort_btn msf"></div>
	              </div>
	            </div>
	            <span class="listSort_colour_tit msf fr">价格：</span>
	       </div>
	    </div>
    </form:form>
</div>
<script type="text/javascript">
function submitPrice() {
	var pricefrom = $("#pricefrom").val();
	var priceto = $("#priceto").val();
	if((pricefrom == '') && priceto == '') {
	    alert('妞儿，请至少填一个数吧~~');
	    $("#pricefrom").focus();
	    return;
	}
	if(pricefrom == '' || isNaN(pricefrom)) {
	    pricefrom = 0;
	}
	if(priceto == '' || isNaN(priceto)) {
	    priceto = 0;
	}
	if(pricefrom == priceto && pricefrom == 0) {
		$("#pricefrom").val('');
		$("#priceto").val('');
		return;
	}
	$("#searchForm").submit();
	
}
</script><div class="wrap968">
    <span class="iepng smallBgT"></span>
    <div class="iepng smallBgY smallBgYBP">
	    <ul class="pro_list newList clearfix">
	    	<c:choose>
	    		<c:when test="${fn:length(goodsList) > 0 }">
		    		<c:forEach items="${goodsList}" var="goods">
			    		<li>
			                <div class="layout">
			                    <a href="http://www.j.cn/product/1941294.htm" class="imgwrap" target="_blank" onclick="clickLog(&#39;http%3A%2F%2Fclick.uctrac.com%2Fc%2Fc%3Fk%3D3Xl5bgniOsJrlgwTZQEs5dgyzxiqi8d53S-De5kkhfcRON6THvE3KPfgBXtE5ZXlurUbC3WXHL1JALxAMunHVOn3dj3FFFewhwwDf0zIpDfJB0RZRfeRQL57bTYBbFb_lZAYTspubEB0maQLAPaoyInd2YfpFO-YPHH5HfYeIpsnuakG5c7LfVy1zn_0C3K1sOUo_i4fdsXnWPcA-MAAPxun5tl0wmOXXZzYgv6vxfIsUIe8q7SLhxNge4E2y1rbVDN7kKiUf9ztyrMba8jQvjYK%26url%3Dhttp%253A%252F%252Fs.click.taobao.com%252Ft%253Fe%253Dm%25253D2%252526s%25253DywKLSEv5yascQipKwQzePOeEDrYVVa64XoO8tOebS%25252BdRAdhuF14FMXXVbRpmb%25252Buwlovu%25252FCElQOuhAh3HOJNdaNQRGlh44dSUTkt1PB7EAQYTzSJ6RGKXv9AqgaNS7oS9mC60SMY1YWOpPatr84o7yQnP3EV9m%25252Fmo%2526spm%253D2014.12669715.1.0%2526u%253Djn_UCTRAC_CLK_%2526unid%253Djn_UCTRAC_CLK_%26xxid%3D&#39;)"><img src="${goods.l_icon }" width="300px" height="300px" data-original="${goods.l_icon }" alt="${goods.goods_name }" title="${goods.goods_name }"></a>
			                    <p class="pro_add tc abso">
			                    <a href="javascript:void(0)" itemid="${goods.id }" price="${goods.sell_price }" class="add_btn"><span>收入衣橱</span></a>
			                        </p>
			                    <p class="f_proTag">
			                        <c:if test="${goods.keyword != null }">
				                    	<c:forEach items="${fn:split(goods.keyword,',') }" var="item">
				                        	<a href="/?keyword=${item}" target="_blank">${item}</a>
				                        </c:forEach>
			                        </c:if>
			                    </p>
			                </div>
			                <p class="title clearfix"><span class="fl price">￥${goods.sell_price }</span>
			                    <a href="http://www.j.cn/product/1941294.htm" target="_blank" class="fr" onclick="clickLog(&#39;http%3A%2F%2Fclick.uctrac.com%2Fc%2Fc%3Fk%3D3Xl5bgniOsJrlgwTZQEs5dgyzxiqi8d53S-De5kkhfcRON6THvE3KPfgBXtE5ZXlurUbC3WXHL1JALxAMunHVOn3dj3FFFewhwwDf0zIpDfJB0RZRfeRQL57bTYBbFb_lZAYTspubEB0maQLAPaoyInd2YfpFO-YPHH5HfYeIpsnuakG5c7LfVy1zn_0C3K1sOUo_i4fdsXnWPcA-MAAPxun5tl0wmOXXZzYgv6vxfIsUIe8q7SLhxNge4E2y1rbVDN7kKiUf9ztyrMba8jQvjYK%26url%3Dhttp%253A%252F%252Fs.click.taobao.com%252Ft%253Fe%253Dm%25253D2%252526s%25253DywKLSEv5yascQipKwQzePOeEDrYVVa64XoO8tOebS%25252BdRAdhuF14FMXXVbRpmb%25252Buwlovu%25252FCElQOuhAh3HOJNdaNQRGlh44dSUTkt1PB7EAQYTzSJ6RGKXv9AqgaNS7oS9mC60SMY1YWOpPatr84o7yQnP3EV9m%25252Fmo%2526spm%253D2014.12669715.1.0%2526u%253Djn_UCTRAC_CLK_%2526unid%253Djn_UCTRAC_CLK_%26xxid%3D&#39;)">【${goods.shop_name }】${goods.goods_name }</a>
			                </p>
			            </li>
			    	</c:forEach>
	    		</c:when>
	    		<c:otherwise>
	    			亲.. 我们找不到您想要的结果!
	    		</c:otherwise>
	    	</c:choose>
	     </ul> 
	    <div class="main_page clear wrap auto tr">
	    	<c:if test="${formParam.pageTotal != 0}">
	    		<c:if test="${formParam.pageNum > 1}">
	    			<a class="prev" href="javascript:;" onclick='prevPage();'><span class="pad_l">上一页</span></a>
	    		</c:if>
	    		<c:if test="${formParam.pageNum != formParam.pageTotal}">
	    		   <a class="next" href='javascript:;' onclick='nextPage();' ><span class="pad_r">下一页</span></a>
	    		</c:if>
	    	</c:if>
		</div>
	</div>
    <span class="iepng smallBgB"></span>
  </div>
<div class="newmyWardrobe" style="top: 239px;"><a href="http://www.j.cn/myyichu?location=yichu_r" target="_blank" class="iepng ieMyWardrobe">我的<br>衣橱</a><p class="newsAdd_animate iepng ieMyWardrobe msf">+1</p></div>
<span class="newmyWardrobeIco iepng ieMyWardrobe"></span>
<div onclick="newGoToTop();" title="回到顶部" href="javascript:void(0)" class="newGoToTop iepng" style="display: none;"><span class="hide">回到顶部</span></div>
<!--[if lte IE 6]>
    <script src="http://image.guang.j.cn/images/js/png-min.js"></script>
    <script type="text/javascript">
    DD_belatedPNG.fix('.iepng'); //此参数可以设置为标签名、类名
    </script>
<![endif]-->
<!--[if gte IE 7]>
    <script src="http://image.guang.j.cn/images/js/png-min.js"></script>
    <script type="text/javascript"> //解决xp系统IE下png24图片动画问题
    DD_belatedPNG.fix('.ieMyWardrobe'); //此参数可以设置为标签名、类名
    </script>
<![endif]-->
<div class="footer">
	<div class="wrap tr auto">
		<div class="fl footer_left tl">
			<span class="fl">用户交流QQ群:635599045<br>
			     <a href="http://e.weibo.com/1836430855/messboard" target="_blank">提建议</a>
			</span> 
			<em class="fl"></em> 
			<span class="fl">
			     <a href="http://www.j.cn/hz/cooperation.html" target="_blank">网店寻求合作</a><br>
			     <a href="http://www.j.cn/hz/verification.html" target="_blank">商家资质审核</a>
                 &nbsp;&nbsp;<a href="http://www.langtaojin.com/yssm.html" target="_blank">用户隐私声明</a>
			</span>
		</div>
		<p>j-fml.cn版权所有 京ICP证090172号 北京市公安局海淀分局备案1101082154</p>
		<a href="http://www.j.cn/hz/about.html" target="_blank" style="color:#666; margin-left:10px;">关于我们</a>
		<a href="http://www.j.cn/hz/contact.html" target="_blank" style="color:#666; margin-left:10px;">联系我们</a>
	</div>
</div>
<script type="text/javascript" src="./web/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="./web/jquery.jrumble.1.3.min.js"></script>
<script type="text/javascript" src="./web/jcn_nav_c.js"></script>
<script type="text/javascript" src="./web/lazy-load.js"></script>
<script type="text/javascript" src="./web/gdt.php" charset="UTF-8"></script>
<script type="text/javascript" src="./web/tc.js"></script>
<script type="text/javascript" src="./web/mjcn.js"></script>
<script src="/js/main.js"></script>
</body></html>