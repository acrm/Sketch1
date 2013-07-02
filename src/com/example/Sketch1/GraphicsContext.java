package com.example.Sketch1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceHolder;
import com.example.Sketch1.Kernel.Contracts.Color;
import com.example.Sketch1.Kernel.Contracts.IGraphicsContext;
import com.example.Sketch1.Kernel.Contracts.Point;
import com.example.Sketch1.Kernel.Contracts.Size;
import com.example.Sketch1.Kernel.CoordinateConverter;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 28.06.13
 * Time: 0:01
 * To change this template use File | Settings | File Templates.
 */
public class GraphicsContext implements IGraphicsContext {

    private final Canvas canvas;
    private Resources resources;

    public GraphicsContext(Canvas canvas, Resources resources){
        this.canvas = canvas;
        this.resources = resources;

    }

    @Override
    public void setCoordinateConverter(CoordinateConverter converter) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CoordinateConverter getCoordinateConverter() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fillEllipse(Point topLeft, Size size, Color color) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void drawText(String text, Point topLeft, Color color) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clear() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Bitmap getImage(int resourceId) {
        return BitmapFactory.decodeResource(resources, resourceId);
    }

    @Override
    public void drawColor(int color) {
        canvas.drawColor(color);
    }

    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix) {
        canvas.drawBitmap(bitmap, matrix, null);
    }
}
