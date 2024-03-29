package com.techelevator;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Audit {

    private File outputFile;
    private PrintWriter auditWriter;
    private String fileName;
    public final String FORMAT = "MM/dd/yyyy HH:mm:ss a";

    public Audit (String auditString)
    {
        fileName = auditString;

        createPrintWriter();
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
            auditWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));

        } catch(FileNotFoundException e){
            System.out.println("File does not exist.");
        }
        catch (NullPointerException e)
        {
            System.out.println("Null pointer exception for the Audit Writer.");
        }

    }

    private String createDateTimeFormatter() {
        String text = "";
        try
        {
            LocalDateTime dateTime = LocalDateTime.now();

            // Create a DateTimeFormatter using a format String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);

            // format the LocalDateTime as into a String
            text = formatter.format(dateTime);

        }
        catch (DateTimeException e)
        {
            System.out.println (e.getLocalizedMessage());
        }
        return text;
    }

    public void createAuditEntry(String message)
    {
        boolean isAppend = true;

        String appendString = createDateTimeFormatter() + " " + message + "\n";

        auditWriter.append(appendString);
        auditWriter.flush();
    }

    public void closeAudit()
    {
        auditWriter.close();
    }

}
