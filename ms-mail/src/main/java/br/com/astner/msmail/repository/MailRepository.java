package br.com.astner.msmail.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.astner.msmail.entity.Mail;

public interface MailRepository extends CrudRepository<Mail, Long> {
	
}
