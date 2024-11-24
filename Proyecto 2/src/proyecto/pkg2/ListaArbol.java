/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;


import static proyecto.pkg2.Proyecto2.arbol;
import proyecto.pkg2.Lista.*;
/**
 *
 * @author Diego
 */

public class ListaArbol {
    NodoArbol raiz;
    private Lista<NodoArbol> mapaNodosNombre; // Mapa para búsqueda eficiente
    private Lista<NodoArbol> mapaNodosApodo;
    private Lista gente;

    public ListaArbol(String nombreRaiz) {
        this.raiz = new NodoArbol(nombreRaiz);
        this.mapaNodosNombre = new Lista<NodoArbol>();
        this.mapaNodosApodo = new Lista<NodoArbol>();
        mapaNodosNombre.agregar(nombreRaiz, raiz);
        mapaNodosApodo.agregar(nombreRaiz, raiz);
        System.out.println(mapaNodosNombre.size());
    }
    
    public void agregarHijo(String nombrePadre,  String nombreHijo, Object[] array) {
        Nodo<NodoArbol> padre1 = mapaNodosNombre.get(nombrePadre);
        
        if (padre1 != null) {
            NodoArbol padre = padre1.getElement();
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
            mapaNodosNombre.agregar(nombreHijo+numerohijo, hijo); // Agregar al mapa
            if (array[4]!=null) {
                mapaNodosApodo.agregar(array[4].toString()+"1", hijo); // Agregar al mapa
            }
        }else {padre1 = mapaNodosApodo.get(nombrePadre);
        if (padre1 != null) {
            NodoArbol padre = padre1.getElement();
            System.out.println("entro");
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
            mapaNodosNombre.agregar(nombreHijo+numerohijo, hijo); // Agregar al mapa
            if (array[4]!=null) {
                mapaNodosApodo.agregar(array[4].toString()+"1", hijo); // Agregar al mapa
            }
        }}if(padre1==null){
            System.out.println("No se encontró el nodo padre: " + nombrePadre);  
        }
    }
    
     public void agregarHijoprimero(String nombreHijo, Object[] array) {
        NodoArbol padre = mapaNodosNombre.get(raiz.getNombre()).getElement();
        NodoArbol hijo = new NodoArbol(nombreHijo);
        padre.agregarHijo(hijo);
        hijo.setData(array);
        mapaNodosNombre.agregar(nombreHijo+"1", hijo); // Agregar al mapa
    }
    
     
    public void Empty(){
        this.raiz = null;
    }
    
    public NodoArbol obtenerRaiz() {
        return raiz;
    }
    
    public NodoArbol buscar(String nombre) {
        if (mapaNodosNombre.get(nombre)!=null) {
            return mapaNodosNombre.get(nombre).getElement(); // Búsqueda en tiempo O(1)
        }else if (mapaNodosApodo.get(nombre)!=null) {
            return mapaNodosApodo.get(nombre).getElement(); // Búsqueda en tiempo O(1)
        }else{
            System.out.println("holssssasd");
            System.out.println(mapaNodosNombre.get(nombre));
            return null;
        }
        
    }
    
    public void imprimirArbol() {
        imprimirRecursivo(raiz, 0);
    }

    private void imprimirRecursivo(NodoArbol nodo, int nivel) {
        if (nodo == null) return;
        int j = 0;
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
           
        }
        String original = nodo.nombre;
        // Expresión regular para insertar espacios antes de mayúsculas y números
        String resultado = original.replaceAll("(?<=[a-z])(?=[A-Z])|(?<=[A-Za-z])(?=\\d)", " ");
        
        System.out.println(resultado+" nivel: "+nivel);

        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            
            imprimirRecursivo(hijo.getElement(), nivel + 1);
        }
    }
    
    public Lista ListadoGeneral(){
        gente =new Lista();
        ListadoGeneralRecursivo(raiz, 0);
        return gente;
    }
    
    private void ListadoGeneralRecursivo(NodoArbol nodo, int nivel) {
        if (nodo == null) return;
        gente.agregar(nodo);
        
        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            
            ListadoGeneralRecursivo(hijo.getElement(), nivel + 1);
        }
    }
    
    public Lista ListadoAntepasados(String Nombre){
        NodoArbol nodobuscado = arbol.buscar(Nombre);
        gente =new Lista();
        ListadoAntepasadosRecursivo(false, nodobuscado, raiz, 0);
        return gente;
    }
    
    private void ListadoAntepasadosRecursivo(boolean encontrado, NodoArbol nodobuscado, NodoArbol nodo, int nivel) {
        if (nodo == null) return;
        gente.agregar(nodo);
        if (encontrado) return;
        if (nodobuscado == nodo) return;
        
        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            if (nodobuscado==hijo.getElement()) {
                encontrado=true;
            }
        }
        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            ListadoAntepasadosRecursivo(encontrado, nodobuscado, hijo.getElement(), nivel + 1);
        }
    }
    
    public Lista ListadoGeneracion(int nivel){
        gente =new Lista();
        ListadoGeneracionRecursivo(nivel, raiz, 0);
        return gente;
    }
    
    private void ListadoGeneracionRecursivo(int nivelbuscado, NodoArbol nodo, int nivel) {
        if (nodo == null) return;
        if (nivel == nivelbuscado) gente.agregar(nodo);
        
        for (Nodo<NodoArbol> hijo : nodo.hijos.toArray()) {
            ListadoGeneracionRecursivo(nivelbuscado, hijo.getElement(), nivel + 1);
        }
    }
}


