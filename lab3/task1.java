
package task5_array;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");

        int n = scanner.nextInt();

        while (n <= 0) {

            System.out.println("Ошибка! Количество должно быть больше 0.");

            System.out.print("Введите количество элементов массива: ");

            n = scanner.nextInt();
        }

        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < n; i++) {

            System.out.print("arr[" + i + "] = ");

            arr[i] = scanner.nextInt();
        }

        System.out.println("Элементы с нечётными номерами:");

        for (int i = 0; i < n; i += 2) {

            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Элементы с чётными номерами:");

        for (int i = n - 1 - (n % 2 == 0 ? 0 : 1);
             i >= 0;
             i -= 2) {

            System.out.print(arr[i] + " ");
        }

        System.out.println();

        scanner.close();
    }
}
