<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
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
	<!-- planetTable -->
	<div class="block-area" id="tableStriped">
		<h3 class="block-title">上限5个（BETA)</h3>
		<div class="table-responsive overflow">
			<table id="lastFiveTable" class="tile table table-bordered table-striped">
				<thead>
				<tr>
					<th>提醒时间</th>
					<th>内容</th>
					<th>邮箱</th>
					<th>状态</th>
					<th>反水</th>
				</tr>
				</thead>
				<tbody id="list">
				</tbody>
			</table>
		</div>
	</div>
	<!-- spinner -->
	<div class="block-area" id="spinner">
		<form onsubmit="return false;">
			<h3 class="block-title">技能到期提醒</h3>
			<br />
			<div class="col-md-4 m-b-15">
				<label>设置日期</label>
				<div class="input-icon datetime-pick date-only">
					<input id="input_day" data-format="yyyy-MM-dd" class="form-control input-sm validate[required]" type="text">
					<span class="add-on">
								<i class="sa-plus icon-calendar"></i>
							</span>
				</div>
			</div>
			<div class="col-md-4 m-b-15">
				<label>设置<font style="color: #d90004">提醒</font>时间</label>
				<div class="input-icon datetime-pick time-only">
					<input id="input_time" data-format="hh:mm:ss" class="form-control input-sm validate[required]" type="text">
					<span class="add-on">
								<i class="sa-plus icon-calendar"></i>
							</span>
				</div>
			</div>
			<div class="col-md-4 m-b-15">
				<label>设置提醒内容</label>
				<input id="input_content" class="form-control input-sm " placeholder="技能将要到期，请及时续一秒！" type="text">
			</div>
			<div class="col-md-12 m-b-15">
				<input id="submitMail" class="submit btn btn-sm" value="提交" type="button" onclick="submitMailFunction();">
			</div>
		</form>
	</div>
	<hr class="whiter m-t-20" />
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
<%--	<script src="js/calendar.min.js"></script>--%>
	<!-- Calendar -->
<%--	<script src="js/feeds.min.js"></script>--%>
	<!-- News Feeds -->


	<!-- All JS functions -->
<%--	<script src="js/functions.js"></script>--%>
	
	<!-- All JS functions -->
	<script src="js/myJs/commonFunction.js"></script>
	<script src="js/myJs/iframeFunction.js"></script>
	<script src="js/myJs/mailFunction.js"></script>

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

            /* TEST按钮事件 */
            (function () {
				parent.setMainIframeHeight();
				getMailTable();
            })();
        });
	</script>
</body>
</html>

