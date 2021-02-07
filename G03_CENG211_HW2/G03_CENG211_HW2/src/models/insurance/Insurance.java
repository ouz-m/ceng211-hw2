package models.insurance;
import models.insuredValue.InsuredValue;
import shared.Constants;
import java.util.Random;

/**
 * This class implements the required methods for Insurance.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Insurance {
    private final int fixedFee;
    private final InsuredValue insuredValue;
    private final int rankOfTheInsurance;

    /**
     * Constructor for Insurance.
     * @param insuredValue
     */
    public Insurance(InsuredValue insuredValue){
        this.insuredValue = insuredValue;
        this.rankOfTheInsurance = rankOfTheInsurance();
        Random random = new Random();
        this.fixedFee = random.nextInt(2000) + 1000;
    }

    /**
     * This method used to calculate policy charge for Insurance class.
     * @return default value.
     */
    public double calculatePolicyCharge(){
        return 1;
    }
    
    /**
     * This method used to calculate rank of the insurance. 
     * @return rankOfTheInsurance
     */
    private int rankOfTheInsurance(){
        return (Constants.CURRENT_YEAR - this.insuredValue.getYearOfInsurance());
    }

    /**
     * Get fixed fee of this Insurance.
     * @return fixed fee of this Insurance.
     */
    protected int getFixedFee() {
        return fixedFee;
    }

    /**
     * Get InsuredValue of this Insurance.
     * @return InsuredValue of this Insurance.
     */
    protected InsuredValue getInsuredValue() {
        return insuredValue;
    }

    /**
     * Get rank of the insurance of this Insurance.
     * @return rankOfTheInsurance of this Insurance.
     */
    protected int getRankOfTheInsurance() {
        return rankOfTheInsurance;
    }

}