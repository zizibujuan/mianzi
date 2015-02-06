package com.zizibujuan.mianzi.tag.form;

import com.zizibujuan.mianzi.tag.AbstractHtmlElementTag;

public class AbstractInputElementTag extends AbstractHtmlElementTag{

	private String name; // 必填
	private boolean disabled;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	

}
