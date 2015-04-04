package com.zizibujuan.mianzi.tag.container;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import com.zizibujuan.mianzi.tag.AbstractHtmlElementTag;

/**
 * 页面标签，封装一个完整的html页面，一个jsp页面中只能放一个Page标签。
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class PageTag extends AbstractHtmlElementTag{

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		Writer originWriter = getWriter();
		originWriter.write("<!DOCTYPE HTML>");
		originWriter.write(System.getProperty("line.separator"));
		tagWriter.startTag("html");
		tagWriter.forceBlock();
		JspFragment jspBody = getJspBody(); // 如果body中没有内容，则jspBody为null
		if(jspBody != null){
			jspBody.invoke(null);
		}
		tagWriter.endTag();
	}

	
}
