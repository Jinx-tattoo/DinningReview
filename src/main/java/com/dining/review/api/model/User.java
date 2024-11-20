package com.dining.review.api.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name="THE_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @Column(name="Name", unique = true)
    private @Getter @Setter String name;

    public enum UserType{
        ADMIN, USER
    }

    @Column(name="Type_User")
    private @Getter @Setter UserType typeUser;

    @Column(name="City")
    private @Getter @Setter String city;

    @Column(name="Country")
    private @Getter @Setter String country;

    @Column(name="Zip_code")
    private @Getter @Setter Integer zipCode;

    @Column(name="Peanut_Allergies")
    private @Setter boolean peanutAllergies;

    @Column(name="Egg_Allergies")
    private @Setter boolean eggAllergies;

    @Column(name="Dairy_Allergies")
    private @Setter boolean dairyAllergies;

    public User(String name, UserType typeUser, String city, String country,
                Integer zipCode, boolean peanutAllergies, boolean eggAllergies,
                boolean dairyAllergies) {
        this.name = name;
        this.typeUser = typeUser;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.peanutAllergies = peanutAllergies;
        this.eggAllergies = eggAllergies;
        this.dairyAllergies = dairyAllergies;
    }

    public User() {}


    // Static method to get a new builder
    public static Builder builder() {
        return new Builder();
    }

    public boolean getPeanutAllergies() {
        return this.peanutAllergies;
    }

    public boolean getEggAllergies() {
        return this.eggAllergies;
    }

    public boolean getDairyAllergies() {
        return this.dairyAllergies;
    }
}