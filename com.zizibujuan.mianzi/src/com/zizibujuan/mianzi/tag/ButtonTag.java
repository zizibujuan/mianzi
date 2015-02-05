package com.zizibujuan.mianzi.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.servlet.tags.form.TagWriter;

/**
 * 按钮标签
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ButtonTag extends SimpleTagSupport{
	private TagWriter tagWriter;
	
	private String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		
		tagWriter.startTag("button");
		tagWriter.writeAttribute("is", "d-button");
		tagWriter.appendValue(getLabel());
		tagWriter.endTag();
		
		//super.doTag();
	}

	protected TagWriter createTagWriter() {
		// TODO: TagWriter基于JspContext是否更合适呢
		return new TagWriter((PageContext)this.getJspContext());
	}
}
