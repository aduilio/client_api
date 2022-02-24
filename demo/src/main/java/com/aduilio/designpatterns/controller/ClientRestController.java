package com.aduilio.designpatterns.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> read(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.read(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		clientService.insert(client);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}
