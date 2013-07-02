package com.example.Sketch1.Kernel;

import com.example.Sketch1.Kernel.Contracts.*;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 22.06.13
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class PhysicalPoint implements Drawable {
    private Point coordinate;

    private Size size;

    private Color normalColor;
    private Color selectedColor;
    private Color actualColor;

    @Override
    public void draw(IGraphicsContext context) {
        Point topLeft = coordinate.Subtract(new Vector(size.x / 2, size.y / 2));
        context.fillEllipse(topLeft, size, actualColor);
    }

    public void place(Point coordinate) {
        this.coordinate = coordinate;
    }

    public void Select() {
        actualColor = selectedColor;
    }

    public void Unselect() {
        actualColor = normalColor;
    }
}
