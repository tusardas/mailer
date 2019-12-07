package org.mailer.utils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

public class MailSender {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(MailSender.class);
	private Logger log = Logger.getLogger(this.getClass());
	private String host;
	private String username;
	private String password;
	private String port;
	private String protocol;
	private String smtpAuthentication;
	private String fromAddress;
	private String startTls;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSmtpAuthentication() {
		return smtpAuthentication;
	}

	public void setSmtpAuthentication(String smtpAuthentication) {
		this.smtpAuthentication = smtpAuthentication;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	@SuppressWarnings( { "unchecked", "deprecation" })
	public String sendMail(String subject, String templateName, Map parameters,
			List<File> attachmentList, String... to) {
		log.info("Entered into MailSender: construction of template"
				+ new Date());
		String fileString = getClass().getClassLoader().getResource(
				".." + File.separator + ".." + File.separator + "templates")
				.getPath()
				+ templateName;
		fileString = fileString.replaceAll("%20", " ");
		File file = new File(fileString);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		StringBuffer mailTemplate = new StringBuffer();
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			while (dis.available() != 0) {
				mailTemplate.append(dis.readLine());
			}
			fis.close();
			bis.close();
			dis.close();
			String mailTemplateStr = mailTemplate.toString();
			mailTemplateStr = VelocityUtil.velocityEval(mailTemplateStr,
					parameters);
			log.info("Entered into MailSender: Send Mail" + new Date());
			sendMail(subject, mailTemplateStr, attachmentList, to);
			log.info("Entered into MailSender: Send Mail Success" + new Date());
			return mailTemplateStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void sendMail(String subject, String content,
		List<File> attachmentList, String... to) throws Exception {
		java.util.Properties props = System.getProperties();
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", getPort());
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", getHost());
		props.put("mail.smtp.port", getPort());
		props.put("mail.smtp.protocol", getProtocol());
		props.put("mail.smtp.auth", getSmtpAuthentication());
		props.put("mail.smtp.user", getUsername());
		props.put("mail.smtp.password", getPassword());
		props.put("mail.smtp.starttls.enable", true);
		SMTPAuthenticator auth = null;
		auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
		// session.setDebug(Properties.debug);

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(getFromAddress()));
		InternetAddress[] toAddress = new InternetAddress[to.length];
		String address = "";
		for (int i = 0; i < to.length; i++) {
			toAddress[i] = new InternetAddress(to[i]);
			address = address + "," + to[i];
		}

		message.addRecipients(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		Multipart multipart = new MimeMultipart();
		messageBodyPart.setContent(content, "text/html");
		multipart.addBodyPart(messageBodyPart);
		// Following code executes if the user attaches a file.

		if (attachmentList != null) {
			for (File attachment : attachmentList) {
				// Part two is attachment
				MimeBodyPart filePart = new MimeBodyPart();
				DataSource source = null;
				filePart.setFileName(attachment.getName());
				source = new FileDataSource(attachment);
				filePart.setDataHandler(new DataHandler(source));
				multipart.addBodyPart(filePart);

				// Put parts in message
				message.setContent(multipart);
			}

		} else {
			message.setContent(content, "text/html");
		}

		// Send message
		Transport.send(message);
		log.info("Email sent to : " + address);
	}

	/**
	 * A local class for smtp authenticator. It is used if the authentication is
	 * required to connect to the smtp server.
	 * 
	 */
	private class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(getUsername(), getPassword());
		}
	}

	public String getStartTls() {
		return startTls;
	}

	public void setStartTls(String startTls) {
		this.startTls = startTls;
	}

	public void sendMail(String subject, String content, String to) throws Exception{
		java.util.Properties props = System.getProperties();
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", getPort());
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", getHost());
		props.put("mail.smtp.port", getPort());
		props.put("mail.smtp.protocol", getProtocol());
		props.put("mail.smtp.auth", getSmtpAuthentication());
		props.put("mail.smtp.user", getUsername());
		props.put("mail.smtp.password", getPassword());
		props.put("mail.smtp.starttls.enable", true);
		SMTPAuthenticator auth = null;
		auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
		// session.setDebug(Properties.debug);

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(getFromAddress()));
		InternetAddress toAddress[] = new InternetAddress[1];
		toAddress[0] = new InternetAddress(to);
		message.addRecipients(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);
		message.setContent(content, "text/html");
		Transport.send(message);
		log.info("Email sent to : " + to);
		toAddress[0] = null;
		
	}

}
