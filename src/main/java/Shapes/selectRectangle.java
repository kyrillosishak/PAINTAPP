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
 * @author kerog
 */
public class selectRectangle extends Shape {

    private int x1, y1;
    private int x2, y2;

    public selectRectangle(int x1, int y1, int x2, int y2, Color color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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

    public boolean contains(int x1, int y1, int x2, int y2) {
        java.awt.Rectangle r = new java.awt.Rectangle(this.x1, this.y1, Math.abs(this.x1 - this.x2), Math.abs(this.y2 - this.y1));
        if (r.contains(x1, y1) && r.contains(x2,y2)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
                if (getX1() < getX2() && getY1() < getY2()) {
                    g.drawRect(getX1(), getY1(), getX2() - getX1(), getY2() - getY1());
                } else if (getX1() > getX2() && getY1() > getY2()) {
                    g.drawRect(getX2(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                } else if (getX1() < getX2() && getY1() > getY2()) {
                    g.drawRect(getX1(), getY2(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                } else if (getX1() > getX2() && getY1() < getY2()) {
                    g.drawRect(getX2(), getY1(), Math.abs(getX2() - getX1()), Math.abs(getY2() - getY1()));
                }
    }
}
