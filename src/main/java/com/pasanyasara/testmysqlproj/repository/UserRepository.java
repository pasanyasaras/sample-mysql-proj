package com.pasanyasara.testmysqlproj.repository;

import com.pasanyasara.testmysqlproj.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
