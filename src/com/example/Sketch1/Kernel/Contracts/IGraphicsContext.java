package com.example.Sketch1.Kernel.Contracts;

import com.example.Sketch1.Kernel.CoordinateConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 22.06.13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public interface IGraphicsContext {
    void SetCoordinateConverter(CoordinateConverter converter);
    CoordinateConverter GetCoordinateConverter();

    void FillEllipse(Point topLeft, Size size, Color color);

    void DrawText(String text, Point topLeft, Color color);

    void Clear();
}
