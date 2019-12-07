package org.mailer.persistance;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mailer.object.User;
import org.mailer.utils.PasswordEncryptor;

public class UserPersistance extends BasePersistenceImpl {
	
	public User getUserByEmail(String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;
		user = getUserByEmail(email);
		if(user == null) {
			return null;
		}
		else if( PasswordEncryptor.getHashCode( 
				org.mailer.utils.Constants.SALT.concat(password) ).equals( user.getPassword() ) ){
			return user;
		}
		else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userCategory", org.mailer.utils.Constants.GENERAL_USER));
		return criteria.list();
	}

	public boolean addUser(String email, String password) throws NoSuchAlgorithmException {
		boolean result = true;
		if(getUserByEmail(email) == null) {
			User userObject = new User();
			SecureRandom generatedHash = SecureRandom.getInstance("SHA1PRNG");
			userObject.setUserId(new Integer(generatedHash.nextInt()));
			userObject.setEmail(email);
			userObject.setUserCategory("a");
			userObject.setPassword(PasswordEncryptor.getHashCode( 
					org.mailer.utils.Constants.SALT.concat(password)));
			getHibernateTemplate().save(userObject);
			getSession().flush();
		}
		else {
			result = false;
		}
		return result;
	}

	public void deleteUser(List<String> idList) {
		User user = new User();
		for(String email : idList) {
			user = getUserByEmail(email);
			if(user != null) {
				getHibernateTemplate().delete(user);
			}
		}
	}
}
