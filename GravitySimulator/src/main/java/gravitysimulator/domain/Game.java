/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author eero
 */
public final class Game {
    
    public ArrayList<CelestialObject> objects;
    private AnimationTimer draw;
    private AnimationTimer update;

    public Game() {
        objects = new ArrayList<>();
    }
    
    private void load(GraphicsContext gc) {
        
    }
    
    public void startDraw(GraphicsContext gc) {      
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);      
        draw = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, 1000, 1000);
                int i = 2;
                for (CelestialObject o : objects) {    
                    Image image = new Image(o.image);
                    gc.drawImage( image, (int) o.getX() - o.getSize() / 2, (int) o.getY() - o.getSize() / 2, o.getSize(), o.getSize());
                    //Print info of object TODO Add these to a separate ui
                    gc.fillText("Objects:", 0, 600);
                    //Name
                    gc.fillText(o.getName(), 40 * i, 600);
                    //X
                    gc.fillText("X:", 0, 615);
                    gc.fillText(Integer.toString((int) o.getX()), 40 * i, 615);
                    //Y
                    gc.fillText("Y:", 0, 630);
                    gc.fillText(Integer.toString((int) o.getY()), 40 * i, 630);
                    //Mass
                    gc.fillText("Mass (Yg):", 0, 645);
                    gc.fillText(Integer.toString((int) o.getMass()), 40 * i, 645);
                    i++;
                }                
            }
        };   
        draw.start();
    }
    
    public void startUpdate() {

        update = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                //Calculate gravity for all objects
                objects.forEach((o1) -> {
                    objects.forEach((o2) -> {  
                        if (!o1.equals(o2)) {                           
                            //Newton's gravity law, allmost. Everything is somewhat smaller
                            double G = 6.674 * Math.pow(10, -11);
                            //mass in Kg
                            long mass = (long) (o2.getMass() * Math.pow(10, 15));
                            //distance in m
                            double distance = Math.abs(Math.pow(Math.pow(o2.getX() - o1.getX(), 2) + (Math.pow(o2.getY() - o1.getY(), 2)), 0.5)) * Math.pow(10, 6);
                            double pullForce = G * (mass / distance);
                            //Angle of the gravity force
                            double angle = Math.atan2(o2.getY() - o1.getY(), o2.getX() - o1.getX());
                            //Apply gravity in an angle
                            o1.setSpeed(o1.getXSpeed() + pullForce * Math.cos(angle), o1.getYSpeed() + pullForce * Math.sin(angle));
                        }
                    });
                    //Move the object
                    o1.setPosition(o1.getX() + o1.getXSpeed(), o1.getY() + o1.getYSpeed());
                });  
            }
        };
        update.start();
    }
    
    public void stop() {
        draw.stop();
        update.stop();
    }
    
    public Boolean addCelestialObject(String type, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size) {
        String fixedName = name;
        
        //Todo actual amount
        if (findCelestialObject(name) != null) {            
            fixedName = fixedName + "1";
        }
        
        switch (type) {
            case "star":
                objects.add(new Star(name, x, y, xSpeed, ySpeed, mass, size));
                break;
            case "planet":
                objects.add(new Planet(name, x, y, xSpeed, ySpeed, mass, size));
                break;
            default:
                return false;
        }
        return true;
    }
    
    public Boolean removeCelestialObject(String name) {
        return objects.remove(findCelestialObject(name));
    }
    
    public CelestialObject findCelestialObject(String name) {
        for (CelestialObject o : this.objects) {
            if (name.equals(o.getName())) {
                return o;
            }
        }
        return null;
    }
}
