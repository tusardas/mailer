<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Edit Profile
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	Edit your mail sender profile here (all fields are mandatory):	
    	<div class="formDiv">
    	<s:form action="update_profile">
			<s:actionerror/>
			<s:actionmessage/>
			<table cellspacing="4" cellpadding="4">
				<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="host"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Hostname<span class="required">*</span></td>
		    		<td>:</td>
		    		<td><s:textfield name="host" cssClass="inputStyle"></s:textfield></td>
		    		<td>
		    			e.g. smtp.gmail.com for Gmail accounts<br/>
		    			smtp.mail.yahoo.com for Yahoo! accounts<br/>
		    		</td>
		    	</tr>
				
	    		<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="username"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Username<span class="required">*</span></td>
		    		<td>:</td>
		    		<td><s:textfield name="username" cssClass="inputStyle"></s:textfield></td>
		    		<td>
		    			e.g. tusar_das@ymail.com
		    		</td>
		    	</tr>
	    		
	    		<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="password"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Password<span class="required">*</span></td>
		    		<td>:</td>
		    		<td><s:password name="password" showPassword="true" cssClass="inputStyle"></s:password></td>
		    		<td>
		    			Password of the username entered above.<br/>
		    			This application saves the password in encrypted form<br/>
		    			and to ensure complete security of your email account, <br/>
		    			it is never displayed.
		    		</td>
		    	</tr>
	    		
	    		<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="protocol"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Protocol<span class="required">*</span></td>
		    		<td>:</td>
		    		<td><s:textfield name="protocol" cssClass="inputStyle"></s:textfield></td>
		    		<td>
		    			This is always smtp
		    		</td>
		    	</tr>
		    	
		    	<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="port"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Port<span class="required">*</span></td>
		    		<td>:</td>
		    		<td><s:textfield name="port" cssClass="inputStyle"></s:textfield></td>
		    		<td>
		    			e.g. 465 for Gmail and Yahoo! accounts<br/>
		    		</td>
		    	</tr>
		    	
		    	<tr valign="top"><td colspan="2"></td><td><s:fielderror fieldName="preferredName"/></td><td></td></tr>
		    	<tr valign="top">
		    		<td>Preferred Name</td>
		    		<td>:</td>
		    		<td><s:textfield name="preferredName" cssClass="inputStyle"></s:textfield></td>
		    		<td>
		    			This name will be used as sender's name.
		    		</td>
		    	</tr>
	    		
	    		<tr valign="top"><td></td><td><s:submit value="Update"/></td></tr>
	    	
	    	</table>
		</s:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>