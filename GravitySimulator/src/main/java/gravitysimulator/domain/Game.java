/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

import gravitysimulator.ui.GameUI;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;

/**
 *
 * @author eero
 * Game class updates and draws all the objects in the game.
 */
public final class Game {
    
    public ArrayList<CelestialObject> objects;
    private AnimationTimer update;
    private final GameUI ui;
    private int i = 0;
    private final Game game;
    private double gameSpeed = 0.01;
    
    public Game(GameUI ui) {
        this.ui = ui;
        objects = new ArrayList<>();
        game = this;
    }
    
    private void load() {
        
    }
 
    /**
    *
    *  Updates all the objects in the game.
    */
    public void startUpdate() {

        update = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                //Calculate gravity for all objects
                i++;
                objects.forEach((o1) -> {
                    if (i % o1.priority == 0) {
                        applyGravity(o1);
                    }    
                    //Move the object
                    o1.setPosition(o1.getX() + o1.getXSpeed(), o1.getY() + o1.getYSpeed());
                });
                ui.drawGame(game);
                 
            }               
        };
        update.start();
        ui.drawGame(game);
    }
    
    /**
    * Applies gravity to object
    * @param o1 the object to apply gravity to.
    */
    private void applyGravity(CelestialObject o1) {
            objects.forEach((o2) -> {  
            if (!o1.equals(o2)) {                           
                //Newton's gravity law, allmost. Everything is somewhat smaller
                //Gravitational constant
                double G = 6.674 * Math.pow(10, -11);
                //mass in Kg
                long mass = (long) (o2.getMass() * Math.pow(10, 15));
                //distance in m
                double distance = Math.abs(Math.pow(Math.pow(o2.getX() - o1.getX(), 2) + (Math.pow(o2.getY() - o1.getY(), 2)), 0.5)) * Math.pow(10, 6);
                //Gravity is multiplied by priority and gameSpeed
                double pullForce = G * (mass / distance) * o1.priority * gameSpeed;
                //Angle of the gravity force
                double angle = Math.atan2(o2.getY() - o1.getY(), o2.getX() - o1.getX());
                //Apply gravity in an angle
                o1.setSpeed(o1.getXSpeed() + pullForce * Math.cos(angle), o1.getYSpeed() + pullForce * Math.sin(angle));
            }
        });
        
    }
    
    /**
    * Stops updating the game
    */
    public void stop() {      
        update.stop();
    }
    
    public double getGameSpeed() {
        return this.gameSpeed;
    }
    
    public void changeGameSpeed(double speed) {
        this.gameSpeed = speed;
    }
    
    /**
    * Add object to the game
     * @param type type of the object
     * @param name name of the object
     * @param x x coordinate of the object
     * @param y y coordinate of the object
     * @param xSpeed the speed in x axis of the object
     * @param ySpeed the speed in y axis of the object
     * @param mass the mass of the object
     * @param size the size of the object
     * @param priority the update priority of the object (smaller = higher)
     * @return if the object was added
    */
    public Boolean addCelestialObject(String type, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size, int priority) {
        String fixedName = name;
        
        //Todo actual amount
        if (findCelestialObject(name) != null) {            
            fixedName = fixedName + objects.size();
        }
        
        int id = objects.size() - 1;
        
        switch (type) {
            case "star":
                objects.add(new Star(id, fixedName, x, y, xSpeed, ySpeed, mass, size, priority));
                break;
            case "planet":
                objects.add(new Planet(id, fixedName, x, y, xSpeed, ySpeed, mass, size, priority));
                break;
            default:
                return false;
        }
        return true;
    }
    
    /**
    * Remove object from the game
     * @param name name of the object
     * @return if the object was removed
    */
    public Boolean removeCelestialObject(String name) {
        return objects.remove(findCelestialObject(name));
    }
    
    /**
    * Find object in the game
     * @param name name of the object
     * @return o if the object was found null otherwise
    */
    public CelestialObject findCelestialObject(String name) {
        for (CelestialObject o : this.objects) {
            if (name.equals(o.getName())) {
                return o;
            }
        }
        return null;
    }
}
