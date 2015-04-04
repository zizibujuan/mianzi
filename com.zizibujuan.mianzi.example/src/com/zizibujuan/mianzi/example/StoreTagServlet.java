package com.zizibujuan.mianzi.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

public class StoreTagServlet extends HttpServlet{
	private static final long serialVersionUID = -8302520112331823350L;
	
	private List<Map<String, String>> list;
	
	
	public List<Map<String, String>> getList() {
		
		return list;
	}


	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

//	
//	list = new ArrayList<Map<String,String>>();
//	Map<String, String> map1 = new HashMap<String, String>();
//	map1.put("label", "a");
//	list.add(map1);
}
