package com.client.graphics.interfaces.impl;

import java.util.Arrays;

import com.client.Client;
import com.client.Configuration;
import com.client.TextDrawingArea;
import com.client.graphics.interfaces.RSInterface;
import com.google.common.base.Preconditions;

public class Bank extends RSInterface {

    public static final int BANK_TAB_CONFIG = 1356;
    public static final int EMPTY_CHILD = 41581;
    public static final int BANK_INTERFACE_ID = 5292;
    public static final int BANK_CONTAINER_ID = 5382;
    public static final int[] BANK_TAB_CONTAINERS = {41573, 41574, 41575, 41576, 41577, 41578, 41579, 41580};
    public static final int[] ALL_BANK_CONTAINERS = {5382, 41573, 41574, 41575, 41576, 41577, 41578, 41579, 41580};
    public static int[] bankTabChildren = new int[BANK_TAB_CONTAINERS.length];
    public static RSInterface bankScrollable = null;
    public static int bankContainerY = 0;

    public Bank() {
        for (RSInterface inter : interfaceCache) {
            if (inter != null && inter.children != null && Arrays.stream(inter.children).anyMatch(id -> id == BANK_CONTAINER_ID)) {
                bankScrollable = interfaceCache[inter.id];
                break;
            }
        }

        Preconditions.checkState(bankScrollable != null, "No bank scrollable.");

        bankContainerY = bankScrollable.childY[getIndexOfChild(bankScrollable, BANK_CONTAINER_ID)];
        Preconditions.checkState(bankContainerY != 0, "No bank scrollable container y.");
    }

    public static int getCurrentBankTab() {
        return Client.instance.variousSettings[BANK_TAB_CONFIG];
    }

    public static boolean isBankContainer(RSInterface rsInterface) {
        return Arrays.stream(ALL_BANK_CONTAINERS).anyMatch(id -> rsInterface.id == id);
    }

    private static boolean moreTabsBelow(int index) {
        for (; index < ALL_BANK_CONTAINERS.length; index++) {
            if (interfaceCache[ALL_BANK_CONTAINERS[index - 1]].getItemContainerRows() > 0) {
                return true;
            }
        }

        return false;
    }

    public static void setupMainTab(RSInterface rsInterface, int x, int y) {
        if (rsInterface.id == BANK_CONTAINER_ID) {
            if (getCurrentBankTab() == 0) {
                int height = bankContainerY;
                for (int index = 0; index < ALL_BANK_CONTAINERS.length; index++) {
                    if (index != 0) {
                        if (moreTabsBelow(index)) {
                            Client.instance.bankDivider.drawSprite(x, height + y);
                            height += 10; // buffer for tab separator
                        }
                        bankScrollable.childY[bankTabChildren[index - 1]] = height;
                    }
                    height += interfaceCache[ALL_BANK_CONTAINERS[index]].getItemContainerHeight();
                }
                bankScrollable.scrollMax = height > bankScrollable.height + 1 ? height : bankScrollable.height + 1;
            } else {
                int height = interfaceCache[BANK_CONTAINER_ID].getItemContainerHeight();
                bankScrollable.scrollMax = height > bankScrollable.height + 1 ? height : bankScrollable.height + 1;
            }
        }
    }

    public static void onConfigChanged(int config, int value) {
        if (config == BANK_TAB_CONFIG) {
            if (value == 0) {
                // Init the main tab view
                for (int index = 0; index < BANK_TAB_CONTAINERS.length; index++) {
                    bankScrollable.children[bankTabChildren[index]] = BANK_TAB_CONTAINERS[index];
                }
            } else {
                // Hide the main tab view
                for (int child : bankTabChildren) {
                    bankScrollable.children[child] = EMPTY_CHILD;
                }
            }
        }
    }

