package Car_types;

import Components.*;
import Factory.Country;

import java.math.BigDecimal;

public class Solara extends Car {
    private boolean isCruiseControlOn;
    private boolean topIsClosed;

    public Solara(String color, int maxSpeed, Wheel[] wheels, GasTank gasTank, Engine engine, Electrics electrics, Headlights headlights, Country country, BigDecimal price) {
        super(color, maxSpeed, Transmission.robot, wheels, gasTank, engine, electrics, headlights, country, price);
        this.isCruiseControlOn = false;
        this.topIsClosed = true;
    }

    @Override
    public boolean checkDiameterWheels(Wheel[] wheels) {
        int flag = 0;
        for (Wheel wheel : wheels) {
            flag += (wheel.getDiameter() == CarTypes.SOLARA.getWheelDiameter()) ? 1 : 0;
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
            if((wheel.getDiameter() == CarTypes.SOLARA.getWheelDiameter()) && (checkingWheel == null || checkingWheel.getIsPierced())) {
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
     * возможность опустить или поднять крышу
     */
    public void setTop(boolean topCondition) {
        topIsClosed = topCondition;
    }
    /**
     * функция охладить напиток
     */
    public void coolTheDrink() {
        System.out.println("Напиток охлажден");
    }

    @Override
    public String toString() {
        return "Solara{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", COUNTRY=" + COUNTRY +
                '}';
    }
}
