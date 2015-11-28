/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemanagement.input;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Burak Ö
 */
public class InputManager implements MouseInputListener, KeyListener{

    private Point p;
    public char pressedKey;
    public boolean isMouseDragged = false;
    public boolean isMousePressed = false;
    public boolean isKeyPressed = false;
    
    public Point getPoint(int zoom){
        Point pa = new Point(this.p.x/zoom, this.p.y/zoom);
        return pa;
    }   

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
        isMousePressed = true;
        this.p = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
        isMousePressed = false;
        isMouseDragged = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.isMouseDragged = true;
        this.p = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        isKeyPressed = true;
        pressedKey = e.getKeyChar();
        System.out.println(e.getKeyChar() + " pressed.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isKeyPressed = false;
        System.out.println(e.getKeyChar() + " released.");
    }
}
