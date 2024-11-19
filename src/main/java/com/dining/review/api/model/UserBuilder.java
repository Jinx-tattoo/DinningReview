package com.dining.review.api.model;

import lombok.Builder;

public class UserBuilder {

    String name;
    String city;
    String state;
    Integer zipcode;
    boolean peanutAllergies;
    boolean eggAllergies;
    boolean dairyAllergies;

    public Builder name(String name) {
        this.name = name;
        return (Builder) this;
    }

    public Builder city(String city) {
        this.city = city;
        return (Builder) this;
    }

    public Builder state(String state) {
        this.state = state;
        return (Builder) this;
    }

    public Builder zipcode(Integer zipcode) {
        this.zipcode = zipcode;
        return (Builder) this;
    }

    public Builder peanutAllergies(boolean peanutAllergies) {
        this.peanutAllergies = peanutAllergies;
        return (Builder) this;
    }

    public Builder eggAllergies(boolean eggAllergies) {
        this.eggAllergies = eggAllergies;
        return (Builder) this;
    }

    public Builder dairyAllergies(boolean dairyAllergies) {
        this.dairyAllergies = dairyAllergies;
        return (Builder) this;
    }

    public User build() {
        return new User(this);
    }
}