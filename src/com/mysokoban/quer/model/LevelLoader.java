package com.mysokoban.quer.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;

/**
 * Created by Qouer on 18.05.2016.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        StringWriter stringWriter = new StringWriter();
        HashSet<Wall> walls = new HashSet<>();
        HashSet<Box> boxes = new HashSet<>();
        HashSet<Home> homes = new HashSet<>();
        Player player = null;

        int tempLevel = level;

        if (tempLevel > 60) {
            tempLevel -= 60;
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line;
            String neededMaze = "Maze: " + tempLevel;
            boolean isNeededMaze = false;
            boolean isX = false;
            int countY = -1;

            while ((line = fileReader.readLine()) != null) {

                if (line.equals(neededMaze)) {
                    isNeededMaze = true;
                }

                if (isNeededMaze == true) {
                    if (line.equals("")) {
                        isX = true;
                    } else {
                        if (isX == true) {
                            if (line.equals("*************************************")) {
                                break;
                            }
                            countY++;
                            char[] chars = line.toCharArray();
                            int x0 = Model.FIELD_SELL_SIZE / 2 + 60;
                            int y0 = Model.FIELD_SELL_SIZE / 2 + 60;
                            for (int countX = 0; countX < chars.length; countX++) {
                                switch (chars[countX]) {
                                    case 'X':
                                        walls.add(new Wall(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE)
                                                );
                                        break;
                                    case '*':
                                        boxes.add(new Box(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE)
                                        );
                                        break;
                                    case '.':
                                        homes.add(new Home(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE)
                                        );
                                        break;
                                    case '@':
                                        player = new Player(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE);
                                        break;
                                    case '&':
                                        homes.add(new Home(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE)
                                        );
                                        boxes.add(new Box(
                                                x0 + countX * Model.FIELD_SELL_SIZE,
                                                y0 + countY*  Model.FIELD_SELL_SIZE)
                                        );break;

                                }
                            }
                            stringWriter.write(line + "\n");
                        }
                    }
                }
            }

//            System.out.println(stringWriter.toString());

            return new GameObjects(walls, boxes, homes, player);

        } catch (IOException e) {
            e.printStackTrace();
        }


        walls.add(new Wall(180, 180));
        walls.add(new Wall(140, 140));
        boxes.add(new Box(120, 120));
        boxes.add(new Box(220, 220));
        homes.add(new Home(40, 40));
        homes.add(new Home(300, 300));
        player = new Player(20, 20);

        return new GameObjects(walls, boxes, homes, player);

    }
}
