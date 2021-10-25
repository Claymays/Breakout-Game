package breakout;

import com.badlogic.gdx.math.MathUtils;

public class BrickBlock {
    Brick[][] bricks;
    public BrickBlock(float xPosition, float yPosition, int x, int y) {
        this.bricks = new Brick[y][x];
        for (int i = 0; i < y; i++) {
            int random = MathUtils.random(1, 10);
            for (int j = 0; j < x; j++) {
                this.bricks[i][j] = new Brick(xPosition + (j*40), yPosition + (i*20), random);
            }
        }
    }
}
