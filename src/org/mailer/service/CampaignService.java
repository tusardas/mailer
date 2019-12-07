package org.mailer.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.mailer.object.Campaign;
import org.mailer.persistance.CampaignPersistance;

public class CampaignService {
	
	private CampaignPersistance campaignPersistance;
	
	public CampaignPersistance getCampaignPersistance() {
		return campaignPersistance;
	}
	public void setCampaignPersistance(CampaignPersistance campaignPersistance) {
		this.campaignPersistance = campaignPersistance;
	}

	public List<Campaign> getAllCampaigns(long createdBy) {
		return campaignPersistance.getAllCampaigns(createdBy);
	}

	public boolean addCampaign(long createdBy, String campaignName) throws NoSuchAlgorithmException {
		return campaignPersistance.addCampaign(createdBy, campaignName);
	}

	public void deleteCampaign(List<String> idList) throws NumberFormatException {
		campaignPersistance.deleteCampaign(idList);
	}
	public Campaign loadCampaign(Long campaignId) {
		return campaignPersistance.getCampaignByCampaignId(campaignId);
	}
	public Date updateCampaign(String campaignId, String subject, String body) {
		return campaignPersistance.updateCampaign(campaignId, subject, body);
	}

}
