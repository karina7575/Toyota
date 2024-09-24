import Car_types.*;
import Factory.AssemblyLine;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


public class Manager {

    private TreeMap <CarTypes, BigDecimal> prices;
    private Report report;


    public Manager(String name) {
        report = new Report(name);
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

    public <C extends Car> C cellCar (BigDecimal money, Warehouse warehouse, AssemblyLine assemblyLine, Color color, Cashier cashier) {
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
                report.addCelledCars(car, item.getValue());
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
        report.addCelledCars(carFromAssemblyLine, carType.getCost().multiply(BigDecimal.valueOf(1.1)));
        return carFromAssemblyLine;
    }

    /**
     * генерация отчета по продажам
     */
    public void makeReport () {
        BigDecimal income = BigDecimal.valueOf(0.0);
        BigDecimal outcome = BigDecimal.valueOf(0.0);
        try (FileWriter fileWriter = new FileWriter("report.txt", true);) {
            fileWriter.write("Имя менеджера: " + report.getManagerName() + "\n");
            fileWriter.write("Модель\t\t" + "Стоимость продажи\t\t" +"Себестоимость\t"+ "\n");
            fileWriter.write("------\t\t" + "-----------------\t\t" +"-------------\t"+ "\n");
            for (Car car : report.getCelledCars()) {
                income = income.add(car.getPrice());
                outcome = outcome.add(report.getPrimeCost().get(car.getCarType()));
                fileWriter.write(car.getCarType() + "\t\t" + car.getPrice() + "\t\t\t\t\t" + report.getPrimeCost().get(car.getCarType())+ "\n");
            }
            fileWriter.write("Итог: Доходы - " + income + ", Расходы - " + outcome + ", Прибыль - " + income.subtract(outcome));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
