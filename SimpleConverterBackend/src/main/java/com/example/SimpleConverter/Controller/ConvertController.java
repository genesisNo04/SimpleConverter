package com.example.SimpleConverter.Controller;

import com.example.SimpleConverter.Enum.LengthUnit;
import com.example.SimpleConverter.Enum.TemperatureUnit;
import com.example.SimpleConverter.Enum.WeightUnit;
import com.example.SimpleConverter.Service.Impl.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/length")
    public double convertLength(@RequestParam double value,
                                @RequestParam LengthUnit from,
                                @RequestParam LengthUnit to) {
        return converterService.convertLength(value, from, to);
    }

    @GetMapping("/weight")
    public double convertWeight(@RequestParam double value,
                                @RequestParam WeightUnit from,
                                @RequestParam WeightUnit to) {
        return converterService.convertWeight(value, from, to);
    }

    @GetMapping("/temperature")
    public double convertTemperature(@RequestParam double value,
                                @RequestParam TemperatureUnit from,
                                @RequestParam TemperatureUnit to) {
        return converterService.convertTemperature(value, from, to);
    }
}
