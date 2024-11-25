
package proyecto.pkg2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Proyecto2 {

    public static File Baratheon = new File("src\\Archivos\\Baratheon.json");
    public static File Targaryen = new File("src\\Archivos\\Targaryen.json");
    public static File Familia;
    public static Grafo miGrafo;
    public static ListaArbol arbol;

        
public static ListaArbol extraerArbol(File file) {
//        
        
        //scanea el file
         try {
            Scanner scanner = new Scanner(file);
            int linea = 0;
            arbol = new ListaArbol("");
            String nombreNumero;
            NodoArbol actual = arbol.raiz;
            while (scanner.hasNextLine()) {
                Object[] array = new Object[12];
                String line = scanner.nextLine();
                while(linea==0){
                if (linea ==0 && line.contains("[") ) {
                    linea = 1;
                    String resultado = line.replace(" ", "");
                    resultado = resultado.replace("[", "");
                    resultado = resultado.replaceAll("[<\">:]", "");
                    
                    arbol = new ListaArbol(resultado);
                    
                    actual = arbol.raiz;
                    
                }
                line = scanner.nextLine();
                }
                
                if (!line.equals("")) {
                    
                while (!line.contains(" ]")) {
                   if (line.contains(":[") && !line.contains("Father to")) {
                    String resultado = line.replace(" ", "");
                    resultado = resultado.replace("[", "");
                    resultado = resultado.replaceAll("[<\">:]", "");
                    array[0] = resultado;
                       
                   }
                   

                    if (line.contains("Of his name")) {
                        if (line.contains("Unknown")) {
                            array[1]=null;
                        }else{
                    String resultado = line.replace("Of his name", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    
                    array[1] = resultado;
                    
                    }}
                    if (line.contains("Born to")) {
                       String resultado = line.replace("Born to", "");
                    resultado = resultado.replace(" of his name", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                        if (resultado.contains("First")) {
                            resultado = resultado.replace("First", "1");
                        }else if (resultado.contains("Second")) {
                            resultado = resultado.replace("Second", "2");
                        }else if (resultado.contains("Third")) {
                            resultado = resultado.replace("Third", "3");
                        }else if (resultado.contains("Fourth")) {
                            resultado = resultado.replace("Fourth", "4");
                        }else if (resultado.contains("Fifth")) {
                            resultado = resultado.replace("Fifth","5");
                        }else if (resultado.contains("Sixth")) {
                            resultado = resultado.replace("Sixth","6");
                        }else{
                            resultado = resultado+"1";
                        }
                    array[2] = resultado;
                        line = scanner.nextLine();
                        
                       if (line.contains("Born to")) {
                        resultado = line.replace("Born to", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[3] = resultado;
                    } 
                    }
                    
                    if (line.contains("Known throughout as")) {
                        String resultado = line.replace("Known throughout as", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[4] = resultado;
                    }
                    
                    if (line.contains("Held title")) {
                        String resultado = line.replace("Held title", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[5] = resultado;
                    }
                    
                    if (line.contains("Wed to")) {
                       String resultado = line.replace("Wed to", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[6] = resultado; 
                    }
                    
                    if (line.contains("Of eyes")) {
                        String resultado = line.replace("Of eyes", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[7] = resultado;
                    }
                    
                    if (line.contains("Of hair")) {
                        String resultado = line.replace("Of hair", "");
                    resultado = resultado.replace(" ", "");
                    resultado = resultado.replaceAll("[{},<\">:]", "");
                    array[8] = resultado;
                    }
                    
                    if (line.contains("Father to")) {
                        line = scanner.nextLine();
                        Lista hijos = new Lista();
                        while (!line.contains("]")) {
                           String resultado = line.replace("Of hair", "");
                            resultado = resultado.replace(" ", "");
                            resultado = resultado.replaceAll("[{},<\">:]", "");
                            hijos.agregar(resultado);
                        line = scanner.nextLine();
                        }
                        array[9] = hijos.toArray();
                        line = scanner.nextLine();
                    }
                    
                    if (line.contains("Notes")) {
                        String resultado = line.replace("Notes", "");
                    resultado = resultado.replaceAll("\\s+", " ").trim();
                    resultado = resultado.replaceAll("[{}<\">:]", "");
                    array[10] = resultado;
                    }
                    
                    if (line.contains("Fate")) {
                       String resultado = line.replace("Fate", "");
                    resultado = resultado.replaceAll("\\s+", " ").trim();
                    resultado = resultado.replaceAll("[{}<\">:]", "");
                    array[11] = resultado; 
                    }
                  line = scanner.nextLine();  
                }
                if (linea==1) {
                           linea = 2;
                           if (array[4]!=null) {
                        arbol.agregarHijoprimero(array[4].toString(), array);
                    }else{
                           arbol.agregarHijoprimero(array[0].toString(), array);
                           }
                }else if (array[0]!=null) {
                    arbol.agregarHijo(array[2].toString(), array[0].toString(), array);
                }}
                
                line = scanner.nextLine();
            }
             return arbol;   
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
//            
        
        
    
        return null;
}
}
    

