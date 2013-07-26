package controlInterface;


import java.util.LinkedList;

public class CommandQueue {
    LinkedList<Short> queue;

    private CommandQueue()
    {
        queue = new LinkedList<Short>();
    }

    public static CommandQueue getCommandQueue()
    {
        if (ref == null)
            // it's ok, we can call this constructor
            ref = new CommandQueue();
        return ref;
    }

    public LinkedList<Short> getQueue() {
        return queue;
    }

    public void addCommand(Short i)
    {
        queue.addLast(i);
    }
    public void addCommand(short i)
    {
        queue.addLast(Short.valueOf(i));
    }

    public void clearQueue()
    {
        queue = new LinkedList<Short>();
    }

    public Short pullCommand() {
        Short rtInt = queue.getFirst();
        queue.removeFirst();
        return rtInt;
    }


    private static CommandQueue ref;
}
