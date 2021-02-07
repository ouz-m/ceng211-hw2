package models.insuredValue;
import shared.Constants;
import java.util.ArrayList;

/**
 * This class implements the required methods for Person.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Person extends InsuredValue {
    private final String residenceCity;
    private final String name;
    private final String nationalID;
    private final String gender;
    private final int yearOfBirth;
    private final String typeOfChronicleIllness;
    
    /**
     * Constructor for Person.
     * @param insuredValueData
     */
    public Person(ArrayList<String> insuredValueData) {
        super(insuredValueData.get(0),//insuranceNumber
        Integer.parseInt(insuredValueData.get(1))); //yearOfInsurance
        this.residenceCity = insuredValueData.get(2); //residenceCity
        this.name = insuredValueData.get(3); //name
        this.nationalID = insuredValueData.get(4); //nationalID
        this.gender = insuredValueData.get(5); //gender
        this.yearOfBirth = Integer.parseInt(insuredValueData.get(6)); //yearOfBirth
        this.typeOfChronicleIllness = insuredValueData.get(7); //typeOfChronicleIllness
    }
    
    
    @Override
    public double calculateRiskFactor() {
        return calculatePersonRiskFactor();
    }
    /**
     * This method is used to calculate risk factor for Person class.
     * @return risk factor of Person.
     */
    private double calculatePersonRiskFactor(){
        int age = Constants.CURRENT_YEAR - yearOfBirth;
        return (Math.pow((age), 2))
                / (calculateTypeOfChronicleIllnessRiskFactor(getTypeOfChronicleIllness()) * 18);
    }
    /**
     * This method used to convert chronicle illness name to risk factor. 
     * @param typeOfChronicleIllness
     * @return risk factor of illness.
     */
    private double calculateTypeOfChronicleIllnessRiskFactor(String typeOfChronicleIllness){
        return switch (typeOfChronicleIllness) {
            case "cardiovascular" -> 1.85;
            case "diabetes" -> 1.84;
            case "respiratory" -> 1.86;
            case "none" -> 0.1;
            default -> 1.8;
        };
    }
   
    /**
     * Get type of chronicle illness of this Person.
     * @return typeOfChronicleIllness of this Person.
     */
    public String getTypeOfChronicleIllness() {
        return typeOfChronicleIllness;
    }
    
    /**
     * Get residence city of this Person. 
     * @return residenceCity of this Person.
     */
    public String getResidenceCity() {
        return residenceCity;
    }

    /**
     * Get name of this Person.
     * @return name of this Person.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get national ID of this Person.
     * @return nationalID of this Person.
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * Get gender of this Person.
     * @return gender of this Person.
     */
    public String getGender() {
        return gender;
    }
}