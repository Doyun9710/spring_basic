package com.exam.di05;

import java.util.ArrayList;

public class MainEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Bean Configuration File
		ArrayList<String> userLists = new ArrayList();
		userLists.add( "홍길동" );
		userLists.add( "김철수" );
		
		BoardListTO listTO = new BoardListTO();
		listTO.setUserLists(userLists);
		
		for( String user : listTO.getUserLists() ) {
			System.out.println( user );
		}
		
		
		
		ArrayList<BoardTO> boardLists = new ArrayList();
		
		BoardTO to1 = new BoardTO();
		to1.setSeq( "1" );
		to1.setSubject( "Subject 1" );
		
		BoardTO to2 = new BoardTO();
		to2.setSeq( "2" );
		to2.setSubject( "Subject 2" );
		
		boardLists.add( to1 );
		boardLists.add( to2 );
		
		listTO.setBoardLists(boardLists);
		
		for( BoardTO to : listTO.getBoardLists() ) {
			System.out.println( to.getSeq() );
			System.out.println( to.getSubject() );
		}
	}

}
