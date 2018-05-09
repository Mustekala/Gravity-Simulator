/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.domain.CelestialObject;
import gravitysimulator.domain.Game;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
* GameUI combines the game interface and the game menu
*/
public class GameUI {

    private GraphicsContext gc;
    
    public GameUI() {
    }
    
    /**
    * Returns the game as a SubScene
    * @return SubScene the game scene
    */
    public SubScene getScene() {      
        BorderPane gamePane = new BorderPane();
        
        Canvas canvas = new Canvas(1000, 800);
        
        BackgroundImage space = new BackgroundImage(new Image("/images/space.jpg",1000,1000,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
              BackgroundSize.DEFAULT);
        gamePane.setBackground(new Background(space));
        
        gc = canvas.getGraphicsContext2D();

        gamePane.setCenter(canvas);

        SubScene gameScene = new SubScene(gamePane, 1000, 800);
        
        //TODO controls
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(0);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        gameScene.setCamera(camera);

        gameScene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                System.out.println("Enter Pressed");
            }
        });
        
        return gameScene;
    }

        
    /**
    *
    *  Draws all the objects in the game.
     * @param game the game to draw
    */
    public void drawGame(Game game) {      
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);      
        gc.clearRect(0, 0, 1000, 1000);
        int i = 2;
        for (CelestialObject o : game.objects) {    
            Image image = new Image(o.getImage());
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

}