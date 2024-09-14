package Car_types;

import Components.*;

public class Dyna extends Car {
    //грузоподъемность
    private int liftingCapacity;

    public Dyna(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, int liftingCapacity) {
        super(color, maxSpeed, Transmission.mechanics, wheels, gasTank, engine, electrics, headlights);

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
