import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            // Создание наличного платежа
            Payment payment1 = new CashPayment(
                    new BigDecimal("1000.00"),
                    LocalDate.now(),
                    "Покупка продуктов"
            );

            Payment payment2 = new CardPayment(
                    new BigDecimal("2000.00"),
                    LocalDate.now(),
                    "Оплата покупки"
            );

            Payment payment3 = new BankTransferPayment(
                    new BigDecimal("5000.00"),
                    LocalDate.now(),
                    "Перевод денежных средств"
            );

            Payment[] payments = {
                    payment1,
                    payment2,
                    payment3
            };

            System.out.println("=== СПИСОК ПЛАТЕЖЕЙ ===");

            for (Payment payment : payments) {

                System.out.println();

                System.out.println(payment);

                System.out.println("-------------------------");
            }

            System.out.println("\n=== СРАВНЕНИЕ ПЛАТЕЖЕЙ ===");

            Payment payment4 = new CashPayment(
                    new BigDecimal("1000.00"),
                    LocalDate.now(),
                    "Покупка продуктов"
            );

            System.out.println(
                    "Первый и четвёртый платежи равны: "
                    + payment1.equals(payment4)
            );

            System.out.println(
                    "HashCode первого платежа: "
                    + payment1.hashCode()
            );

            System.out.println(
                    "HashCode четвёртого платежа: "
                    + payment4.hashCode()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Ошибка: " + e.getMessage()
            );
        }
    }
}
