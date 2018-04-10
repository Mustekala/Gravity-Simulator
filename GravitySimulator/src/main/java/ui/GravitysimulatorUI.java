/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author eero
 */
public class GravitysimulatorUI extends Application {
    
    @Override
    public void start(Stage window) {

        Credits credits = new Credits();
        GameUI game = new GameUI();
        
        BorderPane layout = new BorderPane();

	VBox menu = new VBox();
	menu.setSpacing(50);
        
        Button newGameButton = new Button("New game");
	menu.getChildren().add(newGameButton);
	
        Button loadSaveButton = new Button("Load save");
	menu.getChildren().add(loadSaveButton);
	
        Button creditsButton = new Button("Credits");
	menu.getChildren().add(creditsButton);
        
        menu.setAlignment(Pos.CENTER);
                 
	HBox top = new HBox();
	top.setSpacing(10);
        Button returnButton = new Button("Return to menu");
        
        top.getChildren().add(returnButton);
                 
        layout.setTop(top);
	layout.setCenter(menu);

        Scene view = new Scene(layout, 1200, 800);
        
        //Buttons
        newGameButton.setOnAction((event) -> layout.setCenter(game.getView()));
        
        creditsButton.setOnAction((event) -> layout.setCenter(credits.getView(layout)));
        
        returnButton.setOnAction((event) -> {;
            layout.setCenter(menu);
        });
        
	window.setScene(view);
	window.show();
    }
    
    public static void main(String[] args) {
        launch(GravitysimulatorUI.class);
    }

}