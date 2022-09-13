package com.example.bmicalculator;

import junit.framework.TestCase;

import java.text.MessageFormat;

public class MainActivityTest extends TestCase {

    // Test for valid values - should return the rounded up value of 28
    public void testOnCreate_returnsValidValue() {
        String weightText = "80";
        String heightText = "170";

        String result;

        String errorText = "Fill out all values please!";

        int weightLength = weightText.length();
        int heightLength = heightText.length();

        if (weightLength < 1 || heightLength < 1) {
            result = errorText;
        } else {
            // BMI = Weight : (Height)²
            double weightParsed = Double.parseDouble(weightText);
            double heightParsed = Double.parseDouble(heightText);
            double bmiResult = weightParsed / (heightParsed * heightParsed / 100) * 100;
            int finalResult = (int) Math.ceil(bmiResult);
            result = MessageFormat.format("Your calculated BMI: {0}", finalResult);
        }
        String expected = "Your calculated BMI: 28";
        assertEquals(result, expected);
    }

    // Test for invalid or not existing values - should return the error string
    public void testOnCreate_returnsErrorText() {
        String weightText = "";
        String heightText = "";

        String result;

        String errorText = "Fill out all values please!";

        int weightLength = weightText.length();
        int heightLength = heightText.length();

        if (weightLength < 1 || heightLength < 1) {
            result = errorText;
        } else {
            // BMI = Weight : (Height)²
            double weightParsed = Double.parseDouble(weightText);
            double heightParsed = Double.parseDouble(heightText);
            double bmiResult = weightParsed / (heightParsed * heightParsed / 100) * 100;
            int finalResult = (int) Math.ceil(bmiResult);
            result = MessageFormat.format("Your calculated BMI: {0}", finalResult);
        }
        assertEquals(result, errorText);
    }
}