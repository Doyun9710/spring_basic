package com.example.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardListTO {
	private int cpage;
	private int recordPerPage;
	private int blockPerPage;
	private int totalPage;
	private int totalRecord;
	private int startBlock;
	private int endBlock;
	
	private ArrayList<BoardTO> boardLists;

	public BoardListTO() {
		// 초기화
		this.cpage = 1;
		this.recordPerPage = 5;	// 각 페이지 당 게시글 수. 10추천
		this.blockPerPage = 5;
		this.totalPage = 1;
		this.totalRecord = 0;
	}
}
