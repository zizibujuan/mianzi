package com.zizibujuan.mianzi.tag.container;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import com.zizibujuan.mianzi.tag.AbstractHtmlElementTag;

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
 * 
 * @author jinzw
 *
 */
public class BodyTag extends AbstractHtmlElementTag{

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		tagWriter.startTag("body");
		tagWriter.forceBlock();
		JspFragment jspBody = getJspBody(); // 如果body中没有内容，则jspBody为null
		if(jspBody != null){
			jspBody.invoke(null);
		}
		tagWriter.endTag(true);
	}

}
