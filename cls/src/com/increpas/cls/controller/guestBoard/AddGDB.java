package com.increpas.cls.controller.guestBoard;

import java.util.*;

import javax.servlet.http.*;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

import com.increpas.cls.controller.ClsMain;

public class AddGDB implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cls/guestBoard/guestBoard.cls";
		/*
		// 데이터베이스에 데이터 입력하고
		ArrayList<HashMap<String, String>> list = getList();
		*/

		ArrayList<String> name = new ArrayList<String>();
		name.add("euisan");
		name.add("sun");
		name.add("mygusdnd");
		name.add("smkim");
		name.add("joseph");
		name.add("kys");
		name.add("dhgpcks");
		name.add("jieun");
		name.add("juhyun");
		name.add("park");
		name.add("jang");
		name.add("jinwoo");
		name.add("hh");
		name.add("hong");
		
		ArrayList<HashMap<String, String>> list = getList(name);
		
		GBoardDAO gDAO = new GBoardDAO();
		int cnt = gDAO.addGBoard(list);
		
		System.out.println("### 데이터 입력 수 : " + cnt);
		
		req.setAttribute("isRedirect", true);
		return view;
	}
	
	public ArrayList<HashMap<String, String>> getList(){
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("id","euns");
		map1.put("body","인삿말을 등록하세요!");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("id","joo");
		map2.put("body","내가일등이다!!!");
		
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("id","jiwoo");
		map3.put("body"," 제발지우지마세여!");
		
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("id","jjang");
		map4.put("body","내가짱이다!");
		
		HashMap<String, String> map5 = new HashMap<String, String>();
		map5.put("id","wook");
		map5.put("body","우욱");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		return list;
	}
	
	public ArrayList<HashMap<String, String>> getList(ArrayList<String> name){
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		for(int i = 0; i < name.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", name.get(i));
			map.put("body", "오늘 가입했습니다 ^^7~~ [" + (i + 1)+ "]" );
			list.add(map);
		}
		return list;
	}
	
}
