package com.example.SimpleConverter.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum LengthUnit {

    MM("millimeter", 0.001),
    CM("centimeter", 0.01),
    M("meter", 1.0),
    KM("kilometer", 1000.0),
    IN("inch", 0.0254),
    FT("feet", 0.3048),
    YD("yard", 0.9144),
    MI("mile", 1609.34);

    private final String fullUnitName;
    private final double toMeterFactor;
    private static final Map<String, LengthUnit> LOOKUP_MAP = new HashMap<>();

    static {
        for (LengthUnit unit : LengthUnit.values()) {
            // Store both abbreviation and full name (in lowercase) for fast lookup
            LOOKUP_MAP.put(unit.name().toLowerCase(), unit);
            LOOKUP_MAP.put(unit.fullUnitName.toLowerCase(), unit);
        }
    }

    private LengthUnit(String fullUnitName, double toMeterFactor) {

        this.fullUnitName = fullUnitName;
        this.toMeterFactor = toMeterFactor;
    }

    public String getFullUnitName() {
        return fullUnitName;
    }

    public double toMeters(double value) {
        return value * toMeterFactor;
    }

    public double fromMeters(double valueInMeters) {
        return valueInMeters / toMeterFactor;
    }

    @JsonCreator
    public static LengthUnit fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        LengthUnit unit = LOOKUP_MAP.get(value.toLowerCase());
        if (unit == null) {
            throw new IllegalArgumentException("Unknown length unit: " + value);
        }
        return unit;
    }
}
