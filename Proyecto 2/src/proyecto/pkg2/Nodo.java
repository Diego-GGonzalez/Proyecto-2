/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author Fabián Espinoza
 */
public class Nodo<E> {
    private String id;
    private E element;
    private Nodo pnext;
    
    public Nodo(E element, Nodo pnext){
        this.element = element;
        this.pnext = pnext;
    }
    
    public Nodo(String nombre, E element, Nodo pnext){
        this.id = nombre;
        this.element = element;
        this.pnext = pnext;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setElement(E element) {
        this.element = element;
    }
    
    public E getElement() {return element;}
    
    public Nodo getPnext() {return pnext;}
    
    public void setPnext(Nodo pnext) {this.pnext = pnext;}
    
    public boolean equals(Nodo<E> otro){
        return element == otro.element && ((pnext == null && otro.pnext == null) || pnext.equals(otro.pnext));
    }
}
