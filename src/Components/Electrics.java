package Components;

public class Electrics {
    private boolean isFunctional;

    public Electrics(boolean isFunctional) {
        this.isFunctional = isFunctional;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }
}
