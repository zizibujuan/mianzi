package com.zizibujuan.mianzi.tests.tag;

import java.io.StringWriter;

import javax.servlet.jsp.PageContext;

import org.junit.Assert;
import org.junit.Before;
import org.springframework.mock.web.MockPageContext;

/**
 * 标签测试抽象类
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class AbstractTagTests {
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
	
	protected final void assertContainsAttribute(String output, String attributeName, String attributeValue) {
		String attributeString = attributeName + "=\"" + attributeValue + "\"";
		Assert.assertTrue("Expected to find attribute '" + attributeName +
				"' with value '" + attributeValue +
				"' in output + '" + output + "'",
				output.indexOf(attributeString) > -1);
	}

	protected final void assertAttributeNotPresent(String output, String attributeName) {
		Assert.assertTrue("Unexpected attribute '" + attributeName + "' in output '" + output + "'.",
				output.indexOf(attributeName + "=\"") < 0);
	}

	protected final void assertBlockTagContains(String output, String desiredContents) {
		String contents = output.substring(output.indexOf(">") + 1, output.lastIndexOf("<"));
		Assert.assertTrue("Expected to find '" + desiredContents + "' in the contents of block tag '" + output + "'",
				contents.indexOf(desiredContents) > -1);
	}
}
