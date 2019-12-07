package org.mailer.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mailer.persistance.UserPersistance;
import org.mailer.object.User;
import org.mailer.utils.MailSender;
public class UserService {
	
	private UserPersistance userPersistance;
	private MailSender mailSender;
	
	public MailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public UserPersistance getUserPersistance() {
		return userPersistance;
	}
	
	public void setUserPersistance(UserPersistance userPersistance) {
		this.userPersistance = userPersistance;
	}
	
	public User authenticateUser(String email, String password) {
		User user = null;
		user = userPersistance.getUserByEmailAndPassword(email, password);
		return user;
	}

	public List<User> getAllUsers() {
		return userPersistance.getAllUsers();
	}

	@SuppressWarnings({ "unchecked" })
	public boolean addUser(String email, String password) throws NoSuchAlgorithmException {
		boolean result = false;
		if(userPersistance.addUser(email, password)) {
			Map mailTemplateMap = new HashMap<String, String>();
			String subject = "Welcome to Simple Mailer Application!";
			mailTemplateMap.put("email", email);
			mailTemplateMap.put("password", password);
			mailTemplateMap.put("link", "http://localhost:8080/mailer/login_page.action");
			mailSender.sendMail(subject, "welcomeUser.html", mailTemplateMap, null, email);
			result = true;
		}
		return result;
	}
	public void deleteUser(List<String> idList) {
		userPersistance.deleteUser(idList);
	}

}
