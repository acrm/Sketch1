package com.example.Sketch1;

import android.content.res.Resources;
import android.graphics.*;
import android.view.SurfaceHolder;
import com.example.Sketch1.Kernel.Contracts.Point;
import com.example.Sketch1.Kernel.Scene;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class DrawThread extends Thread {
    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private Resources resources;
    private Bitmap picture;
    private Matrix matrix;
    private long prevTime;

    public DrawThread(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;

        // сохраняем текущее время
        prevTime = System.currentTimeMillis();
    }

    public void setRunning(boolean run) {
        runFlag = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (runFlag) {
            // получаем текущее время и вычисляем разницу с предыдущим
            // сохраненным моментом времени
            long now = System.currentTimeMillis();
            long elapsedTime = now - prevTime;
            if (elapsedTime > 20){
                // если прошло больше 30 миллисекунд - сохраним текущее время
                // и повернем картинку на 2 градуса.
                // точка вращения - центр картинки
                prevTime = now;
                //matrix.preRotate(5.0f, picture.getWidth() / 2, picture.getHeight() / 2);
            }
            canvas = null;
            try {
                synchronized (surfaceHolder) {
                    canvas = surfaceHolder.lockCanvas(null);

                    GraphicsContext graphicsContext = new GraphicsContext(canvas, resources);
                    int x = canvas.getWidth() / 2;
                    int y = canvas.getHeight() / 2;

                    Scene scene = new Scene(new Point(x, y));
                    scene.draw(graphicsContext);
                }
            }
            finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
