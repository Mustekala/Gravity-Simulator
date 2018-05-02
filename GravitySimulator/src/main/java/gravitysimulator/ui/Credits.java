/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author eero
 */
public class Credits {
    
    public Credits() {}
    
    public Parent getView(Parent previous) {
	BorderPane layout = new BorderPane();
        
	VBox buttons = new VBox();

	VBox texts = new VBox();
	texts.setSpacing(10);
	
        texts.getChildren().add(new Label("Programming"));
        texts.getChildren().add(new Label("Eero Lumijärvi"));
        
        texts.getChildren().add(new Label("Images"));
        texts.getChildren().add(new Label("--"));
        
        texts.getChildren().add(new Label("Music"));
        texts.getChildren().add(new Label("--"));
        
        layout.setTop(texts);
	layout.setCenter(buttons);

        return layout;
    }
}
