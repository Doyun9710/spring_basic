package com.exam.di02;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardTO {
	private String seq;
	private String subject;
	/*
	public BoardTO(String seq, String subject) {
		this.seq = seq;
		this.subject = subject;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	*/
}
