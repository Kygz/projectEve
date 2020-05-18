<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">

    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

    <title>米氏非正常人类集散地</title>

    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="css/calendar.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/icons.css" rel="stylesheet">
    <link href="css/generics.css" rel="stylesheet">
</head>
<body style="background: none">
<section id="content" class="container" style="margin-left: 0">
<%--    <h4 class="page-title">日程活动</h4>--%>
    <div class="block-area">
        <div class="alert alert-info alert-dismissable fade in">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            点击添加团队事件
        </div>
    </div>

    <div class="col-md-8 clearfix">

        <div id="calendar" class="p-relative p-10 m-b-20">
            <!-- Calendar Views -->
            <ul class="calendar-actions list-inline clearfix">
                <li class="p-r-0">
                    <a data-view="month" href="#" class="tooltips" title="Month">
                        <i class="sa-list-month"></i>
                    </a>
                </li>
                <li class="p-r-0">
                    <a data-view="agendaWeek" href="#" class="tooltips" title="Week">
                        <i class="sa-list-week"></i>
                    </a>
                </li>
                <li class="p-r-0">
                    <a data-view="agendaDay" href="#" class="tooltips" title="Day">
                        <i class="sa-list-day"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="col-md-4">
        <h4 class="m-l-5">Upcoming Events</h4>
        <div class="listview narrow" id="eventList">
        </div>
    </div>

    <!-- Add event -->
    <div class="modal fade" id="addNew-event">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">发布新事件</h4>
                </div>
                <div class="modal-body">
                    <form class="form-validation" role="form">
                        <div class="form-group">
                            <label for="eventName">TITLE</label>
                            <input type="text" class="input-sm form-control validate[required]" id="eventName"
                                   placeholder="标题请勿以‘震惊’为开头">
                        </div>
                        <div class="form-group">
                            <label for="eventCreateMember">USER</label>
                            <input type="text" class="input-sm form-control validate[required]" id="eventCreateMember"
                                   readonly value="${sessionScope.member.member_nickname}">
                        </div>
                        <div class="form-group">
                            <label for="eventContent">CONTENT</label>
                            <textarea class="input-sm form-control auto-size" id="eventContent"
                                      placeholder="事件描述(文体不限 诗歌除外)"></textarea>
                        </div>
                        <input type="hidden" id="getStart"/>
                        <input type="hidden" id="getEnd"/>
                    </form>
                </div>

                <div class="modal-footer">
                    <input type="submit" class="btn btn-info btn-sm" id="addEvent" value="发布">
                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <!-- event Detail-->
    <div class="modal fade" id="show-event">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">事件详情</h4>
                </div>
                <div class="modal-body">
                    <form class="form-validation" role="form">
                        <input type="hidden" id="show_eventId">
                        <div class="form-group">
                            <label for="eventName">TITLE</label>
                            <input type="text" class="input-sm form-control validate[required]" id="show_eventName"
                                   placeholder="你看到了bug，请联系作者" readonly>
                        </div>
                        <div class="form-group">
                            <label for="eventCreateMember">USER</label>
                            <input type="text" class="input-sm form-control validate[required]"
                                   id="show_eventCreateMember" readonly value="">
                        </div>
                        <div class="form-group">
                            <label for="show_eventTime">TIME</label>
                            <input type="text" class="input-sm form-control validate[required]" id="show_eventTime"
                                   readonly value="">
                            <input type="hidden" id="show_getStart"/>
                            <input type="hidden" id="show_getEnd"/>
                        </div>
                        <div class="form-group">
                            <label for="eventContent">CONTENT</label>
                            <textarea class="input-sm form-control auto-size" id="show_eventContent"
                                      placeholder="什么都没留下，只有一句形容 'RT'" readonly></textarea>
                        </div>
                        <div class="form-group">
                            <label for="eventContent">JOIN MEMBER</label>
                            <textarea class="input-sm form-control auto-size" rows="2" id="show_joinMember"
                                      placeholder="凄凄凉凉 问苍茫星空 知音何在？" readonly></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-info btn-sm" id="join" value="参加" data-dismiss="modal">
                    <input type="submit" class="btn btn-info btn-sm" id="noJoin" value="有事退出" data-dismiss="modal">
                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal Resize alert -->
    <div class="modal fade" id="editEvent">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">修改事件</h4>
                </div>
                <div class="modal-body">
                    <div id="eventInfo"></div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">发布</button>
                    <button type="button" class="btn btn-info btn-sm" id="editCancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

    <br/><br/>
</section>
<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->
<script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!-- UX -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<!--  Form Related -->
<script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
<script src="js/validation/validationEngine.min.js"></script>
<!-- jQuery Form Validation Library - requirred with above js -->

<!-- Other -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/feeds.min.js"></script> <!-- News Feeds -->
<script src="js/autosize.min.js"></script><!-- Textare autosize -->


<!-- All JS functions -->
<script src="js/functions.js"></script>
<script src="js/myJs/commonFunction.js"></script>
<script src="js/myJs/iframeFunction.js"></script>
<script src="js/myJs/calendarFunction.js"></script>

