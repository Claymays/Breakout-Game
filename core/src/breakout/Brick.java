package breakout;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import java.util.*;

enum brickColors {
    NAVY
    , PURPLE
    , YELLOW
    , RED
    , ORANGE
    , GREY
    , BROWN
    , BABY_BLUE
    , DARK_GREEN
    , LIGHT_GREEN;
}

public class Brick {
    Rectangle brick;
    boolean hasItem;
    boolean broken;
    brickColors color;


    public Brick(float x, float y, int i) {
        this.brick = new Rectangle(x, y, 40, 20);
        this.broken = false;
        this.hasItem = MathUtils.random(1, 6) == 1;

        switch (i) {
            case 1: this.color = brickColors.NAVY; break;
            case 2:  this.color = brickColors.BROWN; break;
            case 3:  this.color = brickColors.GREY; break;
            case 4:  this.color = brickColors.DARK_GREEN; break;
            case 5:  this.color = brickColors.LIGHT_GREEN; break;
            case 6:  this.color = brickColors.BABY_BLUE; break;
            case 7:  this.color = brickColors.RED; break;
            case 8:  this.color = brickColors.PURPLE; break;
            case 9:  this.color = brickColors.YELLOW; break;
            case 10:  this.color = brickColors.ORANGE; break;

        }
    }

    public void destroy() {
        this.broken = false;
    }
}
