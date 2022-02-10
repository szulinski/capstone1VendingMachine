package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class InitialItemsFile {

    private File inputFile;
    private Scanner inputScanner;
    private Inventory = inventory;


    public InitialItemsFile (File inputFile, Inventory inventory)
    {
        this.inputFile = inputFile;
        this.inventory = inventory;
        createScanner();
    }

    private void InitialItemsFile()
    {
        if (!inputFile.exists())
        {
            System.out.println ("Initialization file does not exist.")
            System.out.println("The file expected is " + inputFile.getPath());
            System.exit (-1);
        }

        try (inputScanner = new Scanner(inputFile))
        {
            loadItemsToInventory();
        }
        catch (catch(IOException e){
        System.out.println("Exception: " + e.getMessage());
        System.out.println("Exception creating scanner to read initialization file");
        System.exit(-1);
    }
    }

    private void loadItemsToInventory()
    {
        while (inputScanner.hasNextLine())
        {
            //inputScanner.nextLine();
        }
    }
}



