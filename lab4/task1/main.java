
package bankaccount;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        try {

            BankAccount account1 = new BankAccount(
                    "Михаил",
                    new BigDecimal("10000.00")
            );

            BankAccount account2 = new BankAccount(
                    "Александр",
                    new BigDecimal("5000.00")
            );

            BankAccount account3 = new BankAccount(
                    "Иван",
                    new BigDecimal("2500.00")
            );

            System.out.println("=== ИНФОРМАЦИЯ О СЧЕТАХ ===");

            System.out.println(account1.getAccountInfo());
            System.out.println();

            System.out.println(account2.getAccountInfo());
            System.out.println();

            System.out.println(account3.getAccountInfo());
            System.out.println();

            // Пополнение первого счёта
            System.out.println("=== ПОПОЛНЕНИЕ СЧЁТА ===");

            account1.deposit(
                    new BigDecimal("3000.00")
            );

            System.out.println(account1.getAccountInfo());
            System.out.println();

            // Снятие денег
            System.out.println("=== СНЯТИЕ ДЕНЕГ ===");

            account1.withdraw(
                    new BigDecimal("2000.00")
            );

            System.out.println(account1.getAccountInfo());
            System.out.println();

            // Проверка изменения исходного объекта
            System.out.println("=== ПРОВЕРКА БАЛАНСА ===");

            System.out.println(
                    "Баланс первого счёта: "
                    + account1.getBalance()
                    + " руб."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
