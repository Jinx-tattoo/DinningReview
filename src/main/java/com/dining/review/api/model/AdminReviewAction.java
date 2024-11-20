package com.dining.review.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

public class AdminReviewAction {

    private @Getter @Setter Boolean acceptReview;

    public AdminReviewAction(Boolean acceptReview) {
        this.acceptReview = acceptReview;
    }

    public AdminReviewAction() {
    }
}
