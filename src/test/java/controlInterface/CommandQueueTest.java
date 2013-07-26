package controlInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;
import static com.jogamp.newt.event.KeyEvent.*;

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
        CommandQueue.getCommandQueue().addCommand(VK_UP);

    }

    @After
    public void tearDown() throws Exception {
        CommandQueue.getCommandQueue().clearQueue();
    }

    @Test
    public void testGetSingletonObject() throws Exception {
        CommandQueue CQ = CommandQueue.getCommandQueue();
        assertEquals(true, CQ != null);
    }

    @Test
    public void testGetQueue() throws Exception {
        LinkedList<Short> testQueue = CommandQueue.getCommandQueue().getQueue();
        assertEquals(1, testQueue.size());
    }

    @Test
    public void testAddCommand() throws Exception {
        CommandQueue.getCommandQueue().addCommand(VK_DOWN);
        CommandQueue.getCommandQueue().addCommand(VK_LEFT);
        LinkedList<Short> testQueue = CommandQueue.getCommandQueue().getQueue();
        assertEquals(new Short(VK_UP), testQueue.get(0));
        assertEquals(new Short(VK_DOWN), testQueue.get(1));
        assertEquals(new Short(VK_LEFT), testQueue.get(2));
    }

    @Test
    public void testClearQueue() throws Exception {
        CommandQueue.getCommandQueue().clearQueue();
        LinkedList<Short> testQueue = CommandQueue.getCommandQueue().getQueue();
        assertEquals(0, testQueue.size());

    }

    @Test
    public void testPullCommand() {
        CommandQueue.getCommandQueue().addCommand(VK_DOWN);
        Short i = CommandQueue.getCommandQueue().pullCommand();
        assertEquals(new Short(VK_UP), i);
        LinkedList<Short> list = CommandQueue.getCommandQueue().getQueue();
        assertEquals(1, list.size());
        assertEquals(new Short(VK_DOWN), list.get(0));

    }
}
