<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
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
<body id="${sessionScope.member.member_skin}">
	<header id="header" class="media">
		<a href="" id="menu-toggle"></a> <a class="logo pull-left"
			href="../../DEMO/index.html">米氏非正常人类研究院</a>

		<div class="media-body">
			<div class="media" id="top-menu">
				<div class="pull-left tm-icon">
					<a data-drawer="messages" class="drawer-toggle" href=""> <i
						class="sa-top-message"></i> <i class="n-count animated">5</i> <span>舰长邮件</span>
					</a>
				</div>
				<div class="pull-left tm-icon">
					<a data-drawer="notifications" class="drawer-toggle" href=""> <i
						class="sa-top-updates"></i> <i class="n-count animated">9</i> <span>消息更新</span>
					</a>
				</div>
				<!-- 时间栏 -->
				<div id="time" class="pull-right">
					<span id="hours"></span>:<span id="min"></span>:<span id="sec"></span>
				</div>
				<!-- 搜索栏 -->
				<div class="media-body">
					<input type="text" class="main-search">
				</div>
			</div>
		</div>
	</header>

	<div class="clearfix"></div>

	<section id="main" class="p-relative" role="main">
		<!-- Sidebar -->
		<aside id="sidebar">
			<!-- Sidbar Widgets -->
			<div class="side-widgets overflow">
				<!-- Profile Menu -->
				<eve:showProfileMenu userName="${sessionScope.member.member_nickname}" qqNum="${sessionScope.member.member_qq}"/>
				<!-- Calendar -->
				<div class="s-widget m-b-25">
					<div id="sidebar-calendar"></div>
				</div>
				<%--舰长六维--%>
				<eve:showTheSix para1="7" para2="4" para3="6" para4="8" para5="2" para6="3"/>
			</div>
			<!-- Side Menu -->
			<eve:showSideMenu />
		</aside>
		<!-- Content -->
		<section id="content" class="container">
			<!-- Messages Drawer -->
			<div id="messages" class="tile drawer animated">
				<div class="listview narrow">
					<div class="media">
						<a href="">Send a New Message</a> <span class="drawer-close">&times;</span>
					</div>
					<div class="overflow" style="height: 254px">
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/1.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
								<a class="t-overflow" href="">Mauris consectetur urna nec
									tempor adipiscing. Proin sit amet nisi ligula. Sed eu
									adipiscing lectus</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/2.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">David Villa - 5 Hours ago</small><br>
								<a class="t-overflow" href="">Suspendisse in purus ut nibh
									placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
									pharetra</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/3.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Harris worgon - On 15/12/2013</small><br>
								<a class="t-overflow" href="">Maecenas venenatis enim
									condimentum ultrices fringilla. Nulla eget libero rhoncus,
									bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
									ornare turpis id</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/4.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Mitch Bradberry - On
									14/12/2013</small><br> <a class="t-overflow" href="">Phasellus
									interdum felis enim, eu bibendum ipsum tristique vitae.
									Phasellus feugiat massa orci, sed viverra felis aliquet quis.
									Curabitur vel blandit odio. Vestibulum sagittis quis sem sit
									amet tristique.</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/1.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
								<a class="t-overflow" href="">Ipsum wintoo consectetur urna
									nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu
									adipiscing lectus</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/2.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">David Villa - On 16/12/2013</small><br>
								<a class="t-overflow" href="">Suspendisse in purus ut nibh
									placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
									pharetra</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/3.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Harris worgon - On 17/12/2013</small><br>
								<a class="t-overflow" href="">Maecenas venenatis enim
									condimentum ultrices fringilla. Nulla eget libero rhoncus,
									bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
									ornare turpis id</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/4.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Mitch Bradberry - On
									18/12/2013</small><br> <a class="t-overflow" href="">Phasellus
									interdum felis enim, eu bibendum ipsum tristique vitae.
									Phasellus feugiat massa orci, sed viverra felis aliquet quis.
									Curabitur vel blandit odio. Vestibulum sagittis quis sem sit
									amet tristique.</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/5.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Wendy Mitchell - On 19/12/2013</small><br>
								<a class="t-overflow" href="">Integer a eros dapibus,
									vehicula quam accumsan, tincidunt purus</a>
							</div>
						</div>
					</div>
					<div class="media text-center whiter l-100">
						<a href=""><small>VIEW ALL</small></a>
					</div>
				</div>
			</div>

			<!-- Notification Drawer -->
			<div id="notifications" class="tile drawer animated">
				<div class="listview narrow">
					<div class="media">
						<a href="">Notification Settings</a> <span class="drawer-close">&times;</span>
					</div>
					<div class="overflow" style="height: 254px">
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/1.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Nadin Jackson - 2 Hours ago</small><br>
								<a class="t-overflow" href="">Mauris consectetur urna nec
									tempor adipiscing. Proin sit amet nisi ligula. Sed eu
									adipiscing lectus</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/2.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">David Villa - 5 Hours ago</small><br>
								<a class="t-overflow" href="">Suspendisse in purus ut nibh
									placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
									pharetra</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/3.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Harris worgon - On 15/12/2013</small><br>
								<a class="t-overflow" href="">Maecenas venenatis enim
									condimentum ultrices fringilla. Nulla eget libero rhoncus,
									bibendum diam eleifend, vulputate mi. Fusce non nibh pulvinar,
									ornare turpis id</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/4.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Mitch Bradberry - On
									14/12/2013</small><br> <a class="t-overflow" href="">Phasellus
									interdum felis enim, eu bibendum ipsum tristique vitae.
									Phasellus feugiat massa orci, sed viverra felis aliquet quis.
									Curabitur vel blandit odio. Vestibulum sagittis quis sem sit
									amet tristique.</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/1.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">Nadin Jackson - On 15/12/2013</small><br>
								<a class="t-overflow" href="">Ipsum wintoo consectetur urna
									nec tempor adipiscing. Proin sit amet nisi ligula. Sed eu
									adipiscing lectus</a>
							</div>
						</div>
						<div class="media">
							<div class="pull-left">
								<img width="40" src="img/profile-pics/2.jpg" alt="">
							</div>
							<div class="media-body">
								<small class="text-muted">David Villa - On 16/12/2013</small><br>
								<a class="t-overflow" href="">Suspendisse in purus ut nibh
									placerat Cras pulvinar euismod nunc quis gravida. Suspendisse
									pharetra</a>
							</div>
						</div>
					</div>
					<div class="media text-center whiter l-100">
						<a href=""><small>VIEW ALL</small></a>
					</div>
				</div>
			</div>

			<!-- Breadcrumb -->
			<ol class="breadcrumb hidden-xs">
				<li><a href="#">Home</a></li>
				<li><a href="#">Library</a></li>
				<li class="active">Data</li>
			</ol>

			<h4 class="page-title">行星开发</h4>
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
						<tbody>
						<tr>
							<td>1</td>
							<th>氧</th>
							<th>电解物</th>
							<th>水</th>
							<th>稀有金属</th>
							<th>有毒金属</th>
							<th>反应金属</th>
							<th>手性结构</th>
							<td>data</td>
							<td>10000isk</td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- spinner -->
			<div class="block-area" id="spinner">
				<h3 class="block-title">行星产物记录表</h3>
				<br />
				<!-- 氧   -->
				<div class="col-md-4 m-b-15">
					<p>氧</p>
					<div class="p-relative">
						<input id="planet1" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 电解物   -->
				<div class="col-md-4 m-b-15">
					<p>电解物</p>
					<div class="p-relative">
						<input id="planet2" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 水   -->
				<div class="col-md-4 m-b-15">
					<p>水</p>
					<div class="p-relative">
						<input id="planet3" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 稀有金属   -->
				<div class="col-md-4 m-b-15">
					<p>稀有金属</p>
					<div class="p-relative">
						<input id="planet4" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 有毒金属   -->
				<div class="col-md-4 m-b-15">
					<p>有毒金属</p>
					<div class="p-relative">
						<input id="planet5" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 反应金属   -->
				<div class="col-md-4 m-b-15">
					<p>反应金属</p>
					<div class="p-relative">
						<input id="planet6" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
				<!-- 手性结构   -->
				<div class="col-md-4 m-b-15">
					<p>手性结构</p>
					<div class="p-relative">
						<input id="planet7" type="text"
							class="form-control input-sm spinner-1 spinedit" />
					</div>
				</div>
			</div>
			<div class="block-area">
				<button class="btn btn-sm m-r-5" id="submitPlanet" >提交产物</button>
				<%--<button class="btn btn-sm m-r-5" id="TESTPlanet" >TEST</button>--%>
		    </div>
			<hr class="whiter m-t-20" />

		</section>
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
	<script src="js/myJs/planetFunction.js"></script>
	<script type="text/javascript">
            $(document).ready(function(){
                /* Tag Select */
                (function(){
                    /* Overflow */
                    $('.overflow').niceScroll();
                })();
                
                /* Input Masking - you can include your own way */
                (function(){
       
                })();
                
                /* Spinners */
                (function(){
                    $('.spinner-1').spinedit('setMaximum', 2000000);
                })();
                
                /* 提交按钮事件 */
                (function(){
                	$('#submitPlanet').on('click', function() {
                		submitPlanetFunction();
                	});
                })();

                /* TEST按钮事件 */
                (function(){
					getPlanetTable();
                })();
            });
        </script>

</body>
</html>
