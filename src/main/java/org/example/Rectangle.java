package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Rectangle")
public class Rectangle extends Shape {

    @Column(name = "a")
    private final double a;

    @Column(name = "b")
    private final double b;

    public Rectangle(Color color, double a, double b) {
        super(color);
        this.a = a;
        this.b = b;
    }

    public Rectangle() {
        this(new Color(255,255,255),1,1);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    double getArea() {
        return a * b;
    }

    @Override
    double getPerimeter() {
        return a * 2 + b * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                " " + super.toString();
    }
}

