package com.prestamo.kafka.service;

import java.text.SimpleDateFormat;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.prestamo.entity.Pais;
import com.prestamo.kafka.config.Event;
import com.prestamo.kafka.entity.PaisCreateEvent;

@Component
public class PaisEventListener {


	
	@KafkaListener(topics = "${topic.customer.name:topic-pais}",
				  containerFactory = "kafkaListenerContainerFactory",
				  groupId = "escuchador-pais")
	public void consumer(Event<?> event) {
		System.out.println("1 Evento recibido  " + event);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(event.getClass().isAssignableFrom(PaisCreateEvent.class)) {
			System.out.println("2 Evento Pais  " + event);
			PaisCreateEvent paisEvent = (PaisCreateEvent) event;
			
			String id = paisEvent.getId();
			String fecha = sdf.format(paisEvent.getDate());
			String tipo = paisEvent.getType().toString();
			Pais objPais =  paisEvent.getData();
			String iso = objPais.getIso();
			String nombre = objPais.getNombre();
			
			System.out.println("3 ID: " + id);
			System.out.println("4 Fecha: " + fecha);
			System.out.println("5 Tipo: " + tipo);
			System.out.println("6 ISO: " + iso);
			System.out.println("7 Nombre: " + nombre);
		}
		
	}
}
