package com.capgemini.greetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.greetingapp.model.Greeting;
import com.capgemini.greetingapp.model.User;
import com.capgemini.greetingapp.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	@Autowired
	private IGreetingService greetingService;
	@GetMapping("")
	public Greeting greeting(@RequestParam(value="name",defaultValue="World")String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
}