<script type="text/javascript">
    var joinColor = "#73ff1e";//green
    var joinPassColor = "#82fa9b";//灰绿
    var normalColor = "#00b4ff";//blue
    var normalPassColor = "#000";//灰
    $(document).ready(function () {
        parent.setMainIframeHeight();

        var date = new Date();
        var m = date.getMonth();
        var y = date.getFullYear();

        getEventData(y, m + 1, function (list) {
            createCalendar(list);
            createEventList(list);
        });
        //新建确定按钮
        $('body').on('click', '#addEvent', function () {
            var eventForm = $(this).closest('.modal').find('.form-validation');
            eventForm.validationEngine('validate');

            if (!(eventForm).find('.formErrorContent')[0]) {
                //Event Name 事件名称
                var eventName = $('#eventName').val();
                var eventContent = $('#eventContent').val();
                var eventData = {
                    title: eventName,
                    content: eventContent,
                    start: $('#getStart').val(),
                    end: $('#getEnd').val(),
                    allDay: true,
                    color: normalColor,
                    idList: []
                };
                $.ajax({
                    url: "calendar.do?method=addCalendarEvent",
                    async: false,
                    type: "POST",
                    dataType: "json",
                    data: eventData,
                    success: function (data) {
                        $message.alert({
                            title: "Insert result",
                            msg: "<p>" + data.msg + "</p>"
                        });
                        if (data.result === "true") {
                            //Render Event
                            $('#calendar').fullCalendar('renderEvent', eventData, true); //Stick the event                                }
                        }
                    },
                    error: function (data) {
                        $message.alert({
                            title: "Insert result",
                            msg: "<p>" + "失败!" + "</p>"
                        });
                    }
                });
                $('#addNew-event form')[0].reset();
                $('#addNew-event').modal('hide');
            }
        });
        $('body').on('click', '#join', function () {
            //Event Name 事件名称
            var eventId = $('#show_eventId').val();
            var eventData = {
                eventId: eventId
            };
            $.ajax({
                url: "calendar.do?method=joinEvent",
                async: false,
                type: "POST",
                dataType: "json",
                data: eventData,
                success: function (data) {
                    $message.alert({
                        title: "Join result",
                        msg: "<p>" + data.msg + "</p>"
                    });
                    if (data.result === "true") {
                        var currentMember = $storage.getCurrentMember();

                        var eventList = $('#calendar').fullCalendar('clientEvents', eventId); //Stick the event
                        if (eventList.length === 1) {
                            var event = eventList[0]; //Stick the event
                            event.color = joinColor;
                            event.isJoin = true;

                            var memberList = event.idList;
                            memberList.push({id: currentMember.member_id, name: currentMember.member_nickname});
                            event.idList = memberList;
                            $('#calendar').fullCalendar('updateEvent', event);
                        }

                    }

                },
                error: function (data) {
                    $message.alert({
                        title: "Insert result",
                        msg: "<p>" + "失败!" + "</p>"
                    });
                }
            });
            $('#addNew-event form')[0].reset();
            $('#addNew-event').modal('hide');
        });
        /**
         * 取消加入
         */
        $('body').on('click', '#noJoin', function () {
            //Event Name 事件名称
            var eventId = $('#show_eventId').val();
            var eventData = {
                eventId: eventId
            };
            $.ajax({
                url: "calendar.do?method=cancelJoinEvent",
                async: false,
                type: "POST",
                dataType: "json",
                data: eventData,
                success: function (data) {
                    $message.alert({
                        title: "Insert result",
                        msg: "<p>" + data.msg + "</p>"
                    });
                    var currentMember = $storage.getCurrentMember();
                    if (data.result === "true") {
                        var eventList = $('#calendar').fullCalendar('clientEvents', eventId); //Stick the event
                        if (eventList.length === 1) {
                            var event = eventList[0]; //Stick the event
                            event.color = normalColor;
                            event.isJoin = false;
                            var memberList = event.idList;
                            for (var i = 0; i < memberList.length; i++) {
                                var tempMember = memberList[i];
                                if (tempMember.id === currentMember.member_id) {
                                    memberList.splice(i, 1);
                                }
                            }
                            event.idList = memberList;
                            $('#calendar').fullCalendar('updateEvent', event);
                        }
                    }
                },
                error: function (data) {
                    $message.alert({
                        title: "Insert result",
                        msg: "<p>" + "失败!" + "</p>"
                    });
                }
            });
            $('#addNew-event form')[0].reset();
            $('#addNew-event').modal('hide');
        });
    });

    //Calendar views 视图改变 切换 月/周/日
    $('body').on('click', '.calendar-actions > li > a', function (e) {
        e.preventDefault();
        var dataView = $(this).attr('data-view');
        $('#calendar').fullCalendar('changeView', dataView);

        //Custom scrollbar
        var overflowRegular, overflowInvisible = false;
        overflowRegular = $('.overflow').niceScroll();
    });
</script>
</body>
</html>

