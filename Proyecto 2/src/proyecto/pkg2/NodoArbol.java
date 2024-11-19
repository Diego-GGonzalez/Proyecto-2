
package proyecto.pkg2;
import java.util.ArrayList;
import java.util.List ; 

public class NodoArbol {
    private String nombre;
    private NodoArbol padre; 
    private List<NodoArbol> hijos; 
    
    public NodoArbol(String nombre){
        this.nombre = nombre;
        this.hijos = new ArrayList<>();          
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public NodoArbol getPadre(){
        return padre;
    }
    
    public void setPadre(NodoArbol padre){
        this.padre = padre; 
    }
    
    public List<NodoArbol> getHijos(){ 
        return hijos; 
    }
    
    public void agregarHijos(NodoArbol hijo){
        hijo.setPadre(this);
        this.hijos.add(hijo);
    }
}