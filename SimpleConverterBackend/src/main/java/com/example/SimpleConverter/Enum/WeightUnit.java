package com.example.SimpleConverter.Enum;

public enum WeightUnit {

    MG("milligram"), GM("gram"), KG("kilogram"), OZ("ounce"), LB("pound");

    private final String fullUnitName;

    private WeightUnit(String fullUnitName) {
        this.fullUnitName = fullUnitName;
    }
}
