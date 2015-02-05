package com.zizibujuan.mianzi.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 封装body节点，在最后生成js脚本
 * <code>
 * <script type="text/javascript">
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
 * </code>
 * @author jinzw
 *
 */
public class BodyTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}

}
