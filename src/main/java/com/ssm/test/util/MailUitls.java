package com.ssm.test.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author 许家杰
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code, String basePath){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("13253515835", "xjj19970617");
			}
		};
		
		Session session = Session.getInstance(props, authenticator);
		
	/*
	 * 创建MimeMessage
	 */
		MimeMessage msg = new MimeMessage(session);
		//设置发件人
		try {
			msg.setFrom(new InternetAddress("13253515835@163.com") );
			msg.setRecipients(RecipientType.TO, to);
		//设置抄送
		//msg.setRecipients(RecipientType.CC, s);
		//设置暗送
		//msg.setRecipients(RecipientType.CC, "424255910@qq.com");
	
		msg.setSubject("说天下激活邮箱");
			msg.setContent("请点击激活账号<h3><a href='" +basePath+ "activeUser.action?userAcode="+code+"'>说天下账号激活</a></h3>" + code, "text/html;charset=utf-8");

			//发送
		Transport.send(msg);
	} catch (AddressException e) {
		e.printStackTrace();
	} catch (MessagingException e) {
		e.printStackTrace();
	}	
	}
	
}
