/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.CelestialObject;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {
    
    public ArrayList<CelestialObject> objects;
    
    public Parent getView() {
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        objects = new ArrayList<>();
        draw(gc);
        update();
        root.getChildren().add(canvas);
        return root;
    }
       
    private void draw(GraphicsContext gc) {
        
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        
        //Background image
        Image space = new Image( "images/space.jpg" );

        final long startNanoTime = System.nanoTime();
 
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
                gc.drawImage( space, 0, 0 );
                
                objects.forEach((o) -> {          
                    //double x = o.x + 128 * Math.cos(t);
                    //double y = o.y + 128 * Math.sin(t);
                    gc.drawImage( o.image, (int) o.x, (int) o.y );
                });
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
                            double pullForce = o1.mass * o2.mass / Math.pow(Math.pow(o2.x - o1.x, 2) + (Math.pow(o2.y - o1.y, 2)), 0.5) / 100;
                            //Angle of the gravity force
                            double angle = Math.atan2(o2.y - o1.y, o2.x - o1.x);
                            //Apply gravity in an angle
                            o1.setSpeed(o1.xSpeed + pullForce * Math.cos(angle), o1.ySpeed + pullForce * Math.sin(angle));
                        }
                    });
                });
                
                //Move all objects
                objects.forEach((o) -> {
                    o.setPosition(o.x + o.xSpeed, o.y + o.ySpeed);
                });
                
            }
        }.start();
    }
}
