package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.techelevator.VendingMachine;

public class VendingMachineTest {

    @Test
    public void constructor_Test(){

        //Arrange
        String inventoryString = "VendingMachineTest.csv";
        String auditLog = "AuditLogTest.txt";
        String salesReport = "SalesReport.csv";

        // Act
        VendingMachine vendingMachine = new VendingMachine(inventoryString, auditLog, salesReport);

        File newAuditTest = new File (auditLog);

        // Assert
        Assert.assertEquals(true, newAuditTest.exists());
    }

    @Test
    public void cash_out_test_normal_data() {

        //Arrange
        String inventoryString = "VendingMachineTest.csv";
        String auditLog = "AuditLogTest.txt";
        String salesReport = "SalesReport.csv";
        VendingMachine vendingMachine = new VendingMachine(inventoryString, auditLog, salesReport);

        BigDecimal addedFunds = new BigDecimal("6.90");
        vendingMachine.addFunds(addedFunds);
        addedFunds = addedFunds.setScale(2);
        String expectedChange = "\n27 Quarters 1 Dimes 1 Nickels";

        // Act
        String change = vendingMachine.cashOut();

        // Assert
        Assert.assertEquals(expectedChange, change);
    }

    @Test
    public void Cash_out_test_normal_data() {

        //Arrange
        String inventoryString = "VendingMachineTest.csv";
        String auditLog = "AuditLogTest.txt";
        String salesReport = "SalesReport.csv";
        VendingMachine vendingMachine = new VendingMachine(inventoryString, auditLog, salesReport);

        BigDecimal addedFunds = new BigDecimal("6.90");
        vendingMachine.addFunds(addedFunds);
        addedFunds = addedFunds.setScale(2);
        String expectedChange = "\n27 Quarters 1 Dimes 1 Nickels";

        // Act
        String change = vendingMachine.cashOut();

        // Assert
        Assert.assertEquals(expectedChange, change);
    }
    @Test
    public void cash_out_test_zero() {

        //Arrange
        String inventoryString = "VendingMachineTest.csv";
        String auditLog = "AuditLogTest.txt";
        String salesReport = "SalesReport.csv";
        VendingMachine vendingMachine = new VendingMachine(inventoryString, auditLog, salesReport);

        String expectedChange = "\n0 Quarters 0 Dimes 0 Nickels";

        // Act
        String change = vendingMachine.cashOut();

        // Assert
        Assert.assertEquals(expectedChange, change);
    }

/*
    public Open_Add_C()
    {
        String changeString = "";

        BigDecimal availableFunds = money.getAvailableFunds();
        BigDecimal zeroBalance = new BigDecimal(0);


        if (availableFunds.compareTo(zeroBalance) > 0)
        {
            changeString = cashOut();
        }
        audit.closeAudit();
        return changeString;
    }*/


}
