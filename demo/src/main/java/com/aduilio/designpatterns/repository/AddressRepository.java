package com.aduilio.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.aduilio.designpatterns.model.Address;

public interface AddressRepository extends CrudRepository<Address, String> {

}
