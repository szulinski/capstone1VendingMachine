package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import com.techelevator.Inventory;

import static org.junit.Assert.assertTrue;

public class InitialItemsFileTest {

   @Test
    public void Initial_Items_File_Normal_Data()
    {
        // Arrange
        String InitialItemsString  = "VendingMachineTest.csv";
        int expectedListLength = 4;

        // Act
        Inventory inventoryTest = new Inventory(InitialItemsString);
        int listLength = inventoryTest.getInventoryListLength();


        // Test
        Assert.assertEquals(expectedListLength, listLength);

    }




    @Test
    public void initial_Items_File_No_File_Name()
    {
        // Arrange
        String InitialItemsString  = "";
        int expectedListLength = 4;

        // Act
        Inventory inventoryTest = new Inventory(InitialItemsString);
        int listLength = inventoryTest.getInventoryListLength();


        // Test
        Assert.assertEquals(expectedListLength, listLength);

    }

  /* @Test
    public void Initial_Items_Constructor ()
    {
        // Arrange
        String initialItemsString  = "VendingMachineTest.csv";
        int expectedListLength = 4;

        // Act
        Inventory inventoryTest = new Inventory(initialItemsString);
        int listLength = inventoryTest.getInventoryListLength();
        String expectedString = "class com.techelevator.Inventory";
        String actualString = inventoryTest.getClass().toString();

        // Test
        Assert.assertEquals(expectedListLength, listLength);
        Assert.assertEquals(expectedString, actualString);

    }*/

 /* @Test
    public void Initial_Items_File_No_Data()
    {
        // Arrange
        String InitialItemsString  = "";
        int expectedListLength = 0;

        // Act
        Inventory inventoryTest = new Inventory(InitialItemsString);
        int listLength = inventoryTest.getInventoryListLength();

        // Test
        Assert.assertEquals(expectedListLength, listLength);
    }*/

    /*public void INITIALIZATION_TEST_NULL_FILE() {
        File inputFile;
        File inventoryFile = new File("testing.txt");
        Map<String, Item> itemList = new TreeMap<>();
        Inventory inventory = new Inventory(inventoryFile);
        InitialItemsFile initialItemsFile = new InitialItemsFile(null, inventory);
        Assert.assertNull(initialItemsFile);
    }

    @Test
    public void DOES_IT_CONTAIN() {

        File testFile = new File("testfile.txt");
        Inventory testInventory = new Inventory(testFile);
        InitialItemsFile testingItemsFile = new InitialItemsFile(testFile, testInventory);
        //assert(testInventory.itemList.containsKey("testing"));

    }*/
}