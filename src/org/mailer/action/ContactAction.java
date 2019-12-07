package org.mailer.action;

import java.io.File;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Workbook;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

import org.mailer.object.Contact;
import org.mailer.service.ContactService;
import org.mailer.utils.BeanFinder;

public class ContactAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1380217933455069726L;
	private static Logger logger = Logger.getLogger(ContactAction.class);
	private List<Contact> contactList;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String gender;
	private HttpServletRequest servletRequest;
	private List<String> idList = new ArrayList<String>();
	private File uploadedFile;
	private String contentType;
	private String fileName;
	
	public String getUploadedFileContentType() {
		return contentType;
	}
	public void setUploadedFileContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getUploadedFileFileName() {
		return fileName;
	}
	public void setUploadedFileFileName(String fileName) {
		this.fileName = fileName;
	}
	public File getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(File uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String listContacts() {
		ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
		long uploadedBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		contactList = contactService.getAllContacts(uploadedBy);
		return SUCCESS;
	}
	
	public String addContact() {
		ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
		long uploadedBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		try {
			if(contactService.addContact(uploadedBy, emailAddress, firstName, lastName, gender)) {
				return SUCCESS;
			}
			else {
				addActionError(getText("error.contact.exists"));
				return INPUT;
			}
		}
		catch(Exception e) {
			addActionError(getText("error.contact.saving"));
			return INPUT;
		}
	}
	
	public String deleteContact() {
		ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
		long uploadedBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		contactService.deleteContact(idList, uploadedBy);
		return SUCCESS;
	}
	
	public String contactsUpload() {
		try{
			UID uId = new UID();
			String UUId = uId.toString();
			for(int i=0;i<UUId.length();i++){
				if(!Character.isLetter(UUId.charAt(i)) && !Character.isDigit(UUId.charAt(i))){
					UUId = UUId.substring(0,i)+UUId.substring(i+1,UUId.length());
				}
			}
			if(UUId.indexOf("-") >= 0){
				UUId = UUId.substring(0,UUId.indexOf("-"))+UUId.substring(UUId.indexOf("-")+1,UUId.length());
			}
			UUId = UUId.substring(UUId.length()-13,UUId.length());
			String uniqueName = ((String) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.EMAIL)).concat("_").concat(UUId).concat(".xls");
			logger.info("\nAttempting to write file: " + uniqueName);
			File saveTo = new File(getText("file.save.path"), uniqueName);
			uploadedFile.renameTo(saveTo);
			logger.info("\nNew file created: " + saveTo.getAbsolutePath());
			ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
			long uploadedBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
			logger.info("\nUploading contacts...");
			String errorMsg = contactService.uploadContacts(uploadedBy, Workbook.getWorkbook(saveTo)); 
			if (errorMsg.equals("")) {
				return SUCCESS;
			}
			else {
				logger.info("\nError(s)...\n" + errorMsg);
				addActionMessage(getText("error.contact.uploading") + "<br/>" + errorMsg.replaceAll("\n", "<br/>"));
				return INPUT;
			}
		}
		catch (Exception e){
			logger.info("\nError occurred while saving file: \n"+ e);
			addActionError(getText("error.file.saving"));
			return INPUT;
		}
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}
}
