<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Campaigns
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<div>
    		Here you can create, edit or delete your campaigns.<br/>
    		<span class="required">*</span> marked fields are mandatory.
    	</div>
    	<div>
    	<div class="emailFormDiv">
		<s:form action="add_campaign" theme="simple">
			<p><s:actionerror /></p>
			
			<p><s:fielderror fieldName="campaignName"></s:fielderror></p>
			Name of campaign<span class="required">*</span> : <s:textfield name="campaignName" cssClass="inputStyle"></s:textfield><br/>
			[Max 50 characters.]<br/>
			
			<s:submit value="Add Campaign" cssClass="button"></s:submit>
		</s:form>
		</div>
		
		<div class="userList">
			<s:if test="%{campaignList.size == 0}">
				Currently, there are no campaigns created by you.
			</s:if>
			<s:else>
				<s:form action="delete_campaign" theme="simple">
				<strong>
					<s:property value="%{campaignList.size}"/> campaigns found !<br/>
					Click on the campaign-name to edit/send.<br/>
				</strong>
				<div class="listing">
				<s:iterator value="campaignList" var="user" status="ind">
					<p>
						<s:property value="%{#ind.index + 1}"/>.&nbsp;
						<s:checkbox name="idList[%{#ind.index}]" fieldValue="%{campaignId}" cssClass="checkBoxClass" />
						<a href="edit_campaign.action?campaignId=${campaignId}">
							${campaignName}
						</a>
					</p>
				</s:iterator>
				</div>
				<div class="panel">
					<p><input type="button" value="Select All" id="checkAll" /></p>
					<p><input type="button" value="Uncheck All" id="uncheckAll"/></p>
					<p><s:submit value="Delete"/></p>
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