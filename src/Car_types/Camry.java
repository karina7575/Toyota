package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public class Camry extends Car {
    private boolean isCruiseControlOn;
    CarTypes carType = CarTypes.CAMRY;


    public Camry(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, Country country, BigDecimal price) {
        super(color, maxSpeed, Transmission.automatic, wheels, gasTank, engine, electrics, headlights, country ,price);
        this.isCruiseControlOn = false;
    }
    @Override
    public boolean checkDiameterWheels (Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == CarTypes.CAMRY.getWheelDiameter()) ? 1 : 0;
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
            if((wheel.getDiameter() == CarTypes.CAMRY.getWheelDiameter()) && (checkingWheel == null || checkingWheel.getIsPierced())) {
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

    @Override
    public String toString() {
        return "Camry{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", COUNTRY=" + COUNTRY +
                '}';
    }
}
