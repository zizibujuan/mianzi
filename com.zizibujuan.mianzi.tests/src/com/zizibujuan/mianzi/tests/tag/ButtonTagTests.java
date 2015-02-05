package com.zizibujuan.mianzi.tests.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.zizibujuan.mianzi.tag.ButtonTag;

public class ButtonTagTests {
	private StringWriter writer;
	private PageContext pageContext;
	
	@Test
	public void test() throws JspException, IOException{
		writer = new StringWriter();
		ButtonTag tag = new ButtonTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		pageContext = new MockPageContext();
		tag.setJspContext(pageContext);
		tag.doTag();
		
		Assert.assertTrue(getOutput().startsWith("<button"));
	}

	protected String getOutput(){
		return this.writer.toString();
	}
}
