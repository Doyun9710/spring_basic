package com.exam.mvc.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardAction {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
