package com.client.graphics.interfaces.impl;

import com.client.TextDrawingArea;
import com.client.graphics.interfaces.RSInterface;

public class SlayerRewards extends RSInterface
{

    public static void initializeInterfaces(TextDrawingArea[] tda) {
        unlockInterface(tda);
        extendInterface(tda);
        buyInterface(tda);
        taskInterface(tda);
        infoInterface(tda);
    }

    public static void infoInterface(TextDrawingArea[] tda) {
        //44842
        RSInterface rsinterface = addInterface(47900);
        addSprite(47901, 0, "Slayer interface/Info");

        addHoverButton(47902, "Slayer interface/CLOSE", 1, 21, 21, "Close", -1, 47903, 3);
        addHoveredButton2(47903, "Slayer interface/CLOSE", 2, 21, 21, 47904);

        addHoverText(47905, "Back", "Back", tda, 0, 0xFF9900, true, true, 83, 18);
        addHoverText(47906, "Confirm", "Confirm", tda, 0, 0xFF9900, true, true, 83, 18);

        rsinterface.totalChildren(15);

        int y = 104;

        for (int i = 0; i < 10; i++) {
            addText(47907 + i, "asdfas", tda, i == 0? 1 : 0, 0xFF9900, true, true);

            rsinterface.child(i+5, 47907 + i, 246, y);
            y += 15;
        }

        rsinterface.child(0, 47901, 12, 20);
        rsinterface.child(1, 47902, 472, 27);
        rsinterface.child(2, 47903, 472, 27);

        rsinterface.child(3, 47905, 161 - 13, 265);
        rsinterface.child(4, 47906, 279 - 13, 265);

    }

    public static void buyInterface(TextDrawingArea[] tda) {
        RSInterface rsinterface = addInterface(47700);
        addSprite(47701, 0, "Slayer interface/Buy/buy");

        //addHoverButton(47702, "Slayer interface/CLOSE", 1, 21, 21, "Close", -1, 47703, 3);
        //addHoveredButton2(47703, "Slayer interface/CLOSE", 2, 21, 21, 47704);

        addHoverText(27405, "Unlock", "Unlock", tda, 0, 0xFF9900, true, true, 82, 16);
        addHoverText(27406, "Extend", "Extend", tda, 0, 0xFF9900, true, true, 82, 16);
        addHoverText(27407, "Buy", "Buy", tda, 0, 0xFF9900, true, true, 82, 16);
        addHoverText(27408, "Task", "Task", tda, 0, 0xFF9900, true, true, 82, 16);

        addToItemGroup(47706, 5, 4, 60, 40, true, "Info","Buy 1","Buy 5","Buy 10");

        rsinterface.totalChildren(9);
        rsinterface.child(0, 47701, 12, 20);
        rsinterface.child(1, 47902, 472, 27);
        rsinterface.child(2, 47903, 472, 27);
        rsinterface.child(3, 48505, 455, 61);
        rsinterface.child(4, 47706, 58, 81);

        rsinterface.child(5, 27405, 52-15-12, 61);
        rsinterface.child(6, 27406, 134-12-12, 61);
        rsinterface.child(7, 27407, 228-19-12, 61);
        rsinterface.child(8, 27408, 308-14-12, 61);
    }

    public static void taskInterface(TextDrawingArea[] tda) {
        RSInterface rsinterface = addInterface(47800);
        addSprite(47801, 0, "Slayer interface/Task/task");

        //addHoverButton(47802, "Slayer interface/CLOSE", 1, 21, 21, "Close", -1, 47803, 3);
       // addHoveredButton2(47803, "Slayer interface/CLOSE", 2, 21, 21, 47804);

        addText(48809, "Black Demons x230", tda, 1, 0xFFFFFF, true, true);

        addHoverText(48810, "Cancel task", "Cancel", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48811, "Block task", "Block", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48812, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48813, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48814, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48815, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48816, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);
        addHoverText(48817, "Unblock task", "Unblock task", tda, 0, 0xFF9900, true, true, 57);

        addText(48818, "", tda, 1, 0xFFFFFF, true, true);
        addText(48819, "", tda, 1, 0xFFFFFF, true, true);
        addText(48820, "", tda, 1, 0xFFFFFF, true, true);
        addText(48821, "", tda, 1, 0xFFFFFF, true, true);
        addText(48822, "", tda, 1, 0xFFFFFF, true, true);
        addText(48823, "", tda, 1, 0xFFFFFF, true, true);


        rsinterface.totalChildren(23);
        rsinterface.child(0, 47801, 12, 20);
        rsinterface.child(1, 47902, 472, 27);
        rsinterface.child(2, 47903, 472, 27);
        rsinterface.child(3, 48505, 455, 61);

        rsinterface.child(4, 27405, 52-15-12, 61);
        rsinterface.child(5, 27406, 134-12-12, 61);
        rsinterface.child(6, 27407, 228-19-12, 61);
        rsinterface.child(7, 27408, 308-14-12, 61);

        rsinterface.child(8, 48809, 149, 144);
        rsinterface.child(9, 48810, 310, 144);
        rsinterface.child(10, 48811, 410, 144);
        rsinterface.child(11, 48812, 384, 186);
        rsinterface.child(12, 48813, 384, 208);
        rsinterface.child(13, 48814, 384, 230);
        rsinterface.child(14, 48815, 384, 252);
        rsinterface.child(15, 48816, 384, 274);
        rsinterface.child(16, 48817, 384, 296);
        rsinterface.child(17, 48818, 254, 186);
        rsinterface.child(18, 48819, 254, 208);
        rsinterface.child(19, 48820, 254, 230);
        rsinterface.child(20, 48821, 254, 252);
        rsinterface.child(21, 48822, 254, 274);
        rsinterface.child(22, 48823, 254, 296);
    }

