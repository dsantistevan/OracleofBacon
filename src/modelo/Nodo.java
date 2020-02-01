/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author David Santistevan
 * @param <E>
 */
public class Nodo<E> {
    private E data;

    public Nodo(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Nodo))
            return false;
        final Nodo<?> other = (Nodo<?>) obj;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return ""+data;
    }
    
    
}
