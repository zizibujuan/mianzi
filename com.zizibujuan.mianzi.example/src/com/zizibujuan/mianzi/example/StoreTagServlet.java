package com.zizibujuan.mianzi.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreTagServlet extends HttpServlet{
	private static final long serialVersionUID = -8302520112331823350L;
	
	private List<Map<String, String>> list;
	
	
	public List<Map<String, String>> getList() {
		
		return list;
	}


	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}


	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	

//	
//	list = new ArrayList<Map<String,String>>();
//	Map<String, String> map1 = new HashMap<String, String>();
//	map1.put("label", "a");
//	list.add(map1);
}
