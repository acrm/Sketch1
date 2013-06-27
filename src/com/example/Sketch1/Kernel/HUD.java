package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.IGraphicsContext;
import com.example.Sketch1.Kernel.Contracts.*;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 23.06.13
 * Time: 9:46
 * To change this template use File | Settings | File Templates.
 */
public class HUD implements Drawable {

    private boolean isWelcomeScreen;

    @Override
    public void Draw(IGraphicsContext context) {
        if(isWelcomeScreen)
            context.DrawText("Welcome to the Game!", new Point(10, 50), Color.BLACK);
        else
            context.DrawText("HUD", new Point(0,0), Color.BLACK);
    }

    public void ShowWelcomeScreen() {
        isWelcomeScreen = true;
    }
}
