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
        events: list,
        selectable: true,
        selectHelper: true,
        editable: true,
        eventLimit: true,        //设置为true时，如果数据过多超过日历格子显示的高度时，多出去的数据不会将格子挤开，而是显示为 +...more ，点击后才会完整显示所有的数据

        select: function(start, end, allDay) {
            $("#addNew-event").find('.formError').remove();
            $('#addNew-event').modal('show');
            $('#addNew-event input:text').val('');
            $("#eventCreateMember").val($("#eventCreateMember").attr("value"));
            $('#getStart').val(start);
            $('#getEnd').val(end);
        },
        eventClick : function(event){
            // TODO 点击事件的事件
            console.log('eventClick中选中Event的id属性值为：', event.id);
            console.log('eventClick中选中Event的title属性值为：', event.title);
            console.log('eventClick中选中Event的start属性值为：', event.start.Format('yyyy-MM-dd HH:mm'));
            console.log('eventClick中选中Event的end属性值为：', event.end.Format('yyyy-MM-dd HH:mm'));
            console.log('eventClick中选中Event的color属性值为：', event.color);
            console.log('eventClick中选中Event的className属性值为：', event.className);
            console.log('eventClick中选中Event的className属性值为：', event.editable);
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