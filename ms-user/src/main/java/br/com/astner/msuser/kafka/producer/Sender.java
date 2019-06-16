package br.com.astner.msuser.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import br.com.astner.msuser.entity.User;

public class Sender {
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void send(String topic, User payload) {
		kafkaTemplate.send(topic, payload);
	}
}
