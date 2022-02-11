package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachine {

    private String inputFileString = "vendingmachine.csv";
    private Inventory inventory;
    private Money money;
    private Audit audit;

    //public VendingMachine(File inputFile)
    public VendingMachine()
    {
        //this.inputFileString = ;
        loadInventory();
        money = new Money();

        audit = new Audit();
        BigDecimal addFunds = new BigDecimal(1.50);
        addFunds.setScale(2);
        addFunds(addFunds);
        cashOut();
        closeApplication();
        //audit.createAuditEntry("Purchase Made");
    }

    private void cashOut() {

        BigDecimal startingBalance = money.getAvailableFunds();
        String startingBalanceString = "$" + startingBalance.toString() + " ";

        money.cashOut();

        BigDecimal endingBalance = money.getAvailableFunds();
        String endingBalanceString = "$" + endingBalance.toString() + " ";

        String message = "GIVE CHANGE: " + startingBalanceString + endingBalanceString;

        audit.createAuditEntry(message);
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
            funds.setScale(2);
            String startingBalanceString = "$" + funds.toString() + " ";
           //BigDecimal startingBalance = money.getAvailableFunds();
            //String startingBalanceString = "$" + startingBalance.toString() + " ";

            money.addFunds(funds);

            BigDecimal endingBalance = money.getAvailableFunds();
            String endingBalanceString = "$" + endingBalance.toString() + " ";

            String message = "FEED MONEY:  " + startingBalanceString + endingBalanceString;


            audit.createAuditEntry(message);


        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    private void closeApplication()
    {
        audit.closeAudit();
    }
}
