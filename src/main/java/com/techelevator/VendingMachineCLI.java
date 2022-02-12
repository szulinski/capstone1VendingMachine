package com.techelevator;

import com.techelevator.view.VendingMachineUI;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private VendingMachineUI menu;
	private static VendingMachine vendingMachine;

	public VendingMachineCLI(VendingMachineUI menu) {
		this.menu = menu;
	}

	public void run() {

		try {
			while (true) {
				String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
					String[] menuChoices = vendingMachine.createInventoryArray();
					int menuChoicesLength = menuChoices.length;

					for (int i = 0; i < menuChoicesLength; i++) {
						System.out.println(menuChoices[i]);
					}

				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					//1choice.
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
