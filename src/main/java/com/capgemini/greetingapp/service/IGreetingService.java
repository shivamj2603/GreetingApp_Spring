package com.capgemini.greetingapp.service;

import com.capgemini.greetingapp.model.Greeting;
import com.capgemini.greetingapp.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
}
