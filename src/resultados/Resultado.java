/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultados;

import java.util.LinkedList;
import java.util.List;
import modelo.Nodo;

/**
 *
 * @author edwar
 * @param <E>
 */
public class Resultado<E> {
    
    private long duracion;
    private List<Nodo<E>> ruta;
    
    public Resultado(long duracion){
        this.duracion = 0;
        this.ruta = new LinkedList<>();
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public List<Nodo<E>> getRuta() {
        return ruta;
    }

    public void setRuta(List<Nodo<E>> ruta) {
        this.ruta = ruta;
    }
}
