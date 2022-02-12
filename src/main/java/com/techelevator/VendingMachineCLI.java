package com.techelevator;

import com.techelevator.view.VendingMachineUI;

import java.math.BigDecimal;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT,
			PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private static String[] SELECT_PRODUCT_MENU;

	private static final String FEED_MONEY_OPTION_1 = "$1";
	private static final String FEED_MONEY_OPTION_5 = "$5";
	private static final String FEED_MONEY_OPTION_10 = "$10";
	private static final String FEED_MONEY_OPTION_20 = "$20";

	private static final String[] FEED_MONEY_OPTION_MENU = {FEED_MONEY_OPTION_1,
			FEED_MONEY_OPTION_5,
			FEED_MONEY_OPTION_10,
			FEED_MONEY_OPTION_20};

	private VendingMachineUI menu;
	private static VendingMachine vendingMachine;

	private static String[] activeMenu = MAIN_MENU_OPTIONS;

	private boolean isProductList = false;

	public VendingMachineCLI(VendingMachineUI menu) {
		this.menu = menu;
	}

	public void run() {

		displayProducts();

		boolean exit = false;


		try {
			while (!exit) {
			String choice = (String) menu.getChoiceFromOptions(activeMenu);

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					displayProducts();

				}
				else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					activeMenu = PURCHASE_MENU_OPTIONS;
					String availableFundsString = vendingMachine.getAvailableFunds();
					System.out.println(availableFundsString);
				}
				else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					exit = true;

					String changeString = vendingMachine.closeApplication();
					if (changeString.length() > 0)
					{
						System.out.println (changeString);
					}
				} else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					activeMenu = FEED_MONEY_OPTION_MENU;


				} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

					activeMenu = SELECT_PRODUCT_MENU;
					displayProducts();
					isProductList = true;

				}
				else if (isProductList)
				{
					String slotLocation =  choice.substring(0, 2);
					activeMenu = PURCHASE_MENU_OPTIONS;

					String[] success = vendingMachine.purchaseItem(slotLocation);
					int successLength = success.length;

					System.out.println();

					for (int i = 0; i < successLength; i++)
					{
						System.out.println(success [i]);
					}

					isProductList = false;
				}
				else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					String changeString = vendingMachine.cashOut();
					System.out.println(changeString);
					activeMenu = MAIN_MENU_OPTIONS;
				} else if (choice.equals(FEED_MONEY_OPTION_1)) {
					activeMenu = PURCHASE_MENU_OPTIONS;
					BigDecimal addedFunds = new BigDecimal("1.00");
					vendingMachine.addFunds(addedFunds);
					String availableFundsString = vendingMachine.getAvailableFunds();
					System.out.println(availableFundsString);

				} else if (choice.equals(FEED_MONEY_OPTION_5)) {
					activeMenu = PURCHASE_MENU_OPTIONS;
					BigDecimal addedFunds = new BigDecimal("5.00");
					vendingMachine.addFunds(addedFunds);
					String availableFundsString = vendingMachine.getAvailableFunds();
					System.out.println(availableFundsString);
				} else if (choice.equals(FEED_MONEY_OPTION_10)) {
					activeMenu = PURCHASE_MENU_OPTIONS;
					BigDecimal addedFunds = new BigDecimal("10.00");
					vendingMachine.addFunds(addedFunds);
					String availableFundsString = vendingMachine.getAvailableFunds();
					System.out.println(availableFundsString);
				} else if (choice.equals(FEED_MONEY_OPTION_20)) {
					activeMenu = PURCHASE_MENU_OPTIONS;
					BigDecimal addedFunds = new BigDecimal("20.00");
					vendingMachine.addFunds(addedFunds);
					String availableFundsString = vendingMachine.getAvailableFunds();
					System.out.println(availableFundsString);
				}

			}

		} catch (Exception e) {
			System.out.println("An exception occured in the menu.");

		}
	}

	public static void main(String[] args) {

		vendingMachine = new VendingMachine();
		VendingMachineUI menu = new VendingMachineUI(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


	private void displayProducts()
	{
		String[] menuChoices = vendingMachine.createInventoryArray();
		int menuChoicesLength = menuChoices.length;
		SELECT_PRODUCT_MENU = new String[menuChoicesLength];

		for(int i = 0; i<menuChoicesLength;i++)
		{
			SELECT_PRODUCT_MENU[i] = menuChoices[i];
			System.out.println(menuChoices[i]);
		}
	}
}
