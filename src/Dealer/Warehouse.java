package Dealer;

import Car_types.*;

import java.util.*;

public class Warehouse {
    private int freeSpace;
    private final int MAX_COUNT_OF_CARS = 1000;
    private ArrayDeque<Solara> solaras = new ArrayDeque<>();
    private ArrayDeque<Camry> camries = new ArrayDeque<>();
    private ArrayDeque<Dyna> dynas = new ArrayDeque<>();
    private ArrayDeque<Hiance> hiances = new ArrayDeque<>();
    private HashMap<CarTypes, ArrayDeque> cars;

    public Warehouse() {
        this.freeSpace = MAX_COUNT_OF_CARS;
        cars = new HashMap<>();
        cars.put(CarTypes.SOLARA, solaras);
        cars.put(CarTypes.CAMRY, camries);
        cars.put(CarTypes.DYNA, dynas);
        cars.put(CarTypes.HIANCE, hiances);
    }

    public <C extends Car> void addToMap(CarTypes key, C value) {
        // Проверяем, есть ли уже список по данному ключу
        ArrayDeque<C> array = cars.get(key);

        // Если списка нет, создаем новый
        if (array == null) {
            array = new ArrayDeque<>();
            cars.put(key, array);  // Добавляем новый список в карту
        }
        // Добавляем элемент в список
        array.add(value);
        this.freeSpace--;
    }

    public <C extends Car> C getCar(CarTypes key) {
        ArrayDeque<C> array = cars.get(key);
        if (array == null) {
            return null;
        }
        this.freeSpace++;
        return array.pollFirst();
    }

    public int showCountSolaras() {
        return solaras.size();
    }

    public int showCountCamries() {
        return camries.size();
    }

    public int showCountDynas() {
        return dynas.size();
    }

    public int showCountHiances() {
        return hiances.size();
    }


    @Override
    public String toString() {
        return "Dealer.Warehouse{" +
                "solaras=" + cars.get(CarTypes.SOLARA) +
                ", camries=" + cars.get(CarTypes.CAMRY) +
                ", dynas=" + cars.get(CarTypes.DYNA) +
                ", hiances=" + cars.get(CarTypes.HIANCE) +
                '}';
    }
}
