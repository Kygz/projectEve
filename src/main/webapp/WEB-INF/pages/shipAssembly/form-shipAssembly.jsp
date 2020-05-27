<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>舰船装配提交页面</title>

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
    <%--    <h4 class="page-title">舰船装配上传</h4>--%>
    <!-- Custom Select -->
    <div class="block-area" id="uploadDiv">

        <h3 class="block-title">没有什么是一个官员盖伦特藤椒炸鸡腿搞不定的，如果有，那就来两个</h3>
        <br/>
        <div class="row">
            <form id="uploadForm" class="form-validation" role="form" onsubmit="return false;">
                <div class="col-md-12 m-b-15">
                    <label>标题</label>
                    <input type="text" class="input-sm form-control" id="ship_title" placeholder="">
                </div>
                <div class="col-md-3 m-b-15">
                    <label>舰<span style="text-decoration: line-through">船</span>娘名称</label>
                    <select class="select" id="ship_name">
                        <option value="0" selected>未知</option>
                        <c:forEach items="${shipList}" var="ship">
                            <option value="${ship.id}">${ship.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-3 m-b-15">
                    <label>范围描述</label>
                    <select class="select" id="ship_scope">
                        <option value="0" selected>联盟制式</option>
                        <option value="1">军团制式</option>
                        <option value="2">小队制式</option>
                        <option value="3">个人秀</option>
                    </select>
                </div>
                <div class="col-md-3 m-b-15">
                    <label>性质描述</label>
                    <select class="select " id="ship_type">
                        <option value="0" selected>PVP</option>
                        <option value="1">PVE</option>
                    </select>
                </div>
                <div class="col-md-3 m-b-15">
                    <label>特征描述</label>
                    <select data-placeholder="Select Functions..." class="tag-select-limited" multiple id="ship_tag">
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
                        <option value="其它" selected>其它</option>
                    </select>
                </div>
                <div class="col-md-4 hidden">
                    <input id="c1" name="c1" type="hidden" value="">
<%--                    <input id="c2" name="c2" type="hidden" value="">--%>
<%--                    <input id="c3" name="c3" type="hidden" value="">--%>
<%--                    <input id="c4" name="c4" type="hidden" value="">--%>
                    <div class="tile" id="itemList">
                        <h2 class="tile-title">列表</h2>
                        <div class="listview" id="c1List">
                            <div class="media">
                                <div class="m-0"><label class="t-overflow">无</label></div>
                            </div>
                        </div>
<%--                        <h2 class="tile-title">中</h2>--%>
<%--                        <div class="listview" id="c2List">--%>
<%--                            <div class="media">--%>
<%--                                <div class="m-0"><label class="t-overflow">无</label></div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <h2 class="tile-title">高</h2>--%>
<%--                        <div class="listview" id="c3List">--%>
<%--                            <div class="media">--%>
<%--                                <div class="m-0"><label class="t-overflow">无</label></div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <h2 class="tile-title">其它</h2>--%>
<%--                        <div class="listview" id="c4List">--%>
<%--                            <div class="media">--%>
<%--                                <div class="m-0"><label class="t-overflow">无</label></div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                </div>
                <div class="col-md-4 m-b-15">
                    <label>装配图</label>
                    <div class="fileupload fileupload-new" data-provides="fileupload" id="ship_img">
                        <div class="fileupload-preview thumbnail form-control" style="width: 100%;height: 250px"></div>
                        <div>
                            <span class="btn btn-file btn-alt btn-sm">
                                <span class="fileupload-new">Select image</span>
                                <span class="fileupload-exists">Change</span>
                                <input type="file"/>
                            </span>
                            <a href="#" class="btn fileupload-exists btn-sm" data-dismiss="fileupload">Remove</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-8 m-b-15">
                    <label>描述</label>
                    <div class="wysiwye-editor" id="ship_desc"></div>
                </div>
                <div class="col-md-12">
                    <input class="input-sm form-control" id="importFromGame" readonly>从游戏中导入</input>
                </div>
                <div class="col-md-12 m-b-15">
                    <button class="btn btn-sm m-r-5" id="submitPlanet" onclick="submitShipAssembly()">配置上传</button>
                </div>
            </form>
        </div>
    </div>
</section>

<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="js/jquery.min.js"></script> <!-- jQuery Library -->
<script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->

<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>

<!--  Form Related -->
<script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
<script src="js/validation/validationEngine.min.js"></script>
<!-- jQuery Form Validation Library - requirred with above js -->
<script src="js/select.min.js"></script> <!-- Custom Select -->
<script src="js/chosen.min.js"></script> <!-- Custom Multi Select -->
<script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
<script src="js/colorpicker.min.js"></script> <!-- Color Picker -->
<script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
<script src="js/autosize.min.js"></script> <!-- Textare autosize -->
<script src="js/toggler.min.js"></script> <!-- Toggler -->
<script src="js/input-mask.min.js"></script> <!-- Input Mask -->
<script src="js/spinner.min.js"></script> <!-- Spinner -->
<script src="js/slider.min.js"></script> <!-- Input Slider -->
<script src="js/fileupload.min.js"></script> <!-- File Upload -->

<!-- Text Editor -->
<script src="js/editor2.min.js"></script> <!-- WYSIWYG Editor -->
<script src="js/markdown.min.js"></script> <!-- Markdown Editor -->

<!-- UX -->
<script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<!-- Other -->
<script src="js/calendar.min.js"></script> <!-- Calendar -->
<script src="js/feeds.min.js"></script> <!-- News Feeds -->


<!-- All JS functions -->
<script src="js/myJs/commonFunction.js"></script>
<script src="js/functions.js"></script>
<script src="js/myJs/iframeFunction.js"></script>
<script src="js/myJs/shipAssemblyFunctions.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        /* Tag Select */
        (function () {
            /* select 下拉选标签 Limited 初始化*/
            $("#ship_tag").chosen({
                max_selected_options: 3
            });
            //$("#ship_keyWord").trigger("liszt:updated");
            /* Overflow */
            $('.overflow').niceScroll();
        })();

        /* TEST按钮事件 */
        (function () {
            parent.setMainIframeHeight();
            $('#importFromGame').bind('paste', function (e) {
                var _t = e.originalEvent.clipboardData.getData('Text');
                getFromClipBoard(_t);
            });
        })();
    });
</script>

</body>
</html>

