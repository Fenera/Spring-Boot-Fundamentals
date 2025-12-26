package com.application.store.repositories;

import org.springframework.data.repository.CrudRepository;
import com.application.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {


}
