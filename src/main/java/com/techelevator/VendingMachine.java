package com.techelevator;

import java.io.File;
import java.math.BigDecimal;


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
        BigDecimal addFunds = new BigDecimal("1.00");
        addFunds = addFunds.setScale(2);
        addFunds(addFunds);
        purchaseItem("A1");
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
            inventory = new Inventory(inputFile);

            System.out.println("Inventory successfully loaded.");
        }


    public boolean purchaseItem(String slotLocation) {
        boolean isStocked = inventory.isInInventory(slotLocation);
        BigDecimal price = inventory.getPrice(slotLocation);
        BigDecimal initialBalance = money.getAvailableFunds();
        String initialBalanceString = initialBalance.toString();
        boolean isSufficientFunds = money.purchaseItem(price);

            if (isStocked && isSufficientFunds) {

//                money.purchaseItem(price);
                inventory.removeFromInventory(slotLocation);

                String productName = inventory.getProductName(slotLocation);
                String productInfo = productName + " " + slotLocation;
                BigDecimal availableBalance = money.getAvailableFunds();
                String availableBalanceString = availableBalance.toString();
                String moneyString = "$" + initialBalanceString + " $" + availableBalanceString;
                String auditMessage = productInfo + " " + moneyString;
                audit.createAuditEntry(auditMessage);

//            more UI interaction
//            remember to ding audit class with transaction and inventory update
            }
//        Probably going to return message callsigns to the UI
        return isStocked;
    }

    public void addFunds(BigDecimal funds)
    {
        try {
           BigDecimal startingBalance = money.getAvailableFunds();
            String startingBalanceString = "$" + startingBalance.toString() + " ";

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
