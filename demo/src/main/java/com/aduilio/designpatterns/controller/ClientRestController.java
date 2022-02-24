package com.aduilio.designpatterns.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aduilio.designpatterns.model.Client;
import com.aduilio.designpatterns.service.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientRestController {

	private final ClientService clientService;

	@GetMapping
	public ResponseEntity<Iterable<Client>> read() {
		return ResponseEntity.ok(clientService.read());
	}

	@ExceptionHandler
	@GetMapping("/{id}")
	public ResponseEntity<Client> read(@PathVariable final Long id) {
		final Optional<Client> response = clientService.read(id);
		if (response.isPresent()) {
			return ResponseEntity.ok(response.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody final Client client) {
		clientService.insert(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable final Long id, @RequestBody final Client client) {
		if (clientService.read(id).isPresent()) {
			clientService.update(id, client);
			return ResponseEntity.ok(client);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Client> delete(@PathVariable final Long id) {
		if (clientService.read(id).isPresent()) {
			clientService.delete(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
