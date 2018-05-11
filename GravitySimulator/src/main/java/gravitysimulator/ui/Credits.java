/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 *
 * @author eero
 * Credits shows credits for CC-licensed stuff and for the creator :D
 */
public class Credits {
    
    public Credits() {}
    
    GraphicsContext gc;
    AnimationTimer updateCredits;
    int i = 0;
    
    /**
    *
    * Creates the credit layout
     * @return the credits layout 
    */  
    public Parent getView() {
        
        Canvas canvas = new Canvas(10000, 10000);
        
	BorderPane layout = new BorderPane();
        
        //Make the layout transparent 
        layout.setStyle("-fx-background-color: transparent; ");
        
        layout.setCenter(canvas);
        
        gc = canvas.getGraphicsContext2D();
       
        drawCredits();
        
        return layout;
    }
    
    public void drawCredits() {
        gc.setFill(Color.WHITE);
        gc.setLineWidth(5);        
        updateCredits = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, 1000, 800);
                gc.fillText("Programming: Eero Lumijärvi", 400, 800 - i);
                gc.fillText("Star image: farcodev\n" + "https://opengameart.org/content/far-colony-stars-pictures\n" + "Creative Commons 4.0 BY-SA", 400, 900 - i);
                gc.fillText("Space image: Josbert Lonnee \n" + "https://commons.wikimedia.org/wiki/File:Big_Dipper_rotated.JPG\n" + "Creative Commons 4.0 BY-SA", 400, 1000 - i);
                gc.fillText("Earth image: http://pngimg.com\n" + "Creative Commons 4.0 BY-NC", 400, 1100 - i);
                i++;
                if (i > 1200) {
                    updateCredits.stop();
                    i = 0;
                }
            }        
        };
        updateCredits.start();
    }
}
