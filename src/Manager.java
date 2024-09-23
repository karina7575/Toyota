import Car_types.*;
import Factory.AssemblyLine;

import java.math.BigDecimal;
import java.util.*;


public class Manager {

    //private TreeMap <CarTypes, BigDecimal> prices = new TreeMap<>(Comparator.comparing(o -> o.getCost()));
    private TreeMap <CarTypes, BigDecimal> prices;


    public Manager() {
        prices = new TreeMap<>(new Comparator<CarTypes>() {
            @Override
            public int compare(CarTypes type1, CarTypes type2) {
                if (type1.getCost().max(type2.getCost()).equals(type1.getCost())) {
                    return -1;
                }
                else if (type1.getCost().max(type2.getCost()).equals(type2.getCost())) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
        prices.put(CarTypes.SOLARA, CarTypes.SOLARA.getCost());
        prices.put(CarTypes.CAMRY, CarTypes.CAMRY.getCost());
        prices.put(CarTypes.DYNA, CarTypes.DYNA.getCost());
        prices.put(CarTypes.HIANCE, CarTypes.HIANCE.getCost());

    }

    public <C extends Car> C cellCar (BigDecimal money, Warehouse warehouse, AssemblyLine assemblyLine, String color, Cashier cashier) {
        CarTypes carType = null;
        C car = null;
        //проверяем на что у клиента хватает денег
        for (Map.Entry<CarTypes, BigDecimal> item : prices.entrySet()) {
            if (item.getValue().max(money).equals(money) || item.getValue().equals(money)) {
                //проверяем, есть ли в наличии машина по этой цене
                carType = item.getKey();
                car = warehouse.getCar(carType);
                if (car == null) {
                    //нет машины в наличии, идем дальше
                    continue;
                }
                System.out.println("Вы приобрели машину " + car + carType);
                cashier.acceptOrder(car);
                return car;
            }
        }
        if (carType == null) {
            //значит денег нет у покупателя, возвращаем null
            System.out.println("Недостаточно средств для покупки машины");
            return null;
        }
        System.out.println("На складе нет подходящей машины. Делаем запрос на сборочную линию");
        //проверяем какую машину он может оплатить со сборочной линии за цену +10%
        for (Map.Entry<CarTypes, BigDecimal> item : prices.entrySet()) {
            if (item.getValue().multiply(BigDecimal.valueOf(1.1)).max(money).equals(money)
                    || (item.getValue().multiply(BigDecimal.valueOf(1.1)).equals(money.add(BigDecimal.valueOf(0.0))))) {
                carType = item.getKey();
                break;
            }
        }
        if (carType == null) {
            //значит денег нет у покупателя на тачку с завода, возвращаем null
            System.out.println("Недостаточно средств для покупки машины");
            return null;
        }
        switch (carType) {
            case SOLARA:
                Solara solarafromAssemblyLine = assemblyLine.createSolara(color, carType.getCost().multiply(BigDecimal.valueOf(1.1)));
                warehouse.addToMap(carType, solarafromAssemblyLine);
                break;
            case CAMRY:
                Camry camryfromAssemblyLine = assemblyLine.createCamry(color, carType.getCost().multiply(BigDecimal.valueOf(1.1)));
                warehouse.addToMap(carType, camryfromAssemblyLine);
                break;
            case DYNA:
                Dyna dynafromAssemblyLine = assemblyLine.createDyna(color, carType.getCost().multiply(BigDecimal.valueOf(1.1)));
                warehouse.addToMap(carType, dynafromAssemblyLine);
                break;
            case HIANCE:
                Hiance hiancefromAssemblyLine = assemblyLine.createHiance(color, carType.getCost().multiply(BigDecimal.valueOf(1.1)));
                warehouse.addToMap(carType, hiancefromAssemblyLine);
                break;
        }
        C carFromAssemblyLine = warehouse.getCar(carType);
        System.out.println("Вы приобрели машину с завода " + carFromAssemblyLine);
        cashier.acceptOrder(carFromAssemblyLine);
        return carFromAssemblyLine;
    }
}
