/**
 * 行星产物页面相关js
 */
function submitMailFunction(){
	var input_day = $('#input_day').val();
	var input_time = $('#input_time').val();
	if(input_day ===""||input_time ===""){
		return false;
	}
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
            getMailTable();
		},
		error : function (data) {
            $message.alert({
                title : "Submit result",
                msg : "<p>发生未知错误! 天知道后台发生了什么肮脏的交易</p>"
            });
        }
	});
	return false;
}
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
						var state = data[i].mail_done;
						var stateStr = "";
						// -2:跳过 -1:失败 0:进行中 1:成功
						if(state === 1){
                            stateStr = "成功";
						}else if(state === 0){
                            stateStr = "进行中";
                        }else if(state === -1){
                            stateStr = "失败";
                        }else if(state === -2){
                            stateStr = "跳过";
                        }

                        $("<tr>" +
                            "<td>"+ data[i].mail_time +"</td>" +
                            "<td>"+ data[i].mail_content + "</td>" +
                            "<td>"+ data[i].mail_address + "</td>" +
                            "<td>"+ stateStr + "</td>" +
                            "<td onclick='delMail(\"" + data[i].mail_id + "\")'>" + "删除" + "</td>" +
                            "</tr>").appendTo(table);
                    }
			}
		}
	});
}
function delMail(mailId) {
    $.ajax({
        url : "skillMail.do?method=delMail",
        async : false,
        type : "POST",
        dataType : "json",
        data : {
        	mailId : mailId
    	},
        success : function(data) {
            $message.alert({
                title : "Delete result",
                msg : "<p>"+ data.msg +"</p>"
            });
            if(data.result === "true"){
                getMailTable();
			}
        }
    });
}
function isNull(value) {
	return value === null||value==="";
}