package com.techelevator;

import com.techelevator.SalesReport;
import org.junit.Assert;
import org.junit.Test;

public class SalesReportTest {

    @Test
    public void Sales_Report_Test()
    {
        // Arrange
        String salesReportFileName = "SalesReportTest.csv";
        SalesReport salesReport = new SalesReport(salesReportFileName);
        String expectedString = "class com.techelevator.SalesReport";

        // Act
        String salesReportString = salesReport.getClass().toString();

        // Assert
        Assert.assertEquals(expectedString, salesReportString);

    }
}
