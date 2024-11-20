package com.dining.review.api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

@Data
@Builder
@Entity
@Table(name="Review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @Column(name="User_Name")
    private String userName;

    @Column(name="Id_Restaurant")
    private @Getter @Setter Long idRestaurant;

    @Column(name="Peanut_Score")
    private @Getter Integer peanutScore;

    @Column(name="Egg_Score")
    private @Getter Integer eggScore;

    @Column(name="Dairy_Score")
    private @Getter Integer dairyScore;

    @Column(name="Commentary")
    private @Getter @Setter String commentary;

    public enum StatusReview {
        PENDING, REJECTED, APPROVED}

    @Column(name="Status", nullable = true)
    private @Getter @Setter StatusReview status = StatusReview.PENDING;

    public Review(String userName, Long idRestaurant, Integer peanutScore, Integer eggScore, Integer dairyScore, String commentary) {
        this.userName = userName;
        this.idRestaurant = idRestaurant;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
    }

    public Review(String userName, Long idRestaurant, Integer peanutScore, Integer eggScore, Integer dairyScore, String commentary, StatusReview status) {
        this.userName = userName;
        this.idRestaurant = idRestaurant;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
        this.status = status;
    }

    public void setPeanutScore(Integer score) {
        if ( score < 1 || score > 5) {
            throw new IllegalArgumentException("score must be between 1 and 5");
        }
        this.peanutScore = score;
    }

    public void setEggScore(Integer score) {
        if ( score < 1 || score > 5) {
            throw new IllegalArgumentException("score must be between 1 and 5");
        }
        this.eggScore = score;
    }

    public void setDairyScore(Integer score) {
        if ( score < 1 || score > 5) {
            throw new IllegalArgumentException("score must be between 1 and 5");
        }
        this.dairyScore = score;
    }

}
