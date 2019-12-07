<%@ include file="includes/inc.taglibs.jsp" %>

<tiles:insertDefinition name="baseLayout">
	
	<tiles:putAttribute name="title"> 
		${campaignName}
	</tiles:putAttribute>
    
    <tiles:putAttribute name="body">
		<div>
		<p>
			Here you can edit and update your campaign-mail.
			A preview of the mail is always displayed when you update your mail.
			<br/>
			After the editing is completed, 
			<a href="send_campaign.action?campaignId=${campaignId}">
				click here
			</a>
			to send the campaign to your contacts.
		</p>
		<s:form action="update_campaign" theme="simple">
			<div class="editorDiv">
				<s:hidden name="campaignName"></s:hidden>
				<s:hidden name="campaignId"></s:hidden>
				<p>
				Last Modified on : ${modifiedOn} 
				</p>
				<p>
				<s:fielderror fieldName="subject"></s:fielderror><br/>
				Subject<span class="required">*</span> :
				<s:textfield name="subject" cssClass="subjectStyle"></s:textfield>
				</p>
				<s:fielderror fieldName="body"></s:fielderror><br/>
				Body<span class="required">*</span> &nbsp;&nbsp;&nbsp;: <br/>
				<s:textarea name="body" cssClass="mceEditor" value="%{body}"></s:textarea>
			</div>
			<div class="editorPanel">
				<s:submit value="Update"></s:submit>
				<input type="button" value="Send Campaign" 
					onclick="window.location='send_campaign.action?campaignId=${campaignId}'"/>
			</div>
		</s:form>
		</div>
		<div class="preview">
			<p>
			<strong>Subject :</strong> ${subject}
			</p>
			<strong>Body &nbsp;&nbsp;&nbsp;:</strong> <br/>
			${body}
		</div>
		<!-- TinyMCE -->
		<script type="text/javascript" src="web/tinyMCE/tiny_mce.js"></script>
		<script type="text/javascript">
			tinyMCE.init({
				// General options
				editor_selector : "mceEditor",
				mode : "textareas",
				theme : "advanced",
				plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",
		
				// Theme options
				theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
				theme_advanced_toolbar_location : "top",
				theme_advanced_toolbar_align : "left",
				theme_advanced_statusbar_location : "bottom",
				theme_advanced_resizing : true,
		
				// Example content CSS (should be your site CSS)
				content_css : "web/css/content.css",
		
				// Drop lists for link/image/media/template dialogs
				template_external_list_url : "lists/template_list.js",
				external_link_list_url : "lists/link_list.js",
				external_image_list_url : "lists/image_list.js",
				media_external_list_url : "lists/media_list.js",
		
				// Style formats
				style_formats : [
					{title : 'Bold text', inline : 'b'},
					{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
					{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
					{title : 'Example 1', inline : 'span', classes : 'example1'},
					{title : 'Example 2', inline : 'span', classes : 'example2'},
					{title : 'Table styles'},
					{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
				],
		
				// Replace values for the template plugin
				template_replace_values : {
					username : "Some User",
					staffid : "991234"
				}
			});
		</script>
		<!-- /TinyMCE -->
	</tiles:putAttribute>
</tiles:insertDefinition>