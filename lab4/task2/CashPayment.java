
package payments;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashPayment extends Payment {

    public CashPayment(
            BigDecimal amount,
            LocalDate date,
            String purpose
    ) {

        super(amount, date, purpose);
    }

    @Override
    public BigDecimal calculateCommission() {

        return BigDecimal.ZERO;
    }

    @Override
    public String getDescription() {

        return "Тип платежа: наличный";
    }
}
