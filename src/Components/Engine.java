package Components;

public class Engine {
    private boolean isFunctional;

    public Engine(boolean isFunctional) {
        this.isFunctional = isFunctional;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }
}
