import Car_types.*;
import Components.*;
import Factory.AssemblyLine;
import Factory.ComponentsFactory;
import Factory.Country;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        ComponentsFactory factory = new ComponentsFactory(Country.JAPAN);
        AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN);
        assemblyLine.setFactory(factory);
        Warehouse warehouse = new Warehouse();

        Camry camry = assemblyLine.createCamry("Black", CarTypes.CAMRY.getCost());
        Solara solara = assemblyLine.createSolara("White", CarTypes.SOLARA.getCost());
        Hiance hiance = assemblyLine.createHiance("Black", CarTypes.HIANCE.getCost());
        Dyna dyna = assemblyLine.createDyna("Black", CarTypes.DYNA.getCost());

        warehouse.addToMap(CarTypes.CAMRY, camry);
        warehouse.addToMap(CarTypes.SOLARA, solara);
        warehouse.addToMap(CarTypes.HIANCE, hiance);
        warehouse.addToMap(CarTypes.DYNA, dyna);

        Manager manager = new Manager();
        Customer customer = new Customer(BigDecimal.valueOf(28000), "Алеша");
        System.out.println(manager.cellCar(customer.getMoney(), warehouse, assemblyLine, "Black"));
    }
}
