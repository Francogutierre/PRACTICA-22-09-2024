package com.prestamo.kafka.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.prestamo.entity.Pais;
import com.prestamo.kafka.config.Event;
import com.prestamo.kafka.config.EventType;
import com.prestamo.kafka.entity.PaisCreateEvent;

@Component
public class PaisEventService {

	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.customer.name:topic-pais}")
	private String topic;
	
	public void publish(Pais pais) {
	
		PaisCreateEvent event = new PaisCreateEvent();
		event.setId(UUID.randomUUID().toString());
		event.setDate(new Date());
		event.setType(EventType.CREATED);
		event.setData(pais);
		
		this.producer.send(topic, event);
	}
}
