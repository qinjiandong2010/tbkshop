$(document).ready(function(){
	$("select[name='cate']").bind("dblclick",function(){
		add_cate();
	});
	$("input[name='add']").bind("click",function(){
		add_cate();
	});
	$("select[name='coupons_cate']").bind("dblclick",function(){
		remove_cate();
	});
	$("input[name='remove']").bind("click",function(){
		remove_cate();
	});
});

function add_cate()
{
	var select_option = $("select[name='cate']").find("option:selected");
	var exist_option = $("select[name='coupons_cate']").find("option");
	var obj = new Array();
	for(i=0;i<select_option.length;i++)
	{
		is_add = true;
		for (j = 0; j < exist_option.length; j++) 
		{
			if ($(select_option[i]).attr("value") == $(exist_option[j]).attr("value")) 
			{
				is_add = false;
				break;
			}
		}
		if(is_add)
		{
			obj.push(select_option[i]);
		}
	}
	var clone = $(obj).clone();
	var text = clone.html().replace(/&nbsp;/g,'');
	text = text.replace('|--','');
	clone.html(text);
	$("select[name='coupons_cate']").append(clone);	
	var opts = $("select[name='coupons_cate']").find("option");
	var ids = new Array();
	for(i=0;i<opts.length;i++)
	{
		ids.push($(opts[i]).attr("value"));
	}
	$("input[name='coupons_cate']").val(ids.join(","));

}

function remove_cate()
{
	$("select[name='coupons_cate']").find("option:selected").remove();	
	var opts = $("select[name='coupons_cate']").find("option");
	var ids = new Array();
	for(i=0;i<opts.length;i++)
	{
		ids.push($(opts[i]).attr("value"));
	}
	$("input[name='coupons_cate']").val(ids.join(","));
	
}
function del_coupons_photo(gp_id,obj)
{
	if(confirm(CONFIRM_DELETE))
	{
		$.ajax({
			url: APP + '/Admin/' + CURR_MODULE + '/removePhoto/id/'+gp_id,
			type:"POST",
			cache: false,
			dataType:"json",
			success: function(result){
				if(result.isErr==0)
				{					
					if($(obj).parent().parent().find(".img_list").length==1)
					{
						$(obj).parent().parent().parent().remove();
						$(obj).parent().remove();
					}
					else
					$(obj).parent().remove();
				}
				else
				$.ajaxError(result.content);
			}
		});
	}
}