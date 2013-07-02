package com.example.Sketch1.Kernel;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.example.Sketch1.Kernel.Contracts.IGraphicsContext;
import com.example.Sketch1.R;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 01.07.13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class Star extends PhysicalPoint implements DynamicObject{
    private float angle;

    @Override
    public void draw(IGraphicsContext context) {
        Bitmap picture = context.getImage(R.drawable.btn_star_big_on);

        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 1.0f);
        matrix.postTranslate(100.0f, 100.0f);
        matrix.preRotate(angle, picture.getWidth() / 2, picture.getHeight() / 2);

        context.drawColor(android.graphics.Color.BLUE);
        context.drawBitmap(picture, matrix);
    }

    @Override
    public void act(IActualContext context) {
        angle = (float)(context.getCurrentSeconds() * 180);
    }
}
