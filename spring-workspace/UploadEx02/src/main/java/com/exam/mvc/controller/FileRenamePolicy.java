package com.exam.mvc.controller;

import java.util.Calendar;

public class FileRenamePolicy {
	
	// 파일이름변경 메서드
	public String renameFile(String fileName) {
		// 내용
		// 파일명_타임스탬프.확장자
		
		String[] arrFileName = fileName.split( "\\." );
		
		arrFileName[ arrFileName.length - 2 ] = arrFileName[ arrFileName.length - 2 ] + "_" + Calendar.getInstance().getTimeInMillis();
		fileName = String.join( ".", arrFileName );
		return fileName;
	}
}






