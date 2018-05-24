<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DownloadPage</title>
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            var url = $("#downloadUrl").val();
            if(url != null && url != ""){
                window.location.href=url;
            }
        };
    </script>
</head>
<body>
    下载码: ${key}<br>
    状态:
    <c:if test="${status == 0}">下载成功</c:if>
    <c:if test="${status == 1}">下载码已使用</c:if>
    <c:if test="${status == 2}">下载失败</c:if>
    <c:if test="${status == 9}">下载码无效</c:if>

    <input type="hidden" id="downloadUrl" name="downloadUrl" value="${downloadUrl}" />
</body>
</html>
