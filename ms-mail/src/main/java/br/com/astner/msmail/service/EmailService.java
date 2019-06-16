package br.com.astner.msmail.service;

import br.com.astner.msmail.entity.dto.UserDto;

public interface EmailService {
	void sendSimpleMessage(UserDto input);
}
