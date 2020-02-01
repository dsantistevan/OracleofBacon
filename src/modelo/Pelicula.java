/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import grafo.GrafoLA;
import java.util.List;

/**
 *
 * @author David Santistevan
 */
public class Pelicula {
    private String nombre;
    private List<Actor> actores;
    
    public Pelicula(String n,List<Actor> a){
        nombre=n;
        actores=a;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Actor> getActores() {
        return actores;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public void agregarPelicula(GrafoLA<Actor,Pelicula> g){
        for(int i=0;i<actores.size();i++) g.addVertex(actores.get(i));
        for(int i=0;i<actores.size();i++){
            for(int j=i+1;j<actores.size();j++){
                g.addEdge(actores.get(i),actores.get(j),this);
            }
        }
    }
    
    
}
