<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="Checkbox"/>
<mz:Body>
	<label><mz:Checkbox name="option1" checked="true"/>选中</label>
	<label><mz:Checkbox name="option2"/>未选中</label>
	<label><mz:Checkbox name="option3" disabled="true"/>失效</label>
</mz:Body>

<script type="text/javascript">
require.config({
    baseUrl: "../js/"
});
require(["deliteful-build/layer"], function () {
    require([
        "delite/register",
        "deliteful/Checkbox"
    ], function (register){
        register.parse();
        document.body.style.display = "";
    });
});
</script>
</html>

