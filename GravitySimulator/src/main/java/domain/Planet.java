/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.image.Image;

/**
 *
 * @author eero
 */
public class Planet extends CelestialObject {
          
    public Image image = new Image("/images/planets/earth.png", 100, 100, true, true) {};
     
    public Planet(String name, int x, int y, int xSpeed, int ySpeed, int mass, int size) {
        super(name, x, y, xSpeed, ySpeed, mass, size);
        super.image = image;
    }

}
