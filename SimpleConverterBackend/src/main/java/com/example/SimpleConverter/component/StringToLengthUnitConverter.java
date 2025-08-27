package com.example.SimpleConverter.component;

import com.example.SimpleConverter.Enum.LengthUnit;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLengthUnitConverter implements Converter<String, LengthUnit> {

    @Override
    public LengthUnit convert(String source) {
        return LengthUnit.fromString(source); // Use your existing lookup logic
    }
}
