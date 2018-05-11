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
 * Game class updates and handles calculations for all the objects in the game.
 * @author eero
 * 
 */
public final class Game {
    
    private ArrayList<CelestialObject> objects;
    //For removing objects after the loop has finished
    private ArrayList<CelestialObject> objectsToBeRemoved;
    
    private AnimationTimer update;
    private final GameUI ui;
    private int i = 0;
    //Give objects unique ids
    private int id = 0;
    private final Game game;
    private double gameSpeed = 0.005;
    private boolean isPaused;
    
    public Game(GameUI ui) {
        this.ui = ui;
        objects = new ArrayList<>();
        objectsToBeRemoved = new ArrayList<>();
        game = this;
    }
     
    private void load() {
        
    }
 
    /**
    *
    *  Updates all the objects in the game.
    */
    public void startUpdate() {
        isPaused = false;
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
                if (ui != null) {
                    ui.drawGame(game);
                }    
                removeObjectsToBeRemoved();
            }               
        };
        update.start();      
    }
    
    /**
    * Applies gravity to object
    * @param o1 the object to apply gravity to.
    */
    public void applyGravity(CelestialObject o1) {
        //If collisions happen, add objects to list       
        objects.forEach((o2) -> {  
            if (!o1.equals(o2)) {                           
                //Newton's gravity law, allmost. Everything is somewhat smaller
                //Gravitational constant
                double g = 6.674 * Math.pow(10, -11);
                //mass in Kg
                long mass = (long) (o2.getMass() * Math.pow(10, 15));
                //distance in m
                double distance = Math.abs(Math.pow(Math.pow(o2.getX() - o1.getX(), 2) + (Math.pow(o2.getY() - o1.getY(), 2)), 0.5)) * Math.pow(10, 6);
                //Gravity is multiplied by priority and gameSpeed
                double pullForce = g * (mass / distance) * o1.priority * gameSpeed;
                //Angle of the gravity force
                double angle = Math.atan2(o2.getY() - o1.getY(), o2.getX() - o1.getX());
                //Apply gravity in an angle
                o1.setSpeed(o1.getXSpeed() + pullForce * Math.cos(angle), o1.getYSpeed() + pullForce * Math.sin(angle));
                //Check collision
                objectsToBeRemoved.add(handleCollision(o1, o2, distance));
            }
        });       
    }
    
    public CelestialObject handleCollision(CelestialObject o1, CelestialObject o2, double distance) {
        if (distance < o1.getSize() * Math.pow(10, 6)) {
            if (o1.getMass() >= o2.getMass()) {
                o1.setMass(o1.getMass() + o2.getMass());
                o1.setSize(o1.getSize() + o2.getSize() / 2);
                return o2;
            } 
        }
        return null;
    }
    
    /**
    * Stops updating the game
    */
    public void stop() { 
        isPaused = true;
        update.stop();
    }
    
    public boolean isPaused() {
        return this.isPaused;
    }
    
    public double getGameSpeed() {
        return this.gameSpeed;
    }
    
    public void changeGameSpeed(double speed) {
        this.gameSpeed = speed;
    }
    
    /**
    * Create object for the game
     * @param type type of the object
     * @param name name of the object
     * @param x x coordinate of the object
     * @param y y coordinate of the object
     * @param xSpeed the speed in x axis of the object
     * @param ySpeed the speed in y axis of the object
     * @param mass the mass of the object
     * @param size the size of the object
     * @param priority the update priority of the object (smaller = higher)
     * @return the created object
    */
    public CelestialObject createCelestialObject(String type, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size, int priority) {
        String fixedName = name;       

        if (findCelestialObject(name) != null) {            
            fixedName = fixedName + objects.size();
        }
        CelestialObject object;        
        if (type.equals("star")) {     
            object = new Star(id, fixedName, x, y, xSpeed, ySpeed, mass, size, priority);
        } else {           
            object = new Planet(id, fixedName, x, y, xSpeed, ySpeed, mass, size, priority);
        }             
        id++;       
        return object;
    }
    
    /**
     * Add object to the game
     * @param o the object to add
     */
    public void addCelestialObject(CelestialObject o) {
        objects.add(o);
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
    * Remove object from the game
     * @param object object to be removed
     * @return if the object was removed
    */
    public Boolean removeCelestialObject(CelestialObject object) {
        return objects.remove(object);
    }
    
    public void removeObjectsToBeRemoved() {
        objects.removeAll(objectsToBeRemoved);
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

    public GameUI getUi() {
        return this.ui;
    }
 
    public void setObjects(ArrayList<CelestialObject> objects) {
        this.objects = objects;
    }
    
    public ArrayList<CelestialObject> getObjects() {
        return this.objects;
    }

}
