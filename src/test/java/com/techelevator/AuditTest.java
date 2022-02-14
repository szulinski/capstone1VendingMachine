package com.techelevator;

import com.techelevator.Audit;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AuditTest {

    private File outputFile;
    private PrintWriter auditWriter;
    private String FileName;
    public final String FORMAT = "MM/dd/yyyy HH:mm:ss a";

   /* @Test
    public void EMPTY_FILENAME_TEST() {
        Audit audit = new Audit();
        FileName = "";
        File outputFile = new File(FileName);
        boolean isAppend = true;
        try {
            auditWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));
        } catch(FileNotFoundException e){
            System.out.println("File does not exist.");
        }

    }

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
