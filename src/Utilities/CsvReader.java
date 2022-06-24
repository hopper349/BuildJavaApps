package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

    public ArrayList<String[]> readCsv(String filePath) {

        ArrayList<String[]> data = new ArrayList<>();
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((dataRow = br.readLine()) != null) {
                String[] accountData = dataRow.split(",");
                data.add(accountData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        ArrayList<String[]> arr = new CsvReader().readCsv("src\\Utilities\\NewBankAccounts.csv");
        System.out.println(Arrays.deepToString(arr.get(0)));
    }
}
