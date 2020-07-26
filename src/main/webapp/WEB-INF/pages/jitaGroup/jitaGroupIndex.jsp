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

    <div class="col-md-4 clearfix">
        <div class="tile">
            <h2 class="tile-title">Social Media activities</h2>
            <div class="tile-config dropdown">
                <a data-toggle="dropdown" href="" class="tooltips tile-menu" title="" data-original-title="Options"></a>
                <ul class="dropdown-menu pull-right text-right">
                    <li><a href="">Refresh</a></li>
                    <li><a href="">Settings</a></li>
                </ul>
            </div>
            <div class="listview narrow">

                <div class="media">
                    <div class="pull-right">
                        <div class="counts">367892</div>
                    </div>
                    <div class="media-body">
                        <h6>FACEBOOK LIKES</h6>
                    </div>
                </div>

                <div class="media">
                    <div class="pull-right">
                        <div class="counts">2012</div>
                    </div>
                    <div class="media-body">
                        <h6>GOOGLE +1s</h6>
                    </div>
                </div>

                <div class="media">
                    <div class="pull-right">
                        <div class="counts">56312</div>
                    </div>
                    <div class="media-body">
                        <h6>YOUTUBE VIEWS</h6>
                    </div>
                </div>

                <div class="media">
                    <div class="pull-right">
                        <div class="counts">785879</div>
                    </div>
                    <div class="media-body">
                        <h6>TWITTER FOLLOWERS</h6>
                    </div>
                </div>
                <div class="media">
                    <div class="pull-right">
                        <div class="counts">68</div>
                    </div>
                    <div class="media-body">
                        <h6>WEBSITE COMMENTS</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-4">
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

<script type="text/javascript">
    $(document).ready(function () {
        parent.setMainIframeHeight();
    });
</script>
</body>
</html>

