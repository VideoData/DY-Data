package com.lida.dy.schedle.liudataset;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static void writeCsvFile(String fileName) {
        Appendable fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            CSVPrinter printer = CSVFormat.RFC4180.withHeader("instanceId", "regionId", "zoneId").print(fileWriter);
            printer.printRecord("testInstanceId", "testRegionId", "testZoneId");
            printer.printRecord("testInstanceId", "testRegionId", "testZoneId");
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCsvFile(String fileName, ArrayList<ArrayList<String>> arrayLists) {
        Appendable fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName,true);
            CSVPrinter printer = CSVFormat.DEFAULT.print(fileWriter);
            for (ArrayList<String> arrayList : arrayLists) {
                printer.printRecord(arrayList.toArray());
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeCsvFile2(String fileName, List<CSVRecord> csvRecords) {
        Appendable fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName,true);
            CSVPrinter printer = CSVFormat.DEFAULT.print(fileWriter);
            for (CSVRecord csvRecord : csvRecords) {
                printer.printRecord(csvRecord);
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Iterable<CSVRecord> readCsvFile(String fileName) {
        Reader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(fileReader);
            return records;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        readCsvFile("C:\\Users\\Administrator\\Documents\\Tencent Files\\1941189375\\FileRecv\\aweme_all_features_append.csv");
    }
}
