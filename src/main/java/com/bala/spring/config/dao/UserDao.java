package com.bala.spring.config.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 

import com.bala.spring.model.User;
import com.bala.spring.util.CustomPasswordEncoder;

import javax.transaction.Transactional;

 
import java.util.List;
 
 
 
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	CustomPasswordEncoder passencoder = new CustomPasswordEncoder();

	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	public void save(User user) {
		logger.info("****************save user*****************************.", "save");
		String pass = passencoder.encode(user.getPassword());
		user.setPassword(pass);
		user.setPasswordConfirm(pass);
		getSession().save(user);
		getSession().flush();
		return;
	}

	/*
	 * public void delete(User user) { getSession().delete(user); return; }
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getSession().createQuery("from User").list();
	}

	public User getByEmail(String email) {
		logger.info("****************getByEmail*****************************.", "getByEmail");
		return (User) getSession().createQuery("from User where email = :email").setParameter("email", email)
				.uniqueResult();
		// return (users != null && !users.isEmpty()) ? users.get(0) : null;
	}

	public User getByUsername(String username) {
		logger.info("****************getByEmail*****************************.", "getByUsername");
		return (User) getSession().createQuery("from User where username = :username")
				.setParameter("username", username).uniqueResult();
		// return (users != null && !users.isEmpty()) ? users.get(0) : null;
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> users = getSession().createCriteria(User.class).list();
		return users;
	}

	public boolean authenticateUser(String userpass, String dbpass) {

		String userp = passencoder.encode(userpass);

		//String dbp = bCryptPasswordEncoder.encode(userpass);
		
		logger.info("****************printing passwords*****************************.", "passwords");

		System.out.println(userpass);
		System.out.println(dbpass);
		System.out.println(userp);
	
   
		if (userp.equals(dbpass)) {
			return true;
		} else {
			return false;
		}
		
	}

	/*
	 * public User getById(String id) { return (User)
	 * getSession().get(User.class, id); }
	 * 
	 * public void update(User user) { getSession().update(user); return; }
	 * 
	 * public HashSet<Role> getAllRoles() { logger.
	 * info("****************inside  getAllRoles*****************************.",
	 * "getAllRoles"); List users =
	 * getSession().createCriteria(Role.class).list();
	 * 
	 * Set<Role> roles = new HashSet<Role>(users); return (HashSet<Role>) roles;
	 * 
	 * }
	 */

}