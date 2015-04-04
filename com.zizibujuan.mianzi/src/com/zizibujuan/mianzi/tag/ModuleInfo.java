package com.zizibujuan.mianzi.tag;

/**
 * AMD模块信息
 * 
 * @author jinzw
 * @since 0.0.1
 */
public class ModuleInfo {

	private String shortName;
	private String fullModuleName;
	
	public ModuleInfo(String shortName, String fullModuleName) {
		this.shortName = shortName;
		this.fullModuleName = fullModuleName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFullModuleName() {
		return fullModuleName;
	}
	public void setFullModuleName(String fullModuleName) {
		this.fullModuleName = fullModuleName;
	}
}
