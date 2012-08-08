package singletons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/8/12
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommandQueueTest {
    @Before
    public void setUp() throws Exception {
        CommandQueue.getSingletonObject().addCommand(11);

    }

    @After
    public void tearDown() throws Exception {
        CommandQueue.getSingletonObject().clearQueue();
    }

    @Test
    public void testGetSingletonObject() throws Exception {
        CommandQueue CQ = CommandQueue.getSingletonObject();
        assertEquals(true, CQ != null);
    }

    @Test
    public void testGetQueue() throws Exception {
        LinkedList<Integer> testQueue = CommandQueue.getSingletonObject().getQueue();
        assertEquals(1, testQueue.size());
    }

    @Test
    public void testAddCommand() throws Exception {
        CommandQueue.getSingletonObject().addCommand(22);
        CommandQueue.getSingletonObject().addCommand(33);
        LinkedList<Integer> testQueue = CommandQueue.getSingletonObject().getQueue();
        assertEquals(new Integer(11), testQueue.get(0));
        assertEquals(new Integer(22), testQueue.get(1));
        assertEquals(new Integer(33), testQueue.get(2));
    }

    @Test
    public void testClearQueue() throws Exception {
        CommandQueue.getSingletonObject().clearQueue();
        LinkedList<Integer> testQueue = CommandQueue.getSingletonObject().getQueue();
        assertEquals(0, testQueue.size());

    }

    @Test
    public void testPullCommand() {
        CommandQueue.getSingletonObject().addCommand(22);
        Integer i = CommandQueue.getSingletonObject().pullCommand();
        assertEquals(new Integer(11), i);
        LinkedList<Integer> list = CommandQueue.getSingletonObject().getQueue();
        assertEquals(1, list.size());
        assertEquals(new Integer(22), list.get(0));

    }
}
