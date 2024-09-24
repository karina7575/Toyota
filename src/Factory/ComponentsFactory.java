package Factory;

import Components.*;

public class ComponentsFactory {
    private Country factoryCountry;

    public ComponentsFactory(Country factoryCountry) {
        this.factoryCountry = factoryCountry;
    }

    public Country getFactoryCountry() {
        return factoryCountry;
    }

    public Electrics makeElectrics() {
        return new Electrics(true);
    }

    public Engine makeEngine() {
        return new Engine(true);
    }

    public GasTank makeGasTank() {
        return new GasTank(0);
    }

    public Headlights makeHeadlights() {
        return new Headlights(false);
    }

    public Wheel makeWheels(int diameter) {
        Wheel carWheel = new Wheel(diameter);
        return carWheel;
    }

}
