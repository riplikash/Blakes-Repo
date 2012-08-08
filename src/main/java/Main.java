import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import controlInterface.MyKeyListener;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

public class Main implements GLEventListener {


    private final GameEngine gameEngine = new GameEngine();

    public static void main(String[] args) {

        GLWindow window = getNewtWindow();
        configureNewtWindow(window);
        addListenersToWindow(window);
        getAnimator(window).start();
    }

    private static FPSAnimator getAnimator(GLWindow window) {
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.add(window);
        return animator;
    }

    private static void addListenersToWindow(GLWindow window) {
        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
                System.exit(0);
            };
        });
        window.addGLEventListener(new Main());
        window.addKeyListener(new MyKeyListener());
    }

    private static void configureNewtWindow(GLWindow window) {
        window.setSize(600, 600);
        window.setVisible(true);
        window.setTitle("NEWT Window Test");
    }

    private static GLWindow getNewtWindow() {
        return GLWindow.create(new GLCapabilities(GLProfile.getDefault()));
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gameEngine.update();
        gameEngine.render(drawable);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gameEngine.init();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }





}