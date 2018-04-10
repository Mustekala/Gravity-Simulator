/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
    
    //Prevent objects from going below 0, 0 by adding this to their coordinates TODO do better
    public int moveConstant = 0;
    
    public ArrayList<CelestialObject> objects;
    
    public Game(GraphicsContext gc) {
        objects = new ArrayList<>();
        draw(gc);
        update();
    }
    
    public Game() {
        objects = new ArrayList<>();
        update();
    }
    
    private void draw(GraphicsContext gc) {
        
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        
        //Background image
        Image space = new Image("/images/space.jpg");

        final long startNanoTime = System.nanoTime();
 
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                              
                gc.drawImage( space, 0, 0 );
                
                int i = 2;
                for (CelestialObject o : objects) {    
                    Image image = new Image(o.image);
                    gc.drawImage( image, (int) o.getX() - moveConstant - o.size / 2, (int) o.getY() - moveConstant - o.size / 2, o.size, o.size);
                    gc.fillText("Objects:", 0, 600);
                    gc.fillText(o.name, 40 * i, 600);
                    i++;
                };
                               
            }
        }.start();
        
    }
    
    public void update() {
        
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
                //Calculate gravity for all objects
                objects.forEach((o1) -> {
                    objects.forEach((o2) -> {  
                        if (!o1.equals(o2)) {                           
                            //Newton's gravity law, allmost
                            double pullForce = o2.mass / Math.abs(Math.pow(Math.pow(o2.getX() - o1.getX(), 2) + (Math.pow(o2.getY() - o1.getY(), 2)), 0.5)) / 100;
                            //Angle of the gravity force
                            double angle = Math.atan2(o2.getY() - o1.getY(), o2.getX() - o1.getX());
                            //Apply gravity in an angle
                            o1.setSpeed(o1.xSpeed + pullForce * Math.cos(angle), o1.ySpeed + pullForce * Math.sin(angle));
                        }
                    });
                });
                
                //Move all objects
                objects.forEach((o) -> {
                    o.setPosition(o.getX() + o.xSpeed, o.getY() + o.ySpeed);
                });
                
            }
        }.start();
    }
    
    public Boolean addCelestialObject(String type, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size) {
        String fixedName = name;
        
        if (findCelestialObject(name) != null) {            
            fixedName = fixedName + "1";
        }
        
        switch (type) {
            case "star":
                objects.add(new Star(name, x + moveConstant, y + moveConstant, xSpeed, ySpeed, mass, size));
                break;
            case "planet":
                objects.add(new Planet(name, x + moveConstant, y + moveConstant, xSpeed, ySpeed, mass, size));
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
            if (name.equals(o.name)) {
                return o;
            }
        }
        return null;
    }
}
