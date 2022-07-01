package com.comert.myhealthylife.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Vitamin {

    @Column(name = "vitaminA", precision = 7, scale = 2)
    private double vitaminA;
    @Column(name = "vitaminB1", precision = 7, scale = 2)
    private double vitaminB1;
    @Column(name = "vitaminB2", precision = 7, scale = 2)
    private double vitaminB2;
    @Column(name = "vitaminB3", precision = 7, scale = 2)
    private double vitaminB3;
    @Column(name = "vitaminB6", precision = 7, scale = 2)
    private double vitaminB6;
    @Column(name = "vitaminB12", precision = 7, scale = 2)
    private double vitaminB12;
    @Column(name = "folicAcid", precision = 7, scale = 2)
    private double folicAcid;
    @Column(name = "vitaminC", precision = 7, scale = 2)
    private double vitaminC;
    @Column(name = "vitaminD", precision = 7, scale = 2)
    private double vitaminD;
    @Column(name = "vitaminE", precision = 7, scale = 2)
    private double vitaminE;
    @Column(name = "vitaminK1", precision = 7, scale = 2)
    private double vitaminK1;
    @Column(name = "vitaminK2", precision = 7, scale = 2)
    private double vitaminK2;

    public Vitamin() {
    }

}
