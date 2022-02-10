package com.techelevator;


import java.io.File;
import java.math.BigDecimal;

public class Item {

    private String[] itemArray;
    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String type;
    private int count;
    private String priceString;

    public Item(String[] itemArray)
    {
       this.itemArray = itemArray;
       this.slotLocation = itemArray[0];
       this.productName = itemArray[1];
       this.priceString = itemArray[2];
       price = new BigDecimal (priceString);
       this.type = itemArray[3];
       count = 5;
    }

    public String getSlotLocation()
    {
        return slotLocation;
    }

    public boolean removeFromInventory()
    {
        boolean isStocked = false;
        if (count > 0 )
        {
            isStocked = true;
            count--;
        }
        return isStocked;
    }

}
