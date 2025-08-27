package com.example.SimpleConverter.Service.Impl;

import com.example.SimpleConverter.Enum.LengthUnit;
import com.example.SimpleConverter.Enum.TemperatureUnit;
import com.example.SimpleConverter.Enum.WeightUnit;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public double convertLength(double value, LengthUnit convertFromUnit, LengthUnit convertToUnit) {
        double valueInMeters = convertFromUnit.toMeters(value);

        return convertToUnit.fromMeters(valueInMeters);
    }

    public double convertWeight(double value, WeightUnit convertFromUnit, WeightUnit convertToUnit) {
        double valueInGram = convertFromUnit.toGram(value);

        return convertToUnit.fromGrams(valueInGram);
    }

    public double convertTemperature(double value, TemperatureUnit convertFromUnit, TemperatureUnit convertToUnit) {
        double valueInKelvin = convertFromUnit.toKelvin(value);

        return convertToUnit.fromKelvin(valueInKelvin);
    }
}
