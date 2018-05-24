<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script type="text/javascript">
        function doLogin(){
            var password = $("#password").val();
            if(password == null || password == ""){
                $("#error").hide();
                $("#empty").show();
            } else {
                $.ajax({
                    type: "get",
                    url: "/login.do?password=" + password,
                    dataType: "text",
                    async: false,
                    success: function (data) {
                        if(data == "true"){
                            window.location.href = "/listpage.do";
                        } else {
                            $("#empty").hide();
                            $("#error").show();
                        }
                    },
                });

            }
        }
    </script>

</head>
<body>
    <div class="container">
        <h2 style="text-align: center;margin-top: 70px;">小喇叭后台管理</h2>
        <div class="row" style="text-align: center; margin-top: 120px;">
            <div class="span3 offset4">
                <input type="text" name="password" id="password" placeholder="输入密码" style="height: 35px;"/>
            </div>
            <div class="span1">
                <input type="button" id="login" value="登录" onclick="doLogin();" class="btn btn-primary btn-large"/>
            </div>
        </div>
        <div class="row" style="display: none;" id="error">
            <div class="offset4">
                <p style="color: red; font-size: larger;">输入密码错误</p>
            </div>
        </div>
        <div class="row" style="display: none;" id="empty">
            <div class="offset4">
                <p style="color: red; font-size: larger;">密码不能为空</p>
            </div>
        </div>
    </div>
</body>
</html>

