package com.musichub.service;

import com.musichub.entity.User;

public interface UserService {

	void storeuser(User u);

	boolean isExist(String email);

	boolean validate(String email, String password);

	String fetchRole(String email);

	User getUser(String mail);

	void updateUser(User user);

	

}
