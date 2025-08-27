package com.example.SimpleConverter.component;

import com.example.SimpleConverter.Enum.TemperatureUnit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTemperatureUnitConverter implements Converter<String, TemperatureUnit> {

    @Override
    public TemperatureUnit convert(String source) {
        return TemperatureUnit.fromString(source);
    }
}
