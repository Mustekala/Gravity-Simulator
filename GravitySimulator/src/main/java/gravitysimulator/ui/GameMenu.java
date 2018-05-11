/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.domain.CelestialObject;
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
 * Game menu provides functionality to add objects into the system, and to save the system
 * @author eero
 * 
 */
public class GameMenu {
    
    Game game;
    Save save;
    GameUI gameUI;
    CelestialObjectUI objectUI;
   
    /**
     *
     * @param game the game 
     * @param objectUI ui to show object info on. Updated in gameUI.
     * @throws Exception if database connection fails in Save class
     */
    public GameMenu(Game game, CelestialObjectUI objectUI) throws Exception {
        this.game = game;  
        this.save = new Save();
        this.gameUI = game.getUi();
        this.objectUI = objectUI;
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
        Button modifyObjectButton = new Button("Modify selected object");
        Button followObjectButton = new Button("Follow selected object");
        
        addObjectsMenu.getChildren().add(nameText);
        addObjectsMenu.getChildren().add(name);
        
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
        addObjectsMenu.getChildren().add(modifyObjectButton);
        addObjectsMenu.getChildren().add(followObjectButton);
        
        //Info menu
        SubScene infoMenu = objectUI.getScene();
                   
        //Saving menu
        VBox bottonMenu = new VBox();
        bottonMenu.setSpacing(5);
        bottonMenu.setPadding(new Insets(5, 5, 5, 5));
        Label saveText = new Label("");
        Button pauseButton = new Button("Pause game");
        Button saveButton = new Button("Save current game");
        
        bottonMenu.getChildren().addAll(pauseButton, saveText, saveButton);
        
        //Button's events
        addStarButton.setOnAction((event) -> {
            //Add star to the center of gameUI
            gameUI.addCelestialObject(game.createCelestialObject("star", name.getText(), 0, 0, Double.parseDouble(xSpeed.getText()),
                    Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()), Integer.parseInt(priority.getText())));
        });
        
        addPlanetButton.setOnAction((event) -> {
            gameUI.addCelestialObject(game.createCelestialObject("planet", name.getText(), 0, 0, Double.parseDouble(xSpeed.getText()),
                    Double.parseDouble(ySpeed.getText()), Double.parseDouble(mass.getText()), Double.parseDouble(size.getText()), Integer.parseInt(priority.getText())));
        });
        
        modifyObjectButton.setOnAction((event) -> {
            CelestialObject o = gameUI.selectedObject;
            if (o != null) {            
                if (!name.getText().isEmpty()) {
                    o.setName(name.getText());
                }
                if (!xSpeed.getText().isEmpty()) {
                    o.setXSpeed(Double.parseDouble(xSpeed.getText()));
                }
                if (!ySpeed.getText().isEmpty()) {
                    o.setYSpeed(Double.parseDouble(ySpeed.getText()));
                }
                if (!mass.getText().isEmpty()) {
                    o.setMass(Double.parseDouble(mass.getText()));
                }
                if (!mass.getText().isEmpty()) {
                    o.setMass(Double.parseDouble(mass.getText()));
                }
                if (!size.getText().isEmpty()) {
                    o.setSize(Double.parseDouble(size.getText()));
                }
            }
        });
        
        followObjectButton.setOnAction((event) -> {
            gameUI.followMode = !gameUI.followMode;
        });
        
        //Pause the game
        pauseButton.setOnAction((event) -> {
            if (game.isPaused()) {
                game.startUpdate();
            } else {
                game.stop();
            }         
        });
        //Save the game using DAO
        saveButton.setOnAction((event) -> {
            try {
                save.saveGame(game.getObjects());
                saveText.textProperty().setValue("Game saved");
            } catch (SQLException ex) {
                Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        menu.setTop(addObjectsMenu);
        menu.setCenter(infoMenu);
        menu.setBottom(bottonMenu);
                      
        SubScene menuScene = new SubScene(menu, 200, 775);
   
        return menuScene;
    }
}