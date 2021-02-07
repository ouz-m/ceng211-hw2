package models;
import models.insuredValue.InsuredValue;
import models.insuredValue.Person;
import models.insuredValue.premises.Housing;
import models.insuredValue.premises.Workplace;
import models.insuredValue.vehicle.Automobile;
import models.insuredValue.vehicle.Truck;
import java.util.ArrayList;

/**
 * This class implements the required methods for PolicyRecord. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class PolicyRecord {
    private final ArrayList<InsuredValue> insuredValueList;

    /**
     * Constructor for PolicyRecord.
     * @param insuredValueList
     */
    public PolicyRecord(ArrayList<InsuredValue> insuredValueList){
        this.insuredValueList = insuredValueList;
    }

    /**
     * This method used to collect whole Workplace objects in an ArrayList.
     * @return list of Workplace.
     */
    public ArrayList<InsuredValue> getWorkplaceList(){
        ArrayList<InsuredValue> workPlaceList = new ArrayList<>();
        for (InsuredValue currentInsuredValue: insuredValueList) {
            if(currentInsuredValue instanceof Workplace) workPlaceList.add(currentInsuredValue);
        }
        return workPlaceList;
    }

    /**
     * This method used to collect whole Housing objects in an ArrayList.
     * @return list of housing.
     */
    public ArrayList<InsuredValue> getHousingList(){
        ArrayList<InsuredValue> housingList = new ArrayList<>();
        for (InsuredValue currentInsuredValue: insuredValueList) {
            if(currentInsuredValue instanceof Housing) housingList.add(currentInsuredValue);
        }
        return housingList;
    }

    /**
     * This method used to collect whole Person objects in an ArrayList.
     * @return list of person.
     */
    public ArrayList<InsuredValue> getPersonList(){
        ArrayList<InsuredValue> personList = new ArrayList<>();
        for (InsuredValue currentInsuredValue: insuredValueList) {
            if(currentInsuredValue instanceof Person) personList.add(currentInsuredValue);
        }
        return personList;
    }

    /**
     * This method used to collect whole Automobile objects in an ArrayList.
     * @return list of automobile.
     */
    public ArrayList<InsuredValue> getAutomobileList(){
        ArrayList<InsuredValue> automobileList = new ArrayList<>();
        for (InsuredValue currentInsuredValue: insuredValueList) {
            if(currentInsuredValue instanceof Automobile) automobileList.add(currentInsuredValue);
        }
        return automobileList;
    }

    /**
     * This method used to collect whole Truck objects in an ArrayList.
     * @return list of truck.
     */
    public ArrayList<InsuredValue> getTruckList(){
        ArrayList<InsuredValue> truckList = new ArrayList<>();
        for (InsuredValue currentInsuredValue: insuredValueList) {
            if(currentInsuredValue instanceof Truck) truckList.add(currentInsuredValue);
        }
        return truckList;
    }

    /**
     * Get insured value list of this PolicyRecord.
     * @return insuredValueLis of this PolicyRecord.
     */
    public ArrayList<InsuredValue> getInsuredValueList() {
        return insuredValueList;
    }
}
