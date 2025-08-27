package com.example.SimpleConverter.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

public enum TemperatureUnit {

    C("Celsius"), F("Fahrenheit"), K("Kelvin");
    
    private final String fullUnitName;
    private static final Map<String, TemperatureUnit> LOOKUP_MAP = new HashMap<>();

    static {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            LOOKUP_MAP.put(unit.name().toLowerCase(), unit);
            LOOKUP_MAP.put(unit.getFullUnitName().toLowerCase(), unit);
        }
    }

    private TemperatureUnit(String fullUnitName) {
        this.fullUnitName = fullUnitName;
    }

    public String getFullUnitName() {
        return fullUnitName;
    }

    public double toKelvin(double value) {
        switch (this) {
            case C:
                return value + 273.15;
            case F:
                return (value - 32) * 5 / 9 + 273.15;
            case K:
            default:
                return value;
        }
    }

    public double fromKelvin(double fromKelvinValue) {
        switch (this) {
            case C:
                return fromKelvinValue - 273.15;
            case F:
                return (fromKelvinValue - 273.15) * 9 / 5 + 32;
            case K:
            default:
                return fromKelvinValue;
        }
    }

    @JsonCreator
    public static TemperatureUnit fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        TemperatureUnit unit = LOOKUP_MAP.get(value);
        if (unit == null) {
            throw new IllegalArgumentException("Unknown weight unit");
        }
        return unit;
    }
}
