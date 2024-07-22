// 329238919 Shalev Wengrowsky

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The information of level 2.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Velocity.fromAngleAndSpeed(-45 + i * 10, 5));
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 1;
    }

    @Override
    public int paddleWidth() {
        return 700;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public LevelBackground getBackground() {
        return new Level2Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW, Color.GREEN,
                Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE, Color.PINK, Color.PINK, Color.CYAN, Color.CYAN};
        for (int i = 0; i < colors.length; i++) {
            blocks.add(new Block(25 + 50 * i, 250, 50, 20, colors[i]));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
