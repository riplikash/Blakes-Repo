import com.jogamp.opengl.util.FPSAnimator;
import controlInterface.MyKeyListener;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main implements GLEventListener {


    private final GameEngine gameEngine = new GameEngine();

    public static void main(String[] args) {
        GLCanvas canvas = getCanvas();
        createFrame(canvas);
        FPSAnimator animator = setUpCanvas(canvas);
        animator.start();
    }

    private static GLCanvas getCanvas() {
        return new GLCanvas(new GLCapabilities(GLProfile.getDefault()));
    }

    private static FPSAnimator setUpCanvas(GLCanvas canvas) {
        canvas.addGLEventListener(new Main());
        canvas.addKeyListener(new MyKeyListener());
        canvas.requestFocus();
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.add(canvas);
        return animator;
    }

    private static void createFrame(GLCanvas canvas) {
        Frame frame = new Frame("AWT Window Test");
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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