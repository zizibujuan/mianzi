package com.zizibujuan.mianzi.tests.tag.container;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.container.PageTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * 页面标签测试类
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class PageTagTests extends AbstractTagTests{
	
	private PageTag pageTag;
	@Before
	public void setUp(){
		pageTag = new PageTag(){
			@Override
			protected TagWriter createTagWriter(){
				return new TagWriter(writer);
			}
			@Override
			protected Writer getWriter(){
				return writer;
			}
		};
		JspFragment jspBody = new JspFragment() {
			
			@Override
			public void invoke(Writer arg0) throws JspException, IOException {
				writer.append("htmlContent");
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		pageTag.setJspBody(jspBody);
	}
	@After
	public void tearDown(){
		pageTag = null;
	}

	@Test
	public void testPageTagStartWithHtml5() throws JspException, IOException{
		pageTag.doTag();
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<!DOCTYPE HTML>"));
	}
	
	@Test
	public void testPageTagContainsHtmlTag() throws JspException, IOException{
		pageTag.doTag();
		String output = getOutput();
		Assert.assertTrue(output.contains("<html>"));
		Assert.assertTrue(output.endsWith("</html>"));
	}
	
	@Test
	public void testPageTagWithContent() throws JspException, IOException{
		pageTag.doTag();
		String output = getOutput();
		assertBlockTagContains(output, "htmlContent");
	}
}
