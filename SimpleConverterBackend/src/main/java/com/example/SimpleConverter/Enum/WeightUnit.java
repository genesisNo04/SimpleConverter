package com.example.SimpleConverter.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum WeightUnit {

    MG("milligram", 0.001),
    GM("gram", 1.0),
    KG("kilogram", 1000.0),
    OZ("ounce", 28.3495),
    LB("pound", 453.592);

    private final String fullUnitName;
    private final double toGramFactor;
    private static final Map<String, WeightUnit> LOOKUP_MAP = new HashMap<>();

    static {
        for (WeightUnit unit : WeightUnit.values()) {
            LOOKUP_MAP.put(unit.name().toLowerCase(), unit);
            LOOKUP_MAP.put(unit.getFullUnitName().toLowerCase(), unit);
        }
    }

    WeightUnit(String fullUnitName, double toGramFactor) {
        this.fullUnitName = fullUnitName;
        this.toGramFactor = toGramFactor;
    }

    public String getFullUnitName() {
        return fullUnitName;
    }

    public double toGram(double value) {
        return value * toGramFactor;
    }

    public double fromGrams(double gramValue) {
        return gramValue / toGramFactor;
    }

    @JsonCreator
    public static WeightUnit fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        WeightUnit unit = LOOKUP_MAP.get(value);

        if (unit == null) {
            throw new IllegalArgumentException("Unknown weight unit");
        }

        return unit;
    }
}
