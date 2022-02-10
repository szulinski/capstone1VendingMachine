package com.techelevator;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    File inputFile;
    Map<String, Item> itemList = new TreeMap<>();
    public Inventory (File inputFile)
    {
        this.inputFile = inputFile;
        loadInitialItemsFile();


    }

    private String loadInitialItemsFile()
    {
        InitialItemsFile initialItemsFile = new InitialItemsFile(inputFile, this);

    }


}
