package com.example.consumerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.consumerservice.model.Event;
import com.example.consumerservice.repo.EventRepo;

@Service
public class ConsumerService {

	@Autowired(required = true)
	@Qualifier("eventRepo")
	private EventRepo eventRepo;

	public List<Event> getEventByNum(Integer num) {

		try {
			return eventRepo.findByNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Event> getEventDetails() {

		try {
			return eventRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
