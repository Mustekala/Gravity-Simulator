/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Game;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GameUI {

    public Parent getView() {      
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(1200, 1000);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Game game = new Game(gc);
        
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
        Label massText = new Label("Mass:");
        TextField mass = new TextField();
        Label sizeText = new Label("Size:");
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
            game.addCelestialObject("star", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(xSpeed.getText()), Integer.parseInt(ySpeed.getText()), Integer.parseInt(mass.getText()), Integer.parseInt(size.getText()));
        });
        
        addPlanetButton.setOnAction((event) -> {
            game.addCelestialObject("planet", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Integer.parseInt(xSpeed.getText()), Integer.parseInt(ySpeed.getText()), Integer.parseInt(mass.getText()), Integer.parseInt(size.getText()));
        });

        root.setLeft(addObjectsMenu);
        root.setCenter(canvas);
                
        return root;
    }
       
}
