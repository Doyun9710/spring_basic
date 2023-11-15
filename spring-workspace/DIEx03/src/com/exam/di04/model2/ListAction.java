package com.exam.di04.model2;

import java.util.ArrayList;

import com.exam.di04.model1.BoardDAO;
import com.exam.di04.model1.BoardTO;

public class ListAction implements Action {
	private BoardDAO dao;
	
	public ListAction(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		ArrayList<BoardTO> boardLists = dao.boardList2();
		System.out.println( "ListAction Print" );
		for( BoardTO to : boardLists ) {
			System.out.print( to.getSeq() + "\t" + to.getSeq() + "\t" + to.getSubject() + "\t" + to.getWriter() + "\t" + to.getMail() + "\t" + to.getPassword() + "\t" + to.getContent() + "\t" + to.getHit() + "\t" + to.getWip() + "\t" + to.getWdate() );
			System.out.println();
			/*
			System.out.println( to.getSeq() );
			System.out.println( to.getSubject() );
			System.out.println( to.getWriter() );
			System.out.println( to.getMail() );
			System.out.println( to.getPassword() );
			*/
		}
	}

}
