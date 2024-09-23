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
        Customer customer1 = new Customer(BigDecimal.valueOf(10000), "Алеша");
        Customer customer2 = new Customer(BigDecimal.valueOf(12000), "Софья");
        Customer customer3 = new Customer(BigDecimal.valueOf(15000), "Степан");
        Customer customer4 = new Customer(BigDecimal.valueOf(22000), "Агафья");
        Customer customer5 = new Customer(BigDecimal.valueOf(11000), "Матрена");
        Customer customer6 = new Customer(BigDecimal.valueOf(13200), "Денис");
        Customer customer7 = new Customer(BigDecimal.valueOf(8000), "Гарик");
        Customer customer8 = new Customer(BigDecimal.valueOf(30000), "Азамат");
        Cashier cashier = new Cashier();

        manager.cellCar(customer1.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer2.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer3.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer4.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer5.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer6.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer7.getMoney(), warehouse, assemblyLine, "Black", cashier);
        manager.cellCar(customer8.getMoney(), warehouse, assemblyLine, "Black", cashier);

        System.out.println(cashier.getCash());
    }
}
