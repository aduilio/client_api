package com.aduilio.designpatterns.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aduilio.designpatterns.model.Client;

@Service
public interface ClientService {

	Iterable<Client> read();
	
	Optional<Client> read(Long id);
	
	Client insert(Client client);
	
	void update(Long id, Client client);
	
	void delete(Long id);
}
