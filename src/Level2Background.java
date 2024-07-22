// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 2.
 */
public class Level2Background extends LevelBackground {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.decode("0xefe7b3"));
        for (int i = 0; i < 100; i++) {
            d.drawLine(160, 130, -10 + i * 8, 250);
        }
        d.fillCircle(160, 130, 60);
        d.setColor(Color.decode("0xebd849"));
        d.fillCircle(160, 130, 50);
        d.setColor(Color.decode("0xfee117"));
        d.fillCircle(160, 130, 40);
    }
}
