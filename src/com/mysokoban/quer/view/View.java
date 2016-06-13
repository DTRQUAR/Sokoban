package com.mysokoban.quer.view;

import com.mysokoban.quer.controller.Controller;
import com.mysokoban.quer.controller.EventListener;
import com.mysokoban.quer.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);
        initMenuBar();
        setTitle("Сокобан");
        setVisible(true);


    }

    private void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initLevelMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void setEventListener(EventListener eventListener) {
        this.field.setEventListener(eventListener);
    }

    public void update() {
        field.repaint();
    }

    public GameObjects getGameObjects() {
        return controller.getGameObjects();
    }

    public void completed(int level) {
        this.update();
        JOptionPane.showMessageDialog(null, level + " уровень пройден", "Поздравляем", JOptionPane.INFORMATION_MESSAGE);
        this.controller.startNextLevel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {

            case "О программе":
                showAbout();
                break;
            case "1 уровень":
                controller.startMyLevel(1);
                break;
            case "2 уровень":
                controller.startMyLevel(2);
                break;
            case "3 уровень":
                controller.startMyLevel(3);
                break;
            case "4 уровень":
                controller.startMyLevel(4);
                break;
            case "5 уровень":
                controller.startMyLevel(5);
                break;
            case "6 уровень":
                controller.startMyLevel(6);
                break;
            case "7 уровень":
                controller.startMyLevel(7);
                break;
            case "8 уровень":
                controller.startMyLevel(8);
                break;
            case "9 уровень":
                controller.startMyLevel(9);
                break;
            case "10 уровень":
                controller.startMyLevel(10);
                break;
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "Игра Сокобан и ничего лишнего", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }
}
