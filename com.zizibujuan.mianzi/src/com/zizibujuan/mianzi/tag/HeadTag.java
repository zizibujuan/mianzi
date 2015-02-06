package com.zizibujuan.mianzi.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

/**
 * 封装html head节点，因为使用amd加载js和css文件，所以这里直接将head封装成一个标签，
 * 不提供用户自己在header中引用js和css文件的功能
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class HeadTag extends AbstractHtmlElementTag{

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
				tagWriter.writeAttribute("src", getContextPath() + "/js/requirejs/require.js");
			tagWriter.endTag(true);
		
		tagWriter.endTag();
	}
	

}
