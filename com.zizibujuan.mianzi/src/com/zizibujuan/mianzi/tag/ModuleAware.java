package com.zizibujuan.mianzi.tag;

/**
 * 通知模块名称
 * 
 * @author jinzw
 * @since 0.0.1
 */
public interface ModuleAware {

	/**
	 * 添加AMD模块名
	 * 
	 * @param shortName 模块名简称，用作模块的实例名
	 * @param fullModuleName 遵循AMD规范的模块名，使用/分割
	 */
	void addModule(String shortName, String fullModuleName);
}
