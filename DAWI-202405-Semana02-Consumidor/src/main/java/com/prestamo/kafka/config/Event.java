package com.prestamo.kafka.config;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Event <T> {
    private String id;
    private Date date;
    private EventType type;
    private T data;
}