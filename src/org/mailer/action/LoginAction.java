package org.mailer.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import org.mailer.object.User;
import org.mailer.service.UserService;
import org.mailer.utils.BeanFinder;

public class LoginAction extends ActionSupport  implements ServletRequestAware {

	private static final long serialVersionUID = 6651454201573518655L;
	
	private String email;
	private String formToken;
	private String password;
	private HttpServletRequest servletRequest;
	private String userToken;
	
	public String authVerify() {
		if(formToken.equals(userToken)){
			UserService userService = (UserService) BeanFinder.getContext(servletRequest).getBean("userService");
			User user  = userService.authenticateUser( email,password); 
			if(user != null) {
				servletRequest.getSession().setAttribute(org.mailer.utils.Constants.EMAIL, user.getEmail());
				servletRequest.getSession().setAttribute(org.mailer.utils.Constants.USERID, user.getUserId());
				servletRequest.getSession().setAttribute(org.mailer.utils.Constants.ROLE, user.getUserCategory());
				return SUCCESS;
			}
			else {
				addActionError(getText("error.login.failed"));
				return INPUT;
			}
		}
		else {
			addActionError(getText("error.authentication.failed"));
			return INPUT;
		}
	}
	public String clearSession() {
		servletRequest.getSession().setAttribute(org.mailer.utils.Constants.EMAIL, null);
		servletRequest.getSession().setAttribute(org.mailer.utils.Constants.USERID, -1);
		servletRequest.getSession().setAttribute(org.mailer.utils.Constants.ROLE, null);
		return SUCCESS;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
		formToken = servletRequest.getSession().getAttribute("userToken").toString();
	}
	
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
}
