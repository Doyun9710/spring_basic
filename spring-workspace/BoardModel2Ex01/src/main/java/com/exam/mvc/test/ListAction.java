package com.exam.mvc.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.mvc.model.*;

public class ListAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ListAction 호출" );
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> datas = dao.boardList();

		request.setAttribute( "datas", datas );
	}

}
