import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class BankTransferPayment extends Payment {

    private static final BigDecimal COMMISSION_RATE =
            new BigDecimal("0.008");

    public BankTransferPayment(
            BigDecimal amount,
            LocalDate date,
            String purpose
    ) {

        super(amount, date, purpose);
    }

    @Override
    public BigDecimal calculateCommission() {

        return getAmount()
                .multiply(COMMISSION_RATE)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getDescription() {

        return "Тип платежа: банковский перевод";
    }
}
