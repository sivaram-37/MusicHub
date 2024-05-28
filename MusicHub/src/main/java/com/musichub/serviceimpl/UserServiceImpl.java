package com.musichub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musichub.entity.User;
import com.musichub.repository.UserRepository;
import com.musichub.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void storeuser(User u) {
		userRepository.save(u);
	}

	@Override
	public boolean isExist(String email) {
		User byEmail = userRepository.findByEmail(email);
		if(byEmail != null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean validate(String email, String typedPassword) {
		User user=userRepository.findByEmail(email);
		String existingPassword=user.getPassword();
		
		if(existingPassword.equals(typedPassword)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean fetchRole(String email) {
		User user = userRepository.findByEmail(email);
		String role=user.getRole();
		System.out.println(user.getRole());
		if(role.equals("admin")) {
			return true;
		}
		return false;
	}


	


}
