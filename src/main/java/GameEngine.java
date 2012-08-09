import controlInterface.CommandQueue;
import gameEngine.GameEngineInterface;
import math.Point2D;
import math.SimpleColor;
import math.SimplePhysics;
import objects.SimpleObject;
import render.Render;

import javax.media.opengl.GLAutoDrawable;
import java.util.LinkedList;

import static java.awt.event.KeyEvent.*;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/8/12
 * Time: 10:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameEngine implements GameEngineInterface {
    private final Render render = new Render();

    @Override
    public void update() {

        executeCommands();
        incrementGame();
//        Point2D theta = new Point2D(.004, 0.002);
//        triangle.translate(theta);
//        Game s = Game.getCommandQueue();
//        s.square.translation = s.square.translation.sum(new Point2D(-.001, 0.01));
    }

    SimpleObject square;

    @Override
    public void init() {

        square = new SimpleObject(new Point2D(0.0,0.0), new Point2D(.1, .1), SimpleColor.green());
        square.setBounciness(85);
    }

    public void incrementGame() {
        SimplePhysics.apply(square);
        square.increment();
    }

    public void executeCommands() {
        LinkedList<Integer> commandQueue = CommandQueue.getCommandQueue().getQueue();
        CommandQueue.getCommandQueue().clearQueue();


        for (Integer command: commandQueue)
        {
            switch (command)
            {
                case VK_UP:
                    jumpCommand();
                    break;
                case VK_SPACE:
                    jetCommand();
                case VK_DOWN:
                    downCommand();
                    break;
                case VK_LEFT:
                    runLeft();
                    break;
                case VK_RIGHT:
                    runRight();
                    break;
                case VK_ESCAPE:
                    escCommand();
                    break;
                case VK_W:
                    posYScale();
                    break;
                case VK_S:
                    negYScale();
                    break;
                case VK_A:
                    negXScale();
                    break;
                case VK_D:
                    posXScale();
                    break;
                case VK_K:
                    rotClock();
                    break;
                case VK_J:
                    rotCClock();
                    break;

            }
        }

    }

    private void jetCommand() {
        square.accel(0.0, 0.01);
    }

    private void runLeft() {
        if (square.getVector().getX() > -.05)
            square.accel(-0.005, 0.0);

    }

    private void runRight() {
        if (square.getVector().getX() < .05)
            square.accel(0.005, 0.0);
    }

    private void jumpCommand() {
        square.accel(0.0, 0.03);
    }

    private void rotCClock() {
        square.rotatationalAccel(.01);
    }

    private void rotClock() {
        square.rotatationalAccel(-.01);
    }

    private void posYScale() {
        square.scale(0.0,0.01);
    }

    private void negYScale() {
        square.scale(0.0,-0.01);
    }

    private void negXScale() {
        square.scale(-.01,0.0);
    }

    private void posXScale() {
        square.scale(.01,0.0);
    }

    private void escCommand() {
        System.exit(0);
    }

    private void rightCommand() {
        square.accel(0.001, 0.0);
    }

    private void leftCommand() {
        square.accel(-0.001, 0.0);
    }

    private void downCommand() {
        square.accel(0.0, -0.001) ;
    }

    private void upCommand() {
        square.accel(0.0, 0.001);
    }

    @Override
    public void render(GLAutoDrawable drawable) {
        render.render(drawable, square);

    }

    @Override
    public void dispose() {
    }


}
