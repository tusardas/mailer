<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Send | Campaign
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<div>
    		Here you can preview your campaign and send the campaign to
    		desired contacts.
    	</div>
    	<div class="emailFormDiv">
    		<p>
    			<input type="button" value="Edit Campaign" 
					onclick="window.location='edit_campaign.action?campaignId=${campaignId}'"/>
    		</p>
    		<p>
			<strong>Campaign Name :</strong> ${campaignName} 
			</p>
    		<p>
			<strong>Last Modified on :</strong> ${modifiedOn} 
			</p>
			<p>
			<strong>Last Triggered on :</strong> 
				<s:if test="%{triggeredOn == null}">
					Never
				</s:if>
				<s:else>
					${triggeredOn}
				</s:else> 
			</p>
			<p>
			<strong>Last targeted on :</strong> ${numberOfTargets} contacts 
			</p>
    	</div>
    	<div class="userList">
    		<s:if test="%{contactList.size == 0}">
				Currently, there are no one on your contact list.
			</s:if>
			<s:else>
				<s:form action="send_now" theme="simple">
				<s:hidden name="campaignId"></s:hidden>
				<s:hidden name="campaignName"></s:hidden>
				<s:hidden name="modifiedOn"></s:hidden>
				<s:hidden name="triggeredOn"></s:hidden>
				<s:hidden name="numberOfTargets"></s:hidden>
				
				<strong>
					<s:property value="%{contactList.size}"/> contacts found !<br/>
				</strong>
				<s:actionerror/>
				<s:actionmessage/>
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
					<p><s:submit value="Send Now"/></p>
				</div>
				</s:form>
			</s:else>
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