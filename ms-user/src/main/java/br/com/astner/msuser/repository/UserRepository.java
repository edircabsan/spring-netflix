package br.com.astner.msuser.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.astner.msuser.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
