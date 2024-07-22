// 329238919 Shalev Wengrowsky

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 1.
 */
public class Level1Background extends LevelBackground {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        d.drawCircle(400, 200, 30);
        d.drawCircle(400, 200, 50);
        d.drawCircle(400, 200, 70);
        d.drawLine(400, 110, 400, 170);
        d.drawLine(400, 230, 400, 290);
        d.drawLine(310, 200, 370, 200);
        d.drawLine(430, 200, 490, 200);
    }
}
