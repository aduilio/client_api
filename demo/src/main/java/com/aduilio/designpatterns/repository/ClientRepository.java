package com.aduilio.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.aduilio.designpatterns.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
