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
    public double x;
    public double y;
    public double xSpeed;
    public double ySpeed;
    
    public Integer mass;
    public Integer size;
    public Image image;
      
    public CelestialObject(String name, int x, int y, double xSpeed, double ySpeed, int mass, int size) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.mass = mass;
        this.size = size;           
    }
    
    public Position returnPosition() {
        return new Position(x, y);
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
