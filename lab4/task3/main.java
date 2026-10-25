import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        try {

            GasCalculation calculation1 =
                    new IdealGasPressure(
                            "Расчёт по скорости",
                            new BigDecimal("2.5E25"),
                            new BigDecimal("4.65E-26"),
                            new BigDecimal("500")
                    );

            GasCalculation calculation2 =
                    new TemperaturePressure(
                            "Расчёт по температуре",
                            new BigDecimal("2.5E25"),
                            new BigDecimal("300")
                    );

            GasCalculation[] calculations = {
                    calculation1,
                    calculation2
            };

            System.out.println("=== РАСЧЁТЫ ДАВЛЕНИЯ ===");

            for (GasCalculation calculation : calculations) {

                System.out.println();

                System.out.println(calculation);

                System.out.println("-------------------------");
            }

            System.out.println("\n=== СРАВНЕНИЕ ОБЪЕКТОВ ===");

            GasCalculation calculation3 =
                    new IdealGasPressure(
                            "Расчёт по скорости",
                            new BigDecimal("2.5E25"),
                            new BigDecimal("4.65E-26"),
                            new BigDecimal("500")
                    );

            System.out.println(
                    "Первый и третий объекты равны: "
                    + calculation1.equals(calculation3)
            );

            System.out.println(
                    "HashCode первого объекта: "
                    + calculation1.hashCode()
            );

            System.out.println(
                    "HashCode третьего объекта: "
                    + calculation3.hashCode()
            );

            System.out.println("\n=== ПОЛИМОРФИЗМ ===");

            GasCalculation calculation = calculation2;

            System.out.println(
                    "Название: " + calculation.getName()
            );

            System.out.println(
                    "Результат: "
                    + calculation.calculatePressure()
                    + " Па"
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Ошибка: " + e.getMessage()
            );
        }
    }
}
