package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.Point;
import com.example.Sketch1.Kernel.Contracts.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
public class SceneCoordinateConverter implements CoordinateConverter {
    private Point origin;

    public SceneCoordinateConverter(Point origin) {
        this.origin = origin;
    }

    @Override
    public Point Convert(Point point) {
        Vector offset = origin.Subtract(new Point(0, 0));
        return point.Add(offset);
    }
}
