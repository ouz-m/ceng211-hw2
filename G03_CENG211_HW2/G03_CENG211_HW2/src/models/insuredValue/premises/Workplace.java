package models.insuredValue.premises;
import java.util.ArrayList;

/**
 * This class implements the required methods for Workplace.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Workplace extends Premises {
    private final int annualRevenue;

    /**
     * Constructor for Workplace.
     * @param insuredValueData
     */
    public Workplace(ArrayList<String> insuredValueData) {
        super(insuredValueData);
        this.annualRevenue = Integer.parseInt(insuredValueData.get(7));
    }

    @Override
    public double calculateRiskFactor() {
        return calculateWorkplaceRiskFactor();
    }

    /**
     * This method is used to calculate risk factor for Workplace class.
     * @return risk factor of Workplace.
     */
    private double calculateWorkplaceRiskFactor(){
        return (calculatePremisesCityRiskFactor(getPremisesCity())
                * calculateFloorRiskFactor(getNumberOfFloors())
                * calculateYearOfConstructionRiskFactor(getYearOfConstruction())
                * calculateTypeOfConstructionRiskFactor(getTypeOfConstruction()))
                * (getSurfaceArea() * 0.2) * (getAnnualRevenue() * 0.003);
    }

    /**
     * Get annual revenue of this Workplace.
     * @return annualRevenue of this Workplace.
     */
    public int getAnnualRevenue() {
        return annualRevenue;
    }
}


