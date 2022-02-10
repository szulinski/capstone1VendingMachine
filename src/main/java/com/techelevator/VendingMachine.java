package com.techelevator;

import java.io.File;

public class VendingMachine {

    private String inputFile;
    private Inventory inventory;

    public VendingMachine(File inputFile)
    {
        this.inputFile = loadInventroy();
    }
    private loadInventory()
    {
        Inventory inventory = new Inventory(inputFile);
    }

}
