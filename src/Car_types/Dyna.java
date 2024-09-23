package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public class Dyna extends Car {
    //грузоподъемность
    private int liftingCapacity;

    public Dyna(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, int liftingCapacity, Country country, BigDecimal price) {
        super(color, maxSpeed, Transmission.mechanics, wheels, gasTank, engine, electrics, headlights, country, price);

        this.liftingCapacity = liftingCapacity;
    }

    /**
     * функция зарядить телефон
     */
    public void chargePhone () {
        System.out.println("Телефон заряжен");
    }

    @Override
    public boolean checkDiameterWheels(Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == CarTypes.DYNA.getWheelDiameter()) ? 1 : 0;
        }
        if (flag == wheels.length) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * установка нового колеса
     */
    @Override
    public void setWheel(Wheel wheel){
        for (Wheel checkingWheel : wheels) {
            if((wheel.getDiameter() == CarTypes.DYNA.getWheelDiameter()) && (checkingWheel == null || checkingWheel.getIsPierced())) {
                checkingWheel = wheel;
            }
        }
    }

    @Override
    public String toString() {
        return "Dyna{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", COUNTRY=" + COUNTRY +
                '}';
    }
}
