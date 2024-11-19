package com.dining.review.api.model;

public class User {

    private final String name;
    private final String city;
    private final String state;
    private final Integer zipcode;
    private final boolean peanutAllergies;
    private final boolean eggAllergies;
    private final boolean dairyAllergies;

    User(UserBuilder builder) {
        this.name = builder.name;
        this.city = builder.city;
        this.state = builder.state;
        this.zipcode = builder.zipcode;
        this.peanutAllergies = builder.peanutAllergies;
        this.eggAllergies = builder.eggAllergies;
        this.dairyAllergies = builder.dairyAllergies;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}