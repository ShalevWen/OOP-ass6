// 329238919 Shalev Wengrowsky

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The information of level 3.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(-50, 5));
        list.add(Velocity.fromAngleAndSpeed(50, 5));
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
        return "Green 3";
    }

    @Override
    public LevelBackground getBackground() {
        return new Level3Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        for (int i = 0; i < colors.length; i++) {
            for (int j = i; j < 10; j++) {
                blocks.add(new Block(275 + 50 * j, 150 + 20 * i, 50, 20, colors[i]));
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
