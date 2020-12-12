package com.capgemini.greetingapp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.greetingapp.model.Greeting;
import com.capgemini.greetingapp.model.User;
import com.capgemini.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingRepository greetingRepository;
	
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().trim().isEmpty()) ? "World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}
	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}
	@Override
	public List<Greeting> getAllGreetings() {
		return greetingRepository.findAll();
	}
	@Override
	public 	String deleteGreeting(long id) {
		greetingRepository.deleteById(id);
		return "Deleted Successfully" ;	
	}
	@Override
	public Greeting updateGreeting(long id, String message) {
		Greeting greet = this.getGreetingById(id);
				greet.setMessage(message);
		greetingRepository.save(greet);
		return this.getGreetingById(id);
	}	
}
