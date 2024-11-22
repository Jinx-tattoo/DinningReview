package com.dining.review.api.repository;

import java.util.Optional;
import java.util.List;

import com.dining.review.api.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findByNameAndZipCode(String name, Integer zipCode);
    Optional<Restaurant> findById(Long id);
    Optional<Restaurant> findByName(String name);
//    List<Restaurant> findByZipCodeAndPeanutAllergiesTrue(Integer zipCode);
//    List<Restaurant> findByZipCodeAndEggAllergiesTrue(Integer zipCode);
//    List<Restaurant> findByZipCodeAndDairyAllergiesTrue(Integer zipCode);
}
