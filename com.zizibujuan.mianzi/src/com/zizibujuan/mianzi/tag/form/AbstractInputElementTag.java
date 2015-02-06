package com.zizibujuan.mianzi.tag.form;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zizibujuan.mianzi.tag.TagWriter;

public class AbstractInputElementTag extends SimpleTagSupport{

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
	
	protected TagWriter tagWriter;
	
	protected TagWriter createTagWriter() {
		// TODO: TagWriter基于JspContext是否更合适呢
		return new TagWriter(this.getJspContext());
	}
}
