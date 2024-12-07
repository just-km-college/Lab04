package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {

    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class.getName());

    public static void describe(Shape shape) {
        try {
            logger.info("Successfully described object Shape, Shape is (Color: {}) {} with {} area and {} perimeter",shape.getColorDescription(), shape.getClass().getSimpleName(), shape.getArea(), shape.getPerimeter());
            System.out.printf("Class is %s\nArea %.2f\nPerimeter %.2f\nColor %s\n\n", shape, shape.getArea(), shape.getPerimeter(), shape.getColor());
        } catch (Exception e) {
            logger.warn("Failed to describe Shape object with following error: {}", e.getMessage());
        }
    }

}
