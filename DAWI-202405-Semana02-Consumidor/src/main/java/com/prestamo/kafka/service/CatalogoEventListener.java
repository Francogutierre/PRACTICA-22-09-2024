package com.prestamo.kafka.service;

import java.text.SimpleDateFormat;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.prestamo.entity.Catalogo;
import com.prestamo.kafka.config.Event;
import com.prestamo.kafka.entity.CatalogoCreateEvent;

@Component
public class CatalogoEventListener {

    @KafkaListener(topics = "${topic.customer.name:topic-catalogo-Perez}",
                  containerFactory = "kafkaListenerContainerFactory",
                  groupId = "escuchador-catalogo")
    public void consumer(Event<?> event) {
        System.out.println("1 Evento recibido: " + event);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (event.getClass().isAssignableFrom(CatalogoCreateEvent.class)) {
            System.out.println("2 Evento Catalogo: " + event);
            CatalogoCreateEvent catalogoEvent = (CatalogoCreateEvent) event;
            
            String id = catalogoEvent.getId();
            String fecha = sdf.format(catalogoEvent.getDate());
            String tipo = catalogoEvent.getType().toString();
            Catalogo objCatalogo = catalogoEvent.getData();
            String descripcion = objCatalogo.getDescripcion();
            
            System.out.println("3 ID: " + id);
            System.out.println("4 Fecha: " + fecha);
            System.out.println("5 Tipo: " + tipo);
            System.out.println("6 Descripción: " + descripcion);
           
        }
    }
}
