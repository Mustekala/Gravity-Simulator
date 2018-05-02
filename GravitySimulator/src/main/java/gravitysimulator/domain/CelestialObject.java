/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

/**
 *
 * @author eero
 * CelestialObject is the superclass for all objects in game
 */

public class CelestialObject {
    
    private Integer id;
    private final String name;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;
    
    private final double mass;
    private final double size;
    String image;
    
    //Todo
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
     
    public double getX() {
        return x;
    };
    
    public double getY() {
        return y;
    };
    
    public double getXSpeed() {
        return xSpeed;
    };
    
    public double getYSpeed() {
        return ySpeed;
    };
    
    public double getMass() {
        return mass;
    };
    
    public double getSize() {
        return size;
    };
    
    public int getPriority() {
        return priority;
    };
    
    public String getImage() {
        return image;
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
