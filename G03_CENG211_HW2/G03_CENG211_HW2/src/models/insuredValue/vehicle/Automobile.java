package models.insuredValue.vehicle;
import shared.Constants;
import java.util.ArrayList;

/**
 * This class implements the required methods for Automobile.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Automobile extends Vehicle {
    private final String typeOfRoof;
    
    /**
     * Constructor for Automobile.
     * @param insuredValueData
     */
    public Automobile(ArrayList<String> insuredValueData) {
            super(insuredValueData);
            this.typeOfRoof = insuredValueData.get(7);
    }

    @Override
    public double calculateRiskFactor() {
        return calculateAutomobileRiskFactor();
    }

    /**
     * This method is used to calculate risk factor for Automobile class.
     * @return risk factor of Automobile.
     */
    private double calculateAutomobileRiskFactor(){
        return (getEngineVolume()
                * (0.004 * getFuelTankVolume())
                * (Constants.CURRENT_YEAR - getYearOfProduction())
                * (calculatePlateCityRiskFactor(getPlateCity()) * 0.03))
                / calculateRoofRiskFactor(getTypeOfRoof());
    }

    /**
     * This method convert type of roof to risk factor.
     * @param typeOfRoof
     * @return risk factor of type of roof.
     */
    private double calculateRoofRiskFactor(String typeOfRoof){
        return switch (typeOfRoof) {
            case "regular" -> 0.1;
            case "sunroof" -> 0.64;
            case "moonroof" -> 0.48;
            default -> throw new IllegalArgumentException("Invalid type of roof: " + typeOfRoof);
        };
    }

    /**
     * Get type of roof of this Automobile.
     * @return typeOfRoof of this Automobile.
     */
    public String getTypeOfRoof() {
        return typeOfRoof;
    }
}
