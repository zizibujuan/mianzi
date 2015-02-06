package com.zizibujuan.mianzi.tests.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.junit.Assert;
import org.junit.Test;

import com.zizibujuan.mianzi.tag.TagWriter;
import com.zizibujuan.mianzi.tag.form.ButtonTag;

/**
 * 按钮标签测试用例
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ButtonTagTests extends AbstractTagTests{

	@Test
	public void test() throws JspException, IOException{
		
		ButtonTag tag = new ButtonTag(){
			@Override
			protected TagWriter createTagWriter() {
				return new TagWriter(writer);
			}
		};
		
		tag.setJspContext(pageContext);
		tag.doTag();
		
		Assert.assertTrue(getOutput().startsWith("<button"));
	}

}
