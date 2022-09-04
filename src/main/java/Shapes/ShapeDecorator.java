/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class ShapeDecorator {

    Shape s;
    private int x1, x2;
    private int y1, y2;

    public void move(Shape selectedShape,int x1,int y1,int x2,int y2) {
        if (selectedShape != null) {
            Shape s1 = (Shape) selectedShape;

            s1.setX1(s1.getX1() + x2 - x1);
            s1.setY1(s1.getY1() + y2 - y1);
            s1.setX2(s1.getX2() + x2 - x1);
            s1.setY2(s1.getY2() + y2 - y1);
            
        }
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

    public ShapeDecorator() {
        

    }

   

//            if (selectedShape != null) {
//                Shape s1 = (Shape) selectedShape;
//
//                s1.setX1(s1.getX1() + x2 - x1);
//                s1.setY1(s1.getY1() + y2 - y1);
//                s1.setX2(s1.getX2() + x2 - x1);
//                s1.setY2(s1.getY2() + y2 - y1);
//                x1 = x2;
//                y1 = y2;
//                repaint();
//            } 
}
