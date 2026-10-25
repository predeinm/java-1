import java.math.BigDecimal;

public class BankAccount {


    private String owner;
    private BigDecimal balance;

    public BankAccount(String owner, BigDecimal balance) {

        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Владелец счёта не может быть пустым."
            );
        }

        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть отрицательным."
            );
        }

        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {

        checkAmount(amount);

        balance = balance.add(amount);

        System.out.println(
                "Счёт пополнен на " + amount + " руб."
        );
    }

    public void withdraw(BigDecimal amount) {

        checkAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException(
                    "Недостаточно средств."
            );
        }

        balance = balance.subtract(amount);

        System.out.println(
                "Со счёта снято " + amount + " руб."
        );
    }

    private void checkAmount(BigDecimal amount) {

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Сумма должна быть больше нуля."
            );
        }
    }

    public String getAccountInfo() {

        return "Владелец: " + owner
                + "\nБаланс: " + balance + " руб.";
    }

    public String getOwner() {

        return owner;
    }

    public BigDecimal getBalance() {

        return balance;
    }
}
