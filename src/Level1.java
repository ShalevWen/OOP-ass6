// 329238919 Shalev Wengrowsky

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The information of level 1.
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(0, 15));
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
        return "Direct Hit";
    }

    @Override
    public LevelBackground getBackground() {
        return new Level1Background();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(380, 180, 40, 40, Color.RED));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
