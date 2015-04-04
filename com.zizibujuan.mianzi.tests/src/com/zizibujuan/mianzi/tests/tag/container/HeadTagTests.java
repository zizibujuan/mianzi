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
import com.zizibujuan.mianzi.tag.container.HeadTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * 页面头信息，对应html的head标签。没有抛弃head的原因是每个页面要写一些meta标签。
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class HeadTagTests extends AbstractTagTests{

	private HeadTag headTag;
	@Before
	public void setUp(){
		headTag = new HeadTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}

			@Override
			protected JspContext getJspContext() {
				return pageContext;
			}
		};
		
		JspFragment jspBody = new JspFragment() {
			
			@Override
			public void invoke(Writer w) throws JspException, IOException {
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		headTag.setJspBody(jspBody);
	}
	@After
	public void tearDown(){
		headTag = null;
	}
	
	@Test
	public void testHeadTag() throws JspException, IOException{
		headTag.doTag();
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<head"));
		Assert.assertTrue(output.endsWith("</head>"));
	}
	
	@Test
	public void testHeadTagSetTitle() throws JspException, IOException{
		headTag.setTitle("title1");
		headTag.doTag();
		String output = getOutput();
		assertBlockTagContains(output, "<title>title1</title>");
	}
}
