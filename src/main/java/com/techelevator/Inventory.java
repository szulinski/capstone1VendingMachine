package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
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

    private void loadInitialItemsFile() {
            InitialItemsFile initialItemsFile = new InitialItemsFile(inputFile, this);
    }

    public void addToInventory(Item item)
    {
        try {
            String slotLocation = item.getSlotLocation();
            itemList.put(slotLocation, item);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public boolean isInInventory(String slotLocation) {
        Item item = itemList.get(slotLocation);
        return item.isInInventory();
    }

    public boolean removeFromInventory(String slotLocation)
    {

            Item item = itemList.get(slotLocation);
            boolean isStocked = item.removeFromInventory();
            // if stocked is false; return message to user interface that item not in stock
            // send message to the audit trail
            // handle money
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


//    We need to have a search method to find slot location
//    public String getSlotLocation()
//  {
//    functionality to display slot locations to UI
//    }

