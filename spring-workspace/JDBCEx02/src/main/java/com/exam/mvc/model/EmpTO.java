package com.exam.mvc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpTO {
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
}
