package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SalesReport {

    private String fileName = "salesreport.csv";
    private String writeString;
    private PrintWriter reportWriter;


    public SalesReport(String writeString)
    {
        this.writeString = writeString;
        generateSalesReport();
    }

    private void generateSalesReport()
    {
        createPrintWriter();
        createReport();
    }

    public void createReport()
    {
        try{
            reportWriter.print(writeString);
            reportWriter.flush();
            reportWriter.close();
        }
        catch (Exception e)
        {
            System.out.println("Problem adding sales report.");
        }

    }

    private void createPrintWriter()
    {

        if (fileName == null)
        {
            System.out.println("The file name of the print writer is null.");
            return;
        }
        File outputFile = new File(fileName);
        boolean isAppend = true;
        try
        {
            reportWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));

        } catch(FileNotFoundException e){
            System.out.println("File does not exist.");
        }
        catch (NullPointerException e)
        {
            System.out.println("Null pointer exception for the Sales Report. ");
        }
    }
}
