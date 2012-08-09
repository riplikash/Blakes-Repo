package gameEngine;

import javax.media.opengl.GLAutoDrawable;

public interface GameEngineInterface {
    public void update();
    public void init();
    public void render(GLAutoDrawable drawable);
    public void dispose();
}
