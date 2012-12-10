package com.volvocars.demo.junitdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MKStringUtilTest {

    @Test
    public void repeaterReturnsEmptyStringIfRepetitionsIs0() {
        String result = MKStringUtil.repeater("foo", 0);
        assertEquals("", result);
    }

    @Test
    public void repeaterRepeatsStringRepetitionsNumberOfTimes() {
        String result = MKStringUtil.repeater("foo", 3);
        assertEquals("foofoofoo", result);
    }

    @Test
    public void repeaterTreatsNullValueAsTheStringNull() {
        String result = MKStringUtil.repeater(null, 3);
        assertEquals("nullnullnull", result);
    }

    @Test
    public void filterRemovesAllOccurrencesOfFilterFromStringToFilter() {
        String result = MKStringUtil.filter("foobarfoo", "foo");
        assertEquals("bar", result);
    }

    @Test
    public void filterReturnsStringToFilterIfFilterIsntFound() {
        String result = MKStringUtil.filter("foobarfoo", "Foo");
        assertEquals("foobarfoo", result);
    }

    @Test(expected = NullPointerException.class)
    public void filterThrowsNullPointerExceptionIfStringToFilterIsNull() {
        MKStringUtil.filter(null, "foo");
    }

    @Test(expected = NullPointerException.class)
    public void filterThrowsNullPointerExceptionIfFilterIsNull() {
        MKStringUtil.filter("foo", null);
    }

    @Test
    public void isNumericReturnsTrueForOnlyDigits() {
        boolean result = MKStringUtil.isNumeric("1234");
        assertTrue(result);
    }

    @Test
    public void isNumericReturnsFalseForEmptyString() {
        boolean result = MKStringUtil.isNumeric("");
        assertFalse(result);
    }

    @Test
    public void isNumericReturnsTrueForOneDotFollowedByDigits() {
        boolean result = MKStringUtil.isNumeric(".1234");
        assertTrue(result);
    }

    @Test
    public void isNumericReturnsFalseIfStringContainsALetter() {
        boolean result = MKStringUtil.isNumeric("1234A");
        assertFalse(result);
    }

    @Test(expected = NullPointerException.class)
    public void isNumericThrowsNullPointerExceptionForNullInput() {
        MKStringUtil.isNumeric(null);
    }
}
