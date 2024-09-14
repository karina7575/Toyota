import Car_types.Camry;
import Car_types.Dyna;
import Car_types.Hiance;
import Car_types.Solara;
import Components.*;
import Factory.AssemblyLine;
import Factory.ComponentsFactory;
import Factory.Country;

public class Runner {
    public static void main(String[] args) {
//        Electrics electrics = new Electrics();
//        Engine engine = new Engine();
//        GasTank gasTank = new GasTank();
//        Headlights headlights = new Headlights();
//        Wheel wheel1 = new Wheel()
//        Car_types.Camry camry = new Car_types.Camry();
//        Car_types.Dyna dyna = new Car_types.Dyna();
//        Car_types.Hiance hiance = new Car_types.Hiance();
//        Car_types.Solara solara = new Car_types.Solara();
//
//        camry.setCruiseControl(true);
//        camry.musicOn();
//
//        solara.setCruiseControl(false);
//        solara.setTop(false);
//        solara.coolTheDrink();
//
//        dyna.chargePhone();
        ComponentsFactory factory = new ComponentsFactory(Country.China);
        AssemblyLine assemblyLine = new AssemblyLine(Country.China, factory);

        ComponentsFactory factoryRussia = new ComponentsFactory(Country.Russia);
        AssemblyLine assemblyLineUSA = new AssemblyLine(Country.USA, factoryRussia);

        Camry camry = assemblyLine.createCamry("Blue");
        Solara solara = assemblyLine.createSolara("Red");
        Hiance hiance = assemblyLine.createHiance("Black");
        Dyna dyna = assemblyLine.createDyna("Purple");

    }
}
