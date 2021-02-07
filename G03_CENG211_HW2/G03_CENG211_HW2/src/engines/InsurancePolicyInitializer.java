package engines;
import models.insuredValue.InsuredValue;
import models.insuredValue.Person;
import models.insuredValue.premises.Housing;
import models.insuredValue.premises.Workplace;
import models.insuredValue.vehicle.Automobile;
import models.insuredValue.vehicle.Truck;
import java.util.ArrayList;

/**
 * This class implements the required methods for InsurancePolicyInitializer. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class InsurancePolicyInitializer {
    ArrayList<InsuredValue> insuredValueList;

    /**
     * Constructor for InsurancePolicyInitializer.
     * @param insuredValueDataList
     */
    public InsurancePolicyInitializer(ArrayList<ArrayList<String>> insuredValueDataList){
        initializeInsuredValueList(insuredValueDataList);
    }

    /**
     * This method used to hold whole InsuredValue objects in an ArrayList.
     * @param insuredValueDataList
     */
    private void initializeInsuredValueList(ArrayList<ArrayList<String>> insuredValueDataList) {
        insuredValueList = new ArrayList<>();
        for (ArrayList<String> insuredValueData : insuredValueDataList) {
            insuredValueList.add(generateInsuredValueObject(insuredValueData));
        }
    }

    /**
     * This method used to generate InsuredValue object according to first character of their insurance number.
     * @param insuredValueData
     * @return InsuredValue object.
     */
    private InsuredValue generateInsuredValueObject(ArrayList<String> insuredValueData){
        String insuranceNumber = insuredValueData.get(0);
        return switch (insuranceNumber.charAt(0)) {
            case 'W' -> new Workplace(insuredValueData);
            case 'H' -> new Housing(insuredValueData);
            case 'P' -> new Person(insuredValueData);
            case 'A' -> new Automobile(insuredValueData);
            case 'T' -> new Truck(insuredValueData);
            default -> null;
        };
    }

    /**
     * Get InsuredValue list of this InsurancePolicyInitializer.
     * @return insuredValueList of this InsurancePolicyInitializer.
     */
    public ArrayList<InsuredValue> getInsuredValueList() {
        return insuredValueList;
    }
}
