//右侧工具栏 - 私人定制 + 选款师选择
J.xks_sort = function(config){
	var init = false,
		that = this,
		speed = config.speed || J.speed,
		obj = config.obj,
		liObj = obj.find("li"),
		olObj = obj.find("ol"),
		iObj = obj.children("i"),
		iUpObj = iObj.filter("[data=js-xks-sort-up]"),
		iDownObj = iObj.filter("[data=js-xks-sort-down]"),
		maxHeight = liObj.length * config.removing,
		oneHeight = config.viewNum * config.removing;
	//计算上下限
	function isMove(i){
		//获取最大可见幕数
		var maxLen = liObj.length - config.viewNum;
		//超出最大幕数
		if(i >= maxLen){
			iUpObj.css("visibility","hidden");
			i = maxLen;
		}
		//小于最小幕数时
		else if(i <= 0){
			iDownObj.css("visibility","hidden");
			i = 0;
		}
		return i;
	};
	//移动到指定幕
	this.move = function(index,callback){
		index = isMove(index);
		//记录当前幕索引号
		config.index = index;
		var mt = index != -1 ? "-" + config.removing * index : config.removing;
		//开始移动
		olObj.stop(true).animate({
			"margin-top" : mt
		},speed,function(){
			if(callback){
				callback();
			}
		});
	};
	//移动到上幕
	this.prev = function(bool){
		iDownObj.css("visibility","visible");
		var i = bool ? config.index + config.viewNum : config.index + 1;
		that.move(i);
	};
	//移动到下幕
	this.next = function(bool){
		iUpObj.css("visibility","visible");
		var i = bool ? config.index - config.viewNum : config.index - 1;
		that.move(i);
	};

	//UI初始化
	obj.children("[data=js-xsk-sort-wrap]").css("overflow","hidden").animate({
		"height" : oneHeight
	},speed,function(){
		//添加当前选中选款师标识
		if(config.index !== "undefined" && typeof config.index == "number" && !init && config.index <= liObj.length){
			that.move(config.index,function(){
				liObj.eq(config.index).addClass("cur");
			});
		}
		else if(!init){
			config.index = 0;
			that.move(config.index);
		}
		init = true;
	});
	if(liObj.length <= config.viewNum){
		iUpObj.add(iDownObj).hide();
	}

	//固定位置
	if(J.fixed){
		J.fixed({
			obj : obj.closest(".xks-sort"),
			top : [110,60],
			bottom : 100
		});
	}

	//引导帮助开启
	$(function(){
		if(J.tip){
			J.tip.rig_show();
		}
	});

	//注册事件
	iObj.hover(
		function(){
			$(this).css({
				opacity : 1
			});
		},
		function(){
			$(this).css({
				opacity : ""
			});
		}
	);
	//注册 切换按钮事件
	iUpObj.click(function(){
		that.prev();
	}).dblclick(function(){
		that.prev(true);
	});
	iDownObj.click(function(){
		that.next();
	}).dblclick(function(){
		that.next(true);
	});
};