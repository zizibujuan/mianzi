package com.zizibujuan.mianzi.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.apache.commons.lang3.StringUtils;

import com.zizibujuan.util.json.JSON;
import com.zizibujuan.util.json.JSONAccessException;

/**
 * Store标签。用来创建数据列表，可被List/Combobox等控件引用。
 * 支持直接在body中设置json对象，多个json对象使用逗号隔开；也支持绑定数据源。
 * 如果有绑定数据源，则忽略body中的json数组
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class StoreTag extends DelitefulWidget{
	
	private String id; // 必填
	private String dataSource; // 数据源，从Action中获取dataSource对应变量的值

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void doTag() throws JspException, IOException {
		addModule("Store", "deliteful/Store");
		tagWriter = createTagWriter();
		tagWriter.startTag("d-store");
		tagWriter.writeAttribute("id", getId());
		tagWriter.forceBlock();
		if(StringUtils.isNotBlank(getDataSource())){
			Object bean = findValue(getDataSource());
			 if(bean == null){
				 System.out.println("没有找到对应的数据源");
			 }else{
				 try {
					 String strJsonArray = JSON.stringify(bean);
					 tagWriter.appendValue(strJsonArray.substring(1, strJsonArray.length()-1));
				} catch (JSONAccessException e) {
					// 如果不是有效的json格式，则打印错误信息，但是不往输出流中写内容
					e.printStackTrace();
				}
			 }
		}else{
			JspFragment jspBody = getJspBody();
			if(jspBody != null){
				jspBody.invoke(null);
			}
		}
		
		tagWriter.endTag(true);
	}
}
