/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracleofbacon;

import ventanas.VentanaInsertar;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author David Santistevan
 */
public class OracleOfBacon extends Application{

    @Override
    public void start(Stage primaryStage) {
        VentanaInsertar ventanaInsertar = new VentanaInsertar();
        Scene sceneInicio = new Scene(ventanaInsertar.getRoot(), 800, 400);
        
        
        
        
        primaryStage.setTitle("ORACLE OF BACON");
        primaryStage.setScene(sceneInicio);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
