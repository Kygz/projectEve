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
    <style>
        .cursor-hand{
            cursor: pointer;
        }
        .select .form-control{
            height: 30px;
        }
        span.icon.transBtn {
            font-size: 16px;
            position: absolute;
            right: 5px;
            top: 5px;
        }
    </style>
</head>
<body style="background: none">
<section id="content" class="container" style="margin-left: 0">
    <%--    <h4 class="page-title">日程活动</h4>--%>
    <div class="block-area">
        <button class="btn m-r-5" id="addSection">新增栏目</button>
    </div>
    <div class="block-area">
        <div class="row">
            <div class="col-md-4">
                <div class="tile">
                    <h2 class="tile-title">凡晶石</h2>
                    <div class="tile-config dropdown">
                        <a data-toggle="dropdown" href="" class="tooltips tile-menu" title="" data-original-title="Options"></a>
                        <ul class="dropdown-menu pull-right text-right">
                            <li><a href="">Refresh</a></li>
                            <li><a href="">Delete</a></li>
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
        </div>
    </div>

    <!-- Add event -->
    <div class="modal fade" id="addNew-event">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">新的栏目</h4>
                </div>
                <div class="modal-body">
                    <form class="form-validation" role="form">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12 m-b-15">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="titleCompare" name="titleCompare" onchange="titleChange()">
                                        标题物品比价
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="totalCount" name="totalCount">
                                        计算总价
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 m-b-15">
                                    <label for="titleItem">标题</label>
                                    <div class="p-relative">
                                        <input type="text" class="input-sm form-control validate[required]" id="titleItem" value="">
                                        <span class="icon cursor-hand transBtn" onclick="transItem(this)"></span>
                                    </div>
                                </div>
                                <div class="col-md-3 m-b-15">
                                    <label>&nbsp;</label>
                                    <select id="titleItemId" class="select">
                                        <option value="-1">-无-</option>
                                    </select>
                                </div>
                                <div class="col-md-3 m-b-15">
                                    <label for="titleNum">&nbsp;</label>
                                    <div class="p-relative">
                                        <input id="titleNum" class="form-control input-sm spinedit" value="1"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 m-b-15">
                                    <label for="titleItem">添加物品</label>
                                    <div class="p-relative">
                                        <input type="text" class="input-sm form-control" id="enterItem" value="">
                                        <span class="icon cursor-hand transBtn" onclick="transItem(this)"></span>
                                    </div>
                                </div>
                                <div class="col-md-2 m-b-15">
                                    <label>&nbsp;</label>
                                    <select id="enterItemId" class="select">
                                        <option value="-1">-无-</option>
                                    </select>
                                </div>
                                <div class="col-md-4 m-b-15">
                                    <p>&nbsp;</p>
                                    <button class="btn m-r-5" id="addToList" onclick="addToList()">添加到列表</button>
                                </div>
                            </div>
                            <div class="row" id="item_block">
                                <div class="col-md-4 m-b-15">
                                    <label><span class="icon cursor-hand"></span>&nbsp;&nbsp;三钛合金</label>
                                    <div class="p-relative">
                                        <input id="test1" class="form-control input-sm spinedit" value="333"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <input type="submit" class="btn btn-info btn-sm" id="addEvent" value="发布">
                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">关闭</button>
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
<script src="js/spinner.min.js"></script>
<script src="js/select.min.js"></script>
<script src="js/icheck.js"></script>
<script src="js/functions.js"></script>
<script src="js/myJs/commonFunction.js"></script>
<script src="js/myJs/iframeFunction.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        parent.setMainIframeHeight();

        $('#titleNum').spinedit('setMinimum', 1).spinedit('setMaximum', 10000);
        $('#test1').spinedit('setMinimum', 1).spinedit('setMaximum', 10000);
        $('#titleItemId').selectpicker();
        // $('#testselect').selectpicker('refresh');
        // $('.selectpicker').selectpicker('val', ‘列表id');
        //新建确定按钮
        $('body').on('click', '#addSection', function () {
            var eventForm = $(this).closest('.modal').find('.form-validation');
            eventForm.validationEngine('validate');
            $('#addNew-event form')[0].reset();
            $("#titleCompare").prop("checked",false);
            $("#totalCount").prop("checked",false);
            $("#titleItem").val("");
            $("#titleItemId option:not(:eq(0))").remove();
            $('#titleItemId').selectpicker('refresh');
            $("#titleNum").val("1");

            $("#enterItem").val("");
            $("#enterItemId option:not(:eq(0))").remove();
            $('#enterItemId').selectpicker('refresh');
            $("#item_block").html("");

            $('#addNew-event').modal('show');



        });
    });
</script>
</body>
</html>

