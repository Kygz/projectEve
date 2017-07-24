/**
 * 行星产物页面相关js
 */
function submitPlanetFunction(){
	var planetNum1 = $('#planet1').val();
	var planetNum2 = $('#planet2').val();
	var planetNum3 = $('#planet3').val();
	var planetNum4 = $('#planet4').val();
	var planetNum5 = $('#planet5').val();
	var planetNum6 = $('#planet6').val();
	var planetNum7 = $('#planet7').val();
	if(isNull(planetNum1)){planetNum1 = 0;$('#planet1').val(planetNum1);}
	if(isNull(planetNum2)){planetNum2 = 0;$('#planet2').val(planetNum1);}
	if(isNull(planetNum3)){planetNum3 = 0;$('#planet3').val(planetNum1);}
	if(isNull(planetNum4)){planetNum4 = 0;$('#planet4').val(planetNum1);}
	if(isNull(planetNum5)){planetNum5 = 0;$('#planet5').val(planetNum1);}
	if(isNull(planetNum6)){planetNum6 = 0;$('#planet6').val(planetNum1);}
	if(isNull(planetNum7)){planetNum7 = 0;$('#planet7').val(planetNum1);}
	$.ajax({
		url : "planet.do?method=insertPlanetRecord",
		data : {
			username : '${sessionScope.username}',
			planet1: planetNum1,
			planet2: planetNum2,
			planet3: planetNum3,
			planet4: planetNum4,
			planet5: planetNum5,
			planet6: planetNum6,
			planet7: planetNum7
		},
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			// alert(data.msg);
            $message.alert({
				title : "Submit result",
				msg : data.msg
			});
            $("input[id^='planet']").val(0);
            location.reload();
		},
		error : function (data) {
            $message.alert({
                title : "Submit result",
                msg : "<p>发生未知错误! 天知道后台发生了什么肮脏的交易</p>"
            });
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
			if(data!==null&&data!==""){
				var table = $("#list");
                table.find("tr").remove();
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

function isNull(value) {
	return value == null||value=="";
}