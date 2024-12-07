package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {

    private Color color;

    @Test
    public void testConstructorValidValues() {

        color = new Color(255, 128, 64, 32);

        assertEquals(255, color.alfa());
        assertEquals(128, color.red());
        assertEquals(64, color.green());
        assertEquals(32, color.blue());

    }

    @Test
    public void testConstructorInvalidValues() {

        color = new Color(300, -10, 500, -1);

        assertEquals(0, color.alfa());
        assertEquals(0, color.red());
        assertEquals(0, color.green());
        assertEquals(0, color.blue());

    }

    @Test
    public void testConstructorRGB() {

        color = new Color(255, 128, 64);

        assertEquals(0, color.alfa());
        assertEquals(255, color.red());
        assertEquals(128, color.green());
        assertEquals(64, color.blue());

    }

    @Test
    public void testNiceToString() {

        color = new Color(255, 128, 64, 32);

        String expectedString = "Color: 0xFF804020";

        assertEquals(expectedString, color.niceToString());

    }

    @Test
    public void testNiceToStringDefault() {

        color = new Color(0, 0, 0, 0);

        String expectedString = "Color: 0x00000000";

        assertEquals(expectedString, color.niceToString());

    }

    @Test
    public void testNiceToStringRGBOnly() {

        color = new Color(255, 128, 64);

        String expectedString = "Color: 0x00FF8040";

        assertEquals(expectedString, color.niceToString());

    }

}