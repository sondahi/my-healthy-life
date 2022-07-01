package com.comert.myhealthylife.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@Getter
@Setter
@MappedSuperclass
public abstract class Component {

    @Embedded
    private Basic basic;
    @Embedded
    private Vitamin vitamin;
    @Embedded
    private Mineral mineral;
    @Transient
    private double amount = 100.0;
    protected Component() {
    }

}
