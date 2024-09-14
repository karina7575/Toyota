package Components;

public class Headlights {
    private boolean isWorking;

    public Headlights(boolean isWorking) {
        this.isWorking = isWorking;
    }

    /**
     * включить или выключить фары
     */
    public void setWork(boolean isWorking) {
        this.isWorking = isWorking;
    }
}
