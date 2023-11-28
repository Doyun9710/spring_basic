package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ConfigController {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping( "/mail.do" )
	public ModelAndView mail(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println( "mail() 호출" );

		return new ModelAndView( "mail" );
	}

	@RequestMapping( "/mail_ok.do" )
	public ModelAndView mail_ok(HttpServletRequest request) {
		
		System.out.println( "mail_ok() 호출" );
		System.out.println( "javaMailSender : " + javaMailSender );
		
		String toEmail = "yuncoding1010@gmail.com";
		String toName = "테스터";
		String subject = "테스트 제목";
		//String content = "테스트 내용";
		StringBuilder sbHtml = new StringBuilder();
		sbHtml.append("<html>");
		sbHtml.append("<head>");
		sbHtml.append("<meta charset='utf-8' />");
		sbHtml.append("</head>");
		sbHtml.append("<body>");
		sbHtml.append("<font color='blue'>테스트 내용</font>");
		sbHtml.append("<img src='https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png' />");
		sbHtml.append("</body>");
		sbHtml.append("</html>");
		String content = sbHtml.toString();

		//this.sendMail1(toEmail, toName, subject, content);
		this.sendMail2(toEmail, toName, subject, content);
		
		return new ModelAndView( "mail_ok" );
	}
	
	// Simple Mail Send
	public void sendMail1(String toEmail, String toName, String subject, String content) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setTo( toEmail );
		simpleMailMessage.setSubject( subject );
		simpleMailMessage.setText( content );
		
		simpleMailMessage.setSentDate( new Date() );
		
		javaMailSender.send( simpleMailMessage );
		
		System.out.println( "전송완료" );
	}
	
	// HTML Send
	public void sendMail2(String toEmail, String toName, String subject, String content) {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			mimeMessage.addRecipient( 
					RecipientType.TO, 
					new InternetAddress( toEmail, toName, "utf-8" ) 
			);
			mimeMessage.setSubject( subject, "utf-8" );
			mimeMessage.setText( content, "utf-8", "html" );
			
			mimeMessage.setSentDate( new Date() );
			
			javaMailSender.send( mimeMessage );
			
			System.out.println( "전송완료" );
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
