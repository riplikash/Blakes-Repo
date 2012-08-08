package singletons;

import shapes.SimpleSquare;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    public SimpleSquare square;
    private Game()
    {
    }

    public static Game getSingletonObject()
    {
        if (ref == null)
            // it's ok, we can call this constructor
            ref = new Game();
        return ref;
    }

    private static Game ref;
}
