package com.example.producerservice.model;


import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Event {
    String id;
    String note;
}

