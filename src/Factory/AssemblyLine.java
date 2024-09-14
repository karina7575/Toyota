package Factory;

import Car_types.Camry;
import Car_types.Dyna;
import Car_types.Hiance;
import Car_types.Solara;
import Components.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * сборочный конвейер
 */
public class AssemblyLine {
    private Country factoryCountry;
    private ComponentsFactory factory;

    public AssemblyLine(Country factoryCountry, ComponentsFactory factory) {
        this.factoryCountry = factoryCountry;
        if(factory.getFactoryCountry() == factoryCountry){
            this.factory = factory;
        }
        else {
            System.out.println("Завод находится в другой стране, использовать его нельзя, выберите другой завод");
        }
    }

    public void setFactory(ComponentsFactory factory) {
        this.factory = factory;
    }

    public Camry createCamry (String color) {
        GasTank gasTank = factory.makeGasTank();
        Engine engine = factory.makeEngine();
        Electrics electrics = factory.makeElectrics();
        Headlights headLights = factory.makeHeadlights();
        Wheel[] wheels = new Wheel[4];
        for( int i = 0; i < wheels.length; i++) {
            wheels[i] = factory.makeWheels(WheelDiameter.SEVENTEEN);
        }
        System.out.println(Arrays.toString(wheels));
        return new Camry(color, 200, wheels, gasTank, engine, electrics, headLights);
    }

    public Solara createSolara (String color) {
        GasTank gasTank = factory.makeGasTank();
        Engine engine = factory.makeEngine();
        Electrics electrics = factory.makeElectrics();
        Headlights headLights = factory.makeHeadlights();
        Wheel[] wheels = new Wheel[4];
        for( int i = 0; i < wheels.length; i++) {
            wheels[i] = factory.makeWheels(WheelDiameter.SIXTEEN);
        }
        System.out.println(Arrays.toString(wheels));
        return new Solara(color, 250, wheels, gasTank, engine, electrics, headLights);
    }

    public Dyna createDyna (String color) {
        GasTank gasTank = factory.makeGasTank();
        Engine engine = factory.makeEngine();
        Electrics electrics = factory.makeElectrics();
        Headlights headLights = factory.makeHeadlights();
        Wheel[] wheels = new Wheel[4];
        for( int i = 0; i < wheels.length; i++) {
            wheels[i] = factory.makeWheels(WheelDiameter.TWENTY);
        }
        System.out.println(Arrays.toString(wheels));
        return new Dyna(color, 160, wheels, gasTank, engine, electrics, headLights, 400);
    }

    public Hiance createHiance (String color) {
        GasTank gasTank = factory.makeGasTank();
        Engine engine = factory.makeEngine();
        Electrics electrics = factory.makeElectrics();
        Headlights headLights = factory.makeHeadlights();
        Wheel[] wheels = new Wheel[4];
        for( int i = 0; i < wheels.length; i++) {
            wheels[i] = factory.makeWheels(WheelDiameter.TWENTY);
        }
        System.out.println(Arrays.toString(wheels));
        return new Hiance(color, 200, wheels, gasTank, engine, electrics, headLights, 20, 900);
    }




}
