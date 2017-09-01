package com.bala.spring.service;

 
import com.bala.spring.config.dao.UserDao;
import com.bala.spring.model.User;
 
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao; 
  /*  @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
    private RoleRepository roleRepository;
    */
    
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
         
       // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(userDao.getAllRoles()));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.getByUsername(username);
    }

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}
}
