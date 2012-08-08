package controlInterface;

import singletons.CommandQueue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyKeyListener implements KeyListener {
    public MyKeyListener() {};

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        System.out.println(keyEvent.getKeyCode() + " was pressed");
        CommandQueue.getSingletonObject().addCommand(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {



    }


}