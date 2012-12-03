package com.volvocars.demo.junitdemo;

/**
 * A very simple temperature converter class.
 * 
 */
public class TemperatureConverter {

    /**
     * Converts a temperature from Celsius to Fahrenheit.
     * 
     * @param celsius
     *            The temperature in degrees Celsius.
     * @return The temperature in degrees Fahrenheit.
     */
    public Integer celsiusToFahrenheit(Integer celsius) {
        int fahrenheit = Math.round(celsius.intValue() * 9 / 5F) + 32;
        return Integer.valueOf(fahrenheit);
    }

    /**
     * Converts a temperature from Fahrenheit to Celsius.
     * 
     * @param fahrenheit
     *            The temperature in degrees Fahrenheit.
     * @return The temperature in degrees Celsius.
     */
    public Integer fahrenheitToCelsius(Integer fahrenheit) {
        int celsius = Math.round((fahrenheit.intValue() - 32) * 5 / 9F);
        return Integer.valueOf(celsius);
    }
}
