package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    @Test
    public void item_constructor_normal_data_test()
    {
        // Arrange
        // string Array
        String expectedSlotLocation = "A2";
        String expectedProductName = "Sun Chips";
        String expectedPriceString = "5.45";
        BigDecimal expectedPrice = new BigDecimal(expectedPriceString);
        String expectedType = "Chip";

        String[] itemArray = new String[4];
        // slot location
        itemArray[0] = expectedSlotLocation;
        // Product name
        itemArray[1] = expectedProductName;
        // Price
        itemArray[2] = expectedPriceString;
        // type
        itemArray[3] = expectedType;

        // Act
        Item item = new Item (itemArray);

        // Assert
        // Slot Location Test
        String actualSlotLocation = item.getSlotLocation();
        Assert.assertEquals(expectedSlotLocation, actualSlotLocation);

        // Product name
        String actualProductName = item.getProductName();
        Assert.assertEquals(expectedProductName, actualProductName);

        // Price
        BigDecimal actualPrice = item.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice);

        // Type
        String actualType = item.getType();
        Assert.assertEquals(expectedType, actualType);
    }

}
