package org.mailer.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.mailer.service.SearchService;
import org.mailer.utils.BeanFinder;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 5513231230300677291L;
	private HttpServletRequest servletRequest;
	
	String indexAll() {
		SearchService searchService = (SearchService) BeanFinder.getContext(servletRequest).getBean("searchService");
		searchService.indexAll();
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}
	
}
