package Components;

public enum WheelDiameter {
    SIXTEEN (16),
    SEVENTEEN (17),
    TWENTY(20);
    private int diameter;

    WheelDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
