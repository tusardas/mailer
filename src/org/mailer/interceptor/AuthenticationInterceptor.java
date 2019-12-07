package org.mailer.interceptor;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class AuthenticationInterceptor extends AbstractInterceptor {
	
	Logger logger = Logger.getLogger(AuthenticationInterceptor.class);
	
	private static final long serialVersionUID = -3333235978553374905L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute(org.mailer.utils.Constants.EMAIL) != null 
				&&
				!(request.getSession().getAttribute(org.mailer.utils.Constants.EMAIL).equals(""))){
			return invocation.invoke();
		}
		return "loginNeeded";
	}

}
