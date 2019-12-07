<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		User Management
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<div>
    		Here you can add and remove users using this mailer application.
    	</div>
    	<div>
    	<div class="emailFormDiv">
		<s:form action="add_user" theme="simple">
			<p><s:actionerror /></p>
			<p><s:fielderror fieldName="email"></s:fielderror></p>
			Email-ID<span class="required">*</span> &nbsp;&nbsp;: <s:textfield name="email" cssClass="emailStyle"></s:textfield><br/>
			<p><s:fielderror fieldName="password"></s:fielderror></p>
			Password<span class="required">*</span> : <s:textfield name="password" cssClass="emailStyle"></s:textfield><br/>
			<s:submit value="Add User" cssClass="button"></s:submit>
		</s:form>
		</div>
		<div class="userList">
			<s:if test="%{userList.size == 0}">
				Currently, no one is using this application.
			</s:if>
			<s:else>
				<s:form action="delete_user" theme="simple">
				<s:actionerror/>
				<strong>
					<s:property value="%{userList.size}"/> users found !<br/>
				</strong>
				<div class="listing">
				<s:iterator value="userList" var="user" status="ind">
					<p>
						<s:property value="%{#ind.index + 1}"/>.&nbsp;
						<s:checkbox name="idList[%{#ind.index}]" fieldValue="%{email}" cssClass="checkBoxClass" />
						${email}
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