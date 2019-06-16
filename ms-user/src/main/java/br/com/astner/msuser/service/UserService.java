package br.com.astner.msuser.service;

import br.com.astner.msuser.entity.User;

public interface UserService {
	User registerUser(User input);
	Iterable<User> findAll();
}
