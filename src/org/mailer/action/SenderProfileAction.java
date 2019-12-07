package org.mailer.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.mailer.object.SenderProfile;
import org.mailer.service.SenderProfileService;
import org.mailer.utils.BeanFinder;

import com.opensymphony.xwork2.ActionSupport;

public class SenderProfileAction extends ActionSupport implements ServletRequestAware {
	
	private static final long serialVersionUID = -4020036218682979481L;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(SenderProfileAction.class);
	private String host;
	private String username;
	private String password;
	private String protocol;
	private String port;
	private String preferredName;
	private HttpServletRequest servletRequest;
	
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
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPreferredName() {
		return preferredName;
	}
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	
	public String loadProfile() {
		SenderProfileService senderProfileService = (SenderProfileService) BeanFinder.getContext(servletRequest).getBean("senderProfileService");
		long senderId = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		SenderProfile senderProfileObj = senderProfileService.loadProfile(senderId);
		if(senderProfileObj != null) {
			host = senderProfileObj.getHost();
			username = senderProfileObj.getUsername();
			password = senderProfileObj.getPassword();
			protocol = senderProfileObj.getProtocol();
			port = senderProfileObj.getPort();
			preferredName = senderProfileObj.getPreferredName();
		}
		return SUCCESS;
	}
	
	public String updateProfile() {
		SenderProfileService senderProfileService = (SenderProfileService) BeanFinder.getContext(servletRequest).getBean("senderProfileService");
		long senderId = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		senderProfileService.updateProfile(senderId, host, username, password, protocol, port, preferredName);
		addActionMessage(getText("msg.profile.update"));
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}
	
}
