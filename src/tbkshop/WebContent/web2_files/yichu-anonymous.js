function favHanlder(itemid, price) {
	if(itemid>0){
		$.post("/yichu/anonymousfav/" + itemid, {'price':price}, function (data) {
			if(data && data == -1) {
				//window.location.href="/login";
				$.get('/logger/anonymousfav_beyond_limit');
			}
		});
		var cur_url_encode=document.getElementById("js-cur-url-encode");
        if(cur_url_encode){
        	var top_px=0;
        	var recordBackUrl="/helper/recordBackUrl?url="+$(cur_url_encode).val()+"&top_px="+top_px+"&location=fav_items_login";
        	$.get(recordBackUrl);
        	$.get('/logger/fans2_login_popups?location=fav_login');
        	J.nav_login();
    	}
	}
}

$(function () {
    $(".add_btn").click(function () {
        try {
        	var itemid=$(this).attr("itemid");
            var price=$(this).attr("price");
            if(itemid>0){
	            favHanlder(itemid, price);
            }
        } catch (e) {
        }

    });
    $("img.lazy").lazyload({
    	threshold : 500 ,
    	effect : "fadeIn" 
    }); 
});


