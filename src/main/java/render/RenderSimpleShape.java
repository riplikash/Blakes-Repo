package render;

import math.Point2D;
import shapes.SimplePolygon;
import shapes.SimpleShape;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class RenderSimpleShape {
    public static void renderTriangle(GL2 gl, SimplePolygon t) {
        gl.glBegin(GL.GL_TRIANGLES);
        List<Point2D> displayList = t.getDisplayList();
        for (Point2D point : displayList){
            gl.glColor3d(point.getRed(), point.getGreen(), point.getBlue());
            gl.glVertex2d(point.getX(), point.getY());
        }
        gl.glEnd();
    }

    public static void renderSimpleShape(GL2 gl, SimpleShape t) {
        gl.glBegin(GL.GL_TRIANGLES);
        List<Point2D> displayList = t.getDisplayList();
        for (Point2D point : displayList){
            gl.glColor3d(point.getRed(), point.getGreen(), point.getBlue());
            gl.glVertex2d(point.getX(), point.getY());
        }
        gl.glEnd();
    }
}
