package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public class Hiance extends Car {
    //грузоподъемность
    private int liftingCapacity;
    private Wheel spareWheel;
    CarTypes carType = CarTypes.HIANCE;

    public Hiance(Color color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, int diameterSpareWheel, int liftingCapacity, Country country, BigDecimal price) {
        super(color, maxSpeed, Transmission.mechanics, wheels, gasTank, engine, electrics, headlights, country, price);
        this.liftingCapacity = liftingCapacity;
        this.spareWheel = new Wheel(CarTypes.HIANCE.getWheelDiameter());

    }

    @Override
    public boolean checkDiameterWheels(Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == CarTypes.HIANCE.getWheelDiameter()) ? 1 : 0;
        }
        if (flag == wheels.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * установка нового колеса
     */
    @Override
    public void setWheel(Wheel wheel) {
        for (Wheel checkingWheel : wheels) {
            if ((wheel.getDiameter() == CarTypes.HIANCE.getWheelDiameter()) && (checkingWheel == null || checkingWheel.getIsPierced())) {
                checkingWheel = wheel;
            }
        }
    }

    @Override
    public String toString() {
        return "Hiance{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", COUNTRY=" + COUNTRY +
                '}';
    }

    public CarTypes getCarType() {
        return carType;
    }
}
