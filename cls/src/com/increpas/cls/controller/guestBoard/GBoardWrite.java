package com.increpas.cls.controller.guestBoard;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.*;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

public class GBoardWrite implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 뷰 요청방식
		req.setAttribute("isRedirect", true);
		String view = "/cls/guestBoard/guestBoard.cls";
		// 파라미터 읽어오고
		
		String sid = "";
		try {
			sid = (String) req.getSession().getAttribute("SID");
			System.out.println("******** cont sid : " + sid);
			String body = req.getParameter("body");

			// 데이터베이스에서 데이터 작업 결과 가져오기
			GBoardDAO gDAO = new GBoardDAO();
			int cnt = gDAO.addGBoard(sid, body);
			
			if(cnt == 0) {
				view = "/cls/member/login.cls";
			}
			
		} catch(Exception e) {
			view = "/cls/member/login.cls";
		}
		// 뷰를 부른다.
		return view;
	}

}












