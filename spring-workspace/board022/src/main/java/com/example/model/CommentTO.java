package com.example.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentTO {
	private String seq;
	private String pseq;
	
	private int grp;
	private int grps;
	private int grpl;
	
	private String writer;
	private String password;
	private String content;
	private String wdate;
	
	private ArrayList<CommentTO> boardReplyLists;
}
