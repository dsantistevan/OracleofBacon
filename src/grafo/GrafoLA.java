/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import modelo.Nodo;

/**
 *
 * @author David Santistevan
 * @param <E>
 */
public class GrafoLA<E,T> {
    private List<Vertex<E,T>> vertexes;
    private boolean directed;
    private Vertex<E,T> origenDijsktra;
    private Vertex<E,T> origenBFS;
    private Vertex<E,T> origenDFS;
    
    public GrafoLA() {
        directed=false;
        this.vertexes = new LinkedList<>();
    }
    
    public boolean addVertex(E data){
        Vertex<E,T> v=new Vertex(data);
        return data==null || vertexes.contains(v) ? false : vertexes.add(v);
            
        
    }
    
    public boolean addEdge(E origen,E destino,T pelicula){
        if(origen==null||destino==null) return false;
        Vertex<E,T> vo=searchVertex(origen);
        Vertex<E,T> vd=searchVertex(destino);
        if(vo==null||vd==null) return false;
        Edge<E,T> e = new Edge(vo,vd,pelicula);
        vo.addEdge(e);
        if(!directed)
            vd.addEdge(e.reverse());
        
        return true;
        
    }
    
    private Vertex<E,T> searchVertex(E data){
        if(data==null) return null;
        for(Vertex<E,T> v: vertexes)
            if(v.getData().equals(data))
                return v;
        return null;
    }
    
    public int outdegree(E data){
        if(data==null)
            return -1;
        Vertex<E,T> v=new Vertex(data);
        for(Vertex<E,T> ve:vertexes){
            if(ve.equals(v))
                return ve.getEdges().size();
        }
        return -1;
    }
    
    public int indegree(E data){
        Vertex<E,T> v=searchVertex(data);
        if(data==null||v==null) return -1;
        int suma=0;
        Iterator<Vertex<E,T>> it = vertexes.iterator();
        while(it.hasNext()) {
            Vertex<E,T> ve = it.next();
            if(!ve.equals(v)){
                Iterator<Edge<E,T>> ite=ve.getEdges().iterator();
                while(ite.hasNext()){
                    Edge<E,T> e=ite.next();
                    if(e.contains(v))
                        suma++;
                }
            }
        }
        return suma;
    }
    
    public boolean removeVertex(E data){
        Vertex<E,T> v=searchVertex(data);
        if(data==null||v==null) return false;
        
        Iterator<Vertex<E,T>> it = vertexes.iterator();
        while(it.hasNext()) {
            Vertex<E,T> ve = it.next();
            if(!ve.equals(v)){
                Iterator<Edge<E,T>> ite=ve.getEdges().iterator();
                while(ite.hasNext()){
                    Edge<E,T> e=ite.next();
                    if(e.contains(v))
                        ite.remove();
                }
            }else
                it.remove();
        }
        return true;
    }
    
