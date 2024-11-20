package com.dining.review.api.model;

import lombok.Getter;
import lombok.Setter;

public class RestaurantDetailsResponse {

    private @Getter @Setter String name;
    private @Getter @Setter Integer zipCode;
    private @Getter @Setter String city;
    private @Getter @Setter String country;
    private Restaurant.RestaurantType type;
    private @Getter @Setter String averagePeanutScore;
    private @Getter @Setter String averageEggScore;
    private @Getter @Setter String averageDairyScore;
    private @Getter @Setter String concatenationReview;

    public RestaurantDetailsResponse(String name, Integer zipCode, String city, String country, Restaurant.RestaurantType type, String averageEggScore, String averageDairyScore, String averagePeanutScore, String concatenationReview) {
        this.name = name;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.type = type;
        this.averageEggScore = averageEggScore;
        this.concatenationReview = concatenationReview;
        this.averageDairyScore = averageDairyScore;
        this.averagePeanutScore = averagePeanutScore;
    }
}
