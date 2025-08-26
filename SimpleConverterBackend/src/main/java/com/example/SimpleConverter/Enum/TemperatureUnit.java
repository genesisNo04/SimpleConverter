package com.example.SimpleConverter.Enum;

public enum TemperatureUnit {

    C("Celsius"), F("Fahrenheit"), K("Kelvin");
    
    private final String fullUnitName;

    private TemperatureUnit(String fullUnitName) {
        this.fullUnitName = fullUnitName;
    }
}
