package com.example.Sketch1.Kernel.Contracts;

/**
 * Created with IntelliJ IDEA.
 * User: Рома
 * Date: 22.06.13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point Subtract(Vector vector) {
        return new Point(x - vector.x, y - vector.y);
    }

    public Vector Subtract(Point other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    public Point Add(Vector offset) {
        return new Point(this.x + offset.x, this.y + offset.y);
    }
}
