import java.math.BigDecimal;
import java.math.RoundingMode;

public class IdealGasPressure extends GasCalculation {

    private BigDecimal concentration;
    private BigDecimal mass;
    private BigDecimal velocity;

    public IdealGasPressure(
            String name,
            BigDecimal concentration,
            BigDecimal mass,
            BigDecimal velocity
    ) {

        super(name);

        if (concentration == null
                || concentration.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Концентрация должна быть больше нуля."
            );
        }

        if (mass == null
                || mass.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Масса должна быть больше нуля."
            );
        }

        if (velocity == null
                || velocity.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Скорость не может быть отрицательной."
            );
        }

        this.concentration = concentration;
        this.mass = mass;
        this.velocity = velocity;
    }

    @Override
    public BigDecimal calculatePressure() {

        BigDecimal velocitySquared =
                velocity.multiply(velocity);

        BigDecimal numerator =
                concentration
                        .multiply(mass)
                        .multiply(velocitySquared);

        return numerator.divide(
                BigDecimal.valueOf(3),
                2,
                RoundingMode.HALF_UP
        );
    }

    @Override
    public String getDescription() {

        return "Давление идеального газа по средней скорости";
    }

    public BigDecimal getConcentration() {
        return concentration;
    }

    public BigDecimal getMass() {
        return mass;
    }

    public BigDecimal getVelocity() {
        return velocity;
    }
}
