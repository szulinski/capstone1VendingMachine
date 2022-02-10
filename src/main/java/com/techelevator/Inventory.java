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

    private void loadInitialItemsFile()
    {
        InitialItemsFile initialItemsFile = new InitialItemsFile(inputFile, this);

    }

    public void addToInventory(Item item)
    {
        String slotLocation = item.getSlotLocation();
        itemList.put (slotLocation, item);
    }
    public boolean removeFromInventory(String slotLocation)
    {
        Item item = itemList.get(slotLocation);
        boolean isStocked =  item.removeFromInventory();
        // if stocked is false; return message to user interface that item not in stock
        // send message to the audit trail
        // handle money
        return isStocked;
    }

}
