/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

import java.util.HashMap;

/**
 *
 * @author Diego
 */

public class ListaArbol {
    NodoArbol raiz;
    private HashMap<String, NodoArbol> mapaNodosNombre; // Mapa para búsqueda eficiente
    private HashMap<String, NodoArbol> mapaNodosApodo;

    public ListaArbol(String nombreRaiz) {
        this.raiz = new NodoArbol(nombreRaiz);
        this.mapaNodosNombre = new HashMap<>();
        this.mapaNodosApodo = new HashMap<>();
        mapaNodosNombre.put(nombreRaiz, raiz);
    }
    
    public void agregarHijo(String nombrePadre,  String nombreHijo, Object[] array) {
        NodoArbol padre = mapaNodosNombre.get(nombrePadre);
        
        if (padre != null) {
            String numerohijo = array[1].toString();
            if (numerohijo.contains("First")) {
                            numerohijo = "1";
                        }else if (numerohijo.contains("Second")) {
                            numerohijo = "2";
                        }else if (numerohijo.contains("Third")) {
                            numerohijo = "3";
                        }else if (numerohijo.contains("Fourth")) {
                            numerohijo = "4";
                        }else if (numerohijo.contains("Fifth")) {
                            numerohijo = "5";
                        }else if (numerohijo.contains("Sixth")) {
                            numerohijo = "6";
                        }else{
                            numerohijo="1";
                        }
            
                NodoArbol hijo = new NodoArbol(nombreHijo+numerohijo);
            padre.agregarHijo(hijo);
            hijo.setData(array);
            mapaNodosNombre.put(nombreHijo+numerohijo, hijo); // Agregar al mapa
            if (array[4]!=null) {
                mapaNodosApodo.put(array[4].toString()+"1", hijo); // Agregar al mapa
            }
            
            
            
        }else {padre = mapaNodosApodo.get(nombrePadre);
        if (padre != null) {
            String numerohijo = array[1].toString();
            if (numerohijo.contains("First")) {
                            numerohijo = "1";
                        }else if (numerohijo.contains("Second")) {
                            numerohijo = "2";
                        }else if (numerohijo.contains("Third")) {
                            numerohijo = "3";
                        }else if (numerohijo.contains("Fourth")) {
                            numerohijo = "4";
                        }else if (numerohijo.contains("Fifth")) {
                            numerohijo = "5";
                        }else if (numerohijo.contains("Sixth")) {
                            numerohijo = "6";
                        }else{
                            numerohijo="1";
                        }
            NodoArbol hijo = new NodoArbol(nombreHijo+numerohijo);
            padre.agregarHijo(hijo);
            hijo.setData(array);
            mapaNodosNombre.put(nombreHijo+numerohijo, hijo); // Agregar al mapa
            if (array[4]!=null) {
                mapaNodosApodo.put(array[4].toString()+"1", hijo); // Agregar al mapa
            }
        }}if(padre==null){
            System.out.println("No se encontró el nodo padre: " + nombrePadre);  
        }
    }
    
     public void agregarHijoprimero(String nombreHijo, Object[] array) {
        NodoArbol padre = mapaNodosNombre.get(raiz.getNombre());
        NodoArbol hijo = new NodoArbol(nombreHijo);
        padre.agregarHijo(hijo);
        hijo.setData(array);
        mapaNodosNombre.put(nombreHijo+"1", hijo); // Agregar al mapa
        
    }
    
     
    public void Empty(){
        this.raiz = null;
    }
    
    public NodoArbol obtenerRaiz() {
        return raiz;
    }
    
    public NodoArbol buscar(String nombre) {
        if (mapaNodosNombre.get(nombre)!=null) {
            return mapaNodosNombre.get(nombre); // Búsqueda en tiempo O(1)
        }else if (mapaNodosApodo.get(nombre)!=null) {
            return mapaNodosApodo.get(nombre); // Búsqueda en tiempo O(1)
        }else{
            return null;
        }
        
    }
    
    public void imprimirArbol() {
        imprimirRecursivo(raiz, 0);
    }

    private void imprimirRecursivo(NodoArbol nodo, int nivel) {
        if (nodo == null) return;

        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }
        System.out.println(nodo.nombre);

        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            
            imprimirRecursivo(hijo.getElement(), nivel + 1);
        }
    }
}


