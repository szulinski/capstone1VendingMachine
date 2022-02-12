package com.techelevator;

import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class InventoryTest {

    File testFile = new File("testfile.txt");
    Inventory testInventory = new Inventory(testFile);
    InitialItemsFile testingItemsFile = new InitialItemsFile(testFile, testInventory);

    @Test
    public void INVENTORY_CHECK_TEST() {
        assertTrue(testInventory.isInInventory("testing"));
    }
}
