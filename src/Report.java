import Car_types.Car;
import Car_types.CarTypes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public class Report {
    private String managerName;
    private EnumMap<CarTypes, BigDecimal> primeCost = new EnumMap<>(CarTypes.class);
    private ArrayList <Car> celledCars;

    public Report(String managerName) {
        this.managerName = managerName;
        celledCars = new ArrayList<>();
        primeCost.put(CarTypes.SOLARA, BigDecimal.valueOf(8000));
        primeCost.put(CarTypes.CAMRY, BigDecimal.valueOf(5000));
        primeCost.put(CarTypes.DYNA, BigDecimal.valueOf(12000));
        primeCost.put(CarTypes.HIANCE, BigDecimal.valueOf(10000));
    }

    public <D extends Car> void addCelledCars(D car, BigDecimal carPrice) {
        celledCars.add(car);
        car.setPrice(carPrice);
    }

    public String getManagerName() {
        return managerName;
    }

    public ArrayList<Car> getCelledCars() {
        return celledCars;
    }

    public EnumMap<CarTypes, BigDecimal> getPrimeCost() {
        return primeCost;
    }
}
