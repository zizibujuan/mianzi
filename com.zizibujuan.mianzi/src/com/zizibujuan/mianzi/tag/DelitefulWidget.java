package com.zizibujuan.mianzi.tag;

public class DelitefulWidget extends AbstractTag{

	protected void addModule(String shortName, String fullModuleName) {
		ModuleAware moduleAwareTag = (ModuleAware) findAncestorWithClass(this, ModuleAware.class);
		if(moduleAwareTag != null){
			moduleAwareTag.addModule(shortName,fullModuleName);
		}
	}
}
