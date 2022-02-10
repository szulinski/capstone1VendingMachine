package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InitialItemsFile {

    private File inputFile;
    //private Scanner inputScanner;
    private Inventory inventory;


    public InitialItemsFile (File inputFile, Inventory inventory)
    {
        this.inputFile = inputFile;
        this.inventory = inventory;
        createScanner();
    }

    private void createScanner()
    {
        if (!inputFile.exists())
        {
            System.out.println ("Initialization file does not exist.");
            System.out.println("The file expected is " + inputFile.getPath());
            System.exit (-1);
        }

        try (Scanner inputScanner = new Scanner(inputFile))
        {
            loadItemsToInventory(inputScanner);
        }
        catch (IOException e){
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Exception creating scanner to read initialization file");
            System.exit(-1);
        }
    }

    private void loadItemsToInventory(Scanner inputScanner)
    {
        while (inputScanner.hasNextLine())
        {
                String lineFromFile = inputScanner.nextLine();
                String[] itemArray =  lineFromFile.split("\\|");
                Item newItem = new Item(itemArray);
                inventory.addToInventory(newItem);

            }
    }
}



