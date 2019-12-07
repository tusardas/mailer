package org.mailer.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.mailer.object.Campaign;
import org.mailer.object.SenderProfile;
import org.mailer.persistance.CampaignPersistance;
import org.mailer.persistance.SenderProfilePersistance;
import org.mailer.utils.EncryptAndDecrypt;
import org.mailer.utils.MailSender;

public class SenderProfileService {
	private SenderProfilePersistance senderProfilePersistance;
	private MailSender mailSender;
	private CampaignPersistance campaignPersistance;
	private static Logger logger = Logger.getLogger(SenderProfileService.class);
	
	public CampaignPersistance getCampaignPersistance() {
		return campaignPersistance;
	}
	public void setCampaignPersistance(CampaignPersistance campaignPersistance) {
		this.campaignPersistance = campaignPersistance;
	}
	public MailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public SenderProfilePersistance getSenderProfilePersistance() {
		return senderProfilePersistance;
	}

	public void setSenderProfilePersistance(
			SenderProfilePersistance senderProfilePersistance) {
		this.senderProfilePersistance = senderProfilePersistance;
	}

	public SenderProfile loadProfile(long senderId) {
		return senderProfilePersistance.loadProfile(senderId);
	}

	public void updateProfile(long senderId, String host, String username,
			String password, String protocol, String port, String preferredName) {
		senderProfilePersistance.updateProfile(senderId, host, username,
				EncryptAndDecrypt.encrypt(password), protocol, port, preferredName);
	}

	public boolean sendCampaign(SenderProfile senderProfileObj, Long campaignId, List<String> idList) {
		boolean returnValue = false;
				
		Campaign campaignObj = campaignPersistance.getCampaignByCampaignId(campaignId);
		
		if(campaignObj != null && idList.size() > 0) {
			mailSender.setHost(senderProfileObj.getHost());
			mailSender.setUsername(senderProfileObj.getUsername());
			mailSender.setPassword(EncryptAndDecrypt.decrypt(senderProfileObj.getPassword()));
			mailSender.setPort(senderProfileObj.getPort());
			mailSender.setProtocol(senderProfileObj.getProtocol());
			/*	Used '+' operator to concat() String. My sincere apologies to true performance enthusiasts.
				Sacrificed this performance issue for greater readability*/
			mailSender.setFromAddress("\"" + senderProfileObj.getPreferredName() + "\"<" + senderProfileObj.getUsername() + ">");
			mailSender.setSmtpAuthentication("true");
			try {
				for(String to : idList) {
					if(!to.equals("false"))
						mailSender.sendMail(campaignObj.getSubject(), campaignObj.getBody(), to);
				}
				returnValue = true;
			}
			catch (Exception e) {
				logger.info("\nException occurred while sending mail: " + e.getMessage());
			}
		}
		return returnValue;
	}

}
