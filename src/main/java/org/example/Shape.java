package org.example;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract double getArea();
    abstract double getPerimeter();

    public Color getColor() {
        return this.color;
    }

    public String getColorDescription() {
        return "Alpha: " + this.color.alfa() + " Red: " + this.color.red() + " Green: " + this.color.green() + " Blue: " + this.color.blue() + "\n";
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", color=" + color +
                '}';
    }
}
