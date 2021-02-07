package models.insuredValue.vehicle;
import models.insuredValue.InsuredValue;
import java.util.ArrayList;

/**
 * This class implements the required methods for Vehicle.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Vehicle extends InsuredValue {
    private final String plateCity;
    private final double engineVolume;
    private final int yearOfProduction;
    private final String typeOfGear;
    private final int fuelTankVolume;

    /**
     * Constructor for Vehicle.
     * @param insuredValueData
     */
    public Vehicle(ArrayList<String> insuredValueData) {
        super(insuredValueData.get(0), Integer.parseInt(insuredValueData.get(1)));
        this.plateCity = insuredValueData.get(2);
        this.engineVolume = Double.parseDouble(insuredValueData.get(3));
        this.yearOfProduction = Integer.parseInt(insuredValueData.get(4));
        this.typeOfGear = insuredValueData.get(5);
        this.fuelTankVolume = Integer.parseInt(insuredValueData.get(6));
    }

    /**
     * This method used to convert plate city to risk factor.
     * @param plateCity
     * @return risk factor of plate city.
     */
    double calculatePlateCityRiskFactor(String plateCity){
        return switch (plateCity.toLowerCase()) {
            case "izmir" -> 0.78;
            case "istanbul" -> 0.97;
            case "ankara" -> 0.85;
            default -> 0.65;
        };
    }

    /**
     * This method used to convert type of gears to risk factor.
     * @param typeOfGear
     * @return risk factor of type of gear.
     */
    double calculateGearRiskFactor(String typeOfGear){
        return switch (typeOfGear) {
            case "manual" -> 0.47;
            case "automatic" -> 0.98;
            default -> throw new IllegalArgumentException("Invalid type of gear " + typeOfGear);
        };
    }

    /**
     * Get plate city of this Vehicle.
     * @return plateCity of this Vehicle.
     */
    public String getPlateCity() {
        return plateCity;
    }

    /**
     * Get engine volume of this Vehicle.
     * @return engineVolume of this Vehicle.
     */
    public double getEngineVolume() {
        return engineVolume;
    }

    /**
     * Get year of production of this Vehicle.
     * @return yearOfProduction of this Vehicle.
     */
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    /**
     * Get type of gear of this Vehicle.
     * @return typeOfGear of this Vehicle.
     */
    public String getTypeOfGear() {
        return typeOfGear;
    }

    /**
     * Get fuel tank volume of this Vehicle.
     * @return fuelTankVolume of this Vehicle.
     */
    public int getFuelTankVolume() {
        return fuelTankVolume;
    }

}
