package models.insuredValue.premises;
import java.util.ArrayList;

/**
 * This class implements the required methods for Housing.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Housing extends Premises {
    private final String residentSituation;

    /**
     * Constructor for Housing.
     * @param insuredValueData
     */
    public Housing(ArrayList<String> insuredValueData) {
        super(insuredValueData);
        this.residentSituation = insuredValueData.get(7); // resident situation
    }

    @Override
    public double calculateRiskFactor() {
        return calculateHousingRiskFactor();
    }

    /**
     * This method is used to calculate risk factor for Housing class.
     * @return risk factor of Housing.
     */
    private double calculateHousingRiskFactor(){
        return ((calculatePremisesCityRiskFactor(getPremisesCity())
                * calculateFloorRiskFactor(getNumberOfFloors())
                * calculateYearOfConstructionRiskFactor(getYearOfConstruction())
                * calculateTypeOfConstructionRiskFactor(getTypeOfConstruction()))
                * (getSurfaceArea()))
                / calculateResidentSituationRiskFactor(getResidentSituation());
    }

    /**
     * This method used to convert resident situation to risk factor.
     * @param residentSituation
     * @return risk factor of resident situation.
     */
    double calculateResidentSituationRiskFactor(String residentSituation){
        return switch (residentSituation) {
            case "tenant" -> 0.18;
            case "landlord" -> 0.42;
            default -> throw new IllegalArgumentException("Invalid resident situation: " + residentSituation);
        };
    }

    /**
     * Get resident situation of this Housing.
     * @return residentSituation of this Housing.
     */
    public String getResidentSituation(){
        return residentSituation;
    }
}
