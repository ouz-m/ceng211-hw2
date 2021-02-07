import engines.InsurancePolicyInitializer;
import engines.InsurancePolicyView;
import models.PolicyRecord;
import services.FileIO;
import java.util.Scanner;

/**
 * This class implements the required methods for Simulation. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class Simulation {
   
	/**
	 * This method used to start execution process. 
	 * @param fileIO
	 */
	public void run(FileIO fileIO) {
        InsurancePolicyView view = new InsurancePolicyView();
        InsurancePolicyInitializer insurancePolicyInitializer = new InsurancePolicyInitializer(fileIO.getInsuredValueArrayList());
        PolicyRecord policyRecord = new PolicyRecord(insurancePolicyInitializer.getInsuredValueList());
        Scanner sc = new Scanner(System.in);
        startMenu(view, policyRecord, sc);
        sc.close();
    }

	/**
	 * This method used to start user/machine communication.
	 * @param view
	 * @param policyRecord
	 */
    public void startMenu(InsurancePolicyView view, PolicyRecord policyRecord, Scanner sc) {
        
        boolean done = false;
        while (!done) {
            view.printMenu();
            view.askInput();
            int keyboardInput = sc.nextInt();

            switch (keyboardInput) {
                case 1 -> view.printAll(policyRecord);
                case 2 -> view.printPremise(policyRecord.getWorkplaceList());
                case 3 -> view.printPremise(policyRecord.getHousingList());
                case 4 -> view.printPerson(policyRecord.getPersonList());
                case 5 -> view.printVehicle(policyRecord.getAutomobileList());
                case 6 -> view.printVehicle(policyRecord.getTruckList());
                default -> throw new IllegalStateException("Unexpected value: " + keyboardInput);
            }
            System.out.println();
        }
    }
}
