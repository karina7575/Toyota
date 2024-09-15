package Factory;

import Car_types.Camry;
import Car_types.Dyna;
import Car_types.Hiance;
import Car_types.Solara;
import Components.*;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * сборочный конвейер
 */
public class AssemblyLine {
    private final Country ASSEMBLY_LINE_COUNTRY;
    private ComponentsFactory factory;

    public AssemblyLine(Country factoryCountry) {
        this.ASSEMBLY_LINE_COUNTRY = factoryCountry;
    }

    public void setFactory(ComponentsFactory factory) {
        try {
            if(checkCountries (factory.getFactoryCountry(), this.ASSEMBLY_LINE_COUNTRY)) {
                this.factory = factory;
            }
        } catch (CountyFactoryNotEqualException e) {
            System.out.println("Сборочный конвейер находится в стране " + ASSEMBLY_LINE_COUNTRY + ", а завод в стране " + factory.getFactoryCountry());
        }
    }

    public ComponentsFactory getFactory() {
        return factory;
    }

    private boolean checkCountries (Country factoryCountry, Country assemblyCountry) throws CountyFactoryNotEqualException {
        if(factoryCountry.equals(assemblyCountry)){
            return true;
        }
        else {
            throw new CountyFactoryNotEqualException();
        }
    }

    public Camry createCamry (String color, BigDecimal price) {
        if (this.factory == null) {
            System.out.println("Сборочный конвейер не использует никакой завод, сначала выберите завод той же страны");
            return null;
        }
        else {
            GasTank gasTank = factory.makeGasTank();
            Engine engine = factory.makeEngine();
            Electrics electrics = factory.makeElectrics();
            Headlights headLights = factory.makeHeadlights();

            Wheel[] wheels = new Wheel[4];
            for (int i = 0; i < wheels.length; i++) {
                wheels[i] = factory.makeWheels(WheelDiameter.SEVENTEEN);
            }
            System.out.println(Arrays.toString(wheels));
            return new Camry(color, 200, wheels, gasTank, engine, electrics, headLights, ASSEMBLY_LINE_COUNTRY, price);
        }
    }

    public Solara createSolara (String color, BigDecimal price) {
        if (this.factory == null) {
            System.out.println("Сборочный конвейер не использует никакой завод, сначала выберите завод той же страны");
            return null;
        }
        else {
            GasTank gasTank = factory.makeGasTank();
            Engine engine = factory.makeEngine();
            Electrics electrics = factory.makeElectrics();
            Headlights headLights = factory.makeHeadlights();
            Wheel[] wheels = new Wheel[4];
            for (int i = 0; i < wheels.length; i++) {
                wheels[i] = factory.makeWheels(WheelDiameter.SIXTEEN);
            }
            System.out.println(Arrays.toString(wheels));
            return new Solara(color, 250, wheels, gasTank, engine, electrics, headLights, ASSEMBLY_LINE_COUNTRY, price);
        }
    }

    public Dyna createDyna (String color, BigDecimal price) {
        if (this.factory == null) {
            System.out.println("Сборочный конвейер не использует никакой завод, сначала выберите завод той же страны");
            return null;
        }
        else {
            GasTank gasTank = factory.makeGasTank();
            Engine engine = factory.makeEngine();
            Electrics electrics = factory.makeElectrics();
            Headlights headLights = factory.makeHeadlights();
            Wheel[] wheels = new Wheel[4];
            for (int i = 0; i < wheels.length; i++) {
                wheels[i] = factory.makeWheels(WheelDiameter.TWENTY);
            }
            System.out.println(Arrays.toString(wheels));
            return new Dyna(color, 160, wheels, gasTank, engine, electrics, headLights, 400, ASSEMBLY_LINE_COUNTRY, price);
        }
    }

    public Hiance createHiance (String color, BigDecimal price) {
        if (this.factory == null) {
            System.out.println("Сборочный конвейер не использует никакой завод, сначала выберите завод той же страны");
            return null;
        }
        else {
            GasTank gasTank = factory.makeGasTank();
            Engine engine = factory.makeEngine();
            Electrics electrics = factory.makeElectrics();
            Headlights headLights = factory.makeHeadlights();
            Wheel[] wheels = new Wheel[4];
            for (int i = 0; i < wheels.length; i++) {
                wheels[i] = factory.makeWheels(WheelDiameter.TWENTY);
            }
            System.out.println(Arrays.toString(wheels));
            return new Hiance(color, 200, wheels, gasTank, engine, electrics, headLights, 20, 900, ASSEMBLY_LINE_COUNTRY, price);
        }
    }




}
