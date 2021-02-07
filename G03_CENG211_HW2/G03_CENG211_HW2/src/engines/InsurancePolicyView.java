package engines;
import models.PolicyRecord;
import models.insuredValue.InsuredValue;
import models.insuredValue.Person;
import models.insuredValue.premises.Premises;
import models.insuredValue.vehicle.Vehicle;
import models.insurance.Health;
import models.insurance.Household;
import models.insurance.Traffic;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class implements the required methods for InsurancePolicyView.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class InsurancePolicyView {

	/**
	 * This method used to show the menu to user.
	 */
    public void printMenu(){
        System.out.println("1 All insured values, 2 Workplaces, 3 Housings, 4 Persons, 5 Automobiles, 6 Trucks");
    }

    /**
     * This method used to ask input to user.
     */
    public void askInput(){
        System.out.println("Please enter your choice: ");
    }

    /**
     * This method used to show details of policy records.
     * @param insuredValue
     * @param policyCharge
     */
    public void printInsuredValueAndPolicyCharge(InsuredValue insuredValue, double policyCharge){
        System.out.println("Insured Value: " + insuredValue.getClass().getSimpleName()
                + " Insurance number: "
                + insuredValue.getInsuranceNumber()
                + " Year of Insurance: " + insuredValue.getYearOfInsurance());
        System.out.println("The policy charge of: " + String.format("%.2f",BigDecimal.valueOf(policyCharge)) + "TL");
    }

    /**
     * This method used to show whole household policy record to user.
     * @param insuredValues
     */
    public void printPremise(ArrayList<InsuredValue> insuredValues){
        for (InsuredValue insuredValue: insuredValues) {
            Household householdPolicy = new Household((Premises) insuredValue);
            this.printInsuredValueAndPolicyCharge(insuredValue, householdPolicy.calculatePolicyCharge());
        }
    }

    /**
     * This method used to show whole health policy record to user.
     * @param insuredValues
     */
    public void printPerson(ArrayList<InsuredValue> insuredValues){
        for (InsuredValue insuredValue: insuredValues) {
            Health healthPolicy = new Health((Person) insuredValue);
            this.printInsuredValueAndPolicyCharge(insuredValue, healthPolicy.calculatePolicyCharge());
        }
    }

    /**
     * This method used to show whole traffic policy record to user.
     * @param insuredValues
     */
    public void printVehicle(ArrayList<InsuredValue> insuredValues){
        for (InsuredValue insuredValue: insuredValues) {
            Traffic trafficPolicy = new Traffic((Vehicle) insuredValue);
            this.printInsuredValueAndPolicyCharge(insuredValue, trafficPolicy.calculatePolicyCharge());
        }
    }

    /**
     * This method used to show whole policy record to user.
     * @param policyRecord
     */
    public void printAll(PolicyRecord policyRecord) {
        printPremise(policyRecord.getWorkplaceList());
        printPremise(policyRecord.getHousingList());
        printPerson(policyRecord.getPersonList());
        printVehicle(policyRecord.getAutomobileList());
        printVehicle(policyRecord.getTruckList());
    }

}
