package br.com.astner.msmail.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import br.com.astner.msmail.entity.dto.UserDto;
import br.com.astner.msmail.service.EmailService;

public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);
	
	@Autowired
	private EmailService emailService;
	
	@KafkaListener(topics = "${spring.kafka.topic.userCreated}")
	public void receive(UserDto payload) {
		LOGGER.info("received payload='{}'", payload);
		emailService.sendSimpleMessage(payload);
		latch.countDown();
	}
}
