/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.image.Image;

/**
 *
 * @author eero
 */

public class CelestialObject {
    
    public String name;
    private double x;
    private double y;
    public double xSpeed;
    public double ySpeed;
    
    public double mass;
    public double size;
    public String image;
    
    //Todo
    public int priority;
    
    public CelestialObject(String name, int x, int y, double xSpeed, double ySpeed, double mass, double size) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.mass = mass;
        this.size = size;           
    }
    
    public double getX() {
        return x;
    };
    
    public double getY() {
        return y;
    };
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    };
    
    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    };
}
