package com.zizibujuan.mianzi.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AbstractHtmlElementTag extends SimpleTagSupport{

	protected TagWriter tagWriter;
	
	protected String getContextPath() {
		return ((PageContext)getJspContext()).getServletContext().getContextPath();
	}
	
	protected TagWriter createTagWriter() {
		// TODO: TagWriter基于JspContext是否更合适呢
		return new TagWriter(this.getJspContext());
	}
	
	protected ServletRequest getServletRequest() {
		PageContext pageContext = (PageContext) getJspContext();
		return pageContext.getRequest();
	}
	
	protected Object findValue(String dataSource) {
		return getServletRequest().getAttribute(dataSource);
	}
}
