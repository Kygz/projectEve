/**
 * 主页相关方法归总
 */

function initSideBarClick() {
	$(".side-menu li > a").on('click',function(){
		var obj = $(this);
		var isIndex = obj.hasClass("sa-side-home");
		if(isIndex){
			showPortal(true);
		}else{
			var toUrl = obj.attr("_href");
			showPortal(false,toUrl);
		}
	})
}

function showPortal(isShow,url){
	if(isShow){
		indexPageParam.mainIframeObj.iframeBlock.toggleClass("hidden",true);
		indexPageParam.mainIframeObj.iframe.toggleClass("hidden",true);
		indexPageParam.mainPortalObj.portalBlock.toggleClass("hidden",false);
		indexPageParam.mainIframeObj.iframe.attr("src","");
	}else{
		indexPageParam.mainPortalObj.portalBlock.toggleClass("hidden",true);
		if(url && $.trim(url) !== ""){
			indexPageParam.mainIframeObj.iframe.attr("src",url);
			indexPageParam.mainIframeObj.iframeBlock.toggleClass("hidden",false);
			indexPageParam.mainIframeObj.iframe.toggleClass("hidden",false);
		}
	}
}

function ajaxQueryPlanetSection(){
	if($("#planetBlock").length === 0){
		return;
	}
	$.ajax({
		url : "planet.do?method=queryMonth",
		data : {
			userId : '${sessionScope.member.member_id}',
			userName : '${sessionScope.member.member_nickname}'
		},
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			$('#planet1').data('easyPieChart').update(
					parseInt(data.planet_star1 / 354000 * 100));
			$('#planet2').data('easyPieChart').update(
					parseInt(data.planet_star2 / 354000 * 100));
			$('#planet3').data('easyPieChart').update(
					parseInt(data.planet_star3 / 354000 * 100));
			$('#planet4').data('easyPieChart').update(
					parseInt(data.planet_star4 / 354000 * 100));
			$('#planet5').data('easyPieChart').update(
					parseInt(data.planet_star5 / 354000 * 100));
			$('#planet6').data('easyPieChart').update(
					parseInt(data.planet_star6 / 354000 * 100));
			$('#planet7').data('easyPieChart').update(
					parseInt(data.planet_star7 / 354000 * 100));
		}
	});
}

/**
 * 老黄历
 */
function initOldYellowCalendar() {
	var oldYellowBlock = $("#oldYellow");
	if(oldYellowBlock.length == 0){
		return;
	}
	var _ROWTPL = $("<div class=\"media\">" +
        			"    <div class=\"m-0\">" +
        			"        <label class=\"t-overflow\">" +
        			"        </label>" +
        			"    </div>" +
        			"</div>");
	var data = oldYellowCalendar.pickTodaysLuck();
	if($("#oldYellow > .listview")[0]){
		var goodListView = $($("#oldYellow > .listview")[0]);
        goodListView.html("");
        if(data.good && data.good.length>0){
			for(var i = 0 ; i < data.good.length ; i++){
				var goodRow = _ROWTPL.clone();
                goodRow.find("label").text(data.good[i].name + "----" + data.good[i].good);
                goodListView.append(goodRow);
			}
		}
	}
	if($("#oldYellow > .listview")[1]){
        var badListView = $($("#oldYellow > .listview")[1]);
        badListView.html("");
        if(data.bad && data.bad.length>0){
            for(var i = 0 ; i < data.bad.length ; i++){
                var badRow = _ROWTPL.clone();
                badRow.find("label").text(data.bad[i].name + "----" + data.bad[i].bad);
            	badListView.append(badRow);
            }
        }
	}
}

function setMainIframeHeight() {
	var isShow = !indexPageParam.mainIframeObj.iframeBlock.hasClass("hidden");
	var hasContent = indexPageParam.mainIframeObj.iframe && indexPageParam.mainIframeObj.iframe[0].contentWindow.getContentHeight;
	if(isShow && hasContent && !indexPageParam.mainIframeObj.autoIframe){
		indexPageParam.mainIframeObj.autoIframe = setInterval(function () {
			if(indexPageParam.mainIframeObj.iframe[0].contentWindow.getContentHeight){
				indexPageParam.mainIframeObj.iframe.height(indexPageParam.mainIframeObj.iframe[0].contentWindow.getContentHeight());
			}else{
				setMainIframeHeight();
			}
		});
	}else if(indexPageParam.mainIframeObj.autoIframe && (!isShow || !hasContent)){
		clearInterval(indexPageParam.mainIframeObj.autoIframe);
		indexPageParam.mainIframeObj.autoIframe = null;
		indexPageParam.mainIframeObj.iframe.height(0);
	}
}