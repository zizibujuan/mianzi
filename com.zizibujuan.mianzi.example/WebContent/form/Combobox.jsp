<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zizibujuan.com/mianzitaglib" prefix="mz" %>
<!DOCTYPE html>
<html>
<mz:Head title="Combobox"/>
<mz:Body>
  <d-combobox autoFilter="true">
    <d-list righttextAttr="sales" store="store"></d-list>
  </d-combobox>
  <d-store id="store">
    { "label": "France", "sales": 500, "profit": 50, "region": "EU" },
	{ "label": "Germany", "sales": 450, "profit": 48, "region": "EU" },
	{ "label": "UK", "sales": 700, "profit": 60, "region": "EU" },
	{ "label": "USA", "sales": 2000, "profit": 250, "region": "America" },
	{ "label": "Canada", "sales": 600, "profit": 30, "region": "America" },
	{ "label": "Brazil", "sales": 450, "profit": 30, "region": "America" },
	{ "label": "China", "sales": 500, "profit": 40, "region": "Asia" },
	{ "label": "Japan", "sales": 900, "profit": 100, "region": "Asia" }
  </d-store>
</mz:Body>

<script type="text/javascript">
require.config({
    baseUrl: "../js/"
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

