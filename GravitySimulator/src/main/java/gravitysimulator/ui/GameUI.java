/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.ui;

import gravitysimulator.domain.CelestialObject;
import gravitysimulator.domain.Game;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
* GameUI combines the game interface and the game menu
*/
public class GameUI {

    CelestialObjectUI objectUI;
    private GraphicsContext gc;
    private Image star;
    private Image planet;
    
    double mouseX, mouseY;
    double camX;
    double camY;
    
    //Mode to add objects using mouse
    boolean addCelestialObjectMode;
    CelestialObject objectToAdd;
    CelestialObject selectedObject;
    
    Game game;
    //Where to center the camera
    int cameraCenterX, cameraCenterY;
    
    public GameUI(CelestialObjectUI objectUI) {
        this.objectUI = objectUI;
        camY = 0;
        camX = 0;
    }
    
    /**
     *
     * @param game the game to load for UI use
     */
    public void loadGame(Game game) {
        this.game = game;
    }
    
    
    /**
    * Returns the game as a SubScene
    * @return SubScene the game scene
    */
    public SubScene getScene() {      
        BorderPane gamePane = new BorderPane();
        
        Canvas canvas = new Canvas(10000, 10000);

        loadImages();
        
        gc = canvas.getGraphicsContext2D();
        
        //Make the borderpane transparent 
        gamePane.setStyle("-fx-background-color: transparent; ");
        
        gamePane.setCenter(canvas);

        SubScene gameScene = new SubScene(gamePane, 5000, 5000);
       
        //Camera
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(0);
        //Move scene to center so borders don't show
        camera.setTranslateX(gameScene.getWidth() / 2);
        camera.setTranslateY(gameScene.getHeight() / 2);
        cameraCenterX = (int) gameScene.getWidth() / 2;
        cameraCenterY = (int) gameScene.getHeight() / 2;
        
        camera.setNearClip(0.1);
        camera.setFarClip(1000.0);
        gameScene.setCamera(camera);
              
        gameScene.setOnMouseEntered((MouseEvent evt) -> {
            //Make mouse cursor look like the object to be added
            if (addCelestialObjectMode) {
                loadImages();
                if (objectToAdd.getType().equals("star")) {
                    gameScene.setCursor(new ImageCursor(star, 50, 50));
                } else {
                    gameScene.setCursor(new ImageCursor(planet));
                }              
            }
        });
        
        //Camera controls
        gameScene.setOnMousePressed((MouseEvent evt) -> {
            //Make mouse location to ignore gameMenu
            mouseX = evt.getSceneX() - 200;
            mouseY = evt.getSceneY() - 25;
            //Add celestial object with mouse click
            if (addCelestialObjectMode && evt.isPrimaryButtonDown()) {
                objectToAdd.setPosition(mouseX - camX, mouseY - camY);
                game.addCelestialObject(objectToAdd);
                addCelestialObjectMode = false;
                gameScene.setCursor(Cursor.DEFAULT);
            }
            for (CelestialObject o : game.getObjects()) {
                if ( o.getTarget().contains( evt.getX() - camX, evt.getY() - camY ) ) {
                    selectedObject = o;
                }
            }
        });
        
        gameScene.setOnMouseDragged((MouseEvent evt) -> {
            //Make mouse location to ignore gameMenu
            double x = evt.getSceneX() - 200;
            double y = evt.getSceneY() - 25;
            double camMoveX, camMoveY;
            //Not a "real" camera, just use it to move all objects
            camX = camX + (x - mouseX);
            camY = camY + (y - mouseY);
            mouseX = evt.getSceneX() - 200;
            mouseY = evt.getSceneY() - 25;
        });

        /*Zoom with mouse wheel TODO
        gameScene.setOnScroll((ScrollEvent evt) -> {
            camera.setTranslateZ(camera.getTranslateZ() + evt.getDeltaY() * 10);
            camera.setTranslateX(camera.getTranslateX() - evt.getDeltaY() *2);
            camera.setTranslateY(camera.getTranslateY() - evt.getDeltaY() *2);
        });
        */
        
        
        return gameScene;
    }

    /**
    *
    *  Loads all the images from the images folder TODO maybe something cleaner?
    */
    public void loadImages() {
        star = new Image("/images/stars/star1.png");
        planet = new Image("/images/planets/earth.png");
    }
    
    /**
    *
    *  Draws all the objects in the game.
     * @param game the game to draw
    */
    public void drawGame(Game game) { 
        gc.setFill(Color.WHITE);
        gc.setLineWidth(5);      
        gc.clearRect(0, 0, 10000, 10000);
        int i = 2;
        for (CelestialObject o : game.getObjects()) { 
            Image img;
            if (o.getType().equals("star")) {
                img = star;
            } else {
                img = planet;
            }      
            gc.drawImage( img, (int) o.getX() - o.getSize() / 2 + camX + cameraCenterX, (int) o.getY() - o.getSize() / 2 + camY + cameraCenterY, o.getSize(), o.getSize());          
        }
        //Object info
        if (selectedObject != null) {
            objectUI.name.textProperty().setValue(selectedObject.getName());
            objectUI.type.textProperty().setValue("Type: " + selectedObject.getType());
            objectUI.x.textProperty().setValue("X: " + selectedObject.getX());
            objectUI.y.textProperty().setValue("Y: " + selectedObject.getY());
            objectUI.mass.textProperty().setValue("Mass: " + selectedObject.getMass());
            objectUI.size.textProperty().setValue("Size: " + selectedObject.getSize());
        }    
    }   
    
    /**
    *
    *  Sets the addCelestialObjectMode to true, so it can be added with mouse
    * 
     * @param o The object to be added.
    */
    public void addCelestialObject(CelestialObject o) {
        this.objectToAdd = o;
        this.addCelestialObjectMode = true;
    }
    
}