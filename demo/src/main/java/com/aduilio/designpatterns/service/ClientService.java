package com.aduilio.designpatterns.service;

import org.springframework.stereotype.Service;

import com.aduilio.designpatterns.model.Client;

@Service
public interface ClientService {

	Iterable<Client> read();
	
	Client read(Long id);
	
	void insert(Client client);
	
	void update(Long id, Client client);
	
	void delete(Long id);
}
