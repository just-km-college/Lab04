package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public record Color(int alfa, int red, int green, int blue) {

    public Color(int alfa, int red, int green, int blue) {
        this.alfa = alfa < 0 || alfa > 255 ? 0 : alfa;
        this.red = red < 0 || red > 255 ? 0 : red;
        this.blue = blue < 0 || blue > 255 ? 0 : blue;
        this.green = green < 0 || green > 255 ? 0 : green;
    }

    public Color(int red, int green, int blue) {
        this(0,red,green,blue);
    }

    public String niceToString() {
        return "Color: 0x" + String.format("%02X", this.alfa) + String.format("%02X", this.red) + String.format("%02X", this.green) + String.format("%02X", this.blue);
    }

}