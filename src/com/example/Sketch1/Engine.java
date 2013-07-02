package com.example.Sketch1;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import com.example.Sketch1.GraphicsContext;
import com.example.Sketch1.Kernel.*;
import com.example.Sketch1.Kernel.Contracts.Point;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */
public class Engine implements Runnable{
    private Thread actionThread;
    private Scene scene;
    private HUD hud;

    private boolean isStopping;
    private final SurfaceHolder surfaceHolder;
    private final Resources resources;
    private long prevTime;
    private int fpsRate;
    private double startTime;

    public Engine(SurfaceHolder surfaceHolder, Resources resources, int fpsRate) {
        this.surfaceHolder = surfaceHolder;
        this.resources = resources;
        this.fpsRate = fpsRate;

        Point sceneOrigin = getSceneOrigin(surfaceHolder.getSurfaceFrame());
        scene = new Scene(sceneOrigin);

        hud = new HUD();

        actionThread = new Thread(new Runnable() {
            @Override
            public void run() { run(); }
        });
    }

    private static Point getSceneOrigin(Rect frame) {
        return new Point(frame.centerX(), frame.centerX());
    }

    public void start() {
        init();

        isStopping = false;
        startTime = System.currentTimeMillis() / 1000;

        run();
    }

    public void stop() {
        isStopping = false;
    }

    private void init() {
        scene.addPoint(new Star());

        hud.showWelcomeScreen();
    }

    private void iteration(IActualContext actualContext, GraphicsContext graphicsContext) {
        Input input = getInput();
        scene.act(actualContext);


        graphicsContext.clear();
        scene.draw(graphicsContext);
        hud.draw(graphicsContext);
    }

    private Input getInput() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void run() {
        prevTime = System.currentTimeMillis();
        while (!isStopping) {
            final long now = System.currentTimeMillis();
            double elapsedTimeInSeconds = (now - prevTime)/1000;
            double refreshPeriod = 1.0 / fpsRate;

            if (elapsedTimeInSeconds < refreshPeriod) continue;

            Canvas canvas = null;
            try {
                synchronized (surfaceHolder) {
                    canvas = surfaceHolder.lockCanvas(null);

                    GraphicsContext graphicsContext = new GraphicsContext(canvas, resources);
                    IActualContext actualContext = new IActualContext(){
                        @Override
                        public double getCurrentSeconds() {
                            return now / 1000 - startTime;
                        }
                    };

                    iteration(actualContext, graphicsContext);
                }
            }
            finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            prevTime = now;
        }
    }
}

