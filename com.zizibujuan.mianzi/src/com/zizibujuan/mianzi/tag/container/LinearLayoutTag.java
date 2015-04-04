package com.zizibujuan.mianzi.tag.container;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.zizibujuan.mianzi.tag.AbstractTag;

/**
 * 线性布局标签，支持垂直和水平两种布局方式
 * @author jinzw
 *
 */
public class LinearLayoutTag extends AbstractTag{

	private boolean vertical = true; // 默认为垂直布局
	private String width;// 有三种类型的值：1没有设置；2固定宽度;3百分比宽度
	private String height;

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		// TODO:校验值的合理性？
		if(NumberUtils.isDigits(width)){
			this.width = width + "px";
		}else{
			this.width = width;
		}
	}
	
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		if(NumberUtils.isDigits(height)){
			this.height = height + "px";
		}else{
			this.height = height;
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		tagWriter.startTag("d-linear-layout");
		if(!isVertical()){
			tagWriter.writeAttribute("vertical", "false");
		}
		tagWriter.writeOptionalAttributeValue("style", getCssStyle());
		tagWriter.forceBlock();
		JspFragment jspBody = getJspBody();
		if(jspBody != null){
			jspBody.invoke(null);
		}
		tagWriter.endTag();
	}
	
	private String getCssStyle(){
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(getWidth())){
			sb.append("width:");
			sb.append(getWidth());
		}

		if(StringUtils.isNotBlank(getHeight())){
			if(sb.length() > 0){
				sb.append(";");
			}
			sb.append("height:");
			sb.append(getHeight());
		}
		return sb.toString();
	}
	
	
}
