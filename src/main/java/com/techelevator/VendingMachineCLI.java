package com.techelevator;

import com.techelevator.view.VendingMachineUI;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS= { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMachineUI menu;
	private static VendingMachine vendingMachine;

	private static String[] menuOptions = MAIN_MENU_OPTIONS;


	public VendingMachineCLI(VendingMachineUI menu) {
		this.menu = menu;
	}

	public void run() {
		boolean exit = false;
		try {
			while (!exit) {
				String choice = (String) menu.getChoiceFromOptions(menuOptions);

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					String[] menuChoices = vendingMachine.createInventoryArray();
					int menuChoicesLength = menuChoices.length;

					for (int i = 0; i < menuChoicesLength; i++) {
						System.out.println(menuChoices[i]);
					}

				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					menuOptions = PURCHASE_MENU_OPTIONS;
					System.out.println("Your current balance");
				}
				else if (choice.equals(MAIN_MENU_OPTION_EXIT))
				{
					exit = true;
				}
				else if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY))
				{

				}
				else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT))
				{

				}
				else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION))
				{
					menuOptions = MAIN_MENU_OPTIONS;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println ("An exception occured.");

		}
	}
	public static void main(String[] args) {

		vendingMachine = new VendingMachine();
		VendingMachineUI menu = new VendingMachineUI(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
