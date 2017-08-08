/**
 * 行星产物页面相关js
 */
function getEventData(year,month,callbackFunc){
    $.ajax({
        url : "calendar.do?method=queryMonth",
        async : false,
        type : "POST",
        dataType : "json",
        data : {
            year : year,
            month : month
        },
        success : function(data) {
            callbackFunc(data.list)
        }
    });
}
function createCalendar(list){
    $('#calendar').fullCalendar({
        header: {
            center: 'title',
            left: 'prev, next',
            right: ''
        },
        events: list,
        businessHours: true,
        selectable: true,
        selectHelper: true,
        editable: true,
        aspectRatio: 1.35,
        allDayText: '全天',

        select: function(start, end, allDay) {
            $("#addNew-event").find('.formError').remove();
            $('#addNew-event').modal('show');
            $('#addNew-event input:text').val('');
            $("#eventCreateMember").val($("#eventCreateMember").attr("value"));
            $('#getStart').val(start.Format('yyyy-MM-dd HH:mm:ss'));
            $('#getEnd').val(end.Format('yyyy-MM-dd HH:mm:ss'));
        },
        eventClick : function(event){
            // TODO 点击事件的事件
            if(!event.isPass && !event.isJoin){
                $("#join").show();
                $("#noJoin").hide();
            }else if(!event.isPass && event.isJoin){
                $("#join").hide();
                $("#noJoin").show();
            }else{
                $("#join").hide();
                $("#noJoin").hide();
            }
            //时间处理
            var startTime = event.allDay?event.start.Format('yyyy-MM-dd'):event.start.Format('yyyy-MM-dd HH:mm');
            var endTime = event.allDay?event.end.Format('yyyy-MM-dd'):event.end.Format('yyyy-MM-dd HH:mm');
            //人头清点
            var joinNum = event.idList.length;

            $("#show_eventId").val(event.id);
            $("#show_eventName").val(event.title);
            $("#show_eventCreateMember").val(event.userName);
            $("#show_eventContent").val(event.content).trigger("input");
            $('#show_getStart').val(startTime);
            $('#show_getEnd').val(endTime);
            if(startTime === endTime){
                $('#show_eventTime').val(startTime);
            }else {
                $('#show_eventTime').val(startTime + " <--> " +endTime);
            }
            if(joinNum>0){
                var allMember = "截至现在共" + joinNum + "人参加\n";
                var memberList = event.idList;
                for(var i = 0;i<joinNum;i++){
                    var tempMember = memberList[i];
                    allMember += tempMember.name +"        ";
                }
                $("#show_joinMember").val(allMember).trigger("input");
            }else{
                $("#show_joinMember").val("").trigger("input");
            }
            $("#show-event").modal("show");
        },
        // eventMouseover : function (event, jsEvent, view) {
        //     debugger;
        // },
        // eventMouseout : function (event, jsEvent, view) {
        //     debugger;
        // },
        eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
            revertFunc();
        }
    });
}

function createEventList(list){
    var _listRow = $("<div class=\"media p-l-5\">\n" +
        "                <div class=\"pull-left\">\n" +
        "                    <img width=\"40\" src=\"img/my-calendar-pics/teamEvent.png\" alt=\"\">\n" +
        "                </div>\n" +
        "                <div class=\"media-body\">\n" +
        "                    <small class=\"text-muted\"></small><br>\n" +
        "                    <a class=\"t-overflow\" href=\"\"></a>\n" +
        "                </div>\n" +
        "            </div>");
    var rowNum = 0;
    for(var i = 0 ;i<list.length;i++){
        var event = list[i];
        if(!event.isPass){
            var tempRow = _listRow.clone();
            tempRow.attr("id","event_"+ event.id);
            var time = event.start.Format('yyyy-MM-dd HH:mm');
            if(event.start.Format('yyyy-MM-dd')!=event.end.Format('yyyy-MM-dd')){
                time += " - " + event.end.Format('yyyy-MM-dd HH:mm');
            }else{
                time += "全天";
            }
            tempRow.find(".text-muted").text(time);
            tempRow.find(".media-body a").text(event.title);
            $("#eventList").append(tempRow);
            rowNum++;
            if(rowNum >= 10){
                break;
            }
        }
    }
}