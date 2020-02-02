/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultados;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.control.ScrollPane;
import modelo.Nodo;

/**
 *
 * @author edwar
 */
public class Resultado {
    
    private long duracion;
    private List<Nodo> lista;
    private ScrollPane root;
    
    public Resultado(long duracion, List<Nodo> l){
        this.duracion = 0;
        lista=l;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }


}
