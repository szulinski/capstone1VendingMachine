package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VendingMachineTest {

    @Test
    public void cash_out_test() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        vendingMachine.cashOut();
        BigDecimal availableFunds = money.getAvailableFunds();
        BigDecimal expectedFunds = new BigDecimal(0.00);
        Assert.assertEquals(expectedFunds.setScale(2, RoundingMode.DOWN), availableFunds);
    }
}
