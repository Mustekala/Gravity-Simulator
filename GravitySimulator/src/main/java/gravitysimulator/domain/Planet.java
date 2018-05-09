/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

/**
 *
 * @author eero
 * Planet is the subclass for all planets in game
 */
public class Planet extends CelestialObject {
     
    Integer imageType = 2;
     
    public Planet(int id, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size, int priority) {
        super(id, name, x, y, xSpeed, ySpeed, mass, size, priority);
        super.imageType = imageType;
    }
    
    @Override
    public String getType() {
        return "planet";
    }
}
