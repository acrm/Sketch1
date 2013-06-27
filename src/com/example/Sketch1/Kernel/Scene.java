package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.IGraphicsContext;
import com.example.Sketch1.Kernel.Contracts.Point;

import java.util.*;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 9:16
 * To change this template use File | Settings | File Templates.
 */
public class Scene implements Drawable {
    private List<PhysicalPoint> points;
    private Point origin;
    private SceneCoordinateConverter coordinateConverter;

    public Scene(Point origin) {
        this.origin = origin;
        coordinateConverter = new SceneCoordinateConverter(origin);

        points = new Vector<PhysicalPoint>();
    }
    
    public void AddPoint(PhysicalPoint point) {
        points.add(point);
    }

    @Override
    public void Draw(IGraphicsContext context) {
        CoordinateConverter formerConverter = context.GetCoordinateConverter();
        context.SetCoordinateConverter(coordinateConverter);

        for(PhysicalPoint point : points) {
            point.Draw(context);
        }

        context.SetCoordinateConverter(formerConverter);
    }
}
