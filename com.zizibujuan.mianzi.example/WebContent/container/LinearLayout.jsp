<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="LinearLayout"/>
<mz:Body>
	<style>
	.red { background-color: #D9534F; }
	.blue { background-color: #5BC0DE; }
	.green { background-color: #5CB85C;}
	</style>
	<mz:LinearLayout height="100%" width="100%">
		<div class="blue" style="width: 20%; ">Left (20%)</div>
    	<div class="fill green">Center (Fill Space)</div>
    	<div class="red" style="width: 50px">Right (50px)</div>
	</mz:LinearLayout>
</mz:Body>

<script type="text/javascript">
require.config({
    baseUrl: "../js/"
});
require(["deliteful-build/layer"], function () {
    require([
        "delite/register",
        "deliteful/LinearLayout"
    ], function (register){
        register.parse();
        document.body.style.display = "";
    });
});
</script>
</html>

