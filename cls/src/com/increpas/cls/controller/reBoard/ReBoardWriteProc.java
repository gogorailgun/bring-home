package com.increpas.cls.controller.reBoard;

import javax.servlet.http.*;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

public class ReBoardWriteProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 할일
		// 1. 데이터 받고
		String sid = req.getParameter("id");
		String body = req.getParameter("body");
		// 2. 데이터베이스 작업하고
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.addContent(sid, body);
		String str = " *** 게시글이 성공적으로 등록되었습니다. ***";
		if(cnt == 0) {
			str = "### 글 등록에 실패했습니다. ###";
		}
		System.out.println(str);
		
		// 3. 뷰 부르고
		String view = "/cls/reBoard/reBoardList.cls";
		// 리다이렉트 한다는 것을 속성(Attribute)에 알려준다.
		req.setAttribute("isRedirect", true);
		// 4. 뷰에 데이터 실어서 보내고
		
		return view;
	}

}
