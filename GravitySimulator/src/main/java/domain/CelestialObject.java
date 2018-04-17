/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author eero
 */

public class CelestialObject {
    
    private String name;
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;
    
    private double mass;
    private double size;
    String image;
    
    //Todo
    public int priority;
    
    public CelestialObject(String name, int x, int y, double xSpeed, double ySpeed, double mass, double size) {
        this.name = name;
        this.x = x;
        this.y = y;
        //Pixels per iteration
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        //mass * 10x24, in Yottagrams
        this.mass = mass;
        this.size = size;           
    }
    
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
