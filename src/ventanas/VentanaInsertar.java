/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author edwar
 */
public class VentanaInsertar {
    private BorderPane root;
    private VBox vbInsertar = new VBox();
    private final Button btEncontrar = new Button("   Encontrar   ");
    private final Button btSalir = new  Button("    Salir    ");
    private final Label lbActor1 = new Label("Actor 1:");
    private final Label lbActor2 = new Label("Actor 2:");
    private final Label titulo = new Label("Oracle of Bacon");
    private TextField tfActor1 = new TextField("Kevin Bacon");
    private TextField tfActor2 = new TextField(); 
    
    public VentanaInsertar(){
        crearVentana();
    }
    
    public void crearVentana(){
        btEncontrar.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        btSalir.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        
        ImageView img = new ImageView("imagenes/Kevin_Bacon.jpg");
        img.setFitWidth(200);
        img.setFitHeight(198);
        HBox hbImagen = new HBox();
        hbImagen.getChildren().addAll(img);
        hbImagen.setAlignment(Pos.CENTER);
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btEncontrar, btSalir);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15);
        
        BackgroundImage bI = new BackgroundImage(new Image("imagenes/fondo.jpg", 960, 740, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        lbActor1.setStyle("-fx-font-weight: bold;");
        lbActor2.setStyle("-fx-font-weight: bold;");
        HBox labelsTextfields = new HBox();
        labelsTextfields.getChildren().addAll(lbActor1, tfActor1, lbActor2, tfActor2);
        labelsTextfields.setSpacing(20);
        labelsTextfields.setAlignment(Pos.CENTER);
        
        titulo.setStyle("-fx-font-weight: bold;");
        titulo.setFont(new Font(24));
        HBox hbTitulo = new HBox();
        hbTitulo.getChildren().addAll(titulo);
        hbTitulo.setAlignment(Pos.CENTER);
        
        vbInsertar.getChildren().addAll(hbTitulo, labelsTextfields, hbox, hbImagen);
        vbInsertar.setBackground(new Background(bI));
        vbInsertar.setPadding(new Insets(10));
        vbInsertar.setSpacing(30);
        root=new BorderPane();
        root.setCenter(vbInsertar);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getBtSalir() {
        return btSalir;
    }

    public String getTfActor1() {
        return tfActor1.getText();
    }

    public String getTfActor2() {
        return tfActor2.getText();
    }
     
}