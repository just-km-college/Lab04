package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle rectangle;

    @Test
    public void testDefaultConstructor() {

        rectangle = new Rectangle();

        assertEquals(1.0, rectangle.getA(), 0.001);
        assertEquals(1.0, rectangle.getB(), 0.001);

    }

    @Test
    public void testCustomConstructor() {

        Color color = new Color(0, 255, 0);
        double a = 5.0;
        double b = 10.0;
        rectangle = new Rectangle(color, a, b);

        assertEquals(a, rectangle.getA(), 0.001);
        assertEquals(b, rectangle.getB(), 0.001);
        assertEquals(color, rectangle.getColor());

    }

    @Test
    public void testGetArea() {
        rectangle = new Rectangle();

        double expectedArea = 1.0;
        assertEquals(expectedArea, rectangle.getArea(), 0.001);
    }

    @Test
    public void testGetPerimeter() {
        rectangle = new Rectangle();

        double expectedPerimeter = 1.0 * 2 + 1.0 * 2;
        assertEquals(expectedPerimeter, rectangle.getPerimeter(), 0.001);

    }

    @Test
    public void testSmallValues() {

        rectangle = new Rectangle(new Color(255, 0, 0), 0.1, 0.1);

        double expectedArea = 0.1 * 0.1;
        double expectedPerimeter = 0.1 * 2 + 0.1 * 2;

        assertEquals(0.1, rectangle.getA(), 0.001);
        assertEquals(0.1, rectangle.getB(), 0.001);
        assertEquals(expectedArea, rectangle.getArea(), 0.001);
        assertEquals(expectedPerimeter, rectangle.getPerimeter(), 0.001);

    }

    @Test
    public void testLargeValues() {

        rectangle = new Rectangle(new Color(0, 0, 255), 1000, 5000);

        double expectedArea = 1000 * 5000;
        double expectedPerimeter = 1000 * 2 + 5000 * 2;

        assertEquals(1000, rectangle.getA(), 0.001);
        assertEquals(5000, rectangle.getB(), 0.001);
        assertEquals(expectedArea, rectangle.getArea(), 0.001);
        assertEquals(expectedPerimeter, rectangle.getPerimeter(), 0.001);

    }

}