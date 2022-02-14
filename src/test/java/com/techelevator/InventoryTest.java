package com.techelevator;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class InventoryTest {


    @Test
    public void Test_Type_Messages ()
    {
        // Arrange
        String testFileString = "VendingMachineTest.csv";
        Inventory testInventory = new Inventory(testFileString);

        // Act
        String chipString = testInventory.getTypeString("A1");
        String expectedChipString = "Crunch Crunch, Yum!";

        String candyString = testInventory.getTypeString("B1");
        String expectedCandyString = "Munch Munch, Yum!";

        String drinkString = testInventory.getTypeString("C1");
        String expectedDrinkString = "Glug Glug, Yum!";

        String gumString = testInventory.getTypeString("D1");
        String expectedGumString = "Chew Chew, Yum!";

        // Assert
        Assert.assertEquals(expectedChipString, chipString);
        Assert.assertEquals(expectedCandyString, candyString);
        Assert.assertEquals(expectedDrinkString, drinkString);
        Assert.assertEquals(expectedGumString, gumString);


    }


    @Test
    public void Initialization_File_Test_File() {
        // Arrange
        String testFileString = "VendingMachineTest.csv";

        // Act
        Inventory testInventory = new Inventory(testFileString);

        String productNameA1= testInventory.getProductName("A1");
        String expectedProductName = "Potato Crisps";
        BigDecimal price = testInventory.getPrice("B1");
        BigDecimal expectedPrice = new BigDecimal("1.80");
        expectedPrice.setScale(2);
        String typeString = testInventory.getType("C1");
        String expectedType = "Drink";
        int count = testInventory.getCount("D1");
        int countExpected = 5;

        // Assert
        Assert.assertTrue(testInventory.isInInventory("A1"));
        Assert.assertTrue(testInventory.isInInventory("B1"));
        Assert.assertTrue(testInventory.isInInventory("C1"));
        Assert.assertTrue(testInventory.isInInventory("D1"));

        Assert.assertEquals(countExpected, count);
        Assert.assertEquals(expectedProductName, productNameA1);
        Assert.assertEquals(expectedPrice, price);
        Assert.assertEquals(expectedType, typeString);

    }
    @Test
    public void Create_Inventory_Array_Test() {
        // Arrange
        String testFileString = "VendingMachineTest.csv";
        Inventory testInventory = new Inventory(testFileString);

        // Act
        String[] testInventoryArray = testInventory.createInventoryArray();
        String testInventoryArrayString0 = testInventoryArray[0].toString();
        String testInventoryArrayString3 = testInventoryArray[3].toString();
        String expectedInventoryArrayString0 = "A1 Potato Crisps $3.05 Items left: 5";
        String expectedInventoryArrayString3 = "D1 U-Chews $0.85 Items left: 5";

        // Assert
        Assert.assertEquals( expectedInventoryArrayString0, testInventoryArrayString0);
        Assert.assertEquals( expectedInventoryArrayString3, testInventoryArrayString3);

    }

}
