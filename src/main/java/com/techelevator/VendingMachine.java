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
        inventory.createInventoryArray();

        //audit.createAuditEntry("Purchase Made");
    }

    public String cashOut() {

        BigDecimal startingBalance = money.getAvailableFunds();
        String startingBalanceString = "$" + startingBalance.toString() + " ";

        BigDecimal[] change = money.cashOut();
        String quartersString = change[0].toString() + " Quarters ";
        String dimesString = change[1].toString() + "Dimes ";
        String nickelsString = change[2].toString() + "Nickels";
        String changeString = quartersString + dimesString + nickelsString;

        System.out.println (changeString);

        BigDecimal endingBalance = money.getAvailableFunds();
        String endingBalanceString = "$" + endingBalance.toString() + " ";

        String message = "GIVE CHANGE: " + startingBalanceString + endingBalanceString;

        audit.createAuditEntry(message);

        return changeString;
    }

    private void loadInventory()
    {
//        Won't accept 404 catch
        File inputFile = new File(inputFileString);
        inventory = new Inventory(inputFile);

        System.out.println("Inventory successfully loaded.");
    }

    public String[] createInventoryArray()
    {
        String[] inventoryChoices = inventory.createInventoryArray();
        return inventoryChoices;
    }


    public String[] purchaseItem(String slotLocation) {

        String[] infoString = new String[5];
        boolean isStocked = inventory.isInInventory(slotLocation);

        if (isStocked)
        {
            infoString[0] = "The item in slot " + slotLocation + " is in stock.";
        }
        else
        {
            infoString[0] = "The item in slot " + slotLocation + " is not in stock.";
        }

        BigDecimal price = inventory.getPrice(slotLocation);
        String priceString = price.toString();
        BigDecimal initialBalance = money.getAvailableFunds();
        String initialBalanceString = initialBalance.toString();
        boolean isSufficientFunds = money.purchaseItem(price);

        infoString [1] = "The available balance is $" + initialBalanceString + " to purchase the item priced at $" +priceString +".";
        if (isSufficientFunds)
        {

            infoString [2] = "There are sufficient funds.";
        }
        else
        {
            infoString[2] = "There are not sufficient funds.  Add more money to purchase this item.";
        }

        if (isStocked && isSufficientFunds) {

            inventory.removeFromInventory(slotLocation);

            String productName = inventory.getProductName(slotLocation);
            String productInfo = productName + " " + slotLocation;
            BigDecimal availableBalance = money.getAvailableFunds();
            String availableBalanceString = availableBalance.toString();
            String moneyString = "$" + initialBalanceString + " $" + availableBalanceString;
            String auditMessage = productInfo + " " + moneyString;
            audit.createAuditEntry(auditMessage);
            infoString [3] = "The item in slot " + slotLocation + " has been purchased.";

        }
        else {
            infoString [3] = "The item in slot " + slotLocation + " has NOT been purchased.";

        }
        infoString[4] = getAvailableFunds();
        return infoString;
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

    public void closeApplication()
    {
        audit.closeAudit();
    }

    public String getAvailableFunds()
    {
        BigDecimal availableFunds = money.getAvailableFunds();
        String availableFundsString = availableFunds.toString();

        String moneyString = "The available balance is $" + availableFundsString + ".";
        return moneyString;
    }
}
