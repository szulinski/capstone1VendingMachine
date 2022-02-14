package com.techelevator;

import com.techelevator.Audit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.techelevator.VendingMachine;

import static org.junit.Assert.*;
//
public class AuditTest {


    public final String FORMAT = "MM/dd/yyyy HH:mm:ss a";

    @Test
    public void Test_Constructor ()
    {
        // Arrange
        File outputFile;
        PrintWriter auditWriter;
        String fileName ="AuditLogTest.txt";
        outputFile = new File(fileName);

        // Act
        Audit audit = new Audit (fileName);
        //Object exoectAudit = audit.getClass();
        String auditTestString = audit.getClass().toString();
        String expectedString = "class com.techelevator.Audit";

        // Asserts
        Assert.assertEquals(true, outputFile.exists());
        Assert.assertEquals(expectedString, auditTestString);
    }

    @Test
    public void Create_Audit_Entry_Test_Add_Funds() throws FileNotFoundException
    {
        // Arrange
        PrintWriter auditWriter;
        String fileName ="AuditLogTest.txt";
        Audit audit = new Audit (fileName);
        LocalDateTime dateTime = LocalDateTime.now();

        // Create a DateTimeFormatter using a format String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);

        // format the LocalDateTime as into a String
        String expectedText = formatter.format(dateTime) +" ";

        // Add to expected string
        expectedText = "FEED MONEY: $0.00 $6.90";

        VendingMachine vendingMachine = new VendingMachine("VendingMachineTest.csv", fileName, "SalesReport.csv");
        BigDecimal addedFunds = new BigDecimal("6.90");
        addedFunds = addedFunds.setScale(2);
        vendingMachine.addFunds(addedFunds);

        File newFile = new File(fileName);

        Scanner readFile = new Scanner(newFile);
        String line = "";

        // Act
        while (readFile.hasNextLine())
        {
            line = readFile.nextLine();
        }
        int indexOfF = line.indexOf("F");
        line = line.substring(indexOfF);

        // Asserts
        Assert.assertEquals(expectedText, line);
    }


    /*@Test
    public void Empty_File_Name_Test() {

        // Arrange
        String fileName = "";

        // Act
        Audit audit = new Audit(fileName);
        String auditClassString = audit.getClass().toString();
        String expectedAuditClassString = "class com.techelevtor.Audit";

        // Assert
        Assert.assertEquals(expectedAuditClassString, auditClassString);


    }*/

    /*@Test
    public void NULL_FILENAME_TEST() {
        Audit audit = new Audit();
        FileName = null;
        File outputFile = new File(FileName);
        boolean isAppend = true;
        try {
            auditWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));
        } catch(FileNotFoundException e){
            System.out.println("File does not exist.");
        }

    }*/


//    Note: Must hard-set filename in Audit() before test
//
    /*@Test
    public void DOES_IT_PRINT_TEST() {
        Audit audit = new Audit();
        FileName = "test.txt";
        File outputFile = new File(FileName);
        boolean isAppend = true;
        try {
            auditWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));
            audit.createAuditEntry("testing testing 123 123");
        } catch(FileNotFoundException e){
            System.out.println("File does not exist.");
        }

        audit.closeAudit();
    }*/

}
