package com.volvocars.demo.junitdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @Before
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    public void celsiusToFahrenHeitReturns32For0() {
        Integer actual = converter.celsiusToFahrenheit(0);
        Integer expected = new Integer(32);
        assertEquals(expected, actual);
    }

    @Test
    public void celsiusToFahrenHeitReturnsMinus459ForMinus273() {
        Integer actual = converter.celsiusToFahrenheit(-273);
        Integer expected = new Integer(-459);
        assertEquals(expected, actual);
    }

    @Test
    public void fahrenHeitToCelsiusReturnsMinus18For0() {
        Integer actual = converter.fahrenheitToCelsius(0);
        Integer expected = new Integer(-18);
        assertEquals(expected, actual);
    }

    @Test
    public void fahrenHeitToCelsiusReturnsMinus273ForMinus459() {
        Integer actual = converter.fahrenheitToCelsius(-459);
        Integer expected = new Integer(-273);
        assertEquals(expected, actual);
    }

}
