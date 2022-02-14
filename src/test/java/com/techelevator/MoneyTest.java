package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyTest {

    @Test
    public void available_funds_normal_data_test()
    {
        //Arrange
        Money money = new Money();

        // Change expected funds to zero
        BigDecimal expectedFunds = new BigDecimal ("6.90");
        money.addFunds (expectedFunds);
        expectedFunds = expectedFunds.setScale(2);

        // Act
        BigDecimal availableFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds, availableFunds);
    }

    @Test
    public void add_funds_normal_data_test()
    {
        // Arrange
        Money money = new Money();
        // Change expected funds to added funds
        BigDecimal expectedFunds = new BigDecimal (5.00);
        //expectedFunds = expectedFunds.scale(2);

        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal addedFunds = new BigDecimal(5.00);

        // Act
        money.addFunds(addedFunds);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds.setScale(2, RoundingMode.DOWN), actualFunds);

    }

    @Test
    public void add_negative_funds_test()
    {
        // Arrange
        Money money = new Money();

        // Change expected funds to zero
        BigDecimal expectedFunds = new BigDecimal (0.00);
        //expectedFunds = expectedFunds.scale(2);

        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal addedFunds = new BigDecimal(-5.00);

        // Act
        money.addFunds(addedFunds);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds.setScale(2, RoundingMode.DOWN), actualFunds);

    }
//
    @Test
    public void purchase_item_normal_data_test()
    {
        // Arrange
        Money money = new Money();
        BigDecimal tenDollars = new BigDecimal("10.00");
        tenDollars = tenDollars.setScale(2);
        money.addFunds (tenDollars);

        BigDecimal expectedFunds = new BigDecimal (6.95);
        // will need to add funds
        BigDecimal availableFunds = money.getAvailableFunds();
        BigDecimal additionalFunds = new BigDecimal(10.00);

        BigDecimal price = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_DOWN);

        // Act
        //money.addFunds(additionalFunds);
        money.purchaseItem(price);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds.setScale(2, RoundingMode.DOWN), actualFunds);

    }

    @Test
    public void purchase_item_funds_not_available()
    {
        // Arrange
        Money money = new Money();

        // Change expected funds to zero

        // should originally be set to 0
        // Will need to modify this

        BigDecimal expectedFunds = new BigDecimal (0.00);
        // will need to add funds
        BigDecimal availableFunds = money.getAvailableFunds();

        BigDecimal price = new BigDecimal(00.50);

        // Act
        money.purchaseItem(price);

        BigDecimal actualFunds = money.getAvailableFunds();

        // Assert
        Assert.assertEquals(expectedFunds.setScale(2, RoundingMode.DOWN), actualFunds);
    }

    @Test
    public void cash_out_test_zero() {

        //Arrange
        Money money = new Money();

        BigDecimal[] expectedChange = new BigDecimal[3];
        expectedChange[0] = new BigDecimal("0");
        expectedChange[1] = new BigDecimal("0");
        expectedChange[2] = new BigDecimal("0");

        // Act
        BigDecimal[] change = money.cashOut();

        // Assert
        Assert.assertEquals(expectedChange[0], change[0]);
        Assert.assertEquals(expectedChange[1], change[1]);
        Assert.assertEquals(expectedChange[2], change[2]);
    }
    @Test
    public void cash_out_test_normal_data() {

        //Arrange
        Money money = new Money();
        BigDecimal addedFunds = new BigDecimal("6.90");
        money.addFunds(addedFunds);

        BigDecimal[] expectedChange = new BigDecimal[3];
        expectedChange[0] = new BigDecimal("27");
        //expectedChange[0] = change[0].setScale(0);
        expectedChange[1] = new BigDecimal("1");
        //expectedChange[1] = change[0].setScale(0);
        expectedChange[2] = new BigDecimal("1");
        //expectedChange[2] = change[0].setScale(0);

        // Act
        BigDecimal[] change = money.cashOut();

        // Assert
        Assert.assertEquals(expectedChange[0], change[0]);
    }
}