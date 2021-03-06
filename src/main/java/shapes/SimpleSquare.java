package shapes;

import math.Point2D;
import math.SimpleColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSquare extends SimpleShape{
    public SimpleSquare(Point2D translation, Point2D scale, SimpleColor color)
    {
        super(translation, scale, color);
        points = new ArrayList<Point2D>();
        points.add(new Point2D(-1, 1, color));
        points.add(new Point2D(1, 1, color));
        points.add(new Point2D(-1, -1, color));

        points.add(new Point2D(-1, -1, color));
        points.add(new Point2D(1, 1, color));
        points.add(new Point2D(1, -1, color));
    }

    @Override
    public List<Point2D> getDisplayList() {
        return getTransformedPoints();
    }
}
