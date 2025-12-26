package com.application.store.repositories;

import com.application.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {


}