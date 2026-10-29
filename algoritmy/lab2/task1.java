
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Сортировка серийных номеров методом Radix Sort.
     *
     * Временная сложность: O(n * k),
     * где n — количество серийных номеров,
     * k — максимальное количество цифр в номере.
     *
     * На каждом разряде алгоритм проходит по всем n номерам.
     * Всего обрабатывается k разрядов.
     * Поэтому общая сложность составляет O(n * k).
     *
     * Пространственная сложность: O(n),
     * поскольку для распределения элементов по цифрам
     * используются дополнительные списки.
     *
     * Сортировка стабильная: порядок номеров с одинаковой
     * цифрой в текущем разряде сохраняется.
     */
    public static int[] radixSort(int[] serialNumbers) {
        if (serialNumbers == null || serialNumbers.length == 0) {
            return serialNumbers;
        }

        int[] numbers = serialNumbers.clone();

        int max = numbers[0];
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException(
                        "Серийные номера должны содержать только цифры"
                );
            }
            max = Math.max(max, number);
        }

        for (long exp = 1; max / exp > 0; exp *= 10) {
            List<Integer>[] buckets = new ArrayList[10];

            for (int i = 0; i < 10; i++) {
                buckets[i] = new ArrayList<>();
            }

            for (int number : numbers) {
                int digit = (int) ((number / exp) % 10);
                buckets[digit].add(number);
            }

            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (int number : bucket) {
                    numbers[index++] = number;
                }
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {123456, 654321, 111111},
                {9000, 1000, 99}
        };

        int[][] expectedResults = {
                {111111, 123456, 654321},
                {99, 1000, 9000}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = radixSort(testCases[i]);

            System.out.println("Вход: " + Arrays.toString(testCases[i]));
            System.out.println("Результат: " + Arrays.toString(result));
            System.out.println(
                    "Проверка: " +
                    Arrays.equals(result, expectedResults[i])
            );
            System.out.println();
        }
    }
}
