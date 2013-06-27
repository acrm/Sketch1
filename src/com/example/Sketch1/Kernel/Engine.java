package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.IGraphicsContext;
import com.example.Sketch1.Kernel.Contracts.Point;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 9:35
 * To change this template use File | Settings | File Templates.
 */
public class Engine implements Runnable{
    private IGraphicsContext context;

    private Scene scene;
    private HUD hud;

    private boolean isStopping;

    public Engine(DeviceInfo deviceInfo, IGraphicsContext context) {
        this.context = context;

        Point sceneOrigin = getSceneOrigin(deviceInfo);
        scene = new Scene(sceneOrigin);

        hud = new HUD();
    }

    private static Point getSceneOrigin(DeviceInfo deviceInfo) {
        return new Point(0, 0).Add(deviceInfo.screenSize.GetVectorToCenter());
    }

    void Init() {
        PhysicalPoint point = new PhysicalPoint();
        point.Place(new Point(0, 0));

        scene.AddPoint(point);

        hud.ShowWelcomeScreen();
    }

    void Iteration() {
        Input input = GetInput();

        context.Clear();
        scene.Draw(context);
        hud.Draw(context);
    }

    private Input GetInput() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public void Start() {
        Init();
        run();
    }

    public void Stop() {
        isStopping = false;
    }

    @Override
    public void run() {
        isStopping = false;
        while (!isStopping) {
            Iteration();
        }
    }
}

