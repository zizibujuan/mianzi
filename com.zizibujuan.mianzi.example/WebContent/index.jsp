<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/requirejs/require.js"></script>
<script type="text/javascript">
require.config({
    baseUrl: "js/"
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
form控件
<a href="form/Button.jsp">按钮</a>
</body>
</html>