package com.example.SimpleConverter.Enum;

public enum LengthUnit {

    MM("millimeter"), CM("centimeter"), M("meter"), KM("kilometer"), IN("inch"), FT("feet"), YD("yard"), MI("mile");

    private final String fullUnitName;

    private LengthUnit(String fullUnitName) {
        this.fullUnitName = fullUnitName;
    }
}
