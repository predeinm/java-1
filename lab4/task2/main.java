import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            Payment[] payments = {

                new CashPayment(
                        new BigDecimal("1000.00"),
                        LocalDate.now(),
                        "Покупка продуктов"
                ),

                new CashPayment(
                        new BigDecimal("2500.00"),
                        LocalDate.now(),
                        "Покупка одежды"
                ),

                new CardPayment(
                        new BigDecimal("3000.00"),
                        LocalDate.now(),
                        "Оплата техники"
                ),

                new CardPayment(
                        new BigDecimal("1500.00"),
                        LocalDate.now(),
                        "Оплата услуг"
                ),

                new BankTransferPayment(
                        new BigDecimal("5000.00"),
                        LocalDate.now(),
                        "Перевод денежных средств"
                ),

                new BankTransferPayment(
                        new BigDecimal("4000.00"),
                        LocalDate.now(),
                        "Оплата аренды"
                )
            };

            BigDecimal total = BigDecimal.ZERO;

            System.out.println("=== СПИСОК ПЛАТЕЖЕЙ ===");

            for (Payment payment : payments) {

                System.out.println(payment);

                BigDecimal paymentTotal =
                        payment.getAmount()
                                .add(payment.calculateCommission());

                total = total.add(paymentTotal);

                System.out.println("-------------------------");
            }

            System.out.println("\n=== ОБЩИЙ РЕЗУЛЬТАТ ===");

            System.out.println(
                    "Количество платежей: " + payments.length
            );

            System.out.println(
                    "Общая сумма платежей с комиссиями: "
                    + total + " руб."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Ошибка: " + e.getMessage()
            );
        }
    }
}
