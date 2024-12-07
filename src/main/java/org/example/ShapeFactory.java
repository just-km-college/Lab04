package org.example;

import java.util.Scanner;

public class ShapeFactory {

    public static Triangle triangleCreator(Scanner scanner) {

        System.out.print("Enter desired triangle base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter desired color alpha parameter: ");
        int alpha = scanner.nextInt();
        System.out.print("Enter desired color red parameter: ");
        int red = scanner.nextInt();
        System.out.print("Enter desired color green parameter: ");
        int green = scanner.nextInt();
        System.out.print("Enter desired color blue parameter: ");
        int blue = scanner.nextInt();

        Color color = new Color(alpha,red,green,blue);

        return new Triangle(color,base);

    }

    public static Rectangle rectangleCreator(Scanner scanner) {

        System.out.print("Enter desired rectangle a side: ");
        double a = scanner.nextDouble();
        System.out.print("Enter desired rectangle b side: ");
        double b = scanner.nextDouble();
        System.out.print("Enter desired color alpha parameter: ");
        int alpha = scanner.nextInt();
        System.out.print("Enter desired color red parameter: ");
        int red = scanner.nextInt();
        System.out.print("Enter desired color green parameter: ");
        int green = scanner.nextInt();
        System.out.print("Enter desired color blue parameter: ");
        int blue = scanner.nextInt();

        Color color = new Color(alpha,red,green,blue);

        return new Rectangle(color,a,b);
    }

}