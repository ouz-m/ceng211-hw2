import services.FileIO;

/**
 * This class implements the required methods for InsurancePolicyCalculatorApp. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */
public class InsurancePolicyCalculatorApp {
    
	/**
	 * This method is main method for program.
	 * @param args
	 */
	public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        Simulation simulation = new Simulation();
        simulation.run(fileIO);
    }
}
