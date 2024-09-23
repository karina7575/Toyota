import Car_types.Car;

import java.math.BigDecimal;

public class Cashier {
    private static BigDecimal cash = BigDecimal.valueOf(0.0);

    public <T extends Car> void acceptOrder (T car) {
        cash = cash.add(car.getPrice());
    }

    public BigDecimal getCash() {
        return cash;
    }
}
