package org.mailer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.mailer.object.Campaign;
import org.mailer.utils.Constants;
import org.mailer.object.Contact;
import org.mailer.object.SenderProfile;
import org.mailer.service.CampaignService;
import org.mailer.service.ContactService;
import org.mailer.service.SenderProfileService;
import org.mailer.utils.BeanFinder;

public class CampaignSenderAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -3238281829740719621L;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(CampaignSenderAction.class);
	private String campaignId;
	private Date modifiedOn;
	private Date triggeredOn;
	private Long numberOfTargets;
	private String campaignName;
	private HttpServletRequest servletRequest;
	private List<String> idList = new ArrayList<String>();
	private List<Contact> contactList;

	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Date getTriggeredOn() {
		return triggeredOn;
	}
	public void setTriggeredOn(Date triggeredOn) {
		this.triggeredOn = triggeredOn;
	}
	public Long getNumberOfTargets() {
		return numberOfTargets;
	}
	public void setNumberOfTargets(Long numberOfTargets) {
		this.numberOfTargets = numberOfTargets;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	
	public String loadCampaign() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		Campaign campaignObj = campaignService.loadCampaign(Long.parseLong(campaignId));
		campaignName = campaignObj.getCampaignName();
		modifiedOn = campaignObj.getModifiedOn();
		triggeredOn = campaignObj.getTriggeredOn();
		numberOfTargets = campaignObj.getNumberOfTargets();
		
		
		ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
		long uploadedBy = (Long) servletRequest.getSession().getAttribute(Constants.USERID);
		contactList = contactService.getAllContacts(uploadedBy);
		
		return SUCCESS;
	}
	
	public String sendNow() {
		String returnString = INPUT;
		SenderProfileService senderProfileService = (SenderProfileService) BeanFinder.getContext(servletRequest).getBean("senderProfileService");
		long senderId = (Long) servletRequest.getSession().getAttribute(Constants.USERID);
		SenderProfile senderProfileObj = senderProfileService.loadProfile(senderId);
		if(senderProfileObj == null || senderProfileObj.getHost().equals("")) {
			addActionError(getText("error.profile.null"));
			returnString = INPUT;
		}
		else {
			if(senderProfileService.sendCampaign(senderProfileObj, Long.parseLong(campaignId), idList)) {
				addActionMessage(getText("msg.campaign.sent"));
				returnString = SUCCESS;
			}
			else {
				addActionError(getText("error.sending.campaign"));
			}
		}
		ContactService contactService = (ContactService) BeanFinder.getContext(servletRequest).getBean("contactService");
		long uploadedBy = (Long) servletRequest.getSession().getAttribute(Constants.USERID);
		contactList = contactService.getAllContacts(uploadedBy);
		return returnString;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}

}
