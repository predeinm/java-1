import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    /*
Сортировка значений сигнала методом Bucket Sort.

Временная сложность:
В среднем — O(n), если значения распределены
примерно равномерно между корзинами.

В худшем случае — O(n^2), если почти все значения
попадут в одну корзину и будут сортироваться
методом, имеющим квадратичную сложность.

Пространственная сложность — O(n + b),
где n — количество значений, b — количество корзин.
Дополнительная память используется для хранения
элементов в корзинах.
*/
    public static double[] bucketSort(double[] signal) {
        int n = signal.length;

        if (n <= 1) {
            return signal.clone();
        }

        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double value : signal) {
            if (value < 0 || value >= 1) {
                throw new IllegalArgumentException(
                        "Значения должны принадлежать диапазону [0, 1)"
                );
            }

            int bucketIndex = (int) (value * n);

            buckets[bucketIndex].add(value);
        }

        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        double[] result = new double[n];
        int index = 0;

        for (List<Double> bucket : buckets) {
            for (double value : bucket) {
                result[index++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[][] testCases = {
                {0.55, 0.05, 0.95, 0.35},
                {0.12, 0.13, 0.90}
        };

        double[][] expectedResults = {
                {0.05, 0.35, 0.55, 0.95},
                {0.12, 0.13, 0.90}
        };

        for (int i = 0; i < testCases.length; i++) {
            double[] result = bucketSort(testCases[i]);

            System.out.println("Вход:");
            System.out.println(java.util.Arrays.toString(testCases[i]));

            System.out.println("Результат:");
            System.out.println(java.util.Arrays.toString(result));

            System.out.println(
                    "Проверка: " +
                    java.util.Arrays.equals(result, expectedResults[i])
            );

            System.out.println();
        }
    }
}
