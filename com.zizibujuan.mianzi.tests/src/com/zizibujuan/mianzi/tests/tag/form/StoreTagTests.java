package com.zizibujuan.mianzi.tests.tag.form;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockPageContext;

import com.zizibujuan.mianzi.tag.StoreTag;
import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * Store标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class StoreTagTests extends AbstractTagTests{

	protected StringWriter writer;
	protected PageContext pageContext;
	
	@Before
	public void setup(){
		writer = new StringWriter();
		pageContext = new MockPageContext();
	}
	
	protected String getOutput(){
		return this.writer.toString();
	}
	
	@Test
	public void testStoreTag() throws JspException, IOException{
		StoreTag tag = new StoreTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		JspFragment jspBody = new JspFragment() {
			@Override
			public void invoke(Writer arg0) throws JspException, IOException {
				writer.append("{\"label\":\"value\"}");
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		tag.setJspBody(jspBody);
		tag.setId("id1");
		
		tag.doTag();
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-store"));
		Assert.assertTrue(output.endsWith("</d-store>"));
		//assertContainsAttribute(output, "id", "id1");
		//assertBlockTagContains(output, "{\"label\":\"value\"}");
	}
	
	@Test
	public void testStoreTagWithDataSource() throws JspException, IOException{
		List<Map<String, String>> list1 = new ArrayList<Map<String,String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("label", "a");
		list1.add(map1);
		HttpServletRequest req = new MockHttpServletRequest();
		req.setAttribute("list1", list1);
		
		StoreTag tag = new StoreTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}

			@Override
			protected ServletRequest getServletRequest() {
				return req;
			}
		};
		tag.setJspContext(pageContext);
		JspFragment jspBody = new JspFragment() {
			@Override
			public void invoke(Writer arg0) throws JspException, IOException {
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		tag.setJspBody(jspBody);
		tag.setId("id1");
		tag.setDataSource("list1");
		
		tag.doTag();
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-store"));
		Assert.assertTrue(output.endsWith("</d-store>"));
		assertContainsAttribute(output, "id", "id1");
		assertBlockTagContains(output, "{\"label\":\"a\"}");
	}
}
