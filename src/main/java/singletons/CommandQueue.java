package singletons;


import java.util.LinkedList;

public class CommandQueue {
    LinkedList<Integer> queue;

    private CommandQueue()
    {
        queue = new LinkedList<Integer>();
    }

    public static CommandQueue getSingletonObject()
    {
        if (ref == null)
            // it's ok, we can call this constructor
            ref = new CommandQueue();
        return ref;
    }

    public LinkedList<Integer> getQueue() {
        return queue;
    }

    public void addCommand(Integer i)
    {
        queue.addLast(i);
    }

    public void clearQueue()
    {
        queue = new LinkedList<Integer>();
    }

    public Integer pullCommand() {
        Integer rtInt = queue.getFirst();
        queue.removeFirst();
        return rtInt;
    }


    private static CommandQueue ref;
}
