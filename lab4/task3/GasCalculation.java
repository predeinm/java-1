import java.math.BigDecimal;
import java.util.Objects;

public abstract class GasCalculation {

    private String name;

    public GasCalculation(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Название расчёта не может быть пустым."
            );
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract BigDecimal calculatePressure();

    public String getDescription() {
        return "Расчёт давления газа: " + name;
    }

    @Override
    public String toString() {

        return getDescription()
                + "\nДавление: "
                + calculatePressure()
                + " Па";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        GasCalculation other = (GasCalculation) obj;

        return name.equals(other.name)
                && calculatePressure().compareTo(
                        other.calculatePressure()
                ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                getClass(),
                name,
                calculatePressure().stripTrailingZeros()
        );
    }
}
