<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/css/cssBootStrap.jsp"%>
<meta http-equiv="Refresh" content="3;url=${pageContext.request.contextPath}/sys/home">
<script>
    function myFunction() {
        var odiv = document.getElementById('odiv');
        var d = new Date();
        var t = d.toLocaleTimeString();
        odiv.innerText = t;
    }
    (function () {
        setInterval("myFunction()", 1);
    }());
</script>
<html>
<body class="nav-md">
<div class="container body">
    <div class="main_container" style="margin-top:40px;">
        <div class="col-md-3 left">
            <label class="label-default label">left</label>
        </div>

        <div class="right col-md-9">
            <span class="span1">正在跳转中 time:</span><label id="odiv" class="label label-danger"/>
        </div>
    </div>
</div>
</body>
</html>
