package com.zizibujuan.mianzi.tests.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.form.CheckboxTag;

/**
 * Checkbox标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class CheckboxTagTests extends AbstractTagTests{

	// <d-checkbox name="option1" checked="true"></d-checkbox>
	@Test
	public void testCheckboxTag() throws JspException, IOException{
		CheckboxTag tag = new CheckboxTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setChecked(true);
		tag.setName("option1");
		tag.doTag();
		
		String output = getOutput();
		Assert.assertTrue(output.startsWith("<d-checkbox"));
		Assert.assertTrue(output.endsWith("</d-checkbox>"));
		assertContainsAttribute(output, "name", "option1");
		assertContainsAttribute(output, "checked", "true");
		assertAttributeNotPresent(output, "disabled");
	}
	
	@Test
	public void testDisabled() throws JspException, IOException{
		CheckboxTag tag = new CheckboxTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		tag.setJspContext(pageContext);
		tag.setDisabled(true);
		tag.doTag();
		String output = getOutput();
		assertContainsAttribute(output, "disabled", "true");
	}
}
