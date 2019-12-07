package org.mailer.object;

import java.util.Date;

public class Campaign {
	private long id;
	private long campaignId;
	private long createdBy;
	private String campaignName;
	private String subject;
	private String body;
	private Date modifiedOn;
	private Date triggeredOn;
	private long numberOfTargets;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
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
	public long getNumberOfTargets() {
		return numberOfTargets;
	}
	public void setNumberOfTargets(long numberOfTargets) {
		this.numberOfTargets = numberOfTargets;
	}
}
