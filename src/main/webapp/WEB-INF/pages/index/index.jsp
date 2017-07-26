<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<link rel="Shortcut Icon" href="../../../favicon.ico" />
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
<!-- 顶栏 -->
	<header id="header" class="media">
		<a href="" id="menu-toggle"></a>
		<a class="logo pull-left" href="/login.do?method=index">米氏非正常人类研究院</a>

		<div class="media-body">
			<div class="media" id="top-menu">
				<div class="pull-left tm-icon">
					<a data-drawer="messages" class="drawer-toggle" href="">
						<i class="sa-top-message"></i> <i class="n-count animated">5</i> <span>舰长邮件</span>
					</a>
				</div>
				<div class="pull-left tm-icon">
					<a data-drawer="notifications" class="drawer-toggle" href="">
						<i class="sa-top-updates"></i> <i class="n-count animated">9</i> <span>消息更新</span>
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
				<!-- Feeds 
                    <div class="s-widget m-b-25">
                        <h2 class="tile-title">栏目待定</h2>
                        <div class="s-widget-body">
                            <div id="news-feed"></div>
                        </div>
                    </div> 
                    -->
				<%--舰长六维--%>
				<eve:showTheSix para1="7" para2="4" para3="6" para4="8" para5="2" para6="3"/>
			</div>
			<!-- Side Menu -->
			<eve:showSideMenu/>
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

			<h4 class="page-title">舰长室</h4>

			<!-- Shortcuts -->
			<div class="block-area shortcut-area">
				<a class="shortcut tile" href="http://www.ceve-market.org/index/">
					<img src="img/shortcuts/money.png" alt=""> <small
					class="t-overflow">国服市场中心</small>
				</a> <a class="shortcut tile" href="http://killboard.nl/cn/?a=home">
					<img src="img/shortcuts/stats.png" alt=""> <small
					class="t-overflow">老KB榜</small>
				</a> <a class="shortcut tile" href="http://kb.ceve-market.org/"> <img
					src="img/shortcuts/reports.png" alt=""> <small
					class="t-overflow">新KB榜</small>
				</a>
				<!-- 隐藏 
                    <a class="shortcut tile" href="">
                        <img src="img/shortcuts/twitter.png" alt="">
                        <small class="t-overflow">Tweets</small>
                    </a>
                    <a class="shortcut tile" href="">
                        <img src="img/shortcuts/calendar.png" alt="">
                        <small class="t-overflow">Calendar</small>
                    </a>
                    <a class="shortcut tile" href="">
                        <img src="img/shortcuts/connections.png" alt="">
                        <small class="t-overflow">Connection</small>
                    </a>
                    
                    -->
			</div>

			<hr class="whiter" />

			<!-- Quick Stats -->
			<div class="block-area">
				<div class="row">
					<div class="col-md-3 col-xs-6">
						<div class="tile quick-stats">
							<div id="stats-line-2" class="pull-left"></div>
							<div class="data">
								<h2 data-value="98">0</h2>
								<small>今日击杀</small>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-xs-6">
						<div class="tile quick-stats media">
							<div id="stats-line-3" class="pull-left"></div>
							<div class="media-body">
								<h2 data-value="1452">0</h2>
								<small>今日出货</small>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-xs-6">
						<div class="tile quick-stats media">

							<div id="stats-line-4" class="pull-left"></div>

							<div class="media-body">
								<h2 data-value="4896">0</h2>
								<small>今日出勤</small>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-xs-6">
						<div class="tile quick-stats media">
							<div id="stats-line" class="pull-left"></div>
							<div class="media-body">
								<h2 data-value="29356">0</h2>
								<small>今日宝剑</small>
							</div>
						</div>
					</div>

				</div>

			</div>

			<hr class="whiter" />

			<!-- Main Widgets -->

			<div class="block-area">
				<div class="row">
					<div class="col-md-8">
						<!-- Main Chart -->
						<div class="tile">
							<h2 class="tile-title">出勤</h2>
							<div class="tile-config dropdown">
								<a data-toggle="dropdown" href="" class="tile-menu"></a>
								<ul class="dropdown-menu pull-right text-right">
									<li><a class="tile-info-toggle" href="">Chart
											Information</a></li>
									<li><a href="">Refresh</a></li>
									<li><a href="">Settings</a></li>
								</ul>
							</div>
							<div class="p-10">
								<div id="line-chart" class="main-chart" style="height: 250px"></div>

								<div class="chart-info">
									<ul class="list-unstyled">
										<li class="m-b-10">本月出勤总计 <span
											class="pull-right text-muted t-s-0"> <i
												class="fa fa-chevron-up"></i>+12%
										</span>
										</li>
										<li><small>本月会战出勤 <span
												class="pull-right text-muted t-s-0"><i
													class="fa m-l-15 fa-chevron-down"></i>-8%</span>
										</small>
											<div class="progress progress-small">
												<div class="progress-bar progress-bar-warning"
													role="progressbar" aria-valuenow="40" aria-valuemin="0"
													aria-valuemax="100" style="width: 40%"></div>
											</div></li>
										<li><small>本月防卫出勤 <span
												class="pull-right text-muted t-s-0"> <i
													class="fa m-l-15 fa-chevron-up"></i>-3%
											</span>
										</small>
											<div class="progress progress-small">
												<div class="progress-bar progress-bar-info"
													role="progressbar" aria-valuenow="40" aria-valuemin="0"
													aria-valuemax="100" style="width: 60%"></div>
											</div></li>
									</ul>
								</div>
							</div>
						</div>

						<!-- Easy Pie Charts 仪表盘  Pies 氧 电解物 水 稀有金属 有毒金属 反应金属 手性结构 -->
						<div class="tile text-center">
							<div class="tile-dark p-10">
								<div class="pie-chart-tiny" data-percent="50" id="planet1">
									<span class="percent"></span> <span class="pie-title">氧
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet2">
									<span class="percent"></span> <span class="pie-title">电解物
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet3">
									<span class="percent"></span> <span class="pie-title">水
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet4">
									<span class="percent"></span> <span class="pie-title">稀有金属
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet5">
									<span class="percent"></span> <span class="pie-title">有毒金属
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet6">
									<span class="percent"></span> <span class="pie-title">反应金属
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
								<div class="pie-chart-tiny" data-percent="50" id="planet7">
									<span class="percent"></span> <span class="pie-title">手性结构
										<i class="m-l-5 fa fa-retweet"></i>
									</span>
								</div>
							</div>
						</div>

						<!--  Recent Postings -->
						<div class="row">
							<div class="col-md-6">
								<div class="tile">
									<h2 class="tile-title">Recent Postings</h2>
									<div class="tile-config dropdown">
										<a data-toggle="dropdown" href="" class="tile-menu"></a>
										<ul class="dropdown-menu animated pull-right text-right">
											<li><a href="">Refresh</a></li>
											<li><a href="">Settings</a></li>
										</ul>
									</div>

									<div class="listview narrow">
										<div class="media p-l-5">
											<div class="pull-left">
												<img width="40" src="img/profile-pics/1.jpg" alt="">
											</div>
											<div class="media-body">
												<small class="text-muted">2 Hours ago by Adrien San</small><br />
												<a class="t-overflow" href="">Cras molestie fermentum
													nibh, ac semper</a>

											</div>
										</div>
										<div class="media p-l-5">
											<div class="pull-left">
												<img width="40" src="img/profile-pics/2.jpg" alt="">
											</div>
											<div class="media-body">
												<small class="text-muted">5 Hours ago by David Villa</small><br />
												<a class="t-overflow" href="">Suspendisse in purus ut
													nibh placerat</a>

											</div>
										</div>
										<div class="media p-l-5">
											<div class="pull-left">
												<img width="40" src="img/profile-pics/3.jpg" alt="">
											</div>
											<div class="media-body">
												<small class="text-muted">On 15/12/2013 by Mitch
													bradberry</small><br /> <a class="t-overflow" href="">Cras
													pulvinar euismod nunc quis gravida. Suspendisse pharetra</a>

											</div>
										</div>
										<div class="media p-l-5">
											<div class="pull-left">
												<img width="40" src="img/profile-pics/4.jpg" alt="">
											</div>
											<div class="media-body">
												<small class="text-muted">On 14/12/2013 by Mitch
													bradberry</small><br /> <a class="t-overflow" href="">Cras
													pulvinar euismod nunc quis gravida. </a>

											</div>
										</div>
										<div class="media p-l-5">
											<div class="pull-left">
												<img width="40" src="img/profile-pics/5.jpg" alt="">
											</div>
											<div class="media-body">
												<small class="text-muted">On 13/12/2013 by Mitch
													bradberry</small><br /> <a class="t-overflow" href="">Integer
													a eros dapibus, vehicula quam accumsan, tincidunt purus</a>

											</div>
										</div>
										<div class="media p-5 text-center l-100">
											<a href=""><small>VIEW ALL</small></a>
										</div>
									</div>
								</div>
							</div>

							<!-- Tasks to do -->
							<div class="col-md-6">
								<div class="tile">
									<h2 class="tile-title">Tasks to do</h2>
									<div class="tile-config dropdown">
										<a data-toggle="dropdown" href="" class="tile-menu"></a>
										<ul class="dropdown-menu pull-right text-right">
											<li id="todo-add"><a href="">Add New</a></li>
											<li id="todo-refresh"><a href="">Refresh</a></li>
											<li id="todo-clear"><a href="">Clear All</a></li>
										</ul>
									</div>

									<div class="listview todo-list sortable">
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox">
													Curabitur quis nisi ut nunc gravida suscipis
												</label>
											</div>
										</div>
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox">
													Suscipit at feugiat dewoo
												</label>
											</div>

										</div>
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox">
													Gravida wendy lorem ipsum seen
												</label>
											</div>

										</div>
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox">
													Fedrix quis nisi ut nunc gravida suscipit at feugiat purus
												</label>
											</div>

										</div>
									</div>

									<h2 class="tile-title">Completed Tasks</h2>

									<div class="listview todo-list sortable">
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox"
													checked="checked"> Motor susbect win latictals bin
													the woodat cool
												</label>
											</div>

										</div>
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox"
													checked="checked"> Wendy mitchel susbect win
													latictals bin the woodat cool
												</label>
											</div>

										</div>
										<div class="media">
											<div class="checkbox m-0">
												<label class="t-overflow"> <input type="checkbox"
													checked="checked"> Latictals bin the woodat cool
													for the win
												</label>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="col-md-4">
						<!-- LQ Map -->
						<div class="tile" hidden>
							<h2 class="tile-title">地窖星图</h2>
							<div class="tile-config dropdown">
								<a data-toggle="dropdown" href="" class="tile-menu"></a>
								<ul class="dropdown-menu pull-right text-right">
									<li><a href="">Refresh</a></li>
									<li><a href="">Settings</a></li>
								</ul>
							</div>

							<div id="usa-map"></div>
						</div>

						<!-- Dynamic Chart -->
						<div class="tile">
							<h2 class="tile-title" hidden>待定</h2>
							<div class="tile-config dropdown">
								<a data-toggle="dropdown" href="" class="tile-menu"></a>
								<ul class="dropdown-menu pull-right text-right">
									<li><a href="">Refresh</a></li>
									<li><a href="">Settings</a></li>
								</ul>
							</div>

							<div class="p-t-10 p-r-5 p-b-5">
								<div id="dynamic-chart" style="height: 200px"></div>
							</div>

						</div>

						<!-- Activity -->
						<div class="tile" hidden>
							<h2 class="tile-title">Social Media activities</h2>
							<div class="tile-config dropdown">
								<a data-toggle="dropdown" href="" class="tile-menu"></a>
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
					<div class="clearfix"></div>
				</div>
			</div>

			<!-- Chat -->
			<div class="chat">

				<!-- Chat List -->
				<div class="pull-left chat-list">
					<div class="listview narrow">
						<div class="media">
							<img class="pull-left" src="img/profile-pics/1.jpg" width="30"
								alt="">
							<div class="media-body p-t-5">Alex Bendit</div>
						</div>
						<div class="media">
							<img class="pull-left" src="img/profile-pics/2.jpg" width="30"
								alt="">
							<div class="media-body">
								<span class="t-overflow p-t-5">David Volla Watkinson</span>
							</div>
						</div>
						<div class="media">
							<img class="pull-left" src="img/profile-pics/3.jpg" width="30"
								alt="">
							<div class="media-body">
								<span class="t-overflow p-t-5">Mitchell Christein</span>
							</div>
						</div>
						<div class="media">
							<img class="pull-left" src="img/profile-pics/4.jpg" width="30"
								alt="">
							<div class="media-body">
								<span class="t-overflow p-t-5">Wayne Parnell</span>
							</div>
						</div>
						<div class="media">
							<img class="pull-left" src="img/profile-pics/5.jpg" width="30"
								alt="">
							<div class="media-body">
								<span class="t-overflow p-t-5">Melina April</span>
							</div>
						</div>
						<div class="media">
							<img class="pull-left" src="img/profile-pics/6.jpg" width="30"
								alt="">
							<div class="media-body">
								<span class="t-overflow p-t-5">Ford Harnson</span>
							</div>
						</div>

					</div>
				</div>

				<!-- Chat Area -->
				<div class="media-body">
					<div class="chat-header">
						<a class="btn btn-sm" href=""> <i
							class="fa fa-circle-o status m-r-5"></i> Chat with Friends
						</a>
					</div>

					<div class="chat-body">
						<div class="media">
							<img class="pull-right" src="img/profile-pics/1.jpg" width="30"
								alt="" />
							<div class="media-body pull-right">
								Hiiii<br /> How you doing bro? <small>Me - 10 Mins ago</small>
							</div>
						</div>

						<div class="media pull-left">
							<img class="pull-left" src="img/profile-pics/2.jpg" width="30"
								alt="" />
							<div class="media-body">
								I'm doing well buddy. <br />How do you do? <small>David
									- 9 Mins ago</small>
							</div>
						</div>

						<div class="media pull-right">
							<img class="pull-right" src="img/profile-pics/2.jpg" width="30"
								alt="" />
							<div class="media-body">
								I'm Fine bro <br />Thank you for asking <small>Me - 8
									Mins ago</small>
							</div>
						</div>

						<div class="media pull-right">
							<img class="pull-right" src="img/profile-pics/2.jpg" width="30"
								alt="" />
							<div class="media-body">
								Any idea for a hangout? <small>Me - 8 Mins ago</small>
							</div>
						</div>

					</div>

					<div class="chat-footer media">
						<i class="chat-list-toggle pull-left fa fa-bars"></i> <i
							class="pull-right fa fa-picture-o"></i>
						<div class="media-body">
							<textarea class="form-control" placeholder="Type something..."></textarea>
						</div>
					</div>

				</div>
			</div>
		</section>

		<!-- Older IE Message -->
		<!--[if lt IE 9]>
                <div class="ie-block">
                    <h1 class="Ops">Ooops!</h1>
                    <p>You are using an outdated version of Internet Explorer, upgrade to any of the following web browser in order to access the maximum functionality of this website. </p>
                    <ul class="browsers">
                        <li>
                            <a href="https://www.google.com/intl/en/chrome/browser/">
                                <img src="img/browsers/chrome.png" alt="">
                                <div>Google Chrome</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.mozilla.org/en-US/firefox/new/">
                                <img src="img/browsers/firefox.png" alt="">
                                <div>Mozilla Firefox</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.opera.com/computer/windows">
                                <img src="img/browsers/opera.png" alt="">
                                <div>Opera</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://safari.en.softonic.com/">
                                <img src="img/browsers/safari.png" alt="">
                                <div>Safari</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://windows.microsoft.com/en-us/internet-explorer/downloads/ie-10/worldwide-languages">
                                <img src="img/browsers/ie.png" alt="">
                                <div>Internet Explorer(New)</div>
                            </a>
                        </li>
                    </ul>
                    <p>Upgrade your browser for a Safer and Faster web experience. <br/>Thank you for your patience...</p>
                </div>   
            <![endif]-->
	</section>

	<!-- Javascript Libraries -->
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Library -->
	<script src="js/jquery-ui.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Charts -->
	<script src="js/charts/jquery.flot.js"></script>
	<!-- Flot Main -->
	<script src="js/charts/jquery.flot.time.js"></script>
	<!-- Flot sub -->
	<script src="js/charts/jquery.flot.animator.min.js"></script>
	<!-- Flot sub -->
	<script src="js/charts/jquery.flot.resize.min.js"></script>
	<!-- Flot sub - for repaint when resizing the screen -->

	<script src="js/sparkline.min.js"></script>
	<!-- Sparkline - Tiny charts -->
	<script src="js/easypiechart.js"></script>
	<!-- EasyPieChart - Animated Pie Charts -->
	<script src="js/charts.js"></script>
	<!-- All the above chart related functions -->

	<!-- Map -->
	<script src="js/maps/jvectormap.min.js"></script>
	<!-- jVectorMap main library -->
	<script src="js/maps/usa.js"></script>
	<!-- USA Map for jVectorMap -->

	<!--  Form Related -->
	<script src="js/icheck.js"></script>
	<!-- Custom Checkbox + Radio -->

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
	
	<!-- 首页初始化方法汇总 -->
	<script src="js/myJs/indexFunction.js"></script>
	
	<script type="text/javascript">
		$(function() {
			var name = "${sessionScope.member}";
			if (name == null || name == "") {
				alert("请先登陆！");
				window.location.href = "login.do?method=logout";
			}
			//行星开发初始化
			ajaxQueryPlanetSection();
		});
	</script>
</body>
</html>
