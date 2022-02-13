package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Inventory {

    private File inputFile;
    private Map<String, Item> itemList = new TreeMap<>();
    //private String[] menuList;

    public Inventory (File inputFile)
    {
        this.inputFile = inputFile;
        loadInitialItemsFile();
    }
    public String createInventorySales()
    {
        int inventorySize = itemList.size();
        String writeString = "\n";

        BigDecimal machineTotalSales = new BigDecimal("0.00");
        machineTotalSales = machineTotalSales.setScale(2);

        int i = 0;

        for (Map.Entry<String, Item> itemEntry : itemList.entrySet()) {

            String slotLocationKey = itemEntry.getKey() ;
            Item item = itemEntry.getValue();

            int count = item.getCount();
            BigDecimal countBD = new BigDecimal(count);

            if ( count < 5)
            {
                String productName = item.getProductName() + "\\|";
                BigDecimal priceValue = item.getPrice();

                BigDecimal totalSales = priceValue.multiply (countBD);
                totalSales = totalSales.setScale(2);

                String totalSalesString = totalSales.toString() + "\n";

                String line = productName + totalSalesString;

                writeString += line;

                machineTotalSales = machineTotalSales.add(totalSales);

            }

        }

        writeString += "\n";

        String totalSalesTitle = "TOTAL SALES \\|";
        String totalSalesString = machineTotalSales.toString() + "\n";
        String totalSalesLine = totalSalesTitle + totalSalesString;


        writeString += totalSalesLine;

        return writeString;
    }

    public String[] createInventoryArray()
    {
        int inventorySize = itemList.size();
        String[] menuList = new String[inventorySize];

        int i = 0;

        for (Map.Entry<String, Item> itemEntry : itemList.entrySet()) {
            String slotLocationKey = itemEntry.getKey() ;
            Item item = itemEntry.getValue();
            String slotLocation = item.getSlotLocation() + " ";
            String productName = item.getProductName() + " ";
            BigDecimal priceValue = item.getPrice();
            String price = "$" + priceValue.toString() + " ";
            int count = item.getCount();
            String countString = "";
            if (count == 0)
                countString = "Sold out";
            else {
                countString = "Items left: " + count;
            }
            menuList [i] = (slotLocation) + String.format("%-20s", productName) + String.format("%-20s", price) + String.format("%-20s", countString);
            i++;

        }
        return menuList;

    }




    private void loadInitialItemsFile() {
            InitialItemsFile initialItemsFile = new InitialItemsFile(inputFile, this);
    }

    public void addToInventory(Item item)
    {
            String slotLocation = item.getSlotLocation();
            itemList.put(slotLocation, item);
    }

    public boolean isInInventory(String slotLocation) {
        Item item = itemList.get(slotLocation);
        return item.isInInventory();
    }

    public boolean removeFromInventory(String slotLocation)
    {
        Item item = itemList.get(slotLocation);
        boolean isStocked = item.removeFromInventory();
        return isStocked;
    }

    public String getProductName(String slotLocation) {
            Item item = itemList.get(slotLocation);
            String productName = item.getProductName();
            return productName;
    }

    public String getType(String slotLocation) {
            Item item = itemList.get(slotLocation);
            String type = item.getType();
            return type;
    }
    public String getTypeString (String slotLocation) {
        Item item = itemList.get(slotLocation);
        String type = item.getType();
        String typeString = "";
        if (type.equals("Beverage"))
        {
            typeString = "Glug Glug, Yum!";
        }
        else if (type.equals("Chip"))
        {
            typeString = "Crunch Crunch, Yum!";
        }
        else if (type.equals("Candy"))
        {
            typeString = "Munch Munch, Yum!";
        }
        else if (type.equals( "Gum"))
        {
            typeString = "Chew Chew, Yum!";
        }
        return typeString;
    }
    public int getCount(String slotLocation) {
            Item item = itemList.get(slotLocation);
            int count = item.getCount();
            return count;
    }

    public BigDecimal getPrice(String slotLocation) {
            Item item = itemList.get(slotLocation);
            BigDecimal price = item.getPrice();
            return price;
        }
    }




