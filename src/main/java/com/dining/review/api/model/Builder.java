package com.dining.review.api.model;


public class Builder {  // Should be static nested class named Builder
    private String name;       // Make fields private
    private User.UserType typeUser;
    private String city;
    private String country;
    private Integer zipCode;
    private Boolean peanutAllergies;
    private Boolean eggAllergies;
    private Boolean dairyAllergies;

    public Builder() {} // Add a constructor

    public Builder name(String name) {
        this.name = name;
        return this;  // Remove the (Builder) cast, just return this
    }

    public Builder typeUser(User.UserType typeUser) {
        this.typeUser = typeUser;
        return this;
    }

    public Builder city(String city) {
        this.city = city;
        return this;
    }

    public Builder country(String country) {
        this.country = country;
        return this;
    }

    public Builder zipCode(Integer zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Builder peanutAllergies(Boolean peanutAllergies) {
        this.peanutAllergies = peanutAllergies;
        return this;
    }

    public Builder eggAllergies(Boolean eggAllergies) {
        this.eggAllergies = eggAllergies;
        return this;
    }

    public Builder dairyAllergies(Boolean dairyAllergies) {
        this.dairyAllergies = dairyAllergies;
        return this;
    }

    public User build() {
        return new User(name, typeUser, city, country, zipCode,
                peanutAllergies, eggAllergies, dairyAllergies);
    }
}