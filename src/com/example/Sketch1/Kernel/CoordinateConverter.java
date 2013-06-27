package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.Point;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public interface CoordinateConverter {
    Point Convert(Point point);
}
