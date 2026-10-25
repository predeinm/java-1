import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Payment {

    private BigDecimal amount;
    private LocalDate date;
    private String purpose;

    public Payment(
            BigDecimal amount,
            LocalDate date,
            String purpose
    ) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Сумма платежа должна быть больше нуля."
            );
        }

        if (date == null) {
            throw new IllegalArgumentException(
                    "Дата платежа не может быть пустой."
            );
        }

        if (purpose == null || purpose.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Назначение платежа не может быть пустым."
            );
        }

        this.amount = amount;
        this.date = date;
        this.purpose = purpose;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPurpose() {
        return purpose;
    }

    public abstract BigDecimal calculateCommission();

    public abstract String getDescription();

    @Override
    public String toString() {

        BigDecimal commission = calculateCommission();

        BigDecimal total = amount.add(commission);

        return getDescription()
                + "\nДата: " + date
                + "\nНазначение: " + purpose
                + "\nСумма: " + amount
                + "\nКомиссия: " + commission
                + "\nИтого: " + total;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Payment payment = (Payment) obj;

        return amount.compareTo(payment.amount) == 0
                && date.equals(payment.date)
                && purpose.equals(payment.purpose);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                amount.stripTrailingZeros(),
                date,
                purpose
        );
    }
}