    public void bank(TextDrawingArea[] tda) {
        RSInterface rs = addInterface(BANK_INTERFACE_ID);
        rs.message = "";
        setChildren(41, rs);
        addSprite(58001, 0, "BankTab/07/BANK");
        addHoverButton(5384, "BankTab/updated/CLOSE", 97, 21, 21, "Close Window", 250, 5380, 3);
        addHoveredButton(5380, "BankTab/updated/CLOSE", 98, 21, 21, 5379);
        addHoverButton(5294, "BankTab/07/BANK", 7, 37, 29, "Set/Edit Your Bank-Pin", 250, 5295, 4);
        addHoveredButton(5295, "BankTab/BANK", 4, 100, 33, 5296);


        //Item Movement
        addBankHover(58002, 4, 58003, 0, 1, "BankTab/updated/FLOW", 50, 22, 304, 1, "Swap Item Movement Mode", 58004, 7, 6,
                "BankTab/BANK", 58005, "Switch to insert items \nmode", "Switch to swap items \nmode.", 12, 20); //7


        //Noted
        addBankHover(58010, 4, 58011, 0, 1, "BankTab/updated/FLOW", 50, 22, 116, 1, "Enable/Disable Noted Withdrawal", 58012,
                10, 12, "BankTab/BANK", 58013, "Switch to note withdrawal \nmode", "Switch to item withdrawal \nmode",
                12, 20); //9


        addBankHover1(58018, 5, 58019, 1, "BankTab/07/BANK", 37, 29, "Deposit carried items", 58020, 2,
                "BankTab/07/BANK", 58021, "Empty your backpack into\nyour bank", 0, 20); //12

        addBankHover1(58026, 5, 58027, 3, "BankTab/07/BANK", 35, 25, "Deposit worn items", 58028, 4, "BankTab/07/BANK",
                58029, "Empty the items your are\nwearing into your bank", 0, 20); //14

        for (int i = 0; i < 9; i++) {
            addInterface(58050 + i);
            if (i == 0)
                addConfigButton(58031, BANK_INTERFACE_ID, 0, 1, "BankTab/TAB", 48, 38, new String[] { "Price Check", "View" }, 1,
                        34);
            else
                addConfigButton(58031 + i, BANK_INTERFACE_ID, 4, 2, "BankTab/TAB", 48, 38,
                        new String[] { "Price Check", "Collapse", "View" }, 1, 34 + i);
            addToItemGroup(58040 + i, 1, 1, 0, 0, false, "", "", "");
        }

        addText(58061, "0", tda, 0, 0xE68A00, true, true); //24
        addText(58062, "350", tda, 0, 0xE68A00, true, true);

        addInputField(58063, 50, 0xE68A00, "Search", 235, 23, false, true);
        addText(58064, "Bank Of " + Configuration.CLIENT_TITLE, tda, 2, 0xE68A00, true, true);

        addBankHover(18929, 4, 18930, 0, 1, "BankTab/updated/FLOW", 50, 22, 305, 1, "Swap Item Movement Mode", 18931, 7, 6,
                "BankTab/BANK", 18932, "Switch to insert items \nmode", "Switch to swap items \nmode.", 12, 20); //7

        addBankHover(18933, 4, 18934, 0, 1, "BankTab/updated/FLOW", 50, 22, 117, 1, "Enable/Disable Noted Withdrawal", 18935,
                10, 12, "BankTab/BANK", 18936, "Switch to note withdrawal \nmode", "Switch to item withdrawal \nmode",
                12, 20); //9

        addBankHover1(18937, 5, 18938, 0, "BankTab/updated/SEARCH", 36, 36, "Search items", 18939, 4, "BankTab/updated/SEARCH",
                18940, "Empty the items your are\nwearing into your bank", 0, 1); //14

        addClickableSprites(58014, "Enable/Disable Always Placeholders", "BankTab/07/BANK", 5, 6, 5);

        addText(18941, "Rearrange mode:", tda, 1, 0xE68A00, false, true);
        addText(18942, "Withdraw as:", tda, 1, 0xE68A00, true, true);

        addText(18943, "Swap", tda, 1, 0xE68A00, true, true);
        addText(18944, "Insert", tda, 1, 0xE68A00, true, true);
        addText(18945, "Item", tda, 1, 0xE68A00, true, true);
        addText(18946, "Note", tda, 1, 0xE68A00, true, true);

        addBankHover1(18947, 5, 18948, 0, "Presets/OPEN", 36, 36, "Open Preset Interface", 18949, 4, "Presets/OPEN",
                18950, "Open Preset Interface", 0, 1);

        //addInputField(58063, 50, 0xE68A00, "Search", 235, 23, false, true);
        RSInterface Interface = interfaceCache[5385];
        Interface.height = 202;
        Interface.width = 481;
        Interface = interfaceCache[BANK_CONTAINER_ID];
        Interface.width = 10;
        Interface.invSpritePadX = 12;
        Interface.height = 35;
        Interface.actions = new String[] { "Withdraw 1", "Withdraw 5", "Withdraw 10", "Withdraw All", "Withdraw X",
                "Withdraw All but one" };

        setBounds(58001, 14, 3, 0, rs);
        setBounds(5384, 474, 10, 1, rs);
        setBounds(5380, 474, 10, 2, rs);
        setBounds(5294, 312, 292, 3, rs); // Bank pin
        setBounds(5295, 312, 297, 4, rs);
        setBounds(58002, 20, 306, 5, rs); // Rearrange mode
        setBounds(58003, 20, 306, 6, rs);
        setBounds(58010, 120, 306, 7, rs); // Noting
        setBounds(58011, 120, 306, 8, rs);

        setBounds(58018, 423, 292, 9, rs); // Items
        setBounds(58019, 423, 292, 10, rs);

        setBounds(58026, 460, 292, 11, rs); // Invo

        setBounds(58027, 460, 292, 12, rs);
        setBounds(5385, -3, 76, 13, rs);
        RSInterface.interfaceCache[5385].height = 216;
        int x = 59;
        for (int i = 0; i < 9; i++) {
            setBounds(58050 + i, 0, 0, 15 + i, rs);
            RSInterface rsi = interfaceCache[58050 + i];
            setChildren(2, rsi);
            setBounds(58031 + i, x, 38, 0, rsi);
            setBounds(58040 + i, x + 5, 42, 1, rsi);
            x += 41;
        }
        // 0-350
        setBounds(58061, 36, 9, 24, rs);
        setBounds(58062, 36, 21, 25, rs);

//		setBounds(58063, 25, 298, 26, rs); // Search
        setBounds(58064, 250, 13, 26, rs);

        setBounds(18929, 70, 306, 27, rs); // Swap items
        setBounds(18930, 70, 306, 28, rs);

        setBounds(18933, 170, 306, 29, rs); // Noting
        setBounds(18934, 170, 306, 30, rs);

        setBounds(18937, 386, 292, 31, rs); // Search
        setBounds(18938, 386, 292, 32, rs);

//
        setBounds(58014, 349, 292, 33, rs); // Placeholder

        setBounds(18941, 22, 291, 34, rs); // Titles
        setBounds(18942, 170, 291, 35, rs); // Titles

        setBounds(18943, 45, 309, 36, rs); // Titles
        setBounds(18944, 95, 309, 37, rs); // Titles
        setBounds(18945, 145, 309, 38, rs); // Titles
        setBounds(18946, 195, 309, 39, rs); // Titles

        setBounds(18947, 275, 292, 40, rs); // Titles

        // Fixing container placement on interface
        bankScrollable.height -= 2;
        RSInterface bank = interfaceCache[BANK_INTERFACE_ID];
        for (int index = 0; index < bank.children.length; index++) {
            if (bank.children[index] == bankScrollable.id) {
                bank.childY[index] += 2;
            }
        }

        // Adding new container for main tab
        addText(EMPTY_CHILD, "", tda, 1, 0xE68A00, true, true);
        RSInterface mainContainer = interfaceCache[BANK_CONTAINER_ID];
        int mainContainerIndex = getIndexOfChild(bankScrollable, mainContainer.id);
        int newContainersStartIndex = expandChildren(BANK_TAB_CONTAINERS.length, bankScrollable);
        for (int index = 0; index < BANK_TAB_CONTAINERS.length; index++) {
            RSInterface container = addInventoryContainer(BANK_TAB_CONTAINERS[index], 10, 35, mainContainer.invSpritePadX, mainContainer.invSpritePadY, true);
            container.actions = new String[] {"Withdraw 1", "Withdraw 5", "Withdraw 10", "Withdraw All", "Withdraw X", "Withdraw All but one"};
            bankTabChildren[index] = newContainersStartIndex;
            bankScrollable.child(newContainersStartIndex++, BANK_TAB_CONTAINERS[index], bankScrollable.childX[mainContainerIndex], 0);
        }
    }

}
