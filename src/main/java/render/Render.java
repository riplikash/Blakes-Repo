package render;

import objects.SimpleObject;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

public class Render {
    public Render() {
    }

    public void render(GLAutoDrawable drawable, SimpleObject square) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // draw a triangle filling the window

        RenderSimpleShape.renderSimpleShape(gl, square.getShape());
    }
}