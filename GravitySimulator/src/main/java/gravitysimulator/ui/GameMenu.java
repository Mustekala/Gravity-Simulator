/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.domain.Game;
import javafx.geometry.Insets;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author eero
 */
public class GameMenu {
    
    Game game;
    
    public GameMenu(Game game) {
        this.game = game;
    }
    
    public SubScene getScene() {      
        BorderPane menu = new BorderPane();

        VBox addObjectsMenu = new VBox();
        addObjectsMenu.setSpacing(5);
        addObjectsMenu.setPadding(new Insets(5, 5, 5, 5));
        
        //Add objects-menu
        Label menuText = new Label("Add objects");
        Label nameText = new Label("Name:");
        TextField name = new TextField();
        Label xText = new Label("x:");
        TextField x = new TextField();
        Label yText = new Label("y:");
        TextField y = new TextField();
        Label xSpeedText = new Label("xSpeed");
        TextField xSpeed = new TextField();
        Label ySpeedText = new Label("ySpeed");
        TextField ySpeed = new TextField();
        Label massText = new Label("Mass (in Yg):");
        TextField mass = new TextField();
        Label sizeText = new Label("Size (pixel = 1000km):");
        TextField size = new TextField();
        
        Button addStarButton = new Button("Add star");
        Button addPlanetButton = new Button("Add planet");
        
        addObjectsMenu.getChildren().add(nameText);
        addObjectsMenu.getChildren().add(name);
        
        addObjectsMenu.getChildren().add(xText);
        addObjectsMenu.getChildren().add(x);
        
        addObjectsMenu.getChildren().add(yText);
        addObjectsMenu.getChildren().add(y);
        
        addObjectsMenu.getChildren().add(xSpeedText);
        addObjectsMenu.getChildren().add(xSpeed);
        
        addObjectsMenu.getChildren().add(ySpeedText);
        addObjectsMenu.getChildren().add(ySpeed);
        
        addObjectsMenu.getChildren().add(massText);
        addObjectsMenu.getChildren().add(mass);
        
        addObjectsMenu.getChildren().add(sizeText);
        addObjectsMenu.getChildren().add(size);
        
        addObjectsMenu.getChildren().add(addStarButton);
        addObjectsMenu.getChildren().add(addPlanetButton);
        
        //Button's events
        addStarButton.setOnAction((event) -> {
            game.addCelestialObject("star", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Double.parseDouble(xSpeed.getText()), Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()));
        });
        
        addPlanetButton.setOnAction((event) -> {
            game.addCelestialObject("planet", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Double.parseDouble(xSpeed.getText()), Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()));
        });
        
        game.addCelestialObject("star", "sun", 400, 300, 0, 0, 100, 100);
        game.addCelestialObject("planet", "earth", 400, 500, 2.9, 0, 5.56, 20);
        
        menu.setLeft(addObjectsMenu);
          
        SubScene menuScene = new SubScene(menu, 200, 800);
   
        return menuScene;
    }
}