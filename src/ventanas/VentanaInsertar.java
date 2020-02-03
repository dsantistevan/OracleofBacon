/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import data.GrafoData;
import grafo.GrafoLA;
import java.util.List;
import javafx.application.Platform;
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
import modelo.Actor;
import modelo.Nodo;
import modelo.Pelicula;
import resultados.Resultado;

/**
 *
 * @author edwar
 */
public final class VentanaInsertar {
    private BorderPane root;
    private final VBox vbInsertar = new VBox();
    private final Button btEncontrar = new Button("   Encontrar   ");
    private final Button btSalir = new  Button("    Salir    ");
    private final Label lbActor1 = new Label("Actor 1:");
    private final Label lbActor2 = new Label("Actor 2:");
    private final Label titulo = new Label("Oracle of Bacon");
    private final TextField tfActor1 = new TextField("Kevin Bacon");
    private final TextField tfActor2 = new TextField(); 
    GrafoLA<Actor, Pelicula> grafo;
    
    public VentanaInsertar(){
        crearVentana();
    }
    
    public final void crearVentana(){
        cargarGrafo();
        aplicarEstilo();
        vbInsertar.getChildren().addAll(tituloTop(), camposTexto(), estiloBotones(), imagenKevin());
        root=new BorderPane();
        root.setCenter(vbInsertar);
        mostrarResultado();
    }
    
    private void cargarGrafo(){
        GrafoLA<Actor, Pelicula> g = GrafoData.grafoArchivo();
        grafo = g;
        
    }
    
    private void aplicarEstilo(){
        BackgroundImage bI = new BackgroundImage(new Image("imagenes/fondo.jpg", 960, 740, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        
        vbInsertar.setBackground(new Background(bI));
        vbInsertar.setPadding(new Insets(10));
        vbInsertar.setSpacing(30);
    }
    
    private HBox estiloBotones(){
        btEncontrar.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        btSalir.setStyle("-fx-background-color: #FD9900; -fx-font-weight: bold;");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btEncontrar, btSalir);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(15);
        return hbox;
    }
    
    private HBox imagenKevin(){
        ImageView img = new ImageView("imagenes/Kevin_Bacon.jpg");
        img.setFitWidth(200);
        img.setFitHeight(198);
        HBox hbImagen = new HBox();
        hbImagen.getChildren().addAll(img);
        hbImagen.setAlignment(Pos.CENTER);
        return hbImagen;
    }
    
    private HBox camposTexto(){
        lbActor1.setStyle("-fx-font-weight: bold;");
        lbActor2.setStyle("-fx-font-weight: bold;");
        HBox labelsTextfields = new HBox();
        labelsTextfields.getChildren().addAll(lbActor1, tfActor1, lbActor2, tfActor2);
        labelsTextfields.setSpacing(20);
        labelsTextfields.setAlignment(Pos.CENTER);
        return labelsTextfields;
    }
    
    private HBox tituloTop(){
        titulo.setStyle("-fx-font-weight: bold;");
        titulo.setFont(new Font(24));
        HBox hbTitulo = new HBox();
        hbTitulo.getChildren().addAll(titulo);
        hbTitulo.setAlignment(Pos.CENTER);
        return hbTitulo;
    }

    
    private void activarBotones(){
        btSalir.setOnAction(e -> Platform.exit());
        btEncontrar.setOnAction(e -> {
            long tiempoIni=System.currentTimeMillis();
            
        });
    }
    
    private void mostrarResultado(){
        btEncontrar.setOnAction((event) -> {
            
            VentanaResultados vr = new VentanaResultados();
            root.setCenter(vr.getBpResultado());
            vr.getBtDijkstra().setOnAction((e) -> {
                vr.getVbRuta().getChildren().clear();
                mostrarDijkstra(vr);
            });
            vr.getBtBfs().setOnAction((e) -> {
                vr.getVbRuta().getChildren().clear();
                mostrarBFS(vr);
            });
            vr.getBtDfs().setOnAction((e) -> {
                vr.getVbRuta().getChildren().clear();
                mostrarDFS(vr);
            });
        });
    }
    
    public void mostrarDijkstra(VentanaResultados vr){
        Actor actor1 = new Actor(tfActor1.getText());
        Actor actor2 = new Actor(tfActor2.getText());
        int dijsktra = grafo.menorDistanciaDijsktra(actor1,actor2);
        long ini=System.nanoTime();
        List<Nodo> list = grafo.rutaDijkstra(actor2);
        long fin=System.nanoTime();
        long total=(fin-ini)/1000000;
        Resultado res = new Resultado(total, list);
        vr.getVbRuta().getChildren().add(res.getRoot());
    }
    
    public void mostrarBFS(VentanaResultados vr){
        Actor actor1 = new Actor(tfActor1.getText());
        Actor actor2 = new Actor(tfActor2.getText());
        int bfs = grafo.menorDistanciaBFS(actor1,actor2);
        long ini=System.nanoTime();
        List<Nodo> list = grafo.rutaBFS(actor2);
        long fin=System.nanoTime();
        long total=(fin-ini)/1000000;
        Resultado res = new Resultado(total, list);
        vr.getVbRuta().getChildren().add(res.getRoot());
    }
    
    public void mostrarDFS(VentanaResultados vr){
        Actor actor1 = new Actor(tfActor1.getText());
        Actor actor2 = new Actor(tfActor2.getText());
        int dfs = grafo.menorDistanciaDFS(actor1,actor2);
        long ini=System.nanoTime();
        List<Nodo> list = grafo.rutaDFS(actor2);
        long fin=System.nanoTime();
        long total=(fin-ini)/1000000;
        Resultado res = new Resultado(total, list);
        vr.getVbRuta().getChildren().add(res.getRoot());
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