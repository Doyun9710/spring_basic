package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardTO {
	private String seq;
	private String subject;
	private String writer;
	private String mail;
	private String password;
	private String content;
	private String filename;
	private long filesize;
	
	private String latitude;	// 위도
	private String longitude;	// 경도
	private int recount;		// 댓글 수

	private String hit;
	private String wip;
	private String wdate;

	private int wgap;
	

	// 다음글 / 이전글
	private String nextseq;
	private String nextsub;
	private String beseq;
	private String besub;
	
	
	public BoardTO() {
		// 초기화
		this.nextseq = "";
		this.nextsub = "다음글이 없습니다.";
		this.beseq = "";
		this.besub = "이전글이 없습니다.";
	}
	
	public int getRecount() {
		return recount;
	}

	public void setRecount(long recount) {
		this.recount = (int) recount;
	}
}
