package com.zizibujuan.mianzi.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

/**
 * 按钮标签
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ButtonTag extends AbstractInputElementTag{
	
	private String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void doTag() throws JspException, IOException {
		addModule("Button", "deliteful/Button");
		
		tagWriter = createTagWriter();
		
		tagWriter.startTag("button");
		tagWriter.writeAttribute("is", "d-button");
		if(isDisabled()){
			tagWriter.writeAttribute("disabled", "true");
		}
		tagWriter.appendValue(getLabel());
		tagWriter.endTag();
	}

}
