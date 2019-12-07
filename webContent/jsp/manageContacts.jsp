<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Contacts
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<div>
    		Here you can update your contacts list.<br/>
    		<span class="required">*</span> marked fields are mandatory.
    	</div>
    	<div>
    	<div class="emailFormDiv">
			<s:form action="add_contact" theme="simple">
				<p><s:actionerror  /></p>
				
				<p><s:fielderror fieldName="emailAddress"></s:fielderror></p>
				Email-ID<span class="required">*</span> &nbsp;&nbsp;&nbsp;&nbsp;: <s:textfield name="emailAddress" cssClass="emailStyle"></s:textfield><br/>
				
				<p><s:fielderror fieldName="firstName"></s:fielderror></p>
				Firstname &nbsp;&nbsp;: <s:textfield name="firstName" cssClass="emailStyle"></s:textfield><br/>
				
				<p><s:fielderror fieldName="lastName"></s:fielderror></p>
				Lastname &nbsp;&nbsp;: <s:textfield name="lastName" cssClass="emailStyle"></s:textfield><br/>
				
				<p><s:fielderror fieldName="gender"></s:fielderror></p>
				Gender &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <s:radio name="gender" list="#{'M':'Male', 'F':'Female'}"></s:radio><br/>
				
				<s:submit value="Add Contact" cssClass="button"></s:submit>
			</s:form>
			<p>
			Or, you may want to upload your contacts from XLS file (we suggest to use firefox browser, as other browsers are unable to detect the file-type):
			</p>
			<s:fielderror></s:fielderror>
			 <s:form action="contacts_upload" method="post" enctype="multipart/form-data">
		        <s:file name="uploadedFile" />
		        <s:submit value="Upload"/>
		    </s:form>
		    <p>
		    <s:actionmessage escape="false"/>
		    </p>
		</div>
		
		<div class="userList">
			<s:if test="%{contactList.size == 0}">
				Currently, there are no one on your contact list.
			</s:if>
			<s:else>
				<s:form action="delete_contact" theme="simple">
				<strong>
					<s:property value="%{contactList.size}"/> contacts found !<br/>
				</strong>
				<div class="listing">
				<s:iterator value="contactList" var="user" status="ind">
					<p>
						<s:property value="%{#ind.index + 1}"/>.&nbsp;
						<s:checkbox name="idList[%{#ind.index}]" fieldValue="%{emailAddress}" cssClass="checkBoxClass" />
						${emailAddress}
					</p>
				</s:iterator>
				</div>
				<div class="panel">
					<p><input type="button" value="Select All" id="checkAll" /></p>
					<p><input type="button" value="Uncheck All" id="uncheckAll"/></p>
					<p><s:submit value="Remove"/></p>
				</div>
				</s:form>
			</s:else>
		</div>
		 
		</div>
		
		<script>
		$(document).ready(function(){
		     $("#checkAll").click(function () {
		          $(".checkBoxClass").attr("checked", true);
		     });

		     $("#uncheckAll").click(function () {
		          $(".checkBoxClass").attr("checked", false);
		     });
		});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>