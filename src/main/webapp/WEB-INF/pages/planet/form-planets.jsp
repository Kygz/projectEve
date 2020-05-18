<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
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
<%--    <h4 class="page-title">行星开发</h4>--%>
    <!-- planetTable -->
    <div class="block-area" id="tableStriped">
        <h3 class="block-title">Last Five</h3>
        <div class="table-responsive overflow">
            <table id="lastFiveTable" class="tile table table-bordered table-striped">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>氧</th>
                    <th>电解物</th>
                    <th>水</th>
                    <th>稀有金属</th>
                    <th>有毒金属</th>
                    <th>反应金属</th>
                    <th>手性结构</th>
                    <th>时间</th>
                    <th>价格</th>
                </tr>
                </thead>
                <tbody id="list">
                </tbody>
            </table>
        </div>
    </div>
    <!-- spinner -->
    <div class="block-area" id="spinner">
        <h3 class="block-title">行星产物记录表</h3>
        <br/>
        <!-- 氧   -->
        <div class="col-md-4 m-b-15">
            <p>氧</p>
            <div class="p-relative">
                <input id="planet1" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 电解物   -->
        <div class="col-md-4 m-b-15">
            <p>电解物</p>
            <div class="p-relative">
                <input id="planet2" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 水   -->
        <div class="col-md-4 m-b-15">
            <p>水</p>
            <div class="p-relative">
                <input id="planet3" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 稀有金属   -->
        <div class="col-md-4 m-b-15">
            <p>稀有金属</p>
            <div class="p-relative">
                <input id="planet4" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 有毒金属   -->
        <div class="col-md-4 m-b-15">
            <p>有毒金属</p>
            <div class="p-relative">
                <input id="planet5" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 反应金属   -->
        <div class="col-md-4 m-b-15">
            <p>反应金属</p>
            <div class="p-relative">
                <input id="planet6" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
        <!-- 手性结构   -->
        <div class="col-md-4 m-b-15">
            <p>手性结构</p>
            <div class="p-relative">
                <input id="planet7" class="form-control input-sm spinner-1 spinedit"/>
            </div>
        </div>
    </div>
    <div class="block-area">
        <button class="btn btn-sm m-r-5" id="submitPlanet">提交产物</button>
    </div>
    <hr class="whiter m-t-20"/>
    <div>
        <a id='submitAlert' data-toggle='modal' href='#successAlertDiv' class='btn btn-sm' style='display: none;'>你看不见我
            看不见我</a>
        <div class='modal fade' id='successAlertDiv' tabindex='-1' role='dialog' aria-hidden='true'
             style='display: none;'>
            <div class='modal-dialog'>
                <div class='modal-content'>
                    <div class='modal-header'>
                        <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>
                        <h4 class='modal-title'>Submit Result</h4>
                    </div>
                    <div class='modal-body'>
                        <p></p>
                    </div>
                    <div class='modal-footer'>
                        <%--<button type='button' class='btn btn-sm'>确定</button>--%>
                        <button type='button' class='btn btn-sm' data-dismiss='modal'>确定</button>
                    </div>
                </div>
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
<script src="js/myJs/planetFunction.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        /* Tag Select */
        (function () {
            /* Overflow */
            $('.overflow').niceScroll();
        })();

        /* Input Masking - you can include your own way */
        (function () {

        })();

        /* Spinners */
        (function () {
            $('.spinner-1').spinedit('setMaximum', 2000000);
            $("input[id^='planet']").val(0);
        })();

        /* 提交按钮事件 */
        (function () {
            $('#submitPlanet').on('click', function () {
                submitPlanetFunction();
            });
        })();

        /* TEST按钮事件 */
        (function () {
            parent.setMainIframeHeight();
            getPlanetTable();
        })();
    });
</script>

</body>
</html>

