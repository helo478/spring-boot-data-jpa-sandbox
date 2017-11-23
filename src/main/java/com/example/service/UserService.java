package com.example.service;

import com.example.model.User;
import com.example.model.UserList;

public interface UserService {

	User createUser(User user);

	UserList readUsers();

	User readUser(String guid);

	void updateUser(String guid, User user);

	boolean deleteUser(String guid);

}
