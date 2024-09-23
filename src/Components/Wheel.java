package Components;

public class Wheel {
    private boolean isPierced;
    private int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
        this.isPierced = false;
    }

    public int getDiameter() {
        return diameter;
    }

    public boolean getIsPierced() {
        return isPierced;
    }

    public void setPierced(boolean pierced) {
        isPierced = pierced;
    }
}
