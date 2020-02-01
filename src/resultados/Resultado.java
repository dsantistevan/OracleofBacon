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
    private List<Nodo<E>> listaNodos;
    
    public Resultado(long duracion){
        this.duracion = 0;
        this.listaNodos = new LinkedList<>();
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public List<Nodo<E>> getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(List<Nodo<E>> listaNodos) {
        this.listaNodos = listaNodos;
    }
}
