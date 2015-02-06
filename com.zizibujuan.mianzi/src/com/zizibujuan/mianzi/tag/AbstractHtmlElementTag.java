package com.zizibujuan.mianzi.tag;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import com.opensymphony.xwork2.util.ValueStack;

public class AbstractHtmlElementTag extends SimpleTagSupport{

	protected TagWriter tagWriter;
	
	protected String getContextPath() {
		return ((PageContext)getJspContext()).getServletContext().getContextPath();
	}
	
	protected TagWriter createTagWriter() {
		// TODO: TagWriter基于JspContext是否更合适呢
		return new TagWriter(this.getJspContext());
	}
	
	protected ValueStack getStack(){
		return TagUtils.getStack((PageContext)getJspContext());
	}
}
