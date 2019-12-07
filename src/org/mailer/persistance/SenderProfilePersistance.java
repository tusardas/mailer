package org.mailer.persistance;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mailer.object.SenderProfile;

public class SenderProfilePersistance extends BasePersistenceImpl {
	
	public SenderProfile loadProfile(long senderId) {
		Criteria criteria = getSession().createCriteria(SenderProfile.class);
		criteria.add(Restrictions.eq("senderId", senderId));
		return (SenderProfile) criteria.uniqueResult();
	}

	public void updateProfile(long senderId, String host, String username,
			String password, String protocol, String port, String preferredName) {
		SenderProfile senderProfile = loadProfile(senderId);
		
		if(senderProfile == null) {
			senderProfile = new SenderProfile();
			senderProfile.setSenderId(senderId);
		}
		senderProfile.setHost(host);
		senderProfile.setUsername(username);
		senderProfile.setPassword(password);
		senderProfile.setProtocol(protocol);
		senderProfile.setPort(port);
		senderProfile.setPreferredName(preferredName);
		getHibernateTemplate().save(senderProfile);
		getSession().flush();
		
	}

}
