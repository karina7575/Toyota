package Components;

public class Wheel {
    private boolean isPierced;
    private WheelDiameter diameter;

    public Wheel(WheelDiameter diameter) {
        this.diameter = diameter;
        this.isPierced = false;
    }

    public WheelDiameter getDiameter() {
        return diameter;
    }

    public boolean getIsPierced() {
        return isPierced;
    }

    public void setPierced(boolean pierced) {
        isPierced = pierced;
    }
}
