package com.example;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableWithSize.iterableWithSize;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.User;
import com.example.model.UserList;
import com.example.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIT {

	private static final String TEST_GUID = "FOO";

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/users");
	}

	@Test
	public void getCustomers_init_shouldReturnEmptyIterable() throws Exception {
		ResponseEntity<UserList> response = template.getForEntity(base.toString(), UserList.class);
		assertThat(response.getBody().getUsers(), iterableWithSize(equalTo(0)));
	}

	@Test
	public void postCustomers() throws Exception {
		final User customer = new User();
		ResponseEntity<User> response = template.postForEntity(base.toString(), customer, User.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody(), equalTo(customer));
	}

	@Test
	public void putUser_extantUser_shouldNotReturn200() throws Exception {

		final User user = new User();
		user.setGuid(TEST_GUID);
		userRepository.save(user);

		final RequestEntity<User> request = new RequestEntity<User>(user, HttpMethod.PUT,
				new URI(base.toString() + "/" + TEST_GUID));
		ResponseEntity<User> response = template.exchange(request, User.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void putUser_nonExistantUser_shouldErrorWith404() throws Exception {
		final User user = new User();
		final RequestEntity<User> request = new RequestEntity<User>(user, HttpMethod.PUT,
				new URI(base.toString() + "/" + TEST_GUID));
		ResponseEntity<User> response = template.exchange(request, User.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	}
	
	// TODO: create a test that makes it fail when you try to update a GUID

}