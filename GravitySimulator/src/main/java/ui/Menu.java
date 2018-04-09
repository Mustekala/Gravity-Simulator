/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author eero
 */
public class Menu {
    
    public Menu() {
        
    }
    
    public Parent getView() {
	BorderPane layout = new BorderPane();
        
	VBox buttons = new VBox();
	buttons.setSpacing(50);
        
        Button newGameButton = new Button("New game");
	buttons.getChildren().add(newGameButton);
	
        Button loadSaveButton = new Button("Load save");
	buttons.getChildren().add(loadSaveButton);
	
        Button creditsButton = new Button("Credits");
	buttons.getChildren().add(creditsButton);
        
        buttons.setAlignment(Pos.CENTER);

        
	HBox texts = new HBox();
	texts.setSpacing(10);
	texts.getChildren().add(new Label("Menu"));
        
        layout.setTop(texts);
	layout.setCenter(buttons);

        return layout;
    }
    
}
