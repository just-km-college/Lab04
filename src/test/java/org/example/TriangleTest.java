package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    private Triangle triangle;

    @Test
    public void testDefaultConstructor() {

        triangle = new Triangle();

        double expectedHeight = (6 * Math.sqrt(3)) / 2;

        assertEquals(6.0, triangle.getBase(), 0.00001);
        assertEquals(expectedHeight, triangle.getHeight(), 0.00001);

    }

    @Test
    public void testCustomConstructor() {

        Color color = new Color(255,0,0);
        double base = 10.0;
        double expectedHeight = (base * Math.sqrt(3)) / 2;

        triangle = new Triangle(color,base);

        assertEquals(base, triangle.getBase(), 0.00001);
        assertEquals(expectedHeight, triangle.getHeight(), 0.00001);
        assertEquals(color, triangle.getColor());

    }

    @Test
    public void testGetArea() {

        triangle = new Triangle();

        double expectedArea = (6 * (6 * Math.sqrt(3)) / 2) / 2;
        assertEquals(expectedArea, triangle.getArea(), 0.001);

    }

    @Test
    public void testGetPerimeter() {

        triangle = new Triangle();

        double expectedPerimeter = 6 * 3;
        assertEquals(expectedPerimeter, triangle.getPerimeter(), 0.001);

    }

    @Test
    public void testSmallBase() {

        triangle = new Triangle(new Color(0, 0, 255), 0.1);

        double expectedHeight = (0.1 * Math.sqrt(3)) / 2;

        assertEquals(0.1, triangle.getBase(), 0.001);
        assertEquals(expectedHeight, triangle.getHeight(), 0.001);

    }

    @Test
    public void testLargeBase() {

        triangle = new Triangle(new Color(0, 255, 0), 1000);

        double expectedHeight = (1000 * Math.sqrt(3)) / 2;

        assertEquals(1000, triangle.getBase(), 0.001);
        assertEquals(expectedHeight, triangle.getHeight(), 0.001);

    }

}