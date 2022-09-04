/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphical;

import Shapes.Circle;
import Shapes.Line;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.ShapeDecorator;
import Shapes.ShapeFactory;
import Shapes.Square;
import Shapes.Triangle;
import Shapes.selectRectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener, MouseMotionListener {

    Color currentColor = Color.BLACK;
    Shape selectedShape = null;

    int mode = 0;//0 for line 1 for rect
    int x1, y1;
    int x2, y2;//dynamic stack of shapes
    boolean filled;//if the value of filled is false so it is not filled

    ArrayList<Shape> myShape = new ArrayList<Shape>();
    ArrayList<Shape> Selection = new ArrayList<Shape>();
    private ArrayList<Shape> clearedShapes = new ArrayList<Shape>(); //dynamic stack of cleared shapes from undo
    private Shape currentShapeObject; //stores the current shape object

    public Board() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentShapeObject = null;
        for (int i = 0; i < myShape.size(); i++) {
            myShape.get(i).draw(g);
            if (!Selection.isEmpty() && Selection.get(0) instanceof selectRectangle) {
                Selection.get(0).draw(g);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        filled = GUI.fill;
        x1 = me.getX();
        y1 = me.getY();
        if (mode == 0) {
            ShapeFactory f = new ShapeFactory();
            Line l = (Line) f.CreateLine(x1, y1, x1, y1, currentColor);
            myShape.add(l);
            repaint();
        } else if (mode == 1) {
            ShapeFactory f = new ShapeFactory();
            Rectangle r = (Rectangle) f.CreateRectangle(x1, y1, x1, y1, currentColor, filled);
            myShape.add(r);
            repaint();
        } else if (mode == 2) {
            ShapeFactory f = new ShapeFactory();
            Circle c = (Circle) f.CreateCircle(x1, y1, x1, y1, currentColor, filled);
            myShape.add(c);
            repaint();
        } else if (mode == 3) {
            // Triangle t = new Triangle(x1, y1, x1, y1, currentColor);
            ShapeFactory f = new ShapeFactory();
            Triangle t = (Triangle) f.CreateTriangle(x1, y1, x1, y1, currentColor, filled);
            myShape.add(t);
            repaint();
        } else if (mode == 4) {
            ShapeFactory f = new ShapeFactory();
            Square s = (Square) f.CreateSquare(x1, y1, x1, y1, currentColor, filled);
            myShape.add(s);
            repaint();
        } else if (mode == 5) {
            selectRectangle s = new selectRectangle(x1, y1, x1, y1, currentColor);
            Selection.add(s);
            repaint();
        } else if (mode == 6) {
            select();
        } else if (mode == 7) {
            select();
        } else if (mode == 8) {
            try {
                Shape s = copy(select());
                myShape.add(s);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (mode == 0) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = myShape.get(myShape.size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }

            repaint();
            //first = false;
        } else if (mode == 1) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = myShape.get(myShape.size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 2) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = myShape.get(myShape.size() - 1);
            if (s instanceof Circle) {
                Circle r = (Circle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 3) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = myShape.get(myShape.size() - 1);
            if (s instanceof Triangle) {
                Triangle r = (Triangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 4) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = myShape.get(myShape.size() - 1);
            if (s instanceof Square) {
                Square r = (Square) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 5) {
            x2 = me.getX();
            y2 = me.getY();
            Shape s = Selection.get(Selection.size() - 1);
            if (s instanceof selectRectangle) {
                selectRectangle r = (selectRectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        } else if (mode == 6) {
            x2 = me.getX();
            y2 = me.getY();
            if (selectedShape != null) {
                Shape r = (Shape) selectedShape;
                r.setX1(r.getX1() + x2 - x1);
                r.setY1(r.getY1() + y2 - y1);
                x1 = x2;
                y1 = y2;
                repaint();
            }
        } else if (mode == 7) {
            x2 = me.getX();
            y2 = me.getY();
            ShapeDecorator s  = new ShapeDecorator();
            s.move(selectedShape, x1, y1, x2, y2);
            x1=x2;
            y1=y2;
            repaint();
        } else if (mode == 8) {
            try {
                Shape s = copy(select());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public void clearLastShape() {
        //System.out.println("in undo");
        if (!myShape.isEmpty()) {
            clearedShapes.add(myShape.get(myShape.size() - 1));
            myShape.remove(myShape.size() - 1);
            repaint();
        } else {
            redoLastShape();
        }
    }

    /**
     * Redo the last shape cleared if clearedShapes is not empty It calls
     * repaint() to redraw the panel.
     */
    public void redoLastShape() {
        //System.out.println("in redo");
        if (!clearedShapes.isEmpty()) {
            myShape.add(clearedShapes.get(clearedShapes.size() - 1));
            clearedShapes.remove(clearedShapes.size() - 1);
            repaint();
        } else {
            clearLastShape();
        }
    }

    /**
     * Remove all shapes in current drawing. Also makes clearedShapes empty
     * since you cannot redo after clear. It called repaint() to redraw the
     * panel.
     */
    public void clearDrawing() {
        myShape.clear();
        Selection.clear();
        clearedShapes.clear();
        repaint();
    }

    public boolean checkSelect(int x1, int x2, int y1, int y2) {
        if (!Selection.isEmpty()) {
            java.awt.Rectangle r = new java.awt.Rectangle(Selection.get(0).getX1(), Selection.get(0).getY1(),
                    Math.abs(Selection.get(0).getX1() - Selection.get(0).getX2()),
                    Math.abs(Selection.get(0).getY2() - Selection.get(0).getY1()));

            if (r.contains(x1, y1) && r.contains(x2, y2)) {
                return true;
            }

        }
        return false;
    }

    public Shape select() {
        Iterator<Shape> it = myShape.iterator();
        while (it.hasNext()) {
            Shape sh = it.next();
            if (checkSelect(sh.getX1(), sh.getX2(), sh.getY1(), sh.getY2())) {
                selectedShape = sh;
            }

        }
        Selection.clear();
        return selectedShape;
    }

    public void Delete(Shape shape) {
        if (!myShape.isEmpty()) {
            clearedShapes.add(shape);
            myShape.remove(shape);
            repaint();
        }
    }

    public Shape copy(Shape shape) throws CloneNotSupportedException {
        Shape sha = (Shape) shape.clone();
        return sha;
    }

}
