/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape implements Cloneable {

    private int x1, y1, x2, y2;
    private boolean filled = false;

    public Circle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.filled = filled;
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        int side = (Math.abs(x2 - x1)+ Math.abs(y2 - y1))/2;
        g.setColor(getColor());
        if (filled == false) {
            if (getX1() < getX2() && getY1() < getY2()) {
                g.drawOval(getX1(), getY1(), side, side);
            } else if (getX1() > getX2() && getY1() > getY2()) {
                g.drawOval(getX1() - side, getY1() - side, side, side);
            } else if (getX1() < getX2() && getY1() > getY2()) {
                g.drawOval(getX1(), getY1() - side, side, side);
            } else if (getX1() > getX2() && getY1() < getY2()) {
                g.drawOval(getX1() - side, getY1(), side, side);
            }
        } else {
             if (getX1() < getX2() && getY1() < getY2()) {
                g.fillOval(getX1(), getY1(), side, side);
            } else if (getX1() > getX2() && getY1() > getY2()) {
                g.fillOval(getX1() - side, getY1() - side, side, side);
            } else if (getX1() < getX2() && getY1() > getY2()) {
                g.fillOval(getX1(), getY1() - side, side, side);
            } else if (getX1() > getX2() && getY1() < getY2()) {
                g.fillOval(getX1() - side, getY1(), side, side);
            }
        }
    }

}
