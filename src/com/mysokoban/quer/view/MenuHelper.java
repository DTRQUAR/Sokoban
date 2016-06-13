package com.mysokoban.quer.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Qouer on 18.05.2016.
 */
public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {
        JMenu helpMenu = new JMenu("Помощь");
        menuBar.add(helpMenu);

        addMenuItem(helpMenu, "О программе", view);
    }

    public static void initLevelMenu(View view, JMenuBar menuBar) {
        JMenu levelMenu = new JMenu("Выбрать уровень");
        menuBar.add(levelMenu);

        addMenuItem(levelMenu, "1 уровень", view);
        addMenuItem(levelMenu, "2 уровень", view);
        addMenuItem(levelMenu, "3 уровень", view);
        addMenuItem(levelMenu, "4 уровень", view);
        addMenuItem(levelMenu, "5 уровень", view);
        addMenuItem(levelMenu, "6 уровень", view);
        addMenuItem(levelMenu, "7 уровень", view);
        addMenuItem(levelMenu, "8 уровень", view);
        addMenuItem(levelMenu, "9 уровень", view);
        addMenuItem(levelMenu, "10 уровень", view);

//        addMenuItem(helpMenu, "11 уровень", view);
//        addMenuItem(helpMenu, "12 уровень", view);
//        addMenuItem(helpMenu, "13 уровень", view);
//        addMenuItem(helpMenu, "14 уровень", view);
//        addMenuItem(helpMenu, "15 уровень", view);
//        addMenuItem(helpMenu, "16 уровень", view);
//        addMenuItem(helpMenu, "17 уровень", view);
//        addMenuItem(helpMenu, "18 уровень", view);
//        addMenuItem(helpMenu, "19 уровень", view);
//        addMenuItem(helpMenu, "20 уровень", view);
//
//        addMenuItem(helpMenu, "21 уровень", view);
//        addMenuItem(helpMenu, "22 уровень", view);
//        addMenuItem(helpMenu, "23 уровень", view);
//        addMenuItem(helpMenu, "24 уровень", view);
//        addMenuItem(helpMenu, "25 уровень", view);
//        addMenuItem(helpMenu, "26 уровень", view);
//        addMenuItem(helpMenu, "27 уровень", view);
//        addMenuItem(helpMenu, "28 уровень", view);
//        addMenuItem(helpMenu, "29 уровень", view);
//        addMenuItem(helpMenu, "30 уровень", view);
//
//        addMenuItem(helpMenu, "31 уровень", view);
//        addMenuItem(helpMenu, "32 уровень", view);
//        addMenuItem(helpMenu, "33 уровень", view);
//        addMenuItem(helpMenu, "34 уровень", view);
//        addMenuItem(helpMenu, "35 уровень", view);
//        addMenuItem(helpMenu, "36 уровень", view);
//        addMenuItem(helpMenu, "37 уровень", view);
//        addMenuItem(helpMenu, "38 уровень", view);
//        addMenuItem(helpMenu, "39 уровень", view);
//        addMenuItem(helpMenu, "30 уровень", view);
//
//        addMenuItem(helpMenu, "41 уровень", view);
//        addMenuItem(helpMenu, "42 уровень", view);
//        addMenuItem(helpMenu, "43 уровень", view);
//        addMenuItem(helpMenu, "44 уровень", view);
//        addMenuItem(helpMenu, "45 уровень", view);
//        addMenuItem(helpMenu, "46 уровень", view);
//        addMenuItem(helpMenu, "47 уровень", view);
//        addMenuItem(helpMenu, "48 уровень", view);
//        addMenuItem(helpMenu, "49 уровень", view);
//        addMenuItem(helpMenu, "50 уровень", view);
//
//        addMenuItem(helpMenu, "51 уровень", view);
//        addMenuItem(helpMenu, "52 уровень", view);
//        addMenuItem(helpMenu, "53 уровень", view);
//        addMenuItem(helpMenu, "54 уровень", view);
//        addMenuItem(helpMenu, "55 уровень", view);
//        addMenuItem(helpMenu, "56 уровень", view);
//        addMenuItem(helpMenu, "57 уровень", view);
//        addMenuItem(helpMenu, "58 уровень", view);
//        addMenuItem(helpMenu, "59 уровень", view);
//        addMenuItem(helpMenu, "60 уровень", view);
    }
}
