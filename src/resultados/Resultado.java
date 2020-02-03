/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultados;

import java.util.LinkedList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.Nodo;

/**
 *
 * @author edwar
 */
public class Resultado {
    
    private long duracion;
    private List<Nodo> lista;
    private ScrollPane root = new ScrollPane();
    private BorderPane bp = new BorderPane();
    private VBox vbRuta = new VBox();
    private ImageView img;
    
    public Resultado(long duracion, List<Nodo> l){
        this.duracion = duracion;
        lista=l;
        mostrarResultado();
    }
    
    public void mostrarResultado(){
        img = new ImageView("imagenes/flecha.png");
        img.setFitWidth(10);
        img.setFitHeight(19);
        
        Label lbBacon = new Label(lista.get(lista.size()-1).toString()+" tiene un numero Bacon de "+(lista.size()-1)/2);
        Label lbDuracion = new Label("Duracion del algoritmo: " + duracion/1000 + " segundos");
        lbBacon.setStyle("-fx-font-weight: bold;");
        lbDuracion.setStyle("-fx-font-weight: bold;");
        
        vbRuta.setAlignment(Pos.CENTER);
        vbRuta.setSpacing(6);
        
        vbRuta.getChildren().addAll(lbBacon, lbDuracion);
        mostrarRuta();
        
        bp.setCenter(vbRuta);
        root.setContent(bp);
    }
    
    public void mostrarRuta(){
        Label lbPeli;
        Label lbActor;
        for(int i=0; i<lista.size(); i++){
            if(i%2==0){
                lbActor = new Label(lista.get(i).toString());
                lbActor.setStyle("-fx-background-color: #9D25CD; -fx-text-fill: white; -fx-font-weight: bold;");
                vbRuta.getChildren().add(lbActor);
            }else{
                lbPeli = new Label(lista.get(i).toString());
                lbPeli.setStyle("-fx-background-color: #00C455; -fx-text-fill: white; -fx-font-weight: bold;");
                vbRuta.getChildren().addAll(lbPeli, estiloLabel("   con"));
            }
            if(i%2==0 && i+1!=lista.size()) vbRuta.getChildren().add(estiloLabel(" estuvo en"));
             
        }
        
    }
    
    public Label estiloLabel(String text){
        Label lb = new Label(text);
        //lb.setGraphic(img);
        //lb.setContentDisplay(ContentDisplay.CENTER);
        return lb;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public ScrollPane getRoot() {
        return root;
    }

    public void setRoot(ScrollPane root) {
        this.root = root;
    }
    
    public VBox getVbRuta(){
        return vbRuta; 
    }

    
}
