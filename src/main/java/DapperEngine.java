import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import gameEngine.GameEngineInterface;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

public class DapperEngine implements GLEventListener {


    private final GameEngineInterface gameEngine;
    private final KeyListener keyListener;
    private final DapperSettings settings;

    public DapperEngine(GameEngineInterface newEngine, KeyListener newKeyListener, DapperSettings newSettings) {
        gameEngine = newEngine;
        keyListener = newKeyListener;
        settings = newSettings;

    }

    public void start() {
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        GLWindow glWindow = GLWindow.create(glCapabilities);
        final FPSAnimator fpsAnimator = new FPSAnimator(glWindow, settings.FPS, true);

        glWindow.addWindowListener(new WindowAdapter(){
            @Override
            public void windowDestroyNotify(WindowEvent e){
                new Thread(){
                    @Override
                    public void run(){
                        fpsAnimator.stop();
                        System.exit(0);
                    }
                }.start();
            };
        });

        glWindow.addGLEventListener(this);
        glWindow.addKeyListener(keyListener);
        glWindow.setTitle("'sup");
        glWindow.setSize(688, 800);
        glWindow.setVisible(true);

        fpsAnimator.start();
        /*GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        GLWindow glWindow = GLWindow.create(glCapabilities);
        int FPS = 60;
        final FPSAnimator fpsAnimator = new FPSAnimator(glWindow, FPS, true);

        GLWindow window = getNewtWindow();
        configureNewtWindow(window);
        addListenersToWindow(window);
        getAnimator(window).start();                                         */
    }

    private FPSAnimator getAnimator(GLWindow window) {
        FPSAnimator animator = new FPSAnimator(window, settings.FPS);
        animator.add(window);
        return animator;
    }

    private void addListenersToWindow(GLWindow window) {
        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
                System.exit(0);
            }
        });
        window.addGLEventListener(this);
        window.addKeyListener(keyListener);
    }

    private void configureNewtWindow(GLWindow window) {
        window.setSize(settings.windowWidth, settings.windowHeight);
        window.setVisible(true);
        window.setTitle(settings.windowTitle);
    }

    private GLWindow getNewtWindow() {
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