<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Home | Mailer
	</tiles:putAttribute>
  	
  	<tiles:putAttribute name="body">
    	This is a simple email campaign application. This
    	application does not send the mail with its own server,
    	rather it uses the mail server details user provides
    	in his/her profile and sends the mails using the same.
    	You are free to use whatever free email account you have
    	in Yahoo! or Google or any other email service provider.
	</tiles:putAttribute>

</tiles:insertDefinition>