package com.example.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.User;
import com.example.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	@InjectMocks
	private MockMvc mvc;

	@Mock
	private UserService mockCustomerService;

	@Before
	public void setUpMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCustomers() throws Exception {

		final User customer = new User();

		Mockito.when(mockCustomerService.createUser(customer)).thenReturn(customer);

		mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}