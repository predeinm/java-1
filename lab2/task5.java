
package pftk;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Practice1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (true) {

            showMenu();

            choice = readInt(scanner, "Выберите пункт меню: ");

            switch (choice) {

                case 1:
                    task1();
                    break;

                case 2:
                    task2(scanner);
                    break;

                case 3:
                    task3(scanner);
                    break;

                case 4:
                    task4(scanner);
                    break;

                case 5:
                    showProgramInfo();
                    break;

                case 6:
                    showDeveloperInfo();
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Такого пункта меню нет.");
            }

            System.out.println();
        }
    }

    public static void showMenu() {

        System.out.println("========== МЕНЮ ==========");
        System.out.println("1. Задание 1 - переменные");
        System.out.println("2. Задание 2 - вычисление функции");
        System.out.println("3. Задание 3 - поиск большего числа");
        System.out.println("4. Задание 4 - давление идеального газа");
        System.out.println("5. Информация о программе");
        System.out.println("6. Информация о разработчике");
        System.out.println("0. Выход");
        System.out.println("=========================");
    }

    public static void task1() {

        System.out.println("Задание 1 - объявление переменных");

        double k = 550.921034429986213;
        char q = 'r';
        String h = "ласточка";
        String y = "мяч";
        double s = 6632.7105756626491271;
        char g = 'k';
        String r = "воздушный шарик";
        String i = "радуга";
        char d = 'b';
        char j = 'y';
        char f = 'U';
        short value = 4764;
        String cd = "фейерверк";
        String ring = "карусель";
        String c = "воздушный шарик";

        System.out.println("Переменные успешно объявлены.");
        System.out.println("double k = " + k);
        System.out.println("char q = " + q);
        System.out.println("String h = " + h);
        System.out.println("short value = " + value);
    }

    public static void task2(Scanner scanner) {

        System.out.println("Задание 2 - вычисление функции");
        System.out.println("y = 4x^3 + 23x - 55");

        double x = readDouble(scanner, "Введите x: ");

        double y = 4 * Math.pow(x, 3) + 23 * x - 55;

        System.out.printf("y(%.2f) = %.2f%n", x, y);
    }

    public static void task3(Scanner scanner) {

        System.out.println("Задание 3 - вывод большего числа");

        double a = readDouble(scanner, "Введите a: ");
        double b = readDouble(scanner, "Введите b: ");

        if (a > b) {

            System.out.println("Большее число: " + a);

        } else if (b > a) {

            System.out.println("Большее число: " + b);

        } else {

            System.out.println("Числа равны: " + a);
        }
    }

    public static void task4(Scanner scanner) {

        System.out.println("Задание 4 - давление идеального газа");
        System.out.println("Формула: p = (n * m * v^2) / 3");

        BigDecimal n = readBigDecimal(
                scanner,
                "Введите концентрацию, м^-3: "
        );

        BigDecimal m = readBigDecimal(
                scanner,
                "Введите массу молекулы, кг: "
        );

        BigDecimal v = readBigDecimal(
                scanner,
                "Введите среднюю скорость, м/с: "
        );

        if (n.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println(
                    "Ошибка! Концентрация должна быть больше 0."
            );

            return;
        }

        if (m.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println(
                    "Ошибка! Масса должна быть больше 0."
            );

            return;
        }

        if (v.compareTo(BigDecimal.ZERO) < 0) {

            System.out.println(
                    "Ошибка! Скорость не может быть отрицательной."
            );

            return;
        }
      
        BigDecimal pressure = n
                .multiply(m)
                .multiply(v.multiply(v))
                .divide(
                        BigDecimal.valueOf(3),
                        32,
                        RoundingMode.HALF_UP
                );

        System.out.printf(
                "Давление, Па: %.2f%n",
                pressure
        );
    }

    public static void showProgramInfo() {

        System.out.println("Информация о программе");
        System.out.println("Лабораторная работа №1");
        System.out.println("Язык программирования: Java");
        System.out.println("Количество заданий: 4");
        System.out.println("Программа выполняет вычисления.");
    }

    public static void showDeveloperInfo() {

        System.out.println("Информация о разработчике");
        System.out.println("Разработчик: Михаил Предеин");
        System.out.println("Группа: РИ-250931");
    }

    public static int readInt(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                return scanner.nextInt();

            } else {

                System.out.println(
                        "Ошибка! Введите целое число."
                );

                scanner.next();
            }
        }
    }

    public static double readDouble(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextDouble()) {

                return scanner.nextDouble();

            } else {

                System.out.println(
                        "Ошибка! Введите вещественное число."
                );

                scanner.next();
            }
        }
    }

    public static BigDecimal readBigDecimal(
            Scanner scanner,
            String message
    ) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextBigDecimal()) {

                return scanner.nextBigDecimal();

            } else {

                System.out.println(
                        "Ошибка! Введите корректное число."
                );

                scanner.next();
            }
        }
    }
}
