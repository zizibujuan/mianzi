<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="Store"/>
<mz:Body>
	<mz:Store id="store1">
	{"label": "value1"},
	{"label": "value2"}
	</mz:Store>
	
	<d-combobox autoFilter="true">
		<d-list righttextAttr="sales" store="store1"></d-list>
	</d-combobox>
	
	<mz:Store id="store2" dataSource="list"></mz:Store>
	<d-combobox autoFilter="true">
		<d-list righttextAttr="sales" store="store2"></d-list>
	</d-combobox>
</mz:Body>
<script type="text/javascript">
require.config({
    baseUrl: "js/"
});

require(["deliteful-build/layer"], function () {
	require([
	     "delite/register", 
	     "deliteful/Store", 
	     "deliteful/list/List",
         "deliteful/Combobox",
	     "requirejs-domready/domReady!"],
    function (register) {
      register.parse();      
      document.body.style.display = "";
  });
});
</script>
</html>