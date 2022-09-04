

package Shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author kerog
 */
public abstract class Shape implements Cloneable{
    private Color color;
    private int x1, y1;
    private int x2, y2;
    private boolean filled;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
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
   // public abstract boolean contains(int x1,int y1 , int x2 , int y2);
      public abstract void draw(Graphics g);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape s =(Shape)super.clone();
       return s;
    }

    /**
     * @return the filled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * @param filled the filled to set
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

}

