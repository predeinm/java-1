import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;

        do {
            System.out.print("Введите размер массива N (N >= 2): ");
            n = scanner.nextInt();

            if (n < 2) {
                System.out.println("Ошибка! Размер массива должен быть >= 2.");
            }

        } while (n < 2);

        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < n; i++) {

            System.out.print("arr[" + i + "] = ");

            arr[i] = scanner.nextInt();
        }

        int first = -1;
        int second = -1;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    first = i;
                    second = j;

                    break;
                }
            }

            if (first != -1) {
                break;
            }
        }

        System.out.println("Номера одинаковых элементов:");

        System.out.println((first + 1) + " и " + (second + 1));

        scanner.close();
    }
}
