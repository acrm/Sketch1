package com.example.Sketch1.Kernel.Contracts;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.example.Sketch1.Kernel.CoordinateConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 22.06.13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public interface IGraphicsContext {
    void setCoordinateConverter(CoordinateConverter converter);
    CoordinateConverter getCoordinateConverter();

    void fillEllipse(Point topLeft, Size size, Color color);

    void drawText(String text, Point topLeft, Color color);

    void clear();

    Bitmap getImage(int resourceId);

    void drawColor(int color);

    void drawBitmap(Bitmap bitmap, Matrix matrix);
}
