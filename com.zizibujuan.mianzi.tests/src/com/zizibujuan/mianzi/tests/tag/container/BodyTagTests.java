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
import com.zizibujuan.mianzi.tag.container.BodyTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * body标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class BodyTagTests extends AbstractTagTests{

	private BodyTag bodyTag;
	
	@Before
	public void setUp(){
		bodyTag = new BodyTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		bodyTag.setJspContext(pageContext);
		
		JspFragment jspBody = new JspFragment(){
			@Override
			public void invoke(Writer w) throws JspException, IOException {
				
			}
			
			@Override
			public JspContext getJspContext() {
				return pageContext;
			}
		};
		bodyTag.setJspBody(jspBody);
	}

	@After
	public void tearDown(){
		bodyTag = null;
	}
	@Test
	public void testBodyTag() throws JspException, IOException{


		bodyTag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<body"));
		Assert.assertTrue(output.endsWith("</body>"));
		
		// body默认不显示
		assertContainsAttribute(output, "style", "display:none");
	}
	
	@Test
	public void testBodyTagWithContent() throws JspException, IOException{
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
		bodyTag.setJspBody(jspBody);
		bodyTag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<body"));
		Assert.assertTrue(output.endsWith("</body>"));
		assertBlockTagContains(output, "aa");
	}
	
	@Test
	public void testBodyTagWithScriptBlock() throws JspException, IOException{
		bodyTag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.contains("<script type=\"text/javascript\">require([\"deliteful-build/layer\"],function(){require([\"delite/register\",\"requirejs-domready/domReady!\"],function(register){register.parse();document.body.style.display=\"\";});});</script>"));
	}
	
	@Test
	public void testBodyTagContainWidget() throws JspException, IOException{
		bodyTag.addModule("Button", "deliteful/Button");
		bodyTag.addModule("Button", "deliteful/Button");
		bodyTag.doTag();
		String output = getOutput();
		assertBlockTagContains(output, "<script type=\"text/javascript\">require([\"deliteful-build/layer\"],function(){require([\"delite/register\",\"deliteful/Button\",\"requirejs-domready/domReady!\"],function(register,Button){register.parse();document.body.style.display=\"\";});});</script>");
	}
}
