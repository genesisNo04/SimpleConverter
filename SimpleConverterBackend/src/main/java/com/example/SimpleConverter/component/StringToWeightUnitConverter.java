package com.example.SimpleConverter.component;

import com.example.SimpleConverter.Enum.WeightUnit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToWeightUnitConverter implements Converter<String, WeightUnit> {

    @Override
    public WeightUnit convert(String source) {
        return WeightUnit.fromString(source);
    }
}
