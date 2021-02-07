package services;
import shared.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class implements the required methods for File I/O.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW2
 */

public class FileIO {

    private final ArrayList<ArrayList<String>> insuredValueArrayList;

    public FileIO(){
        this.insuredValueArrayList = initializeInsuredValueDataList();
    }

    /**
     * @return insuredValueDataList that holds two dimensional string list elements from CSV file.
     */
    private ArrayList<ArrayList<String>> initializeInsuredValueDataList(){
        String line;
        ArrayList<ArrayList<String>> insuredValueDataList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(Constants.INSURED_VALUES_FILE);
            BufferedReader br = new BufferedReader(fr);
            // Adding InsuredValue objects to insuredValueArrayList while traversing on the rows of CSV file
            while ((line = br.readLine()) != null) {
                ArrayList<String> insuredValueData = new ArrayList<String>();
                StringTokenizer st = new StringTokenizer(line, ",");
                while(st.hasMoreElements()){
                    insuredValueData.add(st.nextToken());
                }
                insuredValueDataList.add(insuredValueData);
            }
            fr.close();br.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return insuredValueDataList;
    }

    public ArrayList<ArrayList<String>> getInsuredValueArrayList() {
        return insuredValueArrayList;
    }
}