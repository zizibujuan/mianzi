package com.zizibujuan.mianzi.tests.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.form.SelectTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * SelectTag测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class SelectTagTests extends AbstractTagTests{

	@Test
	public void testSelectTag() throws JspException, IOException{
		SelectTag tag = new SelectTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setStore("store1");
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-select"));
		Assert.assertTrue(output.endsWith("</d-select>"));
		assertContainsAttribute(output, "store", "store1");
		assertAttributeNotPresent(output, "multiple");
		assertAttributeNotPresent(output, "textAttr");
		assertAttributeNotPresent(output, "valueAttr");
		assertAttributeNotPresent(output, "disabledAttr");
	}
	
	@Test
	public void testSelectTagWithMultiple() throws JspException, IOException{
		SelectTag tag = new SelectTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setMultiple(true);
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-select"));
		Assert.assertTrue(output.endsWith("</d-select>"));
		assertContainsAttribute(output, "selectionMode", "multiple");
		assertAttributeNotPresent(output, "multiple");
	}
	
	@Test
	public void testSelectTag_Attribute_Mapping() throws JspException, IOException{
		SelectTag tag = new SelectTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setDisabledAttr("d");
		tag.setTextAttr("l");
		tag.setValueAttr("v");
		tag.doTag();
		
		String output = getOutput();
		assertContainsAttribute(output, "disabledAttr", "d");
		assertContainsAttribute(output, "textAttr", "l");
		assertContainsAttribute(output, "valueAttr", "v");
	}
	
	
}
