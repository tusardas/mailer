package org.mailer.utils;

import org.apache.log4j.Logger;
import org.mailer.service.CampaignService;
import org.mailer.service.ContactService;

public class SolrService {
	private static Logger logger = Logger.getLogger(SolrService.class);
	private CampaignService campaignService;
	private ContactService contactService;
	public CampaignService getCampaignService() {
		return campaignService;
	}
	public void setCampaignService(CampaignService campaignService) {
		this.campaignService = campaignService;
	}
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	public void indexAll() {
		
	}
}
