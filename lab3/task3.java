import java.util.Scanner;

public class Main {

    public static double[] calculateB(double[] a) {

        int n = a.length;

        double[] b = new double[n];

        double sum = 0;

        for (int i = n - 1; i >= 0; i--) {

            sum = sum + a[i];

            b[i] = sum / (n - i);
        }

        return b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;

        do {

            System.out.print("Введите размер массива N (> 0): ");

            n = scanner.nextInt();

            if (n <= 0) {

                System.out.println(
                        "Ошибка! N должно быть больше 0."
                );
            }

        } while (n <= 0);

        double[] a = new double[n];

        System.out.println("Введите элементы массива A:");

        for (int i = 0; i < n; i++) {

            System.out.print("A[" + (i + 1) + "] = ");

            a[i] = scanner.nextDouble();
        }

        double[] b = calculateB(a);

        System.out.println("\nМассив A:");

        for (int i = 0; i < n; i++) {

            System.out.printf("%.2f ", a[i]);
        }

        System.out.println("\n\nМассив B:");

        for (int i = 0; i < n; i++) {

            System.out.printf("%.2f ", b[i]);
        }

        System.out.println();

        scanner.close();
    }
}
