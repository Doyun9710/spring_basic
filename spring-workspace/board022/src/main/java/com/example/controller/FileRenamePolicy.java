package com.example.controller;

import java.util.Calendar;

public class FileRenamePolicy {
	
	// 파일이름변경 메서드 { 파일명_타임스탬프.확장자 }
	public String renameFile(String fileName) {
		String[] arrFileName = fileName.split( "\\." );
		
		arrFileName[ arrFileName.length - 2 ] = arrFileName[ arrFileName.length - 2 ] + "_timestamp" + Calendar.getInstance().getTimeInMillis();
		fileName = String.join( ".", arrFileName );
		return fileName;
	}
}






