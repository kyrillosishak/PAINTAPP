/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ahmed
 */
public class Square extends Shape implements Cloneable {

    private int x1, y1, x2, y2;
    private boolean filled = false;

    public Square(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.filled = filled;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int side = ((Math.abs(x2 - x1)+Math.abs(y2 - y1))/2);
        if (filled == false) {
            if (getX1() < getX2() && getY1() < getY2()) {
                g.drawRect(getX1(), getY1(), side, side);
            } else if (getX1() > getX2() && getY1() > getY2()) {
                g.drawRect(getX1() - side, getY1() - side, side, side);
            } else if (getX1() < getX2() && getY1() > getY2()) {
                g.drawRect(getX1(), getY1() - side, side, side);
            } else if (getX1() > getX2() && getY1() < getY2()) {
                g.drawRect(getX1() - side, getY1(), side, side);
            }
        } else {
            if (getX1() < getX2() && getY1() < getY2()) {
                g.fillRect(getX1(), getY1(), side, side);
            } else if (getX1() > getX2() && getY1() > getY2()) {
                g.fillRect(getX1() - side, getY1() - side, side, side);
            } else if (getX1() < getX2() && getY1() > getY2()) {
                g.fillRect(getX1(), getY1() - side, side, side);
            } else if (getX1() > getX2() && getY1() < getY2()) {
                g.fillRect(getX1() - side, getY1(), side, side);
            }
    
        }
    }
}
