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
import javafx.scene.image.Image;
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
public class VentanaResultados {
    private BorderPane bpResultado;
    private VBox vbResultados = new VBox();
    private final Label lbtitulo = new Label("Resultados de Busqueda");
    private final Button btReintentar = new Button("   Reintentar   ");
    private final Button btSalir = new  Button("    Salir    ");
    
    public VentanaResultados(){
        crearVentana();
    }
    
    public void crearVentana(){
        btReintentar.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        btSalir.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btReintentar, btSalir);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15);
        
        BackgroundImage bI = new BackgroundImage(new Image("imagenes/fondo.jpg", 960, 740, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        lbtitulo.setStyle("-fx-font-weight: bold;");
        lbtitulo.setFont(new Font(24));
        HBox hbTitulo = new HBox();
        hbTitulo.getChildren().addAll(lbtitulo);
        hbTitulo.setAlignment(Pos.CENTER);
        
        vbResultados.getChildren().addAll(hbTitulo, hbox);  //TAMBIEN HAY QUE AGREGAR AHI EL CONCEPTO DEL PROGRAMA
        vbResultados.setBackground(new Background(bI));
        vbResultados.setPadding(new Insets(10));
        vbResultados.setSpacing(30);
        bpResultado=new BorderPane();
        bpResultado.setCenter(bpResultado);
    }

    public Button getBtSalir() {
        return btSalir;
    }

    public BorderPane getBpResultado() {
        return bpResultado;
    }
    
}
