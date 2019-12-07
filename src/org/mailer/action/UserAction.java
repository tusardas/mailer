package org.mailer.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import org.mailer.object.User;
import org.mailer.service.UserService;
import org.mailer.utils.BeanFinder;

public class UserAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 8195034978802080393L;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(UserAction.class);
	private List<User> userList;
	private String email;
	private String password;
	private HttpServletRequest servletRequest;
	private List<String> idList = new ArrayList<String>();
	
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public String listUsers() {
		UserService userService = (UserService) BeanFinder.getContext(servletRequest).getBean("userService");
		userList = userService.getAllUsers();
		return SUCCESS;
	}
	
	public String addUser() {
		UserService userService = (UserService) BeanFinder.getContext(servletRequest).getBean("userService");
		try {
			if(userService.addUser(email, password)) {
				return SUCCESS;
			}
			else {
				addActionError(getText("error.user.exists"));
				return INPUT;
			}
		}
		catch(Exception e) {
			addActionError(getText("error.user.saving"));
			return INPUT;
		}
	}
	
	public String deleteUser() {
		UserService userService = (UserService) BeanFinder.getContext(servletRequest).getBean("userService");
		userService.deleteUser(idList);
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}

}
