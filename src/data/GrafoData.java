/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import modelo.Pelicula;
import grafo.GrafoLA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Actor;
import recursos.CONSTANTES;

/**
 *
 * @author David Santistevan
 */
public class GrafoData {
    
    public static List<Pelicula> leerArchivos(){
        List<Pelicula> list=new LinkedList<>();
        try(BufferedReader bActores=new BufferedReader(new FileReader(new File(CONSTANTES.PATH+"actores.txt")));
                BufferedReader bPeliculas=new BufferedReader(new FileReader(new File(CONSTANTES.PATH+"peliculas.txt")));
                BufferedReader bAP=new BufferedReader(new FileReader(new File(CONSTANTES.PATH+"pelicula-actores.txt")));){
            String lP=bPeliculas.readLine();
            String lA=bActores.readLine();
            String lAP=bAP.readLine();
            
            
            
            TreeMap<Integer,String> tm=new TreeMap<>();
            while(lA!=null){
                String[] listA=lA.split("\\|");
                tm.put(Integer.valueOf(listA[0]), listA[1]);
                lA=bActores.readLine();
            }
            while(lP!=null){
                String[] listP=lP.split("\\|");
                List<Actor> l=new LinkedList<>();
                String[] listAP=lAP!=null? lAP.split("\\|") : null;
                while(listAP!=null && listP[0].equals(listAP[0])){
                    l.add(new Actor(tm.get(Integer.valueOf(listAP[1]))));
                    lAP=bAP.readLine();
                    listAP= lAP!=null? lAP.split("\\|") : null;
                }
                list.add(new Pelicula(listP[1],l));
                lP=bPeliculas.readLine();
            }
            
                
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GrafoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrafoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    public static GrafoLA<Actor,Pelicula> grafoArchivo(){
        List<Pelicula> lP=leerArchivos();
        GrafoLA<Actor,Pelicula> g=new GrafoLA<>();
        for(Pelicula p : lP)
            p.agregarPelicula(g);
        return g;
    }
    
}
