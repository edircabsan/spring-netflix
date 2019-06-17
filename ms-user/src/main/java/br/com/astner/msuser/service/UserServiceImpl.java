package br.com.astner.msuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.astner.msuser.entity.User;
import br.com.astner.msuser.kafka.producer.Sender;
import br.com.astner.msuser.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	@Value("${spring.kafka.topic.userCreated}")
	private String USER_CREATED_TOPIC;
	
	private UserRepository userRepository;
	private Sender sender;
	
	@Autowired
	UserServiceImpl(UserRepository userRepository, Sender sender){
		this.userRepository = userRepository;
		this.sender = sender;
	}
	
	@Override
	public User registerUser(User input) {
		User createdUser = userRepository.save(input);
		sender.send(USER_CREATED_TOPIC, createdUser);
		return createdUser;
	}
	
	@Override
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
}
