package com.zizibujuan.mianzi.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

/**
 * 下拉框标签
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class SelectTag extends AbstractInputElementTag{
	
	private boolean multiple; // 是否支持多选
	private String store;
	
	private String textAttr; // 如果没有值，则默认为"text"。
	private String valueAttr; // 如果没有值，则默认为"value"。
	private String disabledAttr; // 如果没有值，则默认为"disabled"。
	
	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getTextAttr() {
		return textAttr;
	}

	public void setTextAttr(String textAttr) {
		this.textAttr = textAttr;
	}

	public String getValueAttr() {
		return valueAttr;
	}

	public void setValueAttr(String valueAttr) {
		this.valueAttr = valueAttr;
	}

	public String getDisabledAttr() {
		return disabledAttr;
	}

	public void setDisabledAttr(String disabledAttr) {
		this.disabledAttr = disabledAttr;
	}

	@Override
	public void doTag() throws JspException, IOException {
		addModule("Select", "deliteful/Select");
		tagWriter = createTagWriter();
		tagWriter.startTag("d-select");
		if(isMultiple()){
			tagWriter.writeAttribute("selectionMode", "multiple");
		}
		if(StringUtils.isNotBlank(getStore())){
			tagWriter.writeAttribute("store", getStore());
		}
		tagWriter.writeOptionalAttributeValue("textAttr", getTextAttr());
		tagWriter.writeOptionalAttributeValue("valueAttr", getValueAttr());
		tagWriter.writeOptionalAttributeValue("disabledAttr", getDisabledAttr());
		tagWriter.endTag(true);
	}

}
