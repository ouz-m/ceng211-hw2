package models.insuredValue;

/**
 * This class implements the required methods for InsuredValue. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */

public class InsuredValue {
    private final String insuranceNumber;
    private final int yearOfInsurance;
   
    /**
     * Constructor for InsuredValue.
     * @param insuranceNumber
     * @param yearOfInsurance
     */
    public InsuredValue(String insuranceNumber, int yearOfInsurance) {
        this.insuranceNumber = insuranceNumber;
        this.yearOfInsurance = yearOfInsurance;
    }
    
    /**
     * This method is used to calculate risk factor for InsuredValue class.
     * @return default value. 
     */
    public double calculateRiskFactor(){
        return 1;
    }
    
    /**
     * Get insurance number of this InsuredValue.
     * @return insuranceNumber of this InsuredValue.
     */
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    /**
     * Get year of insurance of this InsuredValue.
     * @return yearOfInsurane of this InsuredValue.
     */
    public int getYearOfInsurance() {
        return yearOfInsurance;
    }

}