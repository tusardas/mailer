package org.mailer.persistance;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mailer.object.Campaign;

public class CampaignPersistance extends BasePersistenceImpl {
	
	public Campaign getCampaignByCampaignId(Long campaignId) {
		Criteria criteria = getSession().createCriteria(Campaign.class);
		criteria.add(Restrictions.eq("campaignId", campaignId));
		return (Campaign) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Campaign> getAllCampaigns(long createdBy) {
		Criteria criteria = getSession().createCriteria(Campaign.class);
		criteria.add(Restrictions.eq("createdBy", createdBy));
		return criteria.list();
	}

	public boolean addCampaign(long createdBy, String campaignName) throws NoSuchAlgorithmException {
		Campaign campaignObject = new Campaign();
		SecureRandom generatedHash = SecureRandom.getInstance("SHA1PRNG");
		campaignObject.setCampaignId(new Integer(generatedHash.nextInt()));
		campaignObject.setCreatedBy(createdBy);
		campaignObject.setCampaignName(campaignName);
		getHibernateTemplate().save(campaignObject);
		getSession().flush();
		return true;
	}

	public void deleteCampaign(List<String> idList) throws NumberFormatException {
		Campaign campaign = null;
		for(String campaignId : idList) {
			if(!campaignId.equals("false")) {
				campaign = getCampaignByCampaignId(Long.parseLong(campaignId));
				if(campaign != null) {
					getHibernateTemplate().delete(campaign);
				}
			}
		}
	}
	
	public Date updateCampaign(String campaignId, String subject, String body) throws NumberFormatException {
		Campaign campaign = getCampaignByCampaignId(Long.parseLong(campaignId));
		if(campaign != null) {
		    campaign.setSubject(subject);
		    campaign.setBody(body);
		    getHibernateTemplate().update(campaign);
		    getSession().flush();
		    getSession().refresh(campaign);
		    return campaign.getModifiedOn();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Campaign> getCampaigns() {
		return getSession().createCriteria(Campaign.class).list();
	}

}
