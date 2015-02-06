package com.zizibujuan.mianzi.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class StoreTagAction extends ActionSupport{
	private static final long serialVersionUID = -8302520112331823350L;
	
	private List<Map<String, String>> list;
	
	
	public List<Map<String, String>> getList() {
		return list;
	}


	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}


	@Override
	public String execute() throws Exception {
		list = new ArrayList<Map<String,String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("label", "a");
		list.add(map1);
		
        return SUCCESS;
    }
}
