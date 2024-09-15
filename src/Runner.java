import Car_types.Camry;
import Car_types.Dyna;
import Car_types.Hiance;
import Car_types.Solara;
import Components.*;
import Factory.AssemblyLine;
import Factory.ComponentsFactory;
import Factory.Country;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;

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
        ComponentsFactory factory = new ComponentsFactory(Country.JAPAN);
        AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN);
        assemblyLine.setFactory(factory);
        Warehouse warehouse = new Warehouse<>();

        Camry camry = assemblyLine.createCamry("Black", BigDecimal.valueOf(10000));
        Solara solara = assemblyLine.createSolara("White", BigDecimal.valueOf(12000));
        Solara solara2 = assemblyLine.createSolara("White", BigDecimal.valueOf(28000));
        Solara solara3 = assemblyLine.createSolara("White", BigDecimal.valueOf(21000));
        Solara solara4 = assemblyLine.createSolara("White", BigDecimal.valueOf(14000));
        Hiance hiance = assemblyLine.createHiance("Black", BigDecimal.valueOf(15000));
        Dyna dyna = assemblyLine.createDyna("Black", BigDecimal.valueOf(22000));


        warehouse.addCar(camry);
        warehouse.addCar(solara);
        warehouse.addCar(solara2);
        warehouse.addCar(solara3);
        warehouse.addCar(solara4);
        warehouse.addCar(hiance);
        warehouse.addCar(dyna);

        System.out.println(warehouse.getSolaras());
    }
}
