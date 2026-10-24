import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите X: ");
        double x = scanner.nextDouble();

        int n;

        do {
            System.out.print("Введите N (> 0): ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Ошибка! N должно быть больше 0.");
            }

        } while (n <= 0);

        double sum = 0;

        for (int k = 0; k <= n; k++) {

            // Степень X
            int power = 2 * k + 1;

            // Вычисление X^(2k+1)
            double numerator = Math.pow(x, power);

            // Вычисление (2k+1)!
            long factorial = 1;

            for (int j = 1; j <= power; j++) {
                factorial = factorial * j;
            }

            int sign;

            if (k % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }

            double term = sign * numerator / factorial;

            sum = sum + term;
        }

        System.out.println("Значение выражения = " + sum);

        scanner.close();
    }
}
