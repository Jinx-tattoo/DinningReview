package com.dining.review.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @Column(name= "Name")
    private @Getter @Setter String name;

    @Column(name= "City")
    private @Getter @Setter String city;

    @Column(name= "Country")
    private @Getter @Setter String country;

    @Column(name= "Zip_Code")
    private @Getter @Setter Integer zipCode;

    public enum RestaurantType {
        ITALIAN, MAROCAIN, JAPANESE, AMERICAN, INDIAN, FRENCH, SPANISH, VEGAN, SEAFOOD, BRAZILIAN
    };

    @Column(name= "Type")
    private @Getter @Setter RestaurantType restaurantType;

    public Restaurant(String name, String city, String country, Integer zipCode, RestaurantType type) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.restaurantType = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", type=" + restaurantType +
                '}';
    }

    public Restaurant() {
    }
}
