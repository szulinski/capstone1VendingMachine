//package com.techelevator;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintWriter;
//
//public class SalesReport {
//
//    private String fileName = "salesreport.csv";
//    private String writeString = "";
//    private PrintWriter reportWriter;
//
//
//    public SalesReport(writeString)
//    {
//        //this.vendingMachine = vendingMachine;
//        this.fileName = "salesreport.txt";
//        generateSalesReport();
//    }
//
//    private void generateSalesReport()
//    {
//        createPrintWriter(fileName);
//        //createInventorySales();
//        createReport();
//    }
//
//    private void createInventorySales()
//    {
//        writeString = vendingMachine.createInventorySales();
//    }
//
//    public void createReport()
//    {
//        try{
//            reportWriter.print(writeString);
//            reportWriter.flush();
//            reportWriter.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Problem adding sales report.");
//        }
//
//    }
//
//    private void createPrintWriter()
//    {
//        File outputFile = new File(fileName);
//        boolean isAppend = false;
//        try
//        {
//            reportWriter = new PrintWriter(new FileOutputStream(outputFile, isAppend));
//        } catch(FileNotFoundException e){
//            System.out.println("File does not exist.");
//        }
//
//    }
//}

/*
To go in VendingMachineCLI
            else if (choice.equals("0") {
					vendingMachine.createSalesReport();
			}

 */

/* To go in VendingMachine
private SalesReport salesReport();




public String createInventorySales()
{
    String writeString = inventory.createInventorySales();
    salesReport = new SalesReport(writeString);
}
 */


/* To go in inventory
  public String[] createInventorySales()
    {
        int inventorySize = itemList.size();
        String writeString = "";

        BigDecimal machineTotalSales = new BigDecimal(0);
        totalSales = totalSales.scale(2);

        int i = 0;

        for (Map.Entry<String, Item> itemEntry : itemList.entrySet()) {

            String slotLocationKey = itemEntry.getKey() ;
            Item item = itemEntry.getValue();

            int count = item.getCount();

            if ( count < 5)
            {
                String productName = item.getProductName() + "\\|";
                BigDecimal priceValue = item.getPrice();

                BigDecimal totalSales = priceValue.multiply (count);
                totalSales = totalSales.scale(2);

                String totalSalesString = totalSales.toString + "\n";

                String line = productName + totalSalesString;

                writeString += line;

                machineTotalSales = machineTotalSales.add(totalSales);

            }

          }

          writeString += "/n";

          String totalSalesTitle = "TOTAL SALES \\|";
          totalSalesString = machineTotalSales.toString() + "\n";
          String totalSalesLine = totalSalesTitle + totalSalesString;


        writeString += totalSalesLine;

        return writeString;
 */