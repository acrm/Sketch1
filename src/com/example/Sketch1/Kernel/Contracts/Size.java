package com.example.Sketch1.Kernel.Contracts;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 22.06.13
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
public class Size {
    public int x;
    public int y;

    public Vector GetVectorToCenter() {
        return new Vector(x / 2, y / 2);
    }
}
