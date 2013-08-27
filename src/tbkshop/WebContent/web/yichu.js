function fav(itemid, price) {

}

function favHanlder(itemid, price) {

    var totalprice = parseFloat($("#favprice").attr("data"))+parseFloat(price);
    var totalcnt = parseInt($("#favcnt").attr("data"))+1;
    $("#favprice").attr("data",totalprice);
    $("#favcnt").attr("data",totalcnt);
    $("#favprice").html(fmoney(ForDight(totalprice,0))+"<i>元</i>");
    $("#favcnt").html(totalcnt+"<i>个</i>");
    $.post("/favourite/add/" + itemid, {'price':price}, function (data) {
    });
}

$(function () {
    $(".add_btn").click(function () {
        try {
            var itemid=$(this).attr("itemid");
            var price=$(this).attr("price");
            favHanlder(itemid, price);
        } catch (e) {
        }

    });
    $(".prompt_close").click(function(){
    	var sid = $($(this).parent()).find("input:hidden").val();
    	$.post("/xks/switchxksmatched/",{type:0,switchsid:sid},function(data){    		
    	});
    	
    });

    $("img.lazy").lazyload({
    	threshold : 500 ,
    	effect : "fadeIn" 
    	}); 
});

function fmoney(s, n)
{
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")) + "";
    var l = s.split(".")[0].split("").reverse(),
    t = "";
    for(i = 0; i < l.length; i ++ )
    {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("");
}

function  ForDight(Dight,How)
{
    Dight  =  Math.round  (Dight*Math.pow(10,How))/Math.pow(10,How);
    return  Dight;
}

function changeXks(xksid){	
	$.post("/xks/switchxksmatched/",{type:2,switchsid:xksid},function(data){    	
		url = location.href;
		if (url.indexOf('?') < 0 ){
			location.href = url+"?sx=1";
		}else{
			location.href = url+"&sx=1";
		}
	});
}



