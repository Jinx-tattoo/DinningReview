package com.dining.review.api.controller;

import java.util.List;
import java.util.Optional;

import com.dining.review.api.model.Restaurant;
import com.dining.review.api.model.RestaurantDetailsResponse;
import com.dining.review.api.model.Review;
import com.dining.review.api.model.User;

import com.dining.review.api.repository.RestaurantRepository;
import com.dining.review.api.repository.ReviewRepository;
import com.dining.review.api.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class DinningReviewController {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public DinningReviewController(final UserRepository userRepository, RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    // method related to User model
    @GetMapping("/user")
    public List<User> getUser() {
        return (List<User>) this.userRepository.findAll();
    }

    @GetMapping("/user/{name}")
    public Optional<User> getUserOptional(@PathVariable String name) {
        return this.userRepository.findByName(name);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("/user/{name}")
    public User updateUser(@PathVariable("name") String name, @RequestBody User user) {
        Optional<User> userToUpdateOptional = this.userRepository.findByName(name);

        if (userToUpdateOptional.isEmpty()) {
            return null;
        }

        User userToUpdate = userToUpdateOptional.get();
        if (user.getCity() != null) {
            userToUpdate.setCity(user.getCity());
        }
        if (user.getCity() != null) {
            userToUpdate.setCity(user.getCity());
        }
        if (user.getCountry() != null) {
            userToUpdate.setCountry(user.getCountry());
        }
        if (user.getZipCode() != null) {
            userToUpdate.setZipCode(user.getZipCode());
        }
        userToUpdate.setEggAllergies(user.getEggAllergies());
        userToUpdate.setPeanutAllergies(user.getPeanutAllergies());
        userToUpdate.setDairyAllergies(user.getDairyAllergies());
        return this.userRepository.save(userToUpdate);

    }

    // method related to Review model
    @PostMapping("/review")
    public Review createReview(@RequestBody Review review) {
        if (review.getIdRestaurant() != null) {
            return this.reviewRepository.save(review);
        } else {return null;}
    }

    @GetMapping("/review")
    public List<Review> getAllReview() {
        return (List<Review>) this.reviewRepository.findAll();
    }

    @GetMapping("/review/search")
    public List<Review> getReviewPending(@RequestParam(name="status", required=false) Review.StatusReview status) {
        return this.reviewRepository.findByStatus(status);
    }

    @PutMapping("/review/{id}")
    public Review modifyStatusReview(@PathVariable("id") Long id, @RequestBody Review.StatusReview decision) {
        Optional<Review> assessReviewOptional = this.reviewRepository.findById(id);
        if (assessReviewOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found!");
        }

        Review assessReview = assessReviewOptional.get();
        assessReview.setStatus(decision);
        return this.reviewRepository.save(assessReview);
    }

    @GetMapping("/review/search")
    public List<Review> getReviewRestaurantApproved(@PathVariable("restaurantName") String restaurantName) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findByName(restaurantName);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This restaurant doesn't exist !");
        }

        Restaurant restaurant = restaurantOptional.get();
        Long restaurantId = restaurant.getId();
        return this.reviewRepository.findByIdRestaurantAndStatus(restaurantId, Review.StatusReview.APPROVED);
    }

    // method related to Restaurant model
    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurant() {
        return (List<Restaurant>) this.restaurantRepository.findAll();
    }

    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findByNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
        if (restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Restaurant already exists");
        }
        return this.restaurantRepository.save(restaurant);
    }

    @PutMapping("/restaurant/{name}")
    public Restaurant updateRestaurant(@RequestParam(name="id", required = true) Long id,
                                       @RequestParam(name="name", required = false) String name,
                                       @RequestParam(name="city", required = false) String city,
                                       @RequestParam(name="country", required = false) String country,
                                       @RequestParam(name="zipCode", required = false) Integer zipCode,
                                       @RequestParam(name="restaurantType", required = false) Restaurant.RestaurantType restaurantType) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This restaurant doesn't exist !");
        }

        Restaurant restaurant = restaurantOptional.get();

        if (name != null) {
            restaurant.setName(name);
        }
        if (city != null) {
            restaurant.setCity(city);
        }
        if (country != null) {
            restaurant.setCountry(country);
        }
        if (zipCode != null) {
            restaurant.setZipCode(zipCode);
        }
        if (restaurantType != null) {
            restaurant.setRestaurantType(restaurantType);
        }
        return this.restaurantRepository.save(restaurant);
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDetailsResponse getRestaurantDetailsResponse(@PathVariable("id") Long id) {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(id);
        if (optionalRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }

        Restaurant restaurant = optionalRestaurant.get();
        String name = restaurant.getName();
        String city = restaurant.getCity();
        String country = restaurant.getCountry();
        Integer zipCode = restaurant.getZipCode();
        Restaurant.RestaurantType type = restaurant.getRestaurantType();

        List<Review> reviews = this.reviewRepository.findByIdRestaurant(restaurant.getId());
        if (reviews.isEmpty()) {
            String averagePeanutScore = null;
            String averageEggScore = null;
            String averageDairyScore = null;
            String commentary = null;
        }

        StringBuilder commentary = new StringBuilder();
        float peanutScore = 0;
        float eggScore = 0;
        float dairyScore = 0;
        int numberReview = reviews.size();

        for (Review review : reviews) {
            peanutScore += review.getPeanutScore();
            eggScore += review.getEggScore();
            dairyScore += review.getDairyScore();
            commentary.append(review.getCommentary());
        }
        String averagePeanutScore = String.format("%.2f", peanutScore / numberReview) + "/5";
        String averageEggScore = String.format("%.2f", eggScore / numberReview) + "/5";
        String averageDairyScore = String.format("%.2f", dairyScore / numberReview) + "/5";

        return new RestaurantDetailsResponse(name, zipCode, city, country, type, averagePeanutScore, averageEggScore, averageDairyScore, commentary.toString());
    }

//    @GetMapping("/restaurant/search")
//    public List<Restaurant> getAllByZipCodeAndAllergies(@RequestParam(name="zipCode", required = true) Integer zipCode,
//                                                       @RequestParam(name="peanutAllergies", required = false) boolean peanutAllergies,
//                                                       @RequestParam(name="eggAllergies", required = false) boolean eggAllergies,
//                                                       @RequestParam(name="dairyAllergies", required = false) boolean dairyAllergies) {
//        if (peanutAllergies) {
//            return this.restaurantRepository.findByZipCodeAndPeanutAllergiesTrue(zipCode);
//        } else if (eggAllergies) {
//            return this.restaurantRepository.findByZipCodeAndEggAllergiesTrue(zipCode);
//        } else if (dairyAllergies) {
//            return this.restaurantRepository.findByZipCodeAndDairyAllergiesTrue(zipCode);
//        } else {
//            return null;
//        }
//    }
}
