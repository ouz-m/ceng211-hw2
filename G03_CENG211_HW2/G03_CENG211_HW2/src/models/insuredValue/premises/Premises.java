package models.insuredValue.premises;
import models.insuredValue.InsuredValue;
import java.util.ArrayList;

/**
 * This class implements the required methods for Premises.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Premises extends InsuredValue {
    private final String premisesCity;
    private final int numberOfFloors;
    private final int yearOfConstruction;
    private final String typeOfConstruction;
    private final double surfaceArea;

    /**
     * Constructor for Premises. 
     * @param insuredValueData
     */
    public Premises(ArrayList<String> insuredValueData) {
        super(insuredValueData.get(0), Integer.parseInt(insuredValueData.get(1)));
        this.premisesCity = insuredValueData.get(2);
        this.numberOfFloors = Integer.parseInt(insuredValueData.get(3));
        this.yearOfConstruction = Integer.parseInt(insuredValueData.get(4));
        this.typeOfConstruction = insuredValueData.get(5);
        this.surfaceArea = Double.parseDouble(insuredValueData.get(6));
    }
    
    /**
     * This method used to convert premises city to risk factor.
     * @param premisesCity
     * @return risk factor of premises city.
     */
    double calculatePremisesCityRiskFactor(String premisesCity){
        return switch (premisesCity.toLowerCase()) {
            case "izmir" -> 0.4;
            case "istanbul" -> 0.6;
            case "ankara" -> 0.15;
            default -> 0.25;
        };
    }
    
    /**
     * This method used to convert number of floors to risk factor.
     * @param numberOfFloors
     * @return risk factor of number of floors.
     */
    double calculateFloorRiskFactor(int numberOfFloors){
        if ( numberOfFloors >= 1 && numberOfFloors <= 3 ) return 0.1;
        else if ( numberOfFloors >= 4 && numberOfFloors <= 7 ) return 0.25;
        else if ( numberOfFloors >= 8 && numberOfFloors <= 18 ) return 0.5;
        else if ( numberOfFloors >= 18 ) return 0.85;
        else throw new IllegalArgumentException("Invalid number of floors " + numberOfFloors);
    }
    
    /**
     * This method used to convert year of construction to risk factor.
     * @param yearOfConstruction
     * @return risk factor of year of construction.
     */
    double calculateYearOfConstructionRiskFactor(int yearOfConstruction){
        if ( yearOfConstruction < 1975 ) return 0.58;
        else if (yearOfConstruction <= 1999) return 0.32;
        else return 0.1;
    }
    
    /**
     * This method used to convert type of construction to risk factor.
     * @param typeOfConstruction
     * @return risk factor of type of construction.
     */
    double calculateTypeOfConstructionRiskFactor(String typeOfConstruction){
        return switch (typeOfConstruction.toLowerCase()) {
            case "steel" -> 0.1;
            case "concrete" -> 0.37;
            case "wood" -> 0.58;
            default -> 0.92;
        };
    }
    
    /**
     * Get premises city of this Premises.
     * @return premisesCity of this Premises.
     */
    String getPremisesCity() {
        return premisesCity;
    }

    /**
     * Get number of floors of this Premises.
     * @return numberOfFloors of this Premises.
     */
    int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Get year of construction of this Premises.
     * @return yearOfConstruction of this Premises.
     */
    int getYearOfConstruction() {
            return yearOfConstruction;
    }

    /**
     * Get type of construction of this Premises.
     * @return typeOfConstruction of this Premises.
     */
    String getTypeOfConstruction() {
            return typeOfConstruction;
    }

    /**
     * Get surface area of this Premises.
     * @return surfaceArea of this Premises.
     */
    double getSurfaceArea() {
            return surfaceArea;
    }
}