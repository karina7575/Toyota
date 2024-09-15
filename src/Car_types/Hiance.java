package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public class Hiance extends Car {
    //грузоподъемность
    private int liftingCapacity;
    private Wheel spareWheel;

    public Hiance(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, int diameterSpareWheel, int liftingCapacity, Country country, BigDecimal price) {
        super(color, maxSpeed, Transmission.mechanics, wheels, gasTank, engine, electrics, headlights, country, price);
        this.liftingCapacity = liftingCapacity;
        this.spareWheel = new Wheel(WheelDiameter.TWENTY);

    }
    @Override
    public boolean checkDiameterWheels(Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == WheelDiameter.TWENTY) ? 1 : 0;
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
            if((wheel.getDiameter() == WheelDiameter.TWENTY) && (checkingWheel == null || checkingWheel.getIsPierced())) {
                checkingWheel = wheel;
            }
        }
    }
}
