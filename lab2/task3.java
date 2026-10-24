import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double eps;

        do {
            System.out.print("Введите epsilon (> 0): ");
            eps = scanner.nextDouble();

            if (eps <= 0) {
                System.out.println("Ошибка! Epsilon должно быть больше 0.");
            }

        } while (eps <= 0);

        double previous = 2.0;

        int k = 2;

        while (true) {

            double current = 2.0 + 1.0 / previous;

            if (Math.abs(current - previous) < eps) {

                System.out.println("K = " + k);
                System.out.println("A(K-1) = " + previous);
                System.out.println("A(K) = " + current);

                break;
            }

            previous = current;

            k++;
        }

        scanner.close();
    }
}
