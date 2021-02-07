package models.insurance;
import models.insuredValue.Person;

/**
 * This class implements the required methods for Health.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Health extends Insurance{

	/**
	 * Constructor for Health.
	 * @param insuredValue
	 */
    public Health(Person insuredValue) {
        super(insuredValue);
    }

    /**
     * This method used to calculate policy charge for Health class.
     */
    @Override
    public double calculatePolicyCharge() {
        double riskFactor = getInsuredValue().calculateRiskFactor();
        
        if (riskFactor > 50 && getRankOfTheInsurance() < 3) return 1000000000;
        return (getFixedFee() * Math.pow(riskFactor, 3)) / (208);
    }
}
