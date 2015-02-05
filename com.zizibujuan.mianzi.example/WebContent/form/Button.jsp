<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Button</title>
<script type="text/javascript" src="../js/requirejs/require.js"></script>
<script type="text/javascript">
require.config({
    baseUrl: "../js/"
});
require(["deliteful-build/layer"], function () {
    require([
        "delite/register",
        "deliteful/Button"
    ], function (register){
        register.parse();
        document.body.style.display = "";
    });
});
</script>
</head>
<body>
<button is="d-button">I am a Button!</button>
<mz:Button label="按钮"/>
</body>
</html>