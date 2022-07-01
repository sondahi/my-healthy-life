package com.comert.myhealthylife.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Mineral {

    @Column(name = "calcium", precision = 7, scale = 2)
    private double calcium; //Kalsiyum
    @Column(name = "iodine", precision = 7, scale = 2)
    private double iodine; //İyot
    @Column(name = "iron", precision = 7, scale = 2)
    private double iron; //Demir
    @Column(name = "magnesium", precision = 7, scale = 2)
    private double magnesium; //Magenzyum
    @Column(name = "phosphorus", precision = 7, scale = 2)
    private double phosphorus; //Fosfor
    @Column(name = "potassium", precision = 7, scale = 2)
    private double potassium; //Potasyum
    @Column(name = "selenium", precision = 7, scale = 2)
    private double selenium;//Selenyum
    @Column(name = "sodium", precision = 7, scale = 2)
    private double sodium;//Sodyum
    @Column(name = "zinc", precision = 7, scale = 2)
    private double zinc; //Çinko

    public Mineral() {
    }

}
