<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Login | Mailer
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<div class="formDiv">
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
		</div>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$(".login").each( function () {
					this.innerHTML = "";
				});
			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>