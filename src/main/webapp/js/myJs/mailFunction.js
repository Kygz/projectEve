/**
 * 行星产物页面相关js
 */
function submitMailFunction(){
	var input_day = $('#input_day').val();
	var input_time = $('#input_time').val();
	var input_content = $.trim($('#input_content').val());
	if(isNull(input_content)){input_content = "技能将要到期，请及时续一秒！";}
	$.ajax({
		url : "skillMail.do?method=insertMail",
		data : {
			day: input_day,
			time: input_time,
			content: input_content
		},
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			if(data.result === "true"){
                $message.alert({
                    title : "Submit result",
                    msg : "<p>提交Van♂成！邮件将会在到时间后 FA♂送</p>"
                });
			}
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
function getMailTable(){
	$.ajax({
		url : "skillMail.do?method=queryMail",
		async : false,
		type : "POST",
		dataType : "json",
		success : function(data) {
			console.log(data);
            var table = $("#list");
            table.find("tr").remove();
			if(data!=null&&data!=""){
				var size = data.length;
					for(var i = 0;i<size;i++){
                        var dateObj = new Date(data[i].mail_time);
                        $("<tr>" +
                            "<td>"+ dateObj.getFullYear()+"-"+(dateObj.getMonth()+1)+"-"+dateObj.getDate() +"</td>" +
                            "<td>"+ data[i].mail_content + "</td>" +
                            "<td>"+ data[i].mail_address + "</td>" +
                            "<td>"+ data[i].mail_done + "</td>" +
                            "<td>"+ "删除" + "</td>" +
                            "</tr>").appendTo(table);
                    }
			}
		}
	});
}

function isNull(value) {
	return value == null||value=="";
}