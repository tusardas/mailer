<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="inc.taglibs.jsp" %>
		<div>
        <img src="web/images/title.png" 
        	alt="Simple Mailer Dropdowns" width="503" height="36" />
	   	</div>   
        <div class="FL">
        	<div>
        		-by Tusar
        	</div>
        	<div class="topLinks">
        	<s:if test='#session.email != null'>
        		<a href="user_home.action">Home</a> |
        		<s:if test='#session.role == "o"'>
        			<a href="manage_users.action">User Management</a> |
        		</s:if>
        		<s:elseif test='#session.role == "a"'>
	        		<a href="manage_contacts.action">Contacts</a> |
	        		<a href="manage_campaigns.action">Campaign</a> |
	        		<a href="edit_profile.action">Sender Profile</a> |
        		</s:elseif>
        	</s:if>
        	<s:else>
        		<a href="home.action">Home</a> |
        		<a href="login_page.action">Login</a> |
        	</s:else>
        	<a href="about_page.action">About</a>
        	</div>
        </div>  
        
        <div class="login">
			<s:if test='#session.email != null'>
				<form>
					<div>Welcome <s:property value="#session.email"/></div>
					<div><a href="logout.action">Logout</a></div>
				</form>	
			</s:if>
			<s:else>
				<s:form action="login" theme="simple">
					<s:token name="userToken"></s:token>
					<s:actionerror></s:actionerror>
					<div>
					Email-ID &nbsp;&nbsp;&nbsp;: <s:textfield name="email" cssClass="inputStyle"></s:textfield>
					</div>
					<div>
					Password&nbsp;&nbsp;: <s:password name="password" cssClass="inputStyle"></s:password>
					</div>
					<div>
					<s:submit value="Login"></s:submit>
					</div>
				</s:form>
			</s:else>
		</div>
		<br/>
		<hr />