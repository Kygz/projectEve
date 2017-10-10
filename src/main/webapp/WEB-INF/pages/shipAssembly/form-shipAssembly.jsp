<%@taglib prefix="planet" uri="/planetTaglib" %>
<%@taglib prefix="eve" uri="/indexTaglib" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
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
    <body id="${sessionScope.member.member_skin}">
    <header id="header" class="media">
        <a href="" id="menu-toggle"></a>
        <a class="logo pull-left" href="/login.do?method=index">米氏非正常人类研究院</a>

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
                <eve:messagesDrawer/>
                <!-- Notification Drawer -->
                <eve:notificationDrawer/>
                
                <!-- Breadcrumb -->
                <ol class="breadcrumb hidden-xs">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Library</a></li>
                    <li class="active">Data</li>
                </ol>
                
                <h4 class="page-title">舰船装配上传</h4>
                
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
                            <div class="col-md-6 m-b-15">
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
                            <div class="col-md-12 m-b-15">
                                <button class="btn btn-sm m-r-5" id="submitPlanet" onclick="submitShipAssembly()">配置上传</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </section>
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->
        <script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->
        
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        
        <!--  Form Related -->
        <script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
        <script src="js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
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
        <script src="js/myJs/shipAssemblyFunctions.js"></script>

        <script type="text/javascript">
            $(document).ready(function(){
                /* Tag Select */
                (function(){
                    /* select 下拉选标签 Limited 初始化*/
                    $("#ship_tag").chosen({
                        max_selected_options: 3
                    });
                    //$("#ship_keyWord").trigger("liszt:updated");
                    /* Overflow */
                    $('.overflow').niceScroll();
                })();
            });
        </script>

    </body>
</html>

