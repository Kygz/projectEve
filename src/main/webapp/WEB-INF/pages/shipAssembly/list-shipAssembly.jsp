<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
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
    <h4 class="page-title">装配大厅</h4>
    <div class="block-area">
        <div class="col-md-4">
            <div class="tile">
                <h2 class="tile-title">Upload List</h2>
                <div class="tile-config dropdown">
                    <a data-toggle="dropdown" href="" class="tooltips tile-menu" title="Options"></a>
                    <ul class="dropdown-menu pull-right text-right">
                        <li><a>Refresh</a></li>
                        <li><a>Settings</a></li>
                    </ul>
                </div>
                <div class="listview narrow" id="leftList">
                    <div class="media p-5 text-center l-100" id="pageDiv">
                        <a class="p-r-20"><small>prev</small></a>
                        <a class="p-l-20"><small>next</small></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <h3 class="block-title">配置详情</h3>
            <div class="tile p-15">
                <form role="form">
                    <div class="form-group">
                        <label for="show_title">标题</label>
                        <input class="form-control input-sm" id="show_title" disabled>
                    </div>
                    <div class="form-group">
                        <label for="show_scope">范围描述</label>
                        <select class="select" id="show_scope" disabled>
                            <option value="0">联盟制式</option>
                            <option value="1">军团制式</option>
                            <option value="2">小队制式</option>
                            <option value="3">个人秀</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="show_scope">性质描述</label>
                        <select class="select " id="show_type" disabled>
                            <option value="0">PVP</option>
                            <option value="1">PVE</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="show_scope">特征描述</label>
                        <select data-placeholder="Select Functions..." class="tag-select-limited" multiple id="show_tag"
                                disabled>
                            <option value="抓人">抓人</option>
                            <option value="做点">做点</option>
                            <option value="特种">特种</option>
                            <option value="侦查">侦查</option>
                            <option value="火力">火力</option>
                            <option value="电子">电子</option>
                            <option value="奶妈">奶妈</option>
                            <option value="刷怪">刷怪</option>
                            <option value="任务">任务</option>
                            <option value="土壕">土壕</option>
                            <option value="新人友好">新人友好</option>
                            <option value="其它">其它</option>
                        </select>
                    </div>
                    <label>图</label>
                    <div id="show_img" class="p-l-10">
                        <img src="" alt="" width="100%">
                    </div>
                    <label>不可描述的描述</label>
                    <div id="show_content"></div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Library -->
<script src="js/jquery-ui.min.js"></script>
<!-- jQuery UI -->

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!--  Form Related -->
<script src="js/validation/validate.min.js"></script>
<!-- jQuery Form Validation Library -->
<script src="js/validation/validationEngine.min.js"></script>
<!-- jQuery Form Validation Library - requirred with above js -->
<script src="js/select.min.js"></script>
<!-- Custom Select -->
<script src="js/chosen.min.js"></script>
<!-- Custom Multi Select -->
<script src="js/datetimepicker.min.js"></script>
<!-- Date & Time Picker -->
<script src="js/colorpicker.min.js"></script>
<!-- Color Picker -->
<script src="js/icheck.js"></script>
<!-- Custom Checkbox + Radio -->
<script src="js/autosize.min.js"></script>
<!-- Textare autosize -->
<script src="js/toggler.min.js"></script>
<!-- Toggler -->
<script src="js/input-mask.min.js"></script>
<!-- Input Mask -->
<script src="js/spinner.min.js"></script>
<!-- Spinner -->
<script src="js/slider.min.js"></script>
<!-- Input Slider -->
<script src="js/fileupload.min.js"></script>
<!-- File Upload -->

<!-- Text Editor -->
<script src="js/editor2.min.js"></script>
<!-- WYSIWYG Editor -->
<script src="js/markdown.min.js"></script>
<!-- Markdown Editor -->

<!-- UX -->
<script src="js/scroll.min.js"></script>
<!-- Custom Scrollbar -->

<!-- Other -->
<script src="js/calendar.min.js"></script>
<!-- Calendar -->
<script src="js/feeds.min.js"></script>
<!-- News Feeds -->

<!-- All JS functions -->
<script src="js/functions.js"></script>

<!-- All JS functions -->
<script src="js/myJs/commonFunction.js"></script>
<script src="js/myJs/iframeFunction.js"></script>
<script src="js/myJs/shipAssemblyFunctions.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        /* Tag Select */
        (function () {
            /* Overflow */
            $('.overflow').niceScroll();
            $("#show_tag").chosen({
                max_selected_options: 3
            });
        })();


        (function () {
            parent.setMainIframeHeight();
            $listPageFun.createList(1, null);
        })();

    });
</script>
</body>
</html>

