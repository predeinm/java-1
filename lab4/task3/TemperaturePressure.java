import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperaturePressure extends GasCalculation {

    private static final BigDecimal BOLTZMANN =
            new BigDecimal("1.380649E-23");

    private BigDecimal concentration;
    private BigDecimal temperature;

    public TemperaturePressure(
            String name,
            BigDecimal concentration,
            BigDecimal temperature
    ) {

        super(name);

        if (concentration == null
                || concentration.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Концентрация должна быть больше нуля."
            );
        }

        if (temperature == null
                || temperature.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Температура должна быть больше нуля."
            );
        }

        this.concentration = concentration;
        this.temperature = temperature;
    }

    @Override
    public BigDecimal calculatePressure() {

        return concentration
                .multiply(BOLTZMANN)
                .multiply(temperature)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String getDescription() {

        return "Давление идеального газа по температуре";
    }

    public BigDecimal getConcentration() {
        return concentration;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }
}
