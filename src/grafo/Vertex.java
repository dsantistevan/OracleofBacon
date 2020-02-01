/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author David Santistevan
 * @param <E>
 */
public class Vertex<E,T> {
    private E data;
    private List<Edge<E,T>> edges;
    private boolean visited;
    private int intDijkstra;
    private Vertex<E,T> previoDijkstra;
    private int intBFS;
    private Vertex<E,T> previoBFS;
    private int intDFS;
    private Vertex<E,T> previoDFS;
            
    public Vertex(E data){
        this.data=data;
        edges=new LinkedList<>();
        intDijkstra=Integer.MAX_VALUE;
        previoDijkstra=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public List<Edge<E,T>> getEdges() {
        return edges;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vertex))
            return false;
        final Vertex<?,?> other = (Vertex<?,?>) obj;
        return Objects.equals(this.data, other.data);
    }

    public boolean addEdge(Edge<E,T> ed){
        return edges.contains(ed) ? false : edges.add(ed);
    }
    
    public boolean removeVertex(Vertex<E,T> v){
        Iterator<Edge<E,T>> it = edges.iterator();
        while(it.hasNext()) {
            Edge<E,T> e = it.next();
            if(e.contains(v))
                it.remove();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ""+data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean Visited) {
        this.visited = Visited;
    }

    public int getIntDijkstra() {
        return intDijkstra;
    }

    public void setIntDijkstra(int intDijkstra) {
        this.intDijkstra = intDijkstra;
    }

    public Vertex<E,T> getPrevioDijkstra() {
        return previoDijkstra;
    }

    public void setPrevioDijkstra(Vertex<E,T> previoDijkstra) {
        this.previoDijkstra = previoDijkstra;
    }

    public int getIntBFS() {
        return intBFS;
    }

    public void setIntBFS(int intBFS) {
        this.intBFS = intBFS;
    }

    public int getIntDFS() {
        return intDFS;
    }

    public void setIntDFS(int intDFS) {
        this.intDFS = intDFS;
    }

    public Vertex<E, T> getPrevioBFS() {
        return previoBFS;
    }

    public void setPrevioBFS(Vertex<E, T> previoBFS) {
        this.previoBFS = previoBFS;
    }

    public Vertex<E, T> getPrevioDFS() {
        return previoDFS;
    }

    public void setPrevioDFS(Vertex<E, T> previoDFS) {
        this.previoDFS = previoDFS;
    }
    
    
    
}
