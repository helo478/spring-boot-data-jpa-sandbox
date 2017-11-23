package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.NotFoundException;
import com.example.model.User;
import com.example.model.UserList;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {}
	
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(final User user) {

		return userRepository.save(user);
	}

	@Override
	public UserList readUsers() {

		final UserList userList = new UserList();
		userList.setUsers(userRepository.findAll());
		return userList;
	}

	@Override
	public User readUser(final String guid) {

		return userRepository.findByGuid(guid);
	}

	@Override
	public void updateUser(final String guid, final User user) {
		
		final User existingUser = userRepository.findByGuid(guid);
		
		if (existingUser == null) {
			throw new NotFoundException();
		}
		
		user.setId(existingUser.getId());
		user.setGuid(guid);

		userRepository.save(user);
	}

	@Override
	public boolean deleteUser(final String userId) {

		throw new RuntimeException("not yet implemented");
	}

}
