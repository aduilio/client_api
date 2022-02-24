package com.aduilio.designpatterns.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aduilio.designpatterns.exception.InvalidCepException;
import com.aduilio.designpatterns.model.Address;
import com.aduilio.designpatterns.model.Client;
import com.aduilio.designpatterns.repository.AddressRepository;
import com.aduilio.designpatterns.repository.ClientRepository;
import com.aduilio.designpatterns.service.ClientService;
import com.aduilio.designpatterns.service.ViaCepService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final AddressRepository addressRepository;
	private final ViaCepService viaCepService;

	@Override
	public Iterable<Client> read() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> read(final Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client insert(final Client client) {
		checkAddress(client);

		return clientRepository.save(client);
	}

	@Override
	public void update(final Long id, final Client client) {
		client.setId(id);
		clientRepository.save(client);
	}

	@Override
	public void delete(final Long id) {
		final Client client = Client.builder().id(id).build();
		clientRepository.delete(client);
	}

	private void checkAddress(final Client client) {
		if (client.getAddress() != null && client.getAddress().getCep() != null) {
			final String cep = client.getAddress().getCep();
			final Address address = addressRepository.findById(cep).orElseGet(() -> viaCepService.get(cep));

			if (address.getCep() == null) {
				throw new InvalidCepException(cep);
			}

			addressRepository.save(address);

			client.setAddress(address);
		}
	}
}
