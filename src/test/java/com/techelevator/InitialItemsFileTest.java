package com.techelevator;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class InitialItemsFileTest {

    @Test
    public void INITIALIZATION_TEST_NULL_FILE() {
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

    }
}