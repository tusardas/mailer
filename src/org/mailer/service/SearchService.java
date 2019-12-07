package org.mailer.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.mailer.object.Campaign;
import org.mailer.object.Contact;
import org.mailer.persistance.CampaignPersistance;
import org.mailer.persistance.ContactPersistance;

public class SearchService {
	private static Logger logger = Logger.getLogger(SearchService.class);
	private SolrServer searchServer;
	private CampaignPersistance campaignPersistance;
	private ContactPersistance contactPersistance;
	public CampaignPersistance getCampaignPersistance() {
		return campaignPersistance;
	}
	public void setCampaignPersistance(CampaignPersistance campaignPersistance) {
		this.campaignPersistance = campaignPersistance;
	}
	public ContactPersistance getContactPersistance() {
		return contactPersistance;
	}
	public void setContactPersistance(ContactPersistance contactPersistance) {
		this.contactPersistance = contactPersistance;
	}
	public SolrServer getSearchServer() {
		return searchServer;
	}
	public void setSearchServer(SolrServer searchServer) {
		this.searchServer = searchServer;
	}
	public void indexAll() {
		List<Campaign> campaignList = campaignPersistance.getCampaigns();
		int listSize = campaignList.size();
		if(listSize > 0){
			try {
				logger.info("Going to index " + listSize + "Campaigns...........");
				UpdateResponse ur = searchServer.addBeans(campaignList);
				searchServer.commit();
				logger.info("Done indexing in " + ur.getElapsedTime() +
						"\n Campaigns indexed : " + listSize);
				
			} catch (SolrServerException e) {
				e.printStackTrace();
				logger.error("Error while Indexing the Campaigns:");
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("Error while writing the Campaign-indexes:");
				e.printStackTrace();
			}
			optimizeIndex();
		}
		
		List<Contact> contactList = contactPersistance.getContacts();
		listSize = contactList.size();
		if(listSize > 0){
			try {
				logger.info("Going to index " + listSize + "Contacts...........");
				UpdateResponse ur = searchServer.addBeans(contactList);
				searchServer.commit();
				logger.info("Done indexing in " + ur.getElapsedTime() +
						"\n Contacts indexed : " + listSize);
				
			} catch (SolrServerException e) {
				e.printStackTrace();
				logger.error("Error while Indexing the Contacts:");
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("Error while writing the Contact-indexes:");
				e.printStackTrace();
			}
			optimizeIndex();
		}
		
		
	}
	public void optimizeIndex() {
		try {
			searchServer.optimize();
		} catch (Exception e) {
			logger.error("Error while optimizing the index"+e.getMessage());
		}
	}
}
