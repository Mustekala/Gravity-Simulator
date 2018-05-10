/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import javafx.geometry.Insets;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author eero
 * Shows info about currently selected celestialObject
 */
public class CelestialObjectUI {
    //TODO private
    public Label name;
    public Label type;
    public Label x;
    public Label y;
    public Label mass;
    public Label size;
    
    public CelestialObjectUI() {
        this.name = new Label("");
        this.type = new Label("Type: ");
        this.x = new Label("X: ");
        this.y = new Label("Y: ");
        this.mass = new Label("Mass: ");
        this.size = new Label("Size: ");
    }
    
    public SubScene getScene() {
	BorderPane info = new BorderPane();
        
	VBox texts = new VBox();
	texts.setSpacing(10);
	texts.setPadding(new Insets(5, 5, 5, 5));
        
        texts.getChildren().add(name);
        texts.getChildren().add(type);
        
        texts.getChildren().add(x);
        texts.getChildren().add(y);
        
        texts.getChildren().add(mass);
        texts.getChildren().add(size);
              
        info.setCenter(texts);
        
        SubScene infoScene = new SubScene(info, 200, 200);
        
        return infoScene;
    }
}
