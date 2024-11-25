/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author Diego
 */
public class NodoArbol {
    public String nombre;
    public NodoArbol padre; 
    public Object[] data;
    public Lista<NodoArbol> hijos; 
    
    public NodoArbol(String nombre){
        this.nombre = nombre;
        this.hijos = new Lista<NodoArbol>(); 
        
    }

    public Object[] getData() {
        return data;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
    
    public NodoArbol getPadre(){
        return padre;
    }
    
    public void setPadre(NodoArbol padre){
        this.padre = padre; 
    }
    
    public Lista<NodoArbol> getHijos(){ 
        return hijos; 
    }
    
    public void agregarHijo(NodoArbol hijo){
        hijo.setPadre(this);
        this.hijos.agregar(hijo);
    }
    
    
    
    
}