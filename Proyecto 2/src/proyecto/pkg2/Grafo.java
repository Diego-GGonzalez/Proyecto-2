/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author Fabián Espinoza
 */
public class Grafo {
    
    private boolean[] visitados;
    private int numV, numA;
    private Lista<Adyacente>[] adyacentes;
    private Usuario[] valores;
    private int pasos = 0;
    private Lista marcados;


    
    public Grafo(int nVertices) { 
        numV = nVertices; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = new Usuario(i, i+"");
        }    
    }
    
    public int getUsuarioid(int inde){
        return valores[inde].getId();
    }
    
    public Grafo(Usuario[] vertices){
        numV = vertices.length; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = vertices[i];
        }
    }
    
    public Usuario[] getUsuarios(){return valores;}
    
    public int numVertices() {return numV;}
    
    public int numAristas() {return numA;}
    
    private int getIndex(int value) {
        //Buscamos la localiza cion del ID
        for(int i = 0; i<= numV; i++){
            if(valores[i].getId() == value) {
                return i;
                    }
            
        }   
            return -1;
    }
    
    public boolean existeArista(int i, int j){
        //Se comprueba si existe la arista
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
        while (actual != null) {
            if (actual.getElement().getDestino() == j)  {
                return true;
            } 
            actual = actual.getPnext();
        }
        return false; 
    }
    
    public void insertarArista(int i, int j){
        //Añadimos la arista
        if (!existeArista(i, j)) { 
            adyacentes[i].insertarInicio(new Adyacente(j));
            numA++; 
        }
        if (!existeArista(j, i)){
                insertarArista(j,i);
            }
    }
    
    public void insertarAristaValor(int i, int j){
        //comprobamos las aristas y eliminamos o agregamos correspondientemente
        i = getIndex(i);
        j = getIndex(j);
        if (i != j) {
           insertarArista(i, j); 
        } 
    }
    
 
   private void recorridoDFS(int origen, int t, int pasos) {
    // Recorre el grafo de forma DFS
    visitados[origen] = true;
    pasos++;
    Lista<Adyacente> ady = adyacentes[origen];
    Nodo<Adyacente> nodoAdyacente = ady.getPfirst();
    // Marca el nodo si se cumple la condición
    if (pasos== t) {
        marcados.insertarFinal(origen);
        pasos =0;
    }
    
    int i=0;
    while (nodoAdyacente != null) {
        i = nodoAdyacente.getElement().getDestino();
        if (!visitados[i]) {
            recorridoDFS(i,t, pasos);
        }
        nodoAdyacente = nodoAdyacente.getPnext();
    }
}
   


    public Arista[] getAristas(){
        //Debuelve las aristas con los usuarios
        Arista[] res = new Arista[numA];
        Lista<Arista> lista = new Lista();
        
         int j = 0;
         for (int i = 0; i < numV; i++) {
            if (adyacentes[i] != null) {
                Lista<Adyacente> listaAdyacentes = adyacentes[i];
                Nodo<Adyacente> nodoAdyacente = listaAdyacentes.getPfirst();
                while (nodoAdyacente != null) {
                    Arista arista = new Arista(i, nodoAdyacente.getElement().getDestino());
                    if(!lista.contains(arista)){
                        lista.insertarInicio(arista);
                        res[j++] = arista;
                    
                    }
                    nodoAdyacente = nodoAdyacente.getPnext();
                }
                
            }
        }
        return res;
    }
}

