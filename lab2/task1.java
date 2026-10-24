import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int A, B;

        System.out.println("Введите целые числа A и B (A < B)");

        System.out.print("Введите A: ");
        A = scanner.nextInt();

        System.out.print("Введите B: ");
        B = scanner.nextInt();

        if (A >= B) {
            System.out.println("Ошибка! A должно быть меньше B.");
            return;
        }

        int count = 0;

        System.out.println("Числа от B до A:");

        for (int i = B; i >= A; i--) {

            System.out.print(i + " ");

            count++;
        }

        System.out.println();

        System.out.println("Количество чисел: " + count);

        scanner.close();
    }
}
