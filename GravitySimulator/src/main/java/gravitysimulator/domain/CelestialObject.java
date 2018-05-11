/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

import javafx.scene.shape.Circle;

/**
 *
 * @author eero
 * CelestialObject is the superclass for all objects in game
 */

public class CelestialObject {
    
    private Integer id;
    private String name;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;
    
    private double mass;
    private double size; 
    
    Circle object;
       
    public int priority;
    
    CelestialObject(Integer id, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size, int priority) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        //Pixels per iteration
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        //mass * 10x24, in Yottagrams
        this.mass = mass;
        this.size = size;      
        object = new Circle(x, y, size / 2);
        this.priority = priority;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getType() {
        return null;
    };
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getX() {
        return x;
    };
    
    public double getY() {
        return y;
    };
    
    public double getXSpeed() {
        return xSpeed;
    };
    public void setXSpeed(double xSpeed){
        this.xSpeed = xSpeed;
    }
    public double getYSpeed() {
        return ySpeed;
    };
    public void setYSpeed(double ySpeed){
        this.ySpeed = ySpeed;
    }
    
    public double getMass() {
        return mass;
    };
    public void setMass(double mass) {
        this.mass = mass;
    };
    
    public double getSize() {
        return size;
    };
    public void setSize(double size) {
        this.size = size;
        object.setRadius(size / 2);
    };
    
    public int getPriority() {
        return priority;
    };
    
    public Circle getTarget() {
        return object;
    }
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        this.object.setCenterX(x);
        this.object.setCenterY(y);
    };
    
    public void setSpeed(double xSpeed, double ySpeed) {
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    };
}
