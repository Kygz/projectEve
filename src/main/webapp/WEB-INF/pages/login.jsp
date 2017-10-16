<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
		<link rel="Shortcut Icon" href="../../favicon.ico" />
        <title>米氏非正常人类集散地</title>
            
        <!-- CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/form.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/generics.css" rel="stylesheet"> 
    </head>
    <body id="skin-blur-eve3">
        <section id="login">
            <header>
                <h1>米氏非正常人类研究院</h1>
                <p>此处有NB标语一行，然而我不知道写啥...</p>
            </header>
        
            <div class="clearfix"></div>
            
            <!-- Login -->
            <form class="box tile animated active" id="box-login" action="login.do?method=login" method="post">
                <h2 class="m-t-0 m-b-15">登陆</h2>
                <input id="xxx" name = "name" type="text" class="login-control m-b-10" placeholder="输入帐号" value="">
                <input name = "password" type="password" class="login-control" placeholder="输入密码">
                <div class="checkbox m-b-20">
                    <p>${error}<p>
                    <!-- 
                    <label>
                        <input name = "saveAccount" type="checkbox">记住帐号
                    </label>
                     -->
                </div>
                <button class="btn btn-sm m-r-5">登陆</button>
                
                <small>
                    <a class="box-switcher" data-switch="box-register" href="">还没25？</a> 还是...
                    <a class="box-switcher" data-switch="box-reset" href="">忘记密码？</a>
                </small>
            </form>
            
            <!-- Register -->
            <form class="box animated tile form-validation" id="box-register" onsubmit="return false;">
                <h2 class="m-t-0 m-b-15">注册</h2>
                <input id="reg_name" type="text" class="login-control m-b-10 validate[required]" placeholder="帐号">
                <input id="reg_nickName" type="text" class="login-control m-b-10 validate[required]" placeholder="用户名">
                <input id="reg_pwd" type="password" class="login-control m-b-10 validate[required]" placeholder="密码">
                <input id="reg_pwd1" type="password" class="login-control m-b-20 validate[required]" placeholder="重复密码">
                <input id="reg_qq" type="text" class="login-control m-b-10 validate[required]" placeholder="QQ正身">
                <input id="reg_mail" type="text" class="login-control m-b-10 validate[required]" placeholder="邮箱">
                <span id="registerButton" class="btn btn-sm m-r-5">注册</span>

                <small><a class="box-switcher" data-switch="box-login" href="" id="backToLogin">已有帐户？</a></small>
            </form>
            
            <!-- Forgot Password -->
            <form class="box animated tile" id="box-reset">
                <h2 class="m-t-0 m-b-15">忘记密码</h2>
                <p>功能暂未开放，请带上新鲜妹子联系程序猿...</p>
                <input type="email" class="login-control m-b-20" placeholder="Email Address">    

                <button class="btn btn-sm m-r-5">重置密码</button>

                <small><a class="box-switcher" data-switch="box-login" href="">已有帐户？</a></small>
            </form>
        </section>                      
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->
        
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        
        <!--  Form Related -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        <!--  Form Related -->
        <script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
        <script src="js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
        <script src="js/myJs/commonFunction.js"></script>
        <script>
            $(document).ready(function() {
                $("#registerButton").click(function () {
                    var eventForm = $("box-register");
                    eventForm.validationEngine('validate');
                    if (!(eventForm).find('.formErrorContent')[0]) {
                        alert("可注册");
                        var reg_name = $("#reg_name").val();
                        var reg_nickName = $("#reg_nickName").val();
                        var reg_pwd = $("#reg_pwd").val();
                        var reg_pwd1 = $("#reg_pwd1").val();
                        var reg_qq = $("#reg_qq").val();
                        var reg_mail = $("#reg_mail").val();

                        var data = {
                            reg_name : reg_name,
                            reg_nickName : reg_nickName,
                            reg_pwd : reg_pwd,
                            reg_pwd1 : reg_pwd1,
                            reg_qq : reg_qq,
                            reg_mail : reg_mail
                        };
                        $.ajax({
                            url: "member.do?method=welcomeToMI",
                            async: false,
                            type: "POST",
                            dataType: "json",
                            data: data,
                            success: function (rv) {
                                $message.alert({
                                    title: "注册信息",
                                    msg: "<p>" + rv.msg + "</p>"
                                });
                                $("#backToLogin").click();
                            },
                            error : function (rv) {
                                $message.alert({
                                    title: "注册信息",
                                    msg: "<p>" + "失败!" + "</p>"
                                });
                            }
                        });
                    }
                })
            });
        </script>
    </body>
</html>
