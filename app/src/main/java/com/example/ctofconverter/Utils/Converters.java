package com.example.ctofconverter.Utils;

public class Converters {

    /**
     * Fahrenheit = (C * 9/5) + 32
     * Celsius = (F - 32) * 5/9
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * (9.0/5.0)) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * (5.0/9.0);
    }

}
