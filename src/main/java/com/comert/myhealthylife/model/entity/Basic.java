package com.comert.myhealthylife.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Basic {

    @Column(name = "calorie", precision = 7, scale = 2)
    private double calorie;
    @Column(name = "protein", precision = 7, scale = 2)
    private double protein;
    @Column(name = "carbohydrate", precision = 7, scale = 2)
    private double carbohydrate;
    @Column(name = "lactose", precision = 7, scale = 2)
    private double lactose;
    @Column(name = "fat", precision = 7, scale = 2)
    private double fat;
    @Column(name = "omega3", precision = 7, scale = 2)
    private double omega3;
    @Column(name = "saturatedFattyAcids", precision = 7, scale = 2)
    private double saturatedFattyAcids;
    @Column(name = "cholesterol", precision = 7, scale = 2)
    private double cholesterol;
    @Column(name = "fiber", precision = 7, scale = 2)
    private double fiber;

    public Basic() {
    }

}
