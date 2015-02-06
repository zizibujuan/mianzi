package com.zizibujuan.mianzi.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

/**
 * Checkbox标签
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class CheckboxTag extends AbstractInputElementTag{

	private boolean checked;
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		tagWriter.startTag("d-checkbox");
			tagWriter.writeAttribute("name", getName());
			if(isChecked()){
				tagWriter.writeAttribute("checked", "true");
			}
			if(isDisabled()){
				tagWriter.writeAttribute("disabled", "true");
			}
		tagWriter.endTag(true);
	}
}
