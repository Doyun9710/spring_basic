package com.exam.mvc.share;

// 공유 클래스
public class ShareClass {
	private String shareData1;
	
	public ShareClass() {
		// TODO Auto-generated constructor stub
		System.out.println( "ShareClass() 생성자 호출" );
	}
	
	public String getShareData1() {
		return shareData1;
	}
	
	public void setShareData1(String shareData1) {
		this.shareData1 = shareData1;
	}
}
