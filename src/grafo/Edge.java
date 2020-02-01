/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.Objects;

/**
 *
 * @author David Santistevan
 * @param <E>
 */
public class Edge<E,T> {
    private Vertex<E,T> origen;
    private Vertex<E,T> destino;
    private int peso;
    private T pelicula;

    private Edge(Vertex<E,T> origen, Vertex<E,T> destino, int peso,T p) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.pelicula=p;
    }
    
    public Edge(Vertex<E,T> origen,Vertex<E,T> destino,T p){
        this(origen,destino,1,p);
    }

    public Vertex<E,T> getOrigen() {
        return origen;
    }

    public void setOrigen(Vertex<E,T> origen) {
        this.origen = origen;
    }

    public Vertex<E,T> getDestino() {
        return destino;
    }

    public void setDestino(Vertex<E,T> destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.origen);
        hash = 71 * hash + Objects.hashCode(this.destino);
        hash = 71 * hash + this.peso;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Edge)) {
            return false;
        }
        final Edge<?,?> other = (Edge<?,?>) obj;
        
        return Objects.equals(this.origen, other.origen) && Objects.equals(this.destino, other.destino);
    }
    
    public Edge<E,T> reverse(){
        return new Edge(destino,origen,peso,pelicula);
    }
    
    public boolean contains(Vertex<E,T> v){
        return (destino.equals(v))||(origen.equals(v));
    }
    
    @Override
    public String toString(){
        return "("+origen+" , "+destino+")";
    }

    public T getPelicula() {
        return pelicula;
    }
    
    
    
}
