package org.mailer.interceptor;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.mailer.utils.Constants;
public class UserAuthenticationInterceptor extends AbstractInterceptor {
	
	Logger logger = Logger.getLogger(UserAuthenticationInterceptor.class);
	
	private static final long serialVersionUID = -3333235978553374905L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute(Constants.EMAIL) != null 
				&&
				!(request.getSession().getAttribute(Constants.EMAIL).equals(""))){
			return invocation.invoke();
		}
		return "loginNeeded";
	}

}
