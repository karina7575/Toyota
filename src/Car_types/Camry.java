package Car_types;

import Components.*;

public class Camry extends Car {
    private boolean isCruiseControlOn;

    public Camry(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights) {
        super(color, maxSpeed, Transmission.automatic, wheels, gasTank, engine, electrics, headlights);
        this.isCruiseControlOn = false;
    }
    @Override
    public boolean checkDiameterWheels (Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == WheelDiameter.SEVENTEEN) ? 1 : 0;
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
            if((wheel.getDiameter() == WheelDiameter.SEVENTEEN) && (checkingWheel == null || checkingWheel.getIsPierced())) {
                checkingWheel = wheel;
            }
        }
    }

    /**
     * возможность включить или выключить круиз контроль
     */
    public void setCruiseControl(boolean cruiseControlOn) {
        isCruiseControlOn = cruiseControlOn;
    }
    /**
     * функция подключения музыки
     */
    public void musicOn () {
        System.out.println("Играет музыка");
    }
}
