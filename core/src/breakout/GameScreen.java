package breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    Breakout game;
    OrthographicCamera camera;

    Rectangle paddle;
    Circle ball;
    boolean ballSet = true;
    float ballSpeed;
    float ballXSpeed;
    float ballYSpeed;
    float padLocation;
    BrickBlock block1;
    BrickBlock block2;
    BrickBlock block3;

    Texture padImg;
    Texture ballImg;
    Texture brick;

    public GameScreen(Breakout game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 700, 900);

        paddle = new Rectangle(camera.viewportWidth / 2, 100, 100, 20);
        ball = new Circle(paddle.x + paddle.width / 2, paddle.y + paddle.height, 30);
        block1 = new BrickBlock(camera.viewportWidth / 4, camera.viewportHeight / 2, 13, 10);
        ballSpeed = 5;
        ballYSpeed = 5;

        padImg = new Texture("Paddle.png");
        ballImg = new Texture("Pong Ball.png");
        brick = new Texture("button.png");

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        movePad();
        moveBall();

        game.batch.begin();
        game.batch.draw(padImg, paddle.x, paddle.y - (paddle.height / 2), paddle.width, paddle.height);
        game.batch.draw(ballImg, ball.x - ball.radius / 2, ball.y - ball.radius / 2, ball.radius, ball.radius);
        for (int y = 0; y < block1.bricks.length; y++) {
            for (int x = 0; x < block1.bricks[0].length; x++) {
                Brick tempBrick = block1.bricks[y][x];
                if (!tempBrick.broken) {
                    game.batch.draw(brick, tempBrick.brick.x, tempBrick.brick.y, 40, 20);
                }
            }
        }

        game.batch.end();
    }

    void movePad() {
        if (Gdx.input.isTouched()) {
            Vector3 mousePo = new Vector3();
            mousePo.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mousePo);
            paddle.x = mousePo.x - (paddle.width / 2);
//            if (Gdx.input.isKeyPressed(54) && ballSet) {
//                ballSet = false;
//                ball.y = ball.y + 1;
//            }
        }
    }

    void moveBall() {
//        if (ballSet) {
//            ball.x = paddle.x + (paddle.width / 2);
//            ball.y = paddle.y + paddle.height;
//        }
//        else {
//        ballXSpeed = ballSpeed;
            if (ball.y <= 0) {
                ballSet = true;
            }

            for (int y = 0; y < block1.bricks.length; y++) {
                for (int x = 0; x < block1.bricks[0].length; x++) {
                    Brick tempBrick = block1.bricks[y][x];

                    if (ball.x + ball.radius > tempBrick.brick.x
                            && ball.y + ball.radius > tempBrick.brick.y
                            && tempBrick.brick.y + tempBrick.brick.height > ball.y
                            && tempBrick.brick.x + tempBrick.brick.width > ball.x) {

                        if (ball.y == tempBrick.brick.y + tempBrick.brick.height) {
                            ballYSpeed = ballSpeed;
                        }
                        if (ball.y <= tempBrick.brick.y) {
                            ballYSpeed = -ballSpeed;
                        }
                        if (ball.x == tempBrick.brick.x + tempBrick.brick.width) {
                            ballXSpeed = ballSpeed;
                        }
                        if (ball.x == tempBrick.brick.x) {
                            ballXSpeed = -ballSpeed;
                        }
                    }
                }
            }
            ball.x += ballXSpeed;
            ball.y += ballYSpeed;

//        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
