package com.dining.review.api.repository;

import java.util.List;
import java.util.Optional;

import com.dining.review.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
