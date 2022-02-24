package com.aduilio.designpatterns.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aduilio.designpatterns.model.Client;
import com.aduilio.designpatterns.repository.ClientRepository;
import com.aduilio.designpatterns.service.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	
	@Override
	public Iterable<Client> read() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> read(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client insert(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void update(Long id, Client client) {
		client.setId(id);
		clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		Client client = Client.builder().id(id).build();
		clientRepository.delete(client);
	}
}
