
package task1_distance;

import java.util.Scanner;

public class Main {

    public static double distance(double x1, double y1,
                                 double x2, double y2) {

        double dx = x2 - x1;
        double dy = y2 - y1;

        double result = Math.sqrt(dx * dx + dy * dy);

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки:");

        System.out.print("x1 = ");
        double x1 = scanner.nextDouble();

        System.out.print("y1 = ");
        double y1 = scanner.nextDouble();

        System.out.println("Введите координаты второй точки:");

        System.out.print("x2 = ");
        double x2 = scanner.nextDouble();

        System.out.print("y2 = ");
        double y2 = scanner.nextDouble();

        double result = distance(x1, y1, x2, y2);

        System.out.println("Расстояние между точками = " + result);

        scanner.close();
    }
}
