import java.math.BigDecimal;

public class Customer {
    private BigDecimal money;
    private final String NAME;

    public Customer(BigDecimal money, String name) {
        this.money = money;
        this.NAME = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "NAME='" + NAME + '\'' +
                '}';
    }
}
