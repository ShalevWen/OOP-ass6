// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 4.
 */
public class Level4Background extends LevelBackground {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("0x1787cf"));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(100 + 10 * i, 400, 60 + 10 * i, 600);
        }
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + 10 * i, 500, 570 + 10 * i, 600);
        }
        d.setColor(Color.decode("0xcccccc"));
        d.fillCircle(100, 400, 20);
        d.fillCircle(115, 415, 25);
        d.fillCircle(600, 500, 20);
        d.fillCircle(615, 530, 25);
        d.setColor(Color.decode("0xbbbbbb"));
        d.fillCircle(135, 390, 30);
        d.fillCircle(640, 500, 25);
        d.setColor(Color.decode("0xaaaaaa"));
        d.fillCircle(150, 420, 20);
        d.fillCircle(170, 400, 30);
        d.fillCircle(650, 520, 20);
        d.fillCircle(670, 515, 30);
    }
}
