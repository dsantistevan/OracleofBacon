/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.sun.jndi.dns.DnsContextFactory;
import javafx.application.Platform;
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
    private VBox vbRuta = new VBox();
    private final Label lbtitulo = new Label("Resultados de Busqueda");
    private final Button btDfs = new Button("   Resultado DFS   ");
    private final Button btBfs = new Button("   Resultado BFS   ");
    private final Button btDijkstra = new Button("   Resultado Dijkstra   ");
    private final Button btReintentar = new Button("   Reintentar   ");
    private final Button btSalir = new  Button("    Salir    ");
    
    public VentanaResultados(){
        crearVentana();
    }
    
    public void crearVentana(){
        btReintentar.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        btSalir.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        btDfs.setStyle("-fx-background-color: #87CEEB; -fx-font-weight: bold;");
        btBfs.setStyle("-fx-background-color: #87CEEB; -fx-font-weight: bold;");
        btDijkstra.setStyle("-fx-background-color: #B7CEEB; -fx-font-weight: bold;");
        
        HBox verResultados = new HBox();
        verResultados.getChildren().addAll(btDfs, btBfs, btDijkstra);
        verResultados.setAlignment(Pos.CENTER);
        verResultados.setSpacing(15);
        
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
        
        vbResultados.getChildren().addAll(hbTitulo, verResultados, hbox, vbRuta);  //TAMBIEN HAY QUE AGREGAR AHI EL CONCEPTO DEL PROGRAMA
        vbResultados.setBackground(new Background(bI));
        vbResultados.setPadding(new Insets(10));
        vbResultados.setSpacing(30);
        bpResultado=new BorderPane();
        bpResultado.setCenter(vbResultados);
        acciones();
    }
    
    public void acciones(){
        btSalir.setOnAction(e->Platform.exit());
        btReintentar.setOnAction((event) -> {
           VentanaInsertar vi = new VentanaInsertar();
           bpResultado.setCenter(vi.getRoot());
        });
    }

    public Button getBtSalir() {
        return btSalir;
    }
    
    public Button getBtDijkstra() {
        return btDijkstra;
    }
    
    public Button getBtBfs() {
        return btBfs;
    }
    
    public Button getBtDfs() {
        return btDfs;
    }

    public BorderPane getBpResultado() {
        return bpResultado;
    }
    
    public VBox getVbResultados() {
        return vbResultados;
    }
    
    public VBox getVbRuta() {
        return vbRuta;
    }
}
