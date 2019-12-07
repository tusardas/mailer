package org.mailer.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.mailer.object.Campaign;
import org.mailer.service.CampaignService;
import org.mailer.utils.BeanFinder;

import com.opensymphony.xwork2.ActionSupport;

public class CampaignAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = -2875930241017767231L;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(ContactAction.class);
	private List<Campaign> campaignList;
	private String campaignName;
	private HttpServletRequest servletRequest;
	private List<String> idList = new ArrayList<String>();
	private String campaignId;
	private String subject;
	private String body;
	private Date modifiedOn;
	
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public List<String> getIdList() {
		return idList;
	}
	public List<Campaign> getCampaignList() {
		return campaignList;
	}
	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	public String listCampaigns() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		long createdBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		campaignList = campaignService.getAllCampaigns(createdBy);
		return SUCCESS;
	}
	
	public String addCampaign() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		long createdBy = (Long) servletRequest.getSession().getAttribute(org.mailer.utils.Constants.USERID);
		try {
			if(campaignService.addCampaign(createdBy, campaignName)) {
				return SUCCESS;
			}
			else {
				addActionError(getText("error.campaign.saving"));
				return INPUT;
			}
		}
		catch(Exception e) {
			addActionError(getText("error.campaign.saving"));
			return INPUT;
		}
	}
	
	public String deleteCampaign() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		campaignService.deleteCampaign(idList);
		return SUCCESS;
	}
	
	public String loadCampaign() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		Campaign campaignObj = campaignService.loadCampaign(Long.parseLong(campaignId));
		subject = campaignObj.getSubject();
		body = campaignObj.getBody();
		modifiedOn = campaignObj.getModifiedOn();
		campaignName = campaignObj.getCampaignName();
		return SUCCESS;
	}
	
	public String updateCampaign() {
		CampaignService campaignService = (CampaignService) BeanFinder.getContext(servletRequest).getBean("campaignService");
		modifiedOn = campaignService.updateCampaign(campaignId, subject, body);
		return SUCCESS;
	}
	
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest =  servletRequest;
	}
	
	
}
