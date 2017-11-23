package com.example.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.exception.NotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;

public class UserServiceTest {

	private static final String TEST_GUID = "FOO";

	private UserService sut;

	@Mock
	private UserRepository mockUserRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		sut = new UserServiceImpl(mockUserRepository);
	}

	@Test
	public void readUser_shouldRouteRequestToRepositoryMethodFindByGuid() {

		final User expectedUser = new User();
		Mockito.when(mockUserRepository.findByGuid(TEST_GUID)).thenReturn(expectedUser);
		final User actualUser = sut.readUser(TEST_GUID);
		assertEquals(expectedUser, actualUser);
	}

	@Test
	public void updateUser_extantUser_shouldNotError() {

		final User user = new User();
		user.setGuid(TEST_GUID);
		Mockito.when(mockUserRepository.findByGuid(TEST_GUID)).thenReturn(user);

		final User updatedUser = new User();
		updatedUser.setGuid(TEST_GUID);
		sut.updateUser(TEST_GUID, updatedUser);

		Mockito.verify(mockUserRepository, times(1)).save(argThat(equalTo(updatedUser)));
	}

	@Test(expected = NotFoundException.class)
	public void updateUser_forANonExistantUser_shouldThrowNotFound() {

		final User arbitraryUser = new User();
		sut.updateUser(TEST_GUID, arbitraryUser);
	}

}
