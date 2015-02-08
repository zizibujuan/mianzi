<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="Select"/>
<mz:Body>

<mz:Store id="store1">
	{"text": "Option 1", "value": "1"},
	{"text": "Option 2", "value": "2"},
	{"text": "Option 3", "value": "3", "disabled":true}
</mz:Store>

单选
<mz:Select name="select1" store="store1"></mz:Select>

多选
<mz:Select name="select2" store="store1" multiple="true"></mz:Select>

<mz:Store id="store2">
	{"t": "Option 1", "v": "1"},
	{"t": "Option 2", "v": "2"},
	{"t": "Option 3", "v": "3", "d":true}
</mz:Store>
自定义labelAttr, valueAttr, disabledAttr
<mz:Select name="select3" store="store2" textAttr="t" valueAttr="v" disabledAttr="d"></mz:Select>

</mz:Body>

<script type="text/javascript">
require.config({
    baseUrl: "../js/"
});
require(["deliteful-build/layer"], function () {
    require([
        "delite/register",
        "deliteful/Store", 
        "deliteful/Select",
        "requirejs-domready/domReady!"
    ], function (register){
        register.parse();
        document.body.style.display = "";
    });
});
</script>
</html>

