package Car_types;

import java.math.BigDecimal;

public enum CarTypes {
    CAMRY(BigDecimal.valueOf(10000), 17),
    SOLARA(BigDecimal.valueOf(12000), 16),
    HIANCE(BigDecimal.valueOf(15000), 20),
    DYNA(BigDecimal.valueOf(22000), 20);

    private BigDecimal cost;
    private int wheelDiameter;

    CarTypes(BigDecimal cost, int wheelDiameter) {
        this.cost = cost;
        this.wheelDiameter = wheelDiameter;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }
}
