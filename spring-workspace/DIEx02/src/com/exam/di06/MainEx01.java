package com.exam.di06;

import com.exam.di06.model1.BoardDAO;
import com.exam.di06.model2.Action;
import com.exam.di06.model2.ListAction;

public class MainEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		
		Action action = new ListAction(dao);
		action.execute();
	}

}
