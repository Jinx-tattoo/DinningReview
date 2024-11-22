package com.dining.review.api.config;

import com.dining.review.api.model.Restaurant;
import com.dining.review.api.model.Review;
import com.dining.review.api.model.User;
import com.dining.review.api.repository.RestaurantRepository;
import com.dining.review.api.repository.ReviewRepository;
import com.dining.review.api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public DatabaseSeeder(UserRepository userRepository, RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Prepopulate users
        userRepository.save(new User("Lucas", User.UserType.USER, "Marseille", "France", 13011, false, false, false));
        userRepository.save(new User("Emma", User.UserType.USER, "Paris", "France", 75001, true, false, true));
        userRepository.save(User.builder()
                .name("Jack")
                .typeUser(User.UserType.USER)
                .city("Dijon")
                .country("France")
                .zipCode(65123)
                .peanutAllergies(false)
                .eggAllergies(false)
                .dairyAllergies(false)
                .build());
        userRepository.save(User.builder()
                .name("Justine")
                .typeUser(User.UserType.USER)
                .city("Tour")
                .country("France")
                .zipCode(66893)
                .peanutAllergies(false)
                .eggAllergies(true)
                .dairyAllergies(false)
                .build());
        userRepository.save(User.builder()
                .name("Chloe")
                .typeUser(User.UserType.USER)
                .city("Leipzig")
                .country("Deutschland")
                .zipCode(04003)
                .peanutAllergies(true)
                .eggAllergies(true)
                .dairyAllergies(true)
                .build());

        // Prepopulate restaurants
        Restaurant restaurant1 = new Restaurant("La Bonne Table", "Paris", "France", 92564, Restaurant.RestaurantType.MAROCAIN);
        Restaurant restaurant2 = new Restaurant("Pasta Paradise", "Rome", "Italy", 4185, Restaurant.RestaurantType.ITALIAN);
        Restaurant restaurant3 = new Restaurant("Tokyo Sushi", "Tokyo", "Japan", 100010, Restaurant.RestaurantType.JAPANESE);
        Restaurant restaurant4 = new Restaurant("Burger Haven", "New York", "USA", 10001, Restaurant.RestaurantType.AMERICAN);
        Restaurant restaurant5 = new Restaurant("Curry Delight", "Mumbai", "India", 400001, Restaurant.RestaurantType.INDIAN);
        Restaurant restaurant6 = new Restaurant("Le Grand Gourmet", "Lyon", "France", 69001, Restaurant.RestaurantType.FRENCH);
        Restaurant restaurant7 = new Restaurant("Tapas Fiesta", "Barcelona", "Spain", 8001, Restaurant.RestaurantType.SPANISH);
        Restaurant restaurant8 = new Restaurant("Green Garden", "Berlin", "Germany", 10115, Restaurant.RestaurantType.VEGAN);
        Restaurant restaurant9 = new Restaurant("Seaside Diner", "Sydney", "Australia", 2000, Restaurant.RestaurantType.SEAFOOD);
        Restaurant restaurant10 = new Restaurant("Churrasco Grill", "Rio de Janeiro", "Brazil", 22210, Restaurant.RestaurantType.BRAZILIAN);
        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
        restaurantRepository.save(restaurant3);
        restaurantRepository.save(restaurant4);
        restaurantRepository.save(restaurant5);
        restaurantRepository.save(restaurant6);
        restaurantRepository.save(restaurant7);
        restaurantRepository.save(restaurant8);
        restaurantRepository.save(restaurant9);
        restaurantRepository.save(restaurant10);

        Long restaurantId1 = restaurant1.getId();
        Long restaurantId2 = restaurant2.getId();
        Long restaurantId3 = restaurant3.getId();
        Long restaurantId4 = restaurant4.getId();
        Long restaurantId5 = restaurant5.getId();
        Long restaurantId6 = restaurant6.getId();
        Long restaurantId7 = restaurant7.getId();
        Long restaurantId8 = restaurant8.getId();
        Long restaurantId9 = restaurant9.getId();
        Long restaurantId10 = restaurant10.getId();

        // Prepopulate reviews
        reviewRepository.save(new Review("Ange", restaurantId1, 4, 5, 5, "Amazing food!"));
        reviewRepository.save(new Review("Ange", restaurantId2, 4, 4, 1, "Great ambiance but a bit pricey."));
        reviewRepository.save(new Review("Ange", restaurantId3, 4, 4, 1, "Great ambiance but a bit pricey."));
        reviewRepository.save(new Review("Ange", restaurantId4, 5, 5, 3, "Authentic Moroccan cuisine, highly recommend!"));
        reviewRepository.save(new Review("Ange", restaurantId5, 4, 5, 4, "Delicious pasta, but the portions are small."));
        reviewRepository.save(new Review("Ange", restaurantId6, 3, 3, 2, "Service was a bit slow."));
        reviewRepository.save(new Review("Emma", restaurantId7, 5, 5, 5, "Best sushi in Tokyo!"));
        reviewRepository.save(new Review("Emma", restaurantId8, 4, 4, 3, "Fresh fish and great presentation."));
        reviewRepository.save(new Review("Emma", restaurantId9, 3, 3, 4, "Good burgers, but the fries were cold."));
        reviewRepository.save(new Review("Emma", restaurantId10, 4, 5, 5, "Fantastic milkshakes and juicy burgers!"));
        reviewRepository.save(new Review("Emma", restaurantId1, 5, 5, 5, "The curries were bursting with flavor."));
        reviewRepository.save(new Review("Emma", restaurantId2, 4, 4, 4, "A bit spicy for my taste, but still enjoyable."));
        reviewRepository.save(new Review("Jack", restaurantId3, 5, 5, 5, "Perfect dining experience with amazing wine pairings."));
        reviewRepository.save(new Review("Jack", restaurantId4, 4, 4, 3, "A bit overpriced but delicious food."));
        reviewRepository.save(new Review("Jack", restaurantId5, 5, 5, 4, "The tapas were creative and flavorful."));
        reviewRepository.save(new Review("Jack", restaurantId6, 3, 4, 3, "Good variety, but some dishes lacked seasoning."));
        reviewRepository.save(new Review("Jack", restaurantId7, 4, 4, 5, "Fresh ingredients and great vegan options."));
        reviewRepository.save(new Review("Jack", restaurantId8, 5, 5, 5, "The best vegan restaurant I’ve visited."));
        reviewRepository.save(new Review("Justine", restaurantId9, 5, 4, 4, "Lovely seafood platters by the ocean."));
        reviewRepository.save(new Review("Justine", restaurantId10, 4, 5, 5, "Great service and fresh seafood."));
        reviewRepository.save(new Review("Justine", restaurantId1, 4, 4, 3, "Unique churrasco experience with flavorful meats."));
        reviewRepository.save(new Review("Justine", restaurantId2, 5, 5, 5, "A true taste of Brazil, excellent!"));
        reviewRepository.save(new Review("Justine", restaurantId3, 5, 5, 5, "The tagine was heavenly!"));
        reviewRepository.save(new Review("Justine", restaurantId4, 4, 4, 4, "Tasty pizza and friendly staff."));
        reviewRepository.save(new Review("Chloe", restaurantId5, 5, 5, 5, "Delicious ramen and sushi rolls."));
        reviewRepository.save(new Review("Chloe", restaurantId6, 3, 3, 2, "Could improve the atmosphere."));
        reviewRepository.save(new Review("Chloe", restaurantId7, 5, 4, 5, "The naan was warm and buttery."));
        reviewRepository.save(new Review("Chloe", restaurantId8, 4, 4, 5, "Refined flavors and beautiful plating."));
        reviewRepository.save(new Review("Chloe", restaurantId9, 5, 5, 5, "Best sangria and croquettes!"));
        reviewRepository.save(new Review("Chloe", restaurantId10, 5, 5, 4, "Creative vegan dishes that even non-vegans love."));
        reviewRepository.save(new Review("Chloe", restaurantId1, 5, 5, 4, "Loved the lobster and the view."));
        reviewRepository.save(new Review("Chloe", restaurantId2, 4, 4, 4, "Great variety of meats, but the sides could improve."));

    }
}
