import controlInterface.MyKeyListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/9/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DapperEngineTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        DapperEngine testEngine = new DapperEngine(new GameEngine(), new MyKeyListener(), new DapperSettings());
        testEngine.start();

        while (true)
        {

        }





    }
}
