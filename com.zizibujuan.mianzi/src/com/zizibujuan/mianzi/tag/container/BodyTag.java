package com.zizibujuan.mianzi.tag.container;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;

import org.apache.commons.lang3.StringUtils;

import com.zizibujuan.mianzi.tag.AbstractTag;
import com.zizibujuan.mianzi.tag.ModuleAware;
import com.zizibujuan.mianzi.tag.ModuleInfo;

/**
 * 封装body节点，在最后生成js脚本
 * <code>
 * <script type="text/javascript">
	require.config({
	    baseUrl: "../js/"
	});
	require(["deliteful-build/layer"], function () {
	    require([
	        "delite/register",
	        "deliteful/Button"
	    ], function (register){
	        register.parse();
	        document.body.style.display = "";
	    });
	});
	</script>
 * </code>
 * 
 * @author jinzw
 *
 */
public class BodyTag extends AbstractTag implements ModuleAware{

	private List<ModuleInfo> modules = new ArrayList<ModuleInfo>();
	
	@Override
	public void doTag() throws JspException, IOException {
		tagWriter = createTagWriter();
		tagWriter.startTag("body");
		tagWriter.writeAttribute("style", "display:none");
		tagWriter.forceBlock();
		JspFragment jspBody = getJspBody(); // 如果body中没有内容，则jspBody为null
		if(jspBody != null){
			jspBody.invoke(null);
		}
		tagWriter.startTag("script");
		tagWriter.writeAttribute("type", "text/javascript");
		String strScript = getJavaScript();
		tagWriter.appendValue(strScript);
		tagWriter.endTag();
		
		tagWriter.endTag(true);
	}

	private String getJavaScript() {
		StringBuilder sb = new StringBuilder();
		sb.append("require.config({baseUrl:\"");
		String baseUrl = getContextPath();
		if(StringUtils.isNotBlank(baseUrl)){
			baseUrl += "/";
		}
		sb.append(baseUrl);
		sb.append("js/\"});");
		sb.append("require([\"deliteful-build/layer\"],function(){require([\"delite/register\","); 
		for(ModuleInfo m : modules){
			sb.append("\"").append(m.getFullModuleName()).append("\",");
		}
		sb.append("\"requirejs-domready/domReady!\"],function(register");
		for(ModuleInfo m : modules){
			sb.append(",").append(m.getShortName());
		}
		sb.append("){register.parse();document.body.style.display=\"\";});});");
		return sb.toString();
	}

	@Override
	public void addModule(String shortName, String fullModuleName) {
		ModuleInfo m = new ModuleInfo(shortName, fullModuleName);
		if(!modules.stream().anyMatch(each -> each.getFullModuleName().equals(m.getFullModuleName()))){
			modules.add(m);
		}
	}

}
