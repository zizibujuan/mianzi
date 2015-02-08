package com.zizibujuan.mianzi.tests.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.form.ComboboxTag;
import com.zizibujuan.mianzi.tests.tag.AbstractTagTests;

/**
 * Combobox标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ComboboxTagTests extends AbstractTagTests{

	@Test
	public void testComboboxTag() throws JspException, IOException{
		ComboboxTag tag = new ComboboxTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setName("name1");
		tag.setStore("store1");
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-combobox"));
		Assert.assertTrue(output.endsWith("</d-combobox>"));
		assertContainsAttribute(output, "name", "name1");
		assertBlockTagContains(output, "<d-list store=\"store1\"></d-list>");
	}
}
