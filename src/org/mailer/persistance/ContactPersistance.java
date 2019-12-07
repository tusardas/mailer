package org.mailer.persistance;

import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import org.mailer.object.Contact;

public class ContactPersistance extends BasePersistenceImpl {
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts(long uploadedBy) {
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("uploadedBy", uploadedBy));
		return criteria.list();
	}
	
	public Contact getContactByEmailAddress(String emailAddress) {
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("emailAddress", emailAddress));
		return (Contact) criteria.uniqueResult();
	}
	
	public Contact getContactByEmailAddressAndUploadedBy(String emailAddress, long uploadedBy) {
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("emailAddress", emailAddress));
		criteria.add(Restrictions.eq("uploadedBy", uploadedBy));
		return (Contact) criteria.uniqueResult();
	}

	public boolean addContact(long uploadedBy, String emailAddress, String firstName,
			String lastName, String gender) throws NoSuchAlgorithmException {
		boolean result = true;
		if(getContactByEmailAddressAndUploadedBy(emailAddress, uploadedBy) == null) {
			Contact contactObject = new Contact();
			SecureRandom generatedHash = SecureRandom.getInstance("SHA1PRNG");
			contactObject.setContactId(new Integer(generatedHash.nextInt()));
			contactObject.setUploadedBy(uploadedBy);
			contactObject.setEmailAddress(emailAddress);
			contactObject.setFirstName(firstName);
			contactObject.setLastName(lastName);
			contactObject.setGender(gender);
			getHibernateTemplate().save(contactObject);
			getSession().flush();
		}
		else {
			result = false;
		}
		return result;
	}

	public void deleteContact(List<String> idList, long uploadedBy) {
		Contact contact = new Contact();
		for(String emailAddress : idList) {
			contact = getContactByEmailAddressAndUploadedBy(emailAddress, uploadedBy);
			if(contact != null) {
				getHibernateTemplate().delete(contact);
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getContacts() {
		return getSession().createCriteria(Contact.class).list();
	}

}
