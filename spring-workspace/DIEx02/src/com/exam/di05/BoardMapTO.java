package com.exam.di05;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardMapTO {
	private HashMap<String, String> userMaps;
	private HashMap<String, BoardTO> boardMaps;
}
