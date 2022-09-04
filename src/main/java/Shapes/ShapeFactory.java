/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Color;

public class ShapeFactory {
    public Shape CreateLine(int x1,int y1, int x2, int y2, Color color ) {
        Shape s = null;
            s = new Line( x1, y1,  x2,  y2,  color );
        
        return s;
    }
    
    public Shape CreateCircle(int x1,int y1, int x2, int y2, Color color,boolean filled ) {
        Shape z = null;
            z = new Circle(x1, y1,  x2,  y2,  color,filled  );
        
        return z;
    }
    public Shape CreateSquare(int x1,int y1, int x2, int y2, Color color,boolean filled ) {
        Shape a = null;
            a = new Square( x1, y1,  x2,  y2,  color, filled  );
        
        return a;
    }
    public Shape CreateRectangle(int x1,int y1, int x2, int y2, Color color,boolean filled ) {
        Shape n = null;
            n = new Rectangle( x1, y1, x2, y2,color,filled );
         
        return n;
    }
    public Shape CreateTriangle(int x1, int y1, int x2, int y2, Color color,boolean filled ) {
        Shape o = null;
            o = new Triangle( x1, y1,  x2,  y2,  color,filled  );
        
        return o;
    }

}
