// 329238919 Shalev Wengrowsky

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        } else {
            for (String level : args) {
                switch (level) {
                    case "1":
                        levels.add(new Level1());
                    case "2":
                        levels.add(new Level2());
                    case "3":
                        levels.add(new Level3());
                    case "4":
                        levels.add(new Level4());
                    default:
                }
            }
        }
        GUI gui = new GUI("Arkanoid", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui, 60), gui.getKeyboardSensor());
        gameFlow.runLevels(levels);
        gui.close();
    }
}
