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
			// console.log(data.msg);
			alert(data.msg);
			location.reload();
		}
	});
}/**
 * 行星产物页面相关js
 */
function getPlanetTable(){
	$.ajax({
		url : "planet.do?method=queryFive",
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data);
			if(data!=null&&data!=""){
				var table = $("#lastFiveTable tbody");
				$('#lastFiveTable tbody tr').remove();
				var size = data.length;
					for(var i = 0;i<size;i++){
						var price = 0.8 * 	data[i].planet_star1 * data[i].planet_star1_price +
											data[i].planet_star2 * data[i].planet_star2_price +
											data[i].planet_star3 * data[i].planet_star3_price +
											data[i].planet_star4 * data[i].planet_star4_price +
											data[i].planet_star5 * data[i].planet_star5_price +
											data[i].planet_star6 * data[i].planet_star6_price +
											data[i].planet_star7 * data[i].planet_star7_price;
						var dateObj = new Date(data[i].planet_update_date);
						$("<tr>" +
							"<td>"+ (i+1) +"</td>" +
							"<th>"+ data[i].planet_star1 + "</th>" +
							"<th>"+ data[i].planet_star2 + "</th>" +
							"<th>"+ data[i].planet_star3 + "</th>" +
							"<th>"+ data[i].planet_star4 + "</th>" +
							"<th>"+ data[i].planet_star5 + "</th>" +
							"<th>"+ data[i].planet_star6 + "</th>" +
							"<th>"+ data[i].planet_star7 + "</th>" +
							"<td>"+ dateObj.getFullYear()+"-"+(dateObj.getMonth()+1)+"-"+dateObj.getDate() +"</td>" +
							"<td>"+ price.toFixed(2) +"</td>" +
							"</tr>").appendTo(table);
					}
			}
		}
	});
}