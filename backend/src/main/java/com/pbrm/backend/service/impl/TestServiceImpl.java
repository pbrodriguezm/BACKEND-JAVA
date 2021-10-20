package com.pbrm.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.pbrm.backend.model.User;
import com.pbrm.backend.service.TestService;


/*
 * En el servicio va toda la logica de la aplicacion
 * y ciontroller llama a servicios
 **/
@Service("testService")
public class TestServiceImpl implements TestService {
	private static final Log LOG = LogFactory.getLog(TestService.class);
	

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("User1", "12345"));
		users.add(new User("User2", "12345"));
		users.add(new User("User3", "12345"));
		LOG.info("Loading Service");
		return users;
	}

}
