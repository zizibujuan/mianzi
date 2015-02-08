package com.zizibujuan.mianzi.tests.tag.container;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.container.LinearLayoutTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * LinearLayoutTag测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class LinearLayoutTagTests extends AbstractTagTests{

	@Test
	public void testLinearLayoutTag() throws JspException, IOException{
		LinearLayoutTag tag = new LinearLayoutTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-linear-layout"));
		Assert.assertTrue(output.endsWith("</d-linear-layout>"));
		assertAttributeNotPresent(output, "vertical");
	}
	
	@Test
	public void testLinearLayoutTagWithVertical() throws JspException, IOException{
		LinearLayoutTag tag = new LinearLayoutTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setVertical(false);
		tag.doTag();
		
		String output = getOutput();
		assertContainsAttribute(output, "vertical", "false");
	}
	
	@Test
	public void testBody() throws JspException, IOException{
		LinearLayoutTag tag = new LinearLayoutTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		JspFragment jspBody = new JspFragment(){
			@Override
			public void invoke(Writer w) throws JspException, IOException {
				writer.append("a");
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		tag.setJspBody(jspBody);
		tag.doTag();
		
		String output = getOutput();
		assertBlockTagContains(output, "a");
	}
	
	@Test
	public void testWidth_Width_Percentage_Size() throws JspException, IOException{
		LinearLayoutTag tag = new LinearLayoutTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setWidth("100");
		tag.doTag();
		
		String output = getOutput();
		assertContainsAttribute(output, "style", "width:100px");
	}
	
	@Test
	public void testWidth_Height_Percentage_Size() throws JspException, IOException{
		LinearLayoutTag tag = new LinearLayoutTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setHeight("100");
		tag.doTag();
		
		String output = getOutput();
		assertContainsAttribute(output, "style", "height:100px");
	}
}
