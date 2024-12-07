package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Triangle")
public class Triangle extends Shape {

    @Column(name = "base")
    private final double base;

    @Column(name = "height")
    private final double height;

    public Triangle(Color color, double base) {
        super(color);
        this.base = base;
        this.height = (base * Math.sqrt(3)) / 2;
    }

    public Triangle() {
        this(new Color(255,255,255),6);
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    double getArea() {
        return (base * height) / 2;
    }

    @Override
    double getPerimeter() {
        return base * 3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                " " + super.toString();
    }
}
