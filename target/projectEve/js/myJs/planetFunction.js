/**
 * 行星产物页面相关js
 */
function submitPlanetFunction(){
	$.ajax({
		url : "planet.do?method=insertPlanetRecord",
		data : {
			username : '${sessionScope.username}',
			planet1: $('#planet1').val(),
			planet2: $('#planet2').val(),
			planet3: $('#planet3').val(),
			planet4: $('#planet4').val(),
			planet5: $('#planet5').val(),
			planet6: $('#planet6').val(),
			planet7: $('#planet7').val()
		},
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			alert("提交成功！");
			location.reload();
		}
	});
}