    public boolean removeEdge(E origen,E destino){
        Vertex<E,T> vo=searchVertex(origen);
        Vertex<E,T> vd=searchVertex(destino);
        if(vo==null||vd==null) return false;
        
        Iterator<Vertex<E,T>> it = vertexes.iterator();
        while(it.hasNext()) {
            Vertex<E,T> ve = it.next();
            if(ve.equals(vo))
                vo.removeVertex(vd);
            else if(ve.equals(vd) && !directed)
                vd.removeVertex(vo);
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder edgesSB=new StringBuilder();
        StringBuilder vertexesSB=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        
        vertexesSB.append("{");
        edgesSB.append("{");
        sb.append("V = ");
        Iterator<Vertex<E,T>> it = vertexes.iterator();
        while(it.hasNext()) {
            Vertex<E,T> ve = it.next();
            vertexesSB.append(ve.toString()).append(",");
            Iterator<Edge<E,T>> ite=ve.getEdges().iterator();
            while(ite.hasNext()){
                Edge<E,T> e=ite.next();
                edgesSB.append(e.toString()).append(",");
            }
        }
        vertexesSB.deleteCharAt(vertexesSB.length()-1).append("}");
        edgesSB.deleteCharAt(edgesSB.length()-1).append("}");
        return sb.append(vertexesSB).append("\nA = ").append(edgesSB).toString();
    }
    
    private void cleanVertexDijsktra(){
        Iterator<Vertex<E,T>> it = vertexes.iterator(); 
        while(it.hasNext()) {
            Vertex<E,T> v = it.next();
            v.setVisited(false);
            v.setIntDijkstra(Integer.MAX_VALUE);
        }
    }
    
    private void cleanVertexDFS(){
        Iterator<Vertex<E,T>> it = vertexes.iterator(); 
        while(it.hasNext()) {
            Vertex<E,T> v = it.next();
            v.setVisited(false);
            v.setIntDFS(Integer.MAX_VALUE);
        }
    }
    
    private void cleanVertexBFS(){
        Iterator<Vertex<E,T>> it = vertexes.iterator(); 
        while(it.hasNext()) {
            Vertex<E,T> v = it.next();
            v.setVisited(false);
            v.setIntBFS(Integer.MAX_VALUE);
        }
    }
    
    private void cleanVertex(){
        Iterator<Vertex<E,T>> it = vertexes.iterator(); 
        while(it.hasNext()) {
            Vertex<E,T> v = it.next();
            v.setVisited(false);
        }
    }
    
    public List<E> bfs(E origen){
        cleanVertexBFS();
        List<E> list=new LinkedList<>();
        Vertex<E,T> v=searchVertex(origen);
        if(v==null) return list;    //Si el origen es nulo, el vertice es nulo
        origenBFS = v;
        Queue<Vertex<E,T>> cola=new LinkedList<>();
        cola.offer(v);
        v.setVisited(true);
        v.setIntBFS(0);
        while(!cola.isEmpty()){
            v=cola.poll();
            list.add(v.getData());
            for(Edge<E,T> ed:v.getEdges()){
                Vertex<E,T> ve=ed.getDestino();
                if(!ve.isVisited()){
                    ve.setVisited(true);
                    cola.offer(ve);
                    ve.setIntBFS(v.getIntBFS()+ed.getPeso());
                    ve.setPrevioBFS(v);
                }
            }
        }
        cleanVertex();
        return list;
        
    }
    
    public List<E> dfs(E origen){
        cleanVertexDFS();
        List<E> list=new LinkedList<>();
        Vertex<E,T> v=searchVertex(origen);
        if(v==null) return list;    //Si el origen es nulo, el vertice es nulo
        origenDFS = v; 
        Deque<Vertex<E,T>> pila=new LinkedList<>();
        pila.push(v);
        v.setVisited(true);
        v.setIntDFS(0);
        while(!pila.isEmpty()){
            v=pila.pop();
            list.add(v.getData());
            for(Edge<E,T> ed:v.getEdges()){
                Vertex<E,T> ve=ed.getDestino();
                if(!ve.isVisited()){
                    ve.setVisited(true);
                    pila.push(ve);
                    ve.setIntDFS(v.getIntDFS()+ed.getPeso());
                    ve.setPrevioDFS(v);
                }
            }
        }
        cleanVertex();
        return list;
    }
    
    
    
    private void dijkstra(Vertex<E,T> vOrigen){
        origenDijsktra=vOrigen;
        if(vOrigen!=null){    //Si el origen es nulo, el vertice es nulo
            cleanVertexDijsktra();
            PriorityQueue<Vertex<E,T>> cola=new PriorityQueue<>((Vertex v1,Vertex v2) -> v1.getIntDijkstra()-v2.getIntDijkstra());
            cola.offer(vOrigen);
            vOrigen.setVisited(true);
            vOrigen.setIntDijkstra(0);
            while(!cola.isEmpty()){
                vOrigen=cola.poll();
                vOrigen.setVisited(true);
                for(Edge<E,T> ed:vOrigen.getEdges()){
                    Vertex<E,T> ve=ed.getDestino();
                    if(!ve.isVisited()){
                        if(ed.getPeso()+vOrigen.getIntDijkstra()<ve.getIntDijkstra())
                            ve.setPrevioDijkstra(vOrigen);
                        ve.setIntDijkstra(Math.min(ed.getPeso()+vOrigen.getIntDijkstra(),ve.getIntDijkstra()));
                        cola.offer(ve);
                    }
                }
            }
            
        }
        cleanVertex();
    }
    
    public int menorDistanciaDijsktra(E origen, E destino){
        Vertex<E,T> vo=searchVertex(origen);
        Vertex<E,T> vd=searchVertex(destino);
        if(vo==null||vd==null) return -1;
        dijkstra(vo);
        return vd.getIntDijkstra();
        
    }
    
    public int menorDistanciaDFS(E origen, E destino){
        List<E> l=dfs(origen);
        Vertex<E,T> v=searchVertex(destino);
        return l.contains(destino)&&v!=null ? v.getIntDFS() : -1;
        
    }
    
    public int menorDistanciaBFS(E origen, E destino){
        List<E> l=bfs(origen);
        Vertex<E,T> v=searchVertex(destino);
        return l.contains(destino)&&v!=null ? v.getIntBFS() : -1;
        
    }
    
    public GrafoLA<E,T> reverse(){
        if(!this.directed)
            return this;
        GrafoLA<E,T> reve= new GrafoLA<>();
        for(Vertex<E,T> v: this.vertexes){
            reve.addVertex(v.getData());
        }
        for(Vertex<E,T> v: this.vertexes)
            for(Edge<E,T> e:v.getEdges())
                reve.addEdge(e.getDestino().getData(),v.getData(), e.getPelicula());
        return reve;
    }
    
    public List<Set<E>> connectedComponents(){
        List<Set<E>> list=new ArrayList<>();
        HashSet<E> total=new HashSet<>();
        for(Vertex<E,T> v:vertexes)
            total.add(v.getData());
        while(!total.isEmpty()){
            E e= (E) total.toArray()[0];
            HashSet<E> ini=new HashSet<>();
            HashSet<E> fin=new HashSet<>();
            ini.addAll(dfs(e));
            fin.addAll(reverse().dfs(e));
            ini.removeAll(fin);
            total.removeAll(ini);
            list.add(ini);
        }
        return list;
    }
    
    public boolean isConex(){
        return connectedComponents().size()==1;
    }
    
    public List<Nodo> rutaDFS(E destino){
        Vertex<E,T> vd = searchVertex(destino);
        if(vd == null)  return null;
        LinkedList<Nodo> list = new LinkedList<>();
        while(!vd.equals(origenDFS)){
            Nodo<E> n = new Nodo<>(vd.getData());
            list.addFirst(n);
            Vertex<E,T> v = vd.getPrevioDFS();
            for(Edge<E,T> e : v.getEdges()){
                if(e.getDestino().equals(vd)){
                    Nodo<T> n2 = new Nodo<>(e.getPelicula());
                    list.addFirst(n2);
                }
            }
            vd = vd.getPrevioDFS();
        }
        Nodo<E> ini = new Nodo<>(origenDFS.getData());
        list.addFirst(ini);
        return list;
    }
    
    public List<Nodo> rutaBFS(E destino){
        Vertex<E,T> vd = searchVertex(destino);
        if(vd == null)  return null;
        LinkedList<Nodo> list = new LinkedList<>();
        while(!vd.equals(origenBFS)){
            Nodo<E> n = new Nodo<>(vd.getData());
            list.addFirst(n);
            Vertex<E,T> v = vd.getPrevioBFS();
            for(Edge<E,T> e : v.getEdges()){
                if(e.getDestino().equals(vd)){
                    Nodo<T> n2 = new Nodo<>(e.getPelicula());
                    list.addFirst(n2);
                }
            }
            vd = vd.getPrevioBFS();
        }
        Nodo<E> ini = new Nodo<>(origenBFS.getData());
        list.addFirst(ini);
        return list;
    }
    
    public List<Nodo> rutaDijkstra(E destino){
        Vertex<E,T> vd=searchVertex(destino);
        if(vd==null) return null;
        LinkedList<Nodo> list=new LinkedList<>(); 
        while(!vd.equals(origenDijsktra)){
            Nodo<E> n=new Nodo<>(vd.getData());
            list.addFirst(n);
            Vertex<E,T> v=vd.getPrevioDijkstra();
            for(Edge<E,T> e: v.getEdges()){
                if(e.getDestino().equals(vd)){
                    Nodo<T> n2=new Nodo(e.getPelicula());
                    list.addFirst(n2);
                }
                
            }
            vd=vd.getPrevioDijkstra();
        }
        Nodo<E> ini=new Nodo(origenDijsktra.getData());
        list.addFirst(ini);
        
        return list;
    }
}
