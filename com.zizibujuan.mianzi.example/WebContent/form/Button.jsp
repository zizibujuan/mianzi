<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="Button"/>
<mz:Body>
	<mz:Button label="按钮"/>
</mz:Body>

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
</html>

