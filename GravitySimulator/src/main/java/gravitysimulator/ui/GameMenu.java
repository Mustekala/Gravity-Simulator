/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.dao.CelestialObjectDao;
import gravitysimulator.database.Database;
import gravitysimulator.domain.Game;
import gravitysimulator.domain.Save;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Game menu provides functionality to add objects into the system, and to save the system
 */
public class GameMenu {
    
    Game game;
    Save save;
    
    public GameMenu(Game game) throws Exception {
        this.game = game;  
        this.save = new Save();
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
        Label priorityText = new Label("Priority:");
        TextField priority = new TextField();
              
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
        
        addObjectsMenu.getChildren().add(priorityText);
        addObjectsMenu.getChildren().add(priority);
        
        addObjectsMenu.getChildren().add(addStarButton);
        addObjectsMenu.getChildren().add(addPlanetButton);
        
        //Saving menu
        VBox saveMenu = new VBox();
        saveMenu.setSpacing(5);
        saveMenu.setPadding(new Insets(5, 5, 5, 5));
        
        Button saveButton = new Button("Save current game");
        saveMenu.getChildren().add(saveButton);
        
        //Button's events
        addStarButton.setOnAction((event) -> {
            game.addCelestialObject("star", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Double.parseDouble(xSpeed.getText()),
                    Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()), Integer.parseInt(priority.getText()));
        });
        
        addPlanetButton.setOnAction((event) -> {
            game.addCelestialObject("planet", name.getText(), Integer.parseInt(x.getText()), Integer.parseInt(y.getText()), Double.parseDouble(xSpeed.getText()),
                    Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()), Integer.parseInt(priority.getText()));
        });
        
        //Save the game using DAO
        saveButton.setOnAction((event) -> {
            try {
                save.saveGame(game.objects);
            } catch (SQLException ex) {
                Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        menu.setLeft(addObjectsMenu);
        menu.setBottom(saveMenu);
        
        SubScene menuScene = new SubScene(menu, 200, 770);
   
        return menuScene;
    }
}