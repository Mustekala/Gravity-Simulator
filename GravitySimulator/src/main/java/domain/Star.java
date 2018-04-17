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
public class Star extends CelestialObject {
    
    String image = "/images/stars/star1.png";
    
    public Star(String name, int x, int y, double xSpeed, double ySpeed, double mass, double size) {
        super(name, x, y, xSpeed, ySpeed, mass, size);    
        super.image = image;
    }

}
