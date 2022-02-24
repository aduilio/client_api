package com.aduilio.designpatterns.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aduilio.designpatterns.model.Client;
import com.aduilio.designpatterns.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Override
	public Iterable<Client> read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
