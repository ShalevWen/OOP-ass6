// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 3.
 */
public class Level3Background extends LevelBackground {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("0x2a8214"));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.decode("0x444444"));
        d.fillRectangle(146, 175, 8, 200);
        d.setColor(Color.decode("0x333333"));
        d.fillRectangle(138, 375, 24, 200);
        d.setColor(Color.decode("0x222222"));
        d.fillRectangle(110, 425, 80, 200);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(115 + 15 * i, 430 + 35 * j, 10, 30);
            }
        }
        d.setColor(Color.ORANGE);
        d.fillCircle(150, 175, 11);
        d.setColor(Color.RED);
        d.fillCircle(150, 175, 7);
        d.setColor(Color.WHITE);
        d.fillCircle(150, 175, 3);
    }
}
