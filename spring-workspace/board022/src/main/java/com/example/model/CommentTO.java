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
	private int grp;
	private int grps;
	private int grpl;
	
	private String cwriter;
	private String cpassword;
	private String ccontent;
	private String cdate;
	
	private ArrayList<CommentTO> boardReplyLists;
}