    public static void unlockInterface(TextDrawingArea[] tda) {
        RSInterface rsinterface = addInterface(21_404);
        addSprite(21_405, 0, "Slayer interface/Unlock/1/unlock");

       // addHoverButton(21_406, "Slayer interface/CLOSE", 1, 21, 21, "Close", -1, 47503, 3);
       // addHoveredButton2(21_407, "Slayer interface/CLOSE", 2, 21, 21, 47504);

        rsinterface.totalChildren(9);
        rsinterface.child(0, 21_405, 12, 20);
        rsinterface.child(1, 47902, 472, 27);
        rsinterface.child(2, 47903, 472, 27);
        rsinterface.child(3, 48505, 455, 61);
        rsinterface.child(4, 21_408, 16, 78);

        rsinterface.child(5, 27405, 52-15-12, 61);
        rsinterface.child(6, 27406, 134-12-12, 61);
        rsinterface.child(7, 27407, 228-19-12, 61);
        rsinterface.child(8, 27408, 308-14-12, 61);

        Object[][] unlocks = {
                {20, false}, // imbue slayer helmet
                {6, true}, // malevolent masquerade
                {17, true}, // bigger and badder
        };

        RSInterface scrollInterface = addTabInterface(21_408);
        scrollInterface.scrollPosition = 0;
        scrollInterface.contentType = 0;
        scrollInterface.width = 280 + 182;
        scrollInterface.height = 220;
        int scrollExtension = unlocks.length >= 6 ? (((int) Math.ceil((unlocks.length - 6) / 2d)) * 64) : 0;
        scrollInterface.scrollMax = scrollInterface.height + 1 + scrollExtension;
        int x, y;
        int childrenCount = 0;
        for (Object[] unlock : unlocks)
            childrenCount += ((boolean) unlock[1]) ? 3 : 2;
        scrollInterface.totalChildren(childrenCount);

        int child = 0;
        int interfaceId = 21_409;

        for (int index = 0; index < unlocks.length; index++) {
            x = index % 2 * 227;
            y = index / 2 * 88;

            scrollInterface.child(child++, interfaceId, x + 6, y);
            addHoverButton(interfaceId++, "Slayer interface/Unlock/1/unlock", (int)unlocks[index][0], 224, 64, "Unlock", 0, interfaceId, 1);

            scrollInterface.child(child++, interfaceId, x + 6, y);
            addHoveredButton2(interfaceId++, "Slayer interface/Unlock/2/unlock", (int)unlocks[index][0], 224, 64, interfaceId++);

            if ((boolean) unlocks[index][1]) {
                scrollInterface.child(child++, interfaceId, x + 42 + 6, y + 15);
                addConfigSprite(interfaceId++, 1, "Slayer interface/check", 2, "Slayer interface/check", 1, 880 + index);
            }
        }
    }

    public static void extendInterface(TextDrawingArea[] tda) {
        RSInterface rsinterface = addInterface(47600);
        addSprite(47601, 0, "Slayer interface/Extend/1/extend");

        //addHoverButton(47602, "Slayer interface/CLOSE", 1, 21, 21, "Close", -1, 47603, 3);
        //addHoveredButton2(47603, "Slayer interface/CLOSE", 2, 21, 21, 47604);

        addText(48505, "1300", tda, 0, 0xFF9900, false, true);

        rsinterface.totalChildren(9);
        rsinterface.child(0, 47601, 12, 20);
        rsinterface.child(1, 47902, 472, 27);
        rsinterface.child(2, 47903, 472, 27);
        rsinterface.child(3, 48505, 455, 61);
        rsinterface.child(4, 47606, 16, 78);

        rsinterface.child(5, 27405, 52-15-12, 61);
        rsinterface.child(6, 27406, 134-12-12, 61);
        rsinterface.child(7, 27407, 228-19-12, 61);
        rsinterface.child(8, 27408, 308-14-12, 61);

        int[] extensions = {
                11, // blood veld
                14, // dust devil
                16, // gargoyle
                17, // nech
                19, //kraken
                9, // greater demon
                10, // black demon
        };

        RSInterface scrollInterface = addTabInterface(47606);
        scrollInterface.scrollPosition = 0;
        scrollInterface.contentType = 0;
        scrollInterface.width = 280 + 182;
        scrollInterface.height = 220;
        scrollInterface.scrollMax = scrollInterface.height + 1 + (((int) Math.ceil((extensions.length - 6) / 2d)) * 64);
        int x, y;
        scrollInterface.totalChildren(extensions.length * 3);
        int interfaceId = 47607;
        int child = 0;

       for (int index = 0; index < extensions.length; index++) {
           x = index % 2 * 227;
           y = index / 2 * 67;
           addHoverButton(interfaceId++, "Slayer interface/Extend/1/extend", extensions[index], 224, 64, "Extend", 0, interfaceId, 1);
           addHoveredButton2(interfaceId++, "Slayer interface/Extend/2/extend", extensions[index], 224, 64, interfaceId++);
           addConfigSprite(interfaceId++, 1, "Slayer interface/check", 2, "Slayer interface/check", 1, 899 + index);
           scrollInterface.child(child++, interfaceId-4, x + 6, y);
           scrollInterface.child(child++, interfaceId-3, x + 6, y);
           scrollInterface.child(child++, interfaceId-1, x + 42 + 6, y + 15);
       }
    }

}
