package com.techelevator;

import java.io.File;
import java.math.BigDecimal;

public class VendingMachine {

    private String inputFileString = "vendingmachine.csv";
    private Inventory inventory;
    private Money money;

    //public VendingMachine(File inputFile)
    public VendingMachine()
    {
        //this.inputFileString = ;
        loadInventory();
        money = new Money();
    }

    private void cashOut() {
        money.cashOut();
    }

    private void loadInventory()
    {
//        Won't accept 404 catch
            File inputFile = new File(inputFileString);
            Inventory inventory = new Inventory(inputFile);

            System.out.println("Inventory successfully loaded.");
        }

//        Same deal as Money - Line 30.
    public boolean purchaseItem(String slotLocation) {
        boolean isStocked = inventory.isInInventory(slotLocation);
        BigDecimal price = inventory.getPrice(slotLocation);
        boolean isSufficientFunds = money.purchaseItem(price);

        try {
            if (isStocked && isSufficientFunds) {
                money.purchaseItem(price);
                inventory.removeFromInventory(slotLocation);
//            more UI interaction
//            remember to ding audit class with transaction and inventory update
            }
//        Probably going to return message callsigns to the UI
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return isStocked;
    }

        public void addFunds(BigDecimal funds)
    {
        try {
            money.addFunds(funds);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
