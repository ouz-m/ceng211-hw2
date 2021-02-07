package models.insurance;
import models.insuredValue.premises.Premises;

/**
 * This class implements the required methods for Household.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Household extends Insurance{

	/**
	 * Constructor for Household.
	 * @param insuredValue
	 */
    public Household(Premises insuredValue) {
        super(insuredValue);
    }

    /**
     * This method used to calculate policy charge for Household class.
     */
    @Override
    public double calculatePolicyCharge() {
        double riskFactor = getInsuredValue().calculateRiskFactor();
        double policyCharge = getFixedFee() * Math.pow(riskFactor, 2);
        
        if (getRankOfTheInsurance() > 2) return policyCharge * 90 / 100;
        return policyCharge;
    }
}
