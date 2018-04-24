/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.domain.Game;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class GameUI {
    
    Game game;
    
    public GameUI(Game game) {
        this.game = game;
    }
    
    public SubScene getScene() {      
        BorderPane gamePane = new BorderPane();
        
        Canvas canvas = new Canvas(1000, 800);
        
        BackgroundImage space = new BackgroundImage(new Image("/images/space.jpg",1000,1000,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
              BackgroundSize.DEFAULT);
        gamePane.setBackground(new Background(space));
        
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gamePane.setCenter(canvas);

        SubScene gameScene = new SubScene(gamePane, 1000, 800);
        
        //TODO controls
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(0);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        gameScene.setCamera(camera);

        game.startUpdate();
        game.startDraw(gc);
        
        return gameScene;
    }

}