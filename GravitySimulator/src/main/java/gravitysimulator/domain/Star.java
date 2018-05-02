/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

/**
 *
 * @author eero
 */
public class Star extends CelestialObject {
    
    String image = "/images/stars/star1.png";
    
    public Star(int id, String name, int x, int y, double xSpeed, double ySpeed, double mass, double size, int priority) {
        super(id, name, x, y, xSpeed, ySpeed, mass, size, priority);    
        super.image = image;
    }
    
    @Override
    public String getType() {
        return "star";
    }
}