
import java.util.Arrays;

public class Main {

    /*
    Сортировка расписания по дням недели методом Insertion Sort.

    Временная сложность:
    В лучшем случае — O(n), если массив уже отсортирован.
    В среднем — O(n^2).
    В худшем случае — O(n^2), если массив отсортирован
    в обратном порядке.

    Пространственная сложность — O(1),
    так как сортировка выполняется внутри массива
    без создания дополнительных массивов.

    Алгоритм стабилен: элементы с одинаковым номером дня
    сохраняют свой первоначальный порядок.
    */

    public static void insertionSort(int[] schedule) {
        for (int i = 1; i < schedule.length; i++) {
            int current = schedule[i];
            int j = i - 1;

           
            while (j >= 0 && schedule[j] > current) {
                schedule[j + 1] = schedule[j];
                j--;
            }

            schedule[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {7, 2, 7, 1},
                {3, 3, 5, 1}
        };

        int[][] expectedResults = {
                {1, 2, 7, 7},
                {1, 3, 3, 5}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] schedule = testCases[i].clone();

            insertionSort(schedule);

            System.out.println("Вход: " +
                    Arrays.toString(testCases[i]));
            System.out.println("Результат: " +
                    Arrays.toString(schedule));
            System.out.println("Проверка: " +
                    Arrays.equals(schedule, expectedResults[i]));
            System.out.println();
        }
    }
}
