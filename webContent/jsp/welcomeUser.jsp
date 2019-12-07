<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		Welcome <s:property value="#session.email"/> !
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
    	<p>
    		Hello <s:property value="#session.email"/> !
    	</p>
	</tiles:putAttribute>
</tiles:insertDefinition>