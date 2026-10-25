import java.util.Scanner;

public class Main {

    public static double[][] createMatrix(
            int m,
            int n,
            double d,
            double[] a
    ) {

        double[][] matrix = new double[m][n];

        for (int j = 0; j < n; j++) {

            matrix[0][j] = a[j];
        }

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] = matrix[i - 1][j] * d;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ввод M
        int m;

        do {

            System.out.print("Введите количество строк M (> 0): ");

            m = scanner.nextInt();

            if (m <= 0) {

                System.out.println(
                        "Ошибка! M должно быть больше 0."
                );
            }

        } while (m <= 0);

        // Ввод N
        int n;

        do {

            System.out.print("Введите количество столбцов N (> 0): ");

            n = scanner.nextInt();

            if (n <= 0) {

                System.out.println(
                        "Ошибка! N должно быть больше 0."
                );
            }

        } while (n <= 0);

        System.out.print("Введите число D: ");

        double d = scanner.nextDouble();

        double[] a = new double[n];

        System.out.println("Введите исходные N чисел:");

        for (int j = 0; j < n; j++) {

            System.out.print("A[" + (j + 1) + "] = ");

            a[j] = scanner.nextDouble();
        }

        double[][] matrix = createMatrix(m, n, d, a);

        System.out.println("\nПолученная матрица:");

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%10.2f", matrix[i][j]);
            }

            System.out.println();
        }

        scanner.close();
    }
}
