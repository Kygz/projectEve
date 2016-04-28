/**
 * 主页相关方法归总
 */
function ajaxQueryPlanetSection(){
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