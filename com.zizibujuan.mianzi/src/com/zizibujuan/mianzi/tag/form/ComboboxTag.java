package com.zizibujuan.mianzi.tag.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

/**
 * Combobox
 * @author jinzw
 *
 */
public class ComboboxTag extends AbstractInputElementTag{
	
	private boolean autoFilter; // 是否支持根据输入的文本自动过滤
	private String store;

	public boolean isAutoFilter() {
		return autoFilter;
	}

	public void setAutoFilter(boolean autoFilter) {
		this.autoFilter = autoFilter;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		tagWriter.startTag("d-combobox");
			tagWriter.writeAttribute("name", getName());
			if(isAutoFilter()){
				tagWriter.writeAttribute("autoFilter", "true");
			}
			if(StringUtils.isNotBlank(getStore())){
				tagWriter.startTag("d-list");
					tagWriter.writeAttribute("store", getStore());
				tagWriter.endTag(true);
			}
		tagWriter.endTag();
	}
	
	

}
