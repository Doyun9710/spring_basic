package com.exam.di05;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListTO {
	private ArrayList<String> userLists;
	private ArrayList<BoardTO> boardLists;
}
