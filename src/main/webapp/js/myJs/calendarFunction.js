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
            console.log(data);
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
        // views: {
        //     month: {
        //         eventLimit: 5 // adjust to 6 only for agendaWeek/agendaDay
        //     }
        // },
        events: list,
        businessHours: true,
        selectable: true,
        selectHelper: true,
        editable: true,
        aspectRatio: 1.35,
        // eventLimit: 5,        //设置为true时，如果数据过多超过日历格子显示的高度时，多出去的数据不会将格子挤开，而是显示为 +...more ，点击后才会完整显示所有的数据
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
            $("#show_eventId").val(event.id);
            $("#show_eventName").val(event.title);
            $("#show_eventCreateMember").val(event.userName);
            $("#show_eventContent").val(event.content);
            $('#show_getStart').val(event.start.Format('yyyy-MM-dd HH:mm:ss'));
            $('#show_getEnd').val(event.end.Format('yyyy-MM-dd HH:mm:ss'));
            $("#show-event").modal("show");
            // console.log('eventClick中选中Event的id属性值为：', event.id);
            // console.log('eventClick中选中Event的title属性值为：', event.title);
            // console.log('eventClick中选中Event的start属性值为：', event.start.Format('yyyy-MM-dd HH:mm:ss'));
            // console.log('eventClick中选中Event的end属性值为：', event.end.Format('yyyy-MM-dd HH:mm:ss'));
            // console.log('eventClick中选中Event的color属性值为：', event.color);
            // console.log('eventClick中选中Event的className属性值为：', event.className);
            // console.log('eventClick中选中Event的className属性值为：', event.editable);
            // ...
        },
        eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
            revertFunc();
            //暂不支持拖动改时间
            //$('#editEvent').modal('show');
            //
            //var info =
            //    "The end date of " + event.title + "has been moved " +
            //    dayDelta + " days and " +
            //    minuteDelta + " minutes."
            //;
            //
            //$('#eventInfo').html(info);
            //
            //
            //$('#editEvent #editCancel').click(function(){
            //     revertFunc();
            //})
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
            var time = event.start;
            if(event.start!=event.end){
                time += " - " + event.end;
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