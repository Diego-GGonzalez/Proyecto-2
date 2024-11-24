/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

import java.util.Arrays;
import static proyecto.pkg2.Proyecto2.*;
/**
 *
 * @author Fabián Espinoza
 */
public class pruebas_borrar {
    public static void main(String[] args) {
        // Crear el árbol y rellena los datos
        arbol = Proyecto2.extraerArbol(Baratheon);
        
        String original = arbol.buscar("SteffonBaratheon2").nombre;
        // Expresión regular para insertar espacios antes de mayúsculas y números
        String resultado = original.replaceAll("(?<=[a-z])(?=[A-Z])|(?<=[A-Za-z])(?=\\d)", " ");
        
        System.out.println(resultado);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Lista data = arbol.ListadoGeneral();
        
        int i = 0;
        for (Nodo<NodoArbol> nodo : data.toArray()) {
            System.out.println(nodo.getElement().nombre+" numero: "+i);
            i++;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Lista dataAntepasada = arbol.ListadoAntepasados("JaehaerysTargaryen1");
        
        int j = 0;
        for (Nodo<NodoArbol> nodo : dataAntepasada.toArray()) {
            System.out.println(nodo.getElement().nombre+" numero: "+j);
            j++;
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Lista datageneracion = arbol.ListadoGeneracion(2);
        
        int k = 0;
        for (Nodo<NodoArbol> nodo : datageneracion.toArray()) {
            System.out.println(nodo.getElement().nombre+" numero: "+k);
            k++;
        }
        
        
    }
}

        
    

