package com.increpas.cls.controller.member;

import java.util.*;
import javax.servlet.http.*;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

public class MemberInfo implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String ssid = (String) req.getSession().getAttribute("SID");
		String view = "member/MemberInfo";
		if(ssid == null) {
			// 연결이 해제되거나 로그인이 안된 경우
			// 로그인 페이지로 돌려보낸다.
			req.setAttribute("isRedirect", true);
			view = "/cls/member/login.cls";
			return view;
		}
		String sid = req.getParameter("id");
		
		if(!ssid.equals(sid)) {
			sid = ssid;
		}
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = mDAO.getMembInfo(sid);
		
		
		ArrayList<AvatarVO> list = mDAO.getAvtAll();
		
		req.setAttribute("DATA", mVO);
		req.setAttribute("LIST", list);
		
		return view;
	}

}
