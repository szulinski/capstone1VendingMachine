package com.techelevator;

import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class InventoryTest {

    File testFile = new File("vendingmachine.csv");
    Inventory testInventory = new Inventory(testFile);
    InitialItemsFile testingItemsFile = new InitialItemsFile(testFile, testInventory);

    @Test
    public void INVENTORY_CHECK_TEST() {
        assertTrue(testInventory.isInInventory("A1"));
    }

//    Note: 40% method coverage, but most public methods are Get/Set equivalents, +/-.
}
