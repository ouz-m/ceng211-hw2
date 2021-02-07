package models.insurance;
import models.insuredValue.vehicle.Vehicle;

/**
 * This class implements the required methods for Traffic.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Traffic extends Insurance{

	/**
	 * Costructor for Traffic.
	 * @param insuredValue
	 */
    public Traffic(Vehicle insuredValue) {
        super(insuredValue);
    }

    /**
     * This method used to calculate policy charge for Traffic class.
     */
    @Override
    public double calculatePolicyCharge() {
        double riskFactor = getInsuredValue().calculateRiskFactor();
        double policyCharge = ((getFixedFee()* 90.0) / 100.0) + (getFixedFee() * Math.sqrt(riskFactor));
        if (getRankOfTheInsurance() > 1) return policyCharge * 80 / 100;
        return policyCharge;
    }
}
