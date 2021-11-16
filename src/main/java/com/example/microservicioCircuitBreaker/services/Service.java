package com.example.microservicioCircuitBreaker.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
	
	Logger logger = LoggerFactory.getLogger(Service.class);
	
	RestTemplate restTemplate = new RestTemplate();
	
	String URL = "http://localhost:8888";
	
	public Service()
	{
		close();
	}
	
	public void open()
	{
		String urlOpen
		  = URL + "status/open";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(urlOpen, String.class);
		logger.info("Estado open");
		
	}
	public void close()
	{
		String urlClose
		  = URL + "status/close";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(urlClose, String.class);
		logger.info("Estado close");
	}
	public void halfOpen()
	{
		String urlHalf
		  = URL + "status/half";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(urlHalf, String.class);
		logger.info("Estado half-open");
	}

}
