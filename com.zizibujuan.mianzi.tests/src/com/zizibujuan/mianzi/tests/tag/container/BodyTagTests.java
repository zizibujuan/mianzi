package com.zizibujuan.mianzi.tests.tag.container;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.container.BodyTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * body标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class BodyTagTests extends AbstractTagTests{

	@Test
	public void testBodyTag() throws JspException, IOException{
		BodyTag tag = new BodyTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		JspFragment jspBody = new JspFragment(){
			@Override
			public void invoke(Writer w) throws JspException, IOException {
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		tag.setJspBody(jspBody);
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<body>"));
		Assert.assertTrue(output.endsWith("</body>"));
	}
	
	@Test
	public void testBodyTagWithContent() throws JspException, IOException{
		BodyTag tag = new BodyTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		JspFragment jspBody = new JspFragment() {
			
			@Override
			public void invoke(Writer w) throws JspException, IOException {
				writer.append("aa");
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		tag.setJspBody(jspBody);
		
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<body>"));
		Assert.assertTrue(output.endsWith("</body>"));
	}
}
