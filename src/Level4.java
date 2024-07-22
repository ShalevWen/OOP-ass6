// 329238919 Shalev Wengrowsky

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The information of level 4.
 */
public class Level4 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(-30, 5));
        list.add(Velocity.fromAngleAndSpeed(0, 5));
        list.add(Velocity.fromAngleAndSpeed(30, 5));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 60;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public LevelBackground getBackground() {
        return new Level4Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < 15; j++) {
                blocks.add(new Block(25 + 50 * j, 150 + 20 * i, 50, 20, colors[i]));
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
