package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public abstract class Car {
    protected String color;
    protected int maxSpeed;
    protected Transmission transmissionType;
    protected boolean motion;
    protected final int COUNT_OF_WHEELS = 4;
    protected Wheel[] wheels = new Wheel[COUNT_OF_WHEELS];
    protected GasTank gasTank;
    protected Engine engine;
    protected Electrics electrics;
    protected Headlights headlights;
    protected BigDecimal price;
    protected final Country COUNTRY;

    public Car(String color, int maxSpeed, Transmission transmissionType, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, Country country, BigDecimal price) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.motion = false;
        if(checkDiameterWheels(wheels)) {
            this.wheels = wheels;
        }
        else {
            System.out.println("Диаметр колес не подходит для данной модели автомобиля.");
        }
        this.gasTank = gasTank;
        this.engine = engine;
        this.electrics = electrics;
        this.headlights = headlights;
        this.COUNTRY = country;
        this.price = price;
    }

    /**
     * проверка колес на диаметр
     */
    public abstract boolean checkDiameterWheels (Wheel[] wheels);

    /**
     * установка нового колеса
     */
    public abstract void setWheel(Wheel wheel);

    /**
     * движение автомобиля
     */
    public void go () throws StartCarException {
        if (checkWheels() && gasTank.getAmountOfGasoline() > 0 && electrics.isFunctional() && engine.isFunctional()) {
            motion = true;
        }
        else {
            throw new StartCarException();
        }
    }

    /**
     * проверка колес на целостность
     */
    public boolean checkWheels () {
        for (int i = 0; i < COUNT_OF_WHEELS; i++) {
            if(wheels[i] == null && wheels[i].getIsPierced()) {
                return false;
            }
        }
        return true;
    }

    /**
     * остановка автомобиля
     */
    public void stop () {
        motion = false;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", COUNTRY=" + COUNTRY +
                '}';
    }
}
