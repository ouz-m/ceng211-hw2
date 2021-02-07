package models.insuredValue.vehicle;
import shared.Constants;
import java.util.ArrayList;

/**
 * This class implements the required methods for Truck.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Truck extends Vehicle {
    private final String typeOfTruckBed;
    
    /**
     * Constructor for Truck.
     * @param insuredValueData
     */
    public Truck(ArrayList<String> insuredValueData) {
        super(insuredValueData);
        this.typeOfTruckBed = insuredValueData.get(7);
    }

    @Override
    public double calculateRiskFactor() {
        return calculateTruckRiskFactor();
    }

    /**
     * This method is used to calculate risk factor for Truck class.
     * @return risk factor of Truck.
     */
    private double calculateTruckRiskFactor() {
        return ((Math.pow(Constants.CURRENT_YEAR - getYearOfProduction(), 3)
                / (0.008 * getFuelTankVolume())) * getEngineVolume()
                * (calculatePlateCityRiskFactor(getPlateCity()) * 0.03)) / Math.pow(calculateTruckBedRiskFactor(getTypeOfTruckBed()), 2);
    }

    /**
     * This method used to convert type of truck bed to risk factor.
     * @param typeOfTruckBed
     * @return risk factor of type of truck bed.
     */
    private double calculateTruckBedRiskFactor(String typeOfTruckBed) {
        return switch (typeOfTruckBed) {
            case "trailer" -> 0.87;
            case "tanker" -> 0.84;
            case "regular" -> 0.15;
            default -> throw new IllegalArgumentException("Invalid type of truck bed: " + typeOfTruckBed);
        };
    }

    /**
     * Get type of truck bed of this Truck.
     * @return typeOfTruckBed of this Truck.
     */
    public String getTypeOfTruckBed() {
        return typeOfTruckBed;
    }
}