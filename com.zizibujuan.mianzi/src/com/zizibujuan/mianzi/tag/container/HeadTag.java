package com.zizibujuan.mianzi.tag.container;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import com.zizibujuan.mianzi.tag.AbstractTag;

/**
 * 封装html head节点，因为使用amd加载js和css文件，所以这里直接将head封装成一个标签，
 * 不提供用户自己在header中引用js和css文件的功能。
 * 
 * head标签中只建议放meta标签
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class HeadTag extends AbstractTag{

	private String title;
	//private String theme; // 如何支持切换主题?
	
	
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
			
			JspFragment jspBody = getJspBody(); // 如果body中没有内容，则jspBody为null
			if(jspBody != null){
				jspBody.invoke(null);
			}
			
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
