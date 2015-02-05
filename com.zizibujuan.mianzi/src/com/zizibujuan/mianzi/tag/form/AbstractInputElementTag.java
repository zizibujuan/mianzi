package com.zizibujuan.mianzi.tag.form;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zizibujuan.mianzi.tag.TagWriter;

public class AbstractInputElementTag extends SimpleTagSupport{

	protected TagWriter tagWriter;
	
	protected TagWriter createTagWriter() {
		// TODO: TagWriter基于JspContext是否更合适呢
		return new TagWriter(this.getJspContext());
	}
}
