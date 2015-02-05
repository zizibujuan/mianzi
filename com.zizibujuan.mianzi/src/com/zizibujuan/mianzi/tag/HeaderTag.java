package com.zizibujuan.mianzi.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.zizibujuan.mianzi.tag.form.AbstractInputElementTag;

public class HeaderTag extends AbstractInputElementTag{

	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Button</title>
	<script type="text/javascript" src="../js/requirejs/require.js"></script>
	</head>
	 */
	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		
		tagWriter.startTag("head");
			tagWriter.startTag("meta");
				tagWriter.writeAttribute("http-equiv", "Content-Type");
				tagWriter.writeAttribute("content", "text/html; charset=UTF-8");
			tagWriter.endTag(false);
			
			tagWriter.startTag("title");
				tagWriter.appendValue(getTitle());
			tagWriter.endTag();
			
			tagWriter.startTag("script");
				tagWriter.writeAttribute("type", "text/javascript");
				// TODO: src地址的根路径要从变量中获取
				tagWriter.writeAttribute("src", "../js/requirejs/require.js");
			tagWriter.endTag(true);
		
		tagWriter.endTag();
	}
	

}
