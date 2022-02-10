package com.techelevator;

import java.io.File;

public class VendingMachine {

    private String inputFileString = "vendingmachine.csv";
    private Inventory inventory;

    //public VendingMachine(File inputFile)
    public VendingMachine()
    {
        //this.inputFileString = ;
        loadInventory();
    }
    private void loadInventory()
    {
        File inputFile = new File(inputFileString);
        Inventory inventory = new Inventory(inputFile);

        System.out.println ("Inventory successfully loaded.");
    }

    public void purchaseItem(String slotLocation)
    {
        boolean isStocked = inventory.removeFromInventory();
    }

}
