package com.exam.di06.model2;

import java.util.ArrayList;

import com.exam.di06.model1.BoardDAO;

public class ListAction implements Action {
	private BoardDAO dao;
	
	public ListAction(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ArrayList<String> lists = dao.boardList();

		System.out.println( lists );
	}

}